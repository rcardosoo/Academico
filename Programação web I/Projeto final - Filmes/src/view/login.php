<?php
	# Barra superior + links css 
	include_once "comum/cabecalho.php"; 
?>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
		<?php 
				if (isset($_GET["msg"]))
					if ($_GET["msg"] == "fail")
						echo "<div class='alert alert-danger'>Login ou senha inválidos!</div>";
				?>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Entre para continuar</h3>
				</div>
				<div class="panel-body">
					<form role="form" method="post" action="?do=validarLogin">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="Login" value="<?php echo $_COOKIE["userLogin"]; ?>" name="login" type="text">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Senha" name="senha" type="password">
							</div>
							<input type="hidden" name="op" value="logar">
							<input class="btn btn-lg btn-info btn-block" type="submit" value="Entrar">
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>

