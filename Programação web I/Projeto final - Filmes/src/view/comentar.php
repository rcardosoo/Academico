<?php
	# Barra superior + links css 
include_once "comum/cabecalho.php"; 
?>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-default">
					<div class="panel-heading">
					<h3 class="panel-title">Comentar filme: <?php echo $_GET["id"]; ?></h3>
					</div>
					<div class="panel-body">
						<form role="form" method="post" action="?do=comentarFilme">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Login: <?php echo $_SESSION["login"]; ?>" value="<?php echo $_SESSION["login"]; ?>" type="text" disabled><br>
									<textarea class="form-control" placeholder="Digite seu comentário" name="comentario"></textarea>
									<br>
								</div>
								<input type="hidden" name="user" value="<?php echo $_SESSION["login"]; ?>">
								<input type="hidden" name="idfilme" value="<?php echo $_GET["id"]; ?>">
								<input type="hidden" name="op" value="comentar">
								<input class="btn btn-lg btn-info btn-block" type="submit" value="Comentar">
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
