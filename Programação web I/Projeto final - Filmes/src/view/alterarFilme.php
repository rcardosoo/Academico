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
					if (isset($_GET["id"])) { 

						if (isset($_SESSION["filmes"])) {
							foreach ($_SESSION["filmes"] as $f) {
								if ($f->getCodigo() == $_GET["id"]){
									$filme = $f;
								}
							}
						}

						?>

						<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Alterar filme</h3>
						</div>
						<div class="panel-body">
							<form role="form" method="post" action="?do=alterarFilme">
								<fieldset>
									<div class="form-group">
										<input class="form-control" style="background-color: #eee;" placeholder="Titulo" name="titulo" type="text" value="<?php echo $filme->getTitulo(); ?>"><br>
										<textarea class="form-control" style="background-color: #eee;" placeholder="Sinopse" name="sinopse"><?php echo $filme->getSinopse(); ?></textarea>
										<br><input class="form-control" style="background-color: #eee;" placeholder="Ano" name="ano" type="number" value="<?php echo $filme->getAno(); ?>"><br>
										<input class="form-control" style="background-color: #eee;" placeholder="Gênero" name="genero" type="text" value="<?php echo $filme->getGenero(); ?>"><br>
									</div>
									<input type="hidden" name="id" value="<?php echo $_GET["id"] ?>">
									<input type="hidden" name="op" value="alterar">
									<input class="btn btn-lg btn-info btn-block" type="submit" value="Alterar">
								</fieldset>
							</form>
						</div>
					</div>

				<?php } ?>
			</div>
		</div>
	</div>
</body>
</html>
