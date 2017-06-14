<?php
	# Barra superior + links css 
include_once "comum/cabecalho.php"; 
?>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
			<?php 
				if (isset($_GET["msg"]))
					if ($_GET["msg"] == "comentado")
						echo "<div class='alert alert-success'>Comentário realizado com sucesso!</div>";	
			 ?>
			<?php
				if (isset($_SESSION["detalheFilme"]))
					$filme=$_SESSION["detalheFilme"][0];
			?>
				<div class="row">
					<div class="col-md-12"><br><br>
					<center><h2><?php echo $filme->getTitulo() ?></h2></center><hr><br>
						<img src="../../files/filmeMaior.jpg">
						</div>

					<div class="col-md-12"><br>
						<div class="col-md-6">
							<p><b>Ano: </b><?php echo $filme->getAno() ?></p>
							<p><b>Gênero: </b><?php echo $filme->getGenero() ?></p>
							<p><b>Sinopse: </b><?php echo $filme->getSinopse() ?></p>
						</div>
						<div class="col-md-6">
							<?php if (isset($_SESSION["logado"])) {
								if ($_SESSION["tipo"] == "app\model\usuario\Comentarista")
									echo "<a href='?do=pageComentar&id=".$filme->getCodigo()."' style='float: right;' class='btn btn-info' role='button'>Fazer comentário&nbsp;&nbsp;<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></a><br><br><br>";
									if (isset($_SESSION["assistido"])) {
										if ($_SESSION["assistido"] == true) {
											echo "<b style='float: right;'>Filme assistido</b><br>";
										} else if ($_SESSION["tipo"] == "app\model\usuario\Comentarista"){
											echo "<a href='?do=assistirFilme&sub=assistir&id=".$filme->getCodigo()."' style='float: right;' class='btn btn-default' role='button'>Marcar assistido&nbsp;&nbsp;<span class='glyphicon glyphicon-eye-open' aria-hidden='true'></span></a><br>";
										}
									}
									
							} ?>
						</div>
					</div>
				</div>
				<hr><h4>Comentários:</h4><hr>
				<?php
					if (isset($_SESSION["comentariosFilme"])) {
						$comentarios = $_SESSION["comentariosFilme"];
						$usuarios = $_SESSION["comentaristas"];
				?>

					<?php for ($i=0; $i < sizeof($comentarios); $i++) { ?>
					<div class="panel panel-default">
						<!-- Default panel contents -->
						<div class="panel-heading">
						<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;
						<?php echo $usuarios[$i]; ?></div>
							<div class="panel-body"><?php echo $comentarios[$i]->getTexto(); ?></div>
						</div>

					<?php } ?>
				<?php } ?>
			</div>
		</div>
	</div>

</body>
</html>