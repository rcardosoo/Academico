<?php
	# Barra superior + links css 
include_once "comum/cabecalho.php"; 
?>

<body>

	<div class="container">
		<div class="row">
		
			<div class="col-md-8 col-md-offset-2">
			<?php 
				unset($_SESSION["detalhesFilme"]);
				unset($_SESSION["comentariosFilme"]); 
			?>
			<?php
				if (isset($_SESSION["logado"])) {
					if ($_SESSION["tipo"] == "app\model\usuario\Administrador")
						echo "<a href='?do=admin' role='button' class='btn btn-warning'>Painel de controle</a><br><br>";
					else
						echo "<a href='?do=perfil&sub=comentarista' role='button' class='btn btn-warning'>Perfil</a><br><br>";

					echo "<div class='alert alert-info'>Bem vindo, ".$_SESSION["login"]."</div>";
				}
			?>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;&nbsp;Buscar filme</h3>
					</div>
					<div class="panel-body">
						<form role="form" method="post" action="?do=buscarFilme">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Digite o nome ou gênero do filme" name="busca" type="text">
								</div>
								<input class="btn btn-lg btn-info btn-block" type="submit" value="Buscar">
							</fieldset>
						</form>
					</div>
				</div>

				<?php
					if(isset($_SESSION["resultados"])){
						echo "<div class='alert alert-success'>Resultados para: ".$_SESSION["busca"]."</div>";
						echo "<div class='row'>";
						$_SESSION["filmeDetalhe"]=$_SESSION["resultados"];
						foreach($_SESSION["resultados"] as $filme){
							  echo "<div class='col-sm-6 col-md-4'>";
							    echo "<div class='thumbnail'>";
							      echo "<img src='../../files/filme.jpg'>";
							      echo "<div class='caption'>";
							        echo "<b>". $filme->getTitulo() ."</b>";
							        echo "<p>". $filme->getGenero() ."</p>";
							        echo "<p><a href='?do=detalhesFilme&sub=".$filme->getCodigo()."' class='btn btn-primary' role='button'>Detalhes</a>";
							      echo "</div>";
							    echo "</div>";
							  echo "</div>";
							 
						}
						echo "</div>";
						unset($_SESSION["resultados"]);
					}elseif(isset($_GET["msg"])){
						if($_GET["msg"] == "fail"){
							echo "<div class='alert alert-danger'>Nenhum filme encontrado!</div>";
						}
					}
				?>	

			</div>
		</div>
	</div>

</body>
</html>
