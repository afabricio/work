package br.com.kiman.kiprev.ki.xp.integration.clientes;

import java.util.List;

import com.google.common.collect.Lists;

public class ClientesResponseDTO {

	List<Customer> customers;
	
	public ClientesResponseDTO() {
		if (customers==null) {
			customers = Lists.newArrayList();
		}
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}
