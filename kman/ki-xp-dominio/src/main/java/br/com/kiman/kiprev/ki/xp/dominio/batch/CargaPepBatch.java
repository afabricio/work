package br.com.kiman.kiprev.ki.xp.dominio.batch;

import static br.com.kiman.kiprev.ki.xp.dominio.dao.QueryParameters.with;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.StoredProcedureQuery;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import br.com.kiman.kiprev.ki.xp.dominio.anotation.Batch;
import br.com.kiman.kiprev.ki.xp.dominio.constants.BatchResult;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Grupo;
import br.com.kiman.kiprev.ki.xp.dominio.constants.Interface;
import br.com.kiman.kiprev.ki.xp.dominio.constants.ParametroEnum;
import br.com.kiman.kiprev.ki.xp.dominio.constants.SystemConfEnum;
import br.com.kiman.kiprev.ki.xp.dominio.dao.GenericDAO;
import br.com.kiman.kiprev.ki.xp.dominio.dao.OutMap;
import br.com.kiman.kiprev.ki.xp.dominio.exception.BatchException;
import br.com.kiman.kiprev.ki.xp.dominio.exception.NegocioException;
import br.com.kiman.kiprev.ki.xp.dominio.interceptor.SetaAmbienteInterceptor;
import br.com.kiman.kiprev.ki.xp.dominio.service.ParametroBean;

@Stateless
@Batch(name="cargapep")
@Interceptors(value = { SetaAmbienteInterceptor.class })
public class CargaPepBatch implements BatchInterface {
	
	@Inject
	private GenericDAO dao;

	private String excelFilePath = null;
	
	@Inject
	private ParametroBean parametroService;

	

	@Override
	public BatchResult execute() {
		
	Workbook workbook=null;
		
		Integer sessao=null;
		
		try {
			
			String excelFileDir = parametroService.buscaParametro(Interface.PEP, Grupo.PARAMETRO_FIXO, ParametroEnum.DIR_ARQIVO_PEP);
			String excelFileName = parametroService.buscaParametro(Interface.PEP, Grupo.PARAMETRO_FIXO, ParametroEnum.ARQIVO_PEP);	
			this.excelFilePath = excelFileDir+excelFileName;

			File file = new File(excelFilePath);

			workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheetAt(0);
		
			OutMap oInicia = dao.executeProcedure("kpvcust11.pck_db_ki_xp_int005.p_inicia",
					with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue(), String.class)
					.out("pnSessao", Integer.class)
					.out("pcInterfAtiva", String.class));

			sessao = oInicia.getOut("pnSessao");
			String InterfAtiva = oInicia.getOut("pcInterfAtiva");
			
			Integer idEnca = null;
			boolean header = true;
			

			
			if (InterfAtiva.equals("S")) {

				StoredProcedureQuery storedProc = dao.registerProcedure("kpvcust11.pck_db_ki_xp_int005.p_carga_pep",
						with("pcCodEmpresa", String.class)
						.and("pnSessao", Integer.class)
						.and("pnIdEnca", Integer.class)
						.and("pcNomeArquivo", String.class)
						.and("pnCpfPep", Integer.class)
						.and("pcNomePep", String.class)
						.and("pcSiglaFuncaoPep", String.class)
						.and("pcDescFuncaoPep", String.class)
						.and("pcNivelFuncaoPep", String.class)
						.and("pcNomeOrgaoPep", String.class)
						.and("pdDataIniExercicio", Date.class)
						.and("pdDataFimExercicio", Date.class)
						.and("pdDataFinalCarencia", Date.class)
						.out("pnIdEnca", Integer.class));


	
				for (Row row : sheet) {
					if (header) {
						header = false;
						continue;
					}

					OutMap oCarga = dao.executeStoredProcedure(storedProc, 
							with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue())
							.and("pnSessao", sessao).and("pnIdEnca", idEnca)
							.and("pcNomeArquivo", file.getName())
							.and("pnCpfPep", readCellAsInteger(row.getCell(0)))
							.and("pcNomePep", readCellAsString(row.getCell(1)))
							.and("pcSiglaFuncaoPep", readCellAsString(row.getCell(2)))
							.and("pcDescFuncaoPep", readCellAsString(row.getCell(3)))
							.and("pcNivelFuncaoPep", readCellAsString(row.getCell(4)))
							.and("pcNomeOrgaoPep", readCellAsString(row.getCell(5)))
							.and("pdDataIniExercicio", readCellAsDate(row.getCell(6)))
							.and("pdDataFimExercicio", readCellAsDate(row.getCell(7)))
							.and("pdDataFinalCarencia", readCellAsDate(row.getCell(8)))
							.out("pnIdEnca", Integer.class));

					if (idEnca == null) {
						idEnca = oCarga.getOut("pnIdEnca");
					}
					
	
					
		

				}
			}

			dao.executeProcedure("kpvcust11.pck_db_ki_xp_int005.p_finaliza", 
					with("pnSessao", sessao, Integer.class));
			
			return BatchResult.SUCESSO;

		} catch (Exception e) {
			
			if(sessao != null)
				logMonitor(sessao, e.getMessage());
			
			throw new BatchException("Erro ao executar o batch de de carga de cotas", e);
			
			
		}finally {
			
			if(workbook != null)
				try {workbook.close();} catch (IOException e) {	}
		}
		

	}
	
	
	

	private void logMonitor(Integer sessao, String msg) {
		dao.executeProcedure("kpvcust11.pck_db_ki_xp_int005.p_log_erro",
				with("pnSessao", sessao)
				.and("pcMsgErro", msg));
	}

	
	
	
	public void atualizaPep() {
		
		dao.executeProcedure("kpvcust11.pck_db_ki_xp_int005.p_atualiza_pep",
				with("pcCodEmpresa", SystemConfEnum.DEFAULT_COMPANY.getValue(), String.class));
		
	}
	

	private String readCellAsString(Cell cell) {

		try {

			switch (cell.getCellTypeEnum()) {
			case STRING:
				return cell.getStringCellValue();
			case NUMERIC:
				return String.valueOf(cell.getNumericCellValue());
			default:
				return cell.getStringCellValue();
			}

		} catch (Exception e) {
			throw new NegocioException("Não foi possível ler o registro como Texto.  arquivo: " + excelFilePath + " linha:"
					+ cell.getRowIndex() + " coluna: " + cell.getColumnIndex(), e);
		}

	}

	private Number readCellAsInteger(Cell cell) {

		try {
			switch (cell.getCellTypeEnum()) {
			case STRING:
				return Integer.parseInt(cell.getStringCellValue());
			case NUMERIC:
				return cell.getNumericCellValue();
			default:
				return cell.getNumericCellValue();
			}

		} catch (Exception e) {
			throw new NegocioException("Não foi possível ler o registro como Numero.  arquivo: " + excelFilePath + " linha:"
					+ cell.getRowIndex() + " coluna: " + cell.getColumnIndex(), e);
		}

	}

	private Date readCellAsDate(Cell cell) throws ParseException {

		try {

			switch (cell.getCellTypeEnum()) {
			case STRING:
				return new SimpleDateFormat("dd/MM/yyyy").parse((cell.getStringCellValue()));
			case NUMERIC:
				return cell.getDateCellValue();
			default:
				return cell.getDateCellValue();
			}

		} catch (Exception e) {
			throw new NegocioException("Não foi possível ler o registro como Data.  arquivo: " + excelFilePath + " linha:"
					+ cell.getRowIndex() + " coluna: " + cell.getColumnIndex(), e);
		}

	}

}
