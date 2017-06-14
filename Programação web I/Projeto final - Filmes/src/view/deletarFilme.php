<?php
	# Barra superior + links css 
include_once "comum/cabecalho.php"; 
?>

<body>
	<div class="container">
		<center><h3>Controle de filmes</h3></center>
		<br><br>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<?php
					if (isset($_GET["id"])) { ?>

						<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Deletar filme</h3>
						</div>
						<div class="panel-body">
							<form role="form" method="post" action="?do=deletarFilme">
								<fieldset>
									<div class="alert alert-warning">Tem certeza que quer deletar o filme <?php echo $_GET["id"] ?>?</div>
									<input type="hidden" name="id" value="<?php echo $_GET["id"] ?>">
									<input type="hidden" name="op" value="deletar">
									<input class="btn btn-lg btn-danger btn-block" type="submit" value="Apagar"><br>
								</fieldset>
							</form>
							<a href="?do=admin" role="button" class="btn btn-lg btn-default btn-block">Cancelar</a>
						</div>
					</div>

				<?php } ?>
			</div>
		</div>
	</div>
</body>
</html>
