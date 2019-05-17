<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>KiPREV - Login</title>

<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/fontawesome-all.min.css" />
<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container h-100">
		<div class="row align-items-center h-100">
			<div class="main-login p-4 mx-auto">
				<div class="panel-heading pb-5">
					<div class="text-center">
						<img
							src="${pageContext.request.contextPath}/resources/img/xp_seguros_preto.png"
							alt="Logo XP Seguros" width="340">
					</div>
				</div>

				<form class="form-horizontal" method="post" id="form-login">

					<div class="form-row p-2">
						<div class="col-md-12">
							<label for="username">Usuário</label> <input type="text"
								autocomplete="username" class="form-control" name="username"
								id="username" placeholder="Usuário" required />
						</div>
					</div>

					<div class="form-row p-2">
						<div class="col-md-12">
							<label for="password">Senha</label> <input type="password"
								autocomplete="new-password" class="form-control" name="password"
								id="password" placeholder="Senha" required />
						</div>
					</div>


					<c:if test="${not empty requestScope.ERRO}">
						<div class="form-row p-2">
							<div class="col-md-12">
								<div class="invalid-feedback text-center"
									style="display: block;">${requestScope.ERRO}</div>
							</div>
						</div>
					</c:if>

					<div class="form-group p-2">
						<button type="submit" class="btn btn-primary btn-lg btn-block"
							id="btn-login">Entrar</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>

<style type="text/css">
body,html {
	height: 100%;
	background-repeat: no-repeat;
	background-color: #f0f0f0;
}

input,input::-webkit-input-placeholder {
	font-size: 11px;
	padding-top: 3px;
}

.main-login {
	background-color: #fff;
	/* shadows and rounded borders */
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	-moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	-webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	min-width: 450px;
}
</style>

<script type="text/javascript">
	var loading = '<i class="fa fa-spinner fa-spin" style="font-size:20px"></i> Entrar';
	var url = '${pageContext.request.contextPath}/login';

	var form = $('#form-login');
	form.on('submit', function(e) {
		e.preventDefault();
		$('#btn-login').html(loading);
		$.post(url, form.serialize()).done(function(response) {
			document.open();
			document.write(response);
			document.close();
		});
	});
</script>
</html>