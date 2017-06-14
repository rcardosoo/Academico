<?php
	# Barra superior + links css 
include_once "comum/cabecalho.php"; 
?>

<body>
	<div class="container">
		<center><h3>Perfil do comentarista</h3></center>
		<br><br>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<?php 
					if (isset($_GET["msg"])) {
						if ($_GET["msg"] == "deletado")
							echo "<div class='alert alert-success'>Comentário deletado com sucesso!</div>";
						if ($_GET["msg"] == "desmarcado")
							echo "<div class='alert alert-success'>Filme desmarcado com sucesso!</div>";
					}
				?>

				<br><div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">Lista de comentários</div>

					<!-- Table -->
					<table class="table">
						<thead>
							<tr>
								<th style="color: blue;">Código do filme</th>
								<th style="color: blue;">Texto</th>
							</tr>
						</thead>

						<tbody>
							<?php
								if (isset($_SESSION["comentariosFilme"])) {	
									$comentarios = $_SESSION["comentariosFilme"];
									$filmes = $_SESSION["filmesComentados"];

									for ($i=0; $i < sizeof($comentarios); $i++) {
										echo "<tr>";
										echo "<th>".$filmes[$i]."</th>";
										echo "<th>".$comentarios[$i]->getTexto()."</th>";
										echo "<th><a href='?do=deletarComentario&id=".$comentarios[$i]->getId()."' role='button' type='button'>Deletar</a></th></th>";

										echo "</tr>";
									}

								} else {
									echo "
									<tr>
										<th>###</th>
										<th>###</th>
									</tr>
									";
								}
							
				 			?>

						</tbody>
					</table>
				</div>

				<br><div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">Filmes assistidos</div>

					<!-- Table -->
					<table class="table">
						<thead>
							<tr>
								<th style="color: blue;">Código do filme</th>
							</tr>
						</thead>

						<tbody>
						<?php 

							if (isset($_SESSION["assistidos"])) {
								
								foreach ($_SESSION["assistidos"] as $a) {
									echo "<tr>";
									echo "<th>".$a."</th>";
									echo "<th><a href='?do=desmarcarAssistido&desmarcar=".$a."' role='button' type='button'>Desmarcar</a></th>";
									echo "</tr>";
								}

							} else {
								echo "<div class='alert alert-danger'>Não possui filmes assistidos!</div>";
							}
							?>
						</tbody>
					</table>
				</div>
			</div>
		</div>



	</div>
</body>
<html>