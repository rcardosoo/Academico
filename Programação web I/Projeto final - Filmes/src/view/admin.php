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
					if (isset($_GET["msg"])) {
						if ($_GET["msg"] == "alterado")
							echo "<div class='alert alert-success'>Filme alterado com sucesso!</div>";
						if ($_GET["msg"] == "deletado")
							echo "<div class='alert alert-success'>Filme removido com sucesso!</div>";
						if ($_GET["msg"] == "cadastrado")
							echo "<div class='alert alert-success'>Filme cadastrado com sucesso!</div>";
					}
				?>
				<a href="?do=pageCadastrarFilme" role="button" class="btn btn-success">Cadastrar filme</a><br>
				<br><div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">Lista de filmes</div>

					<!-- Table -->
					<table class="table">
						<thead>
							<tr>
								<th>Codigo</th>
								<th>Titulo</th>
								<th>Gênero</th>
							</tr>
						</thead>

						<tbody>
							<?php 

							if (isset($_SESSION["filmes"])) {
								foreach ($_SESSION["filmes"] as $f) {
									echo "<tr>";
									echo "<th>".$f->getCodigo()."</th>";
									echo "<th>".$f->getTitulo()."</th>";
									echo "<th>".$f->getGenero()."</th>";
									echo "<th><a href='?do=pageAlterarFilme&id=".$f->getCodigo()."' role='button' type='button'>Alterar</a></th>";
									echo "<th><a href='?do=pageDeletarFilme&id=".$f->getCodigo()."' role='button' type='button'>Deletar</a></th></th>";
									echo "</tr>";
								}

							} else {
								echo "
								<tr>
									<th>###</th>
									<th>###</th>
									<th>###</th>
								</tr>
								";
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