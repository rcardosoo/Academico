<?php
	# Barra superior + links css 
include_once "comum/cabecalho.php"; 
?>

<body>

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<?php 
				if (isset($_GET["msg"]))
					if ($_GET["msg"] == "sucesso")
						echo "<div class='alert alert-success'>Cadastro realizado com sucesso!</div>";
				?>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Cadastro de usuário</h3>
						</div>
						<div class="panel-body">
							<form role="form" method="post" action="?do=validarCadastro">
								<fieldset>
									<div class="form-group">
										<input class="form-control" placeholder="Nome" name="nome" type="text"><br>
										<input class="form-control" placeholder="CPF (Digite tudo junto, apenas números)" name="cpf" type="number"><br>
										<input class="form-control" placeholder="Login" name="login" type="text"><br>
										<input class="form-control" placeholder="Senha" name="senha" type="password"><br>
									</div>
									<input type="hidden" name="op" value="cadastrar">
									<input class="btn btn-lg btn-info btn-block" type="submit" value="Cadastrar">
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</body>
	</html>
