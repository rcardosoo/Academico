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
				if (isset($_GET["msg"]))
					if ($_GET["msg"] == "sucesso")
						echo "<div class='alert alert-success'>Filme cadastrado com sucesso!</div>";	
			 ?>
				<div class="panel panel-default">
					<div class="panel-heading">
					<h3 class="panel-title">Cadastrar filme</h3>
					</div>
					<div class="panel-body">
						<form role="form" method="post" action="?do=cadastrarFilme">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Titulo" name="titulo" type="text"><br>
									<textarea class="form-control" placeholder="Sinopse" name="sinopse"></textarea>
									<br><input class="form-control" placeholder="Ano" name="ano" type="number"><br>
									<input class="form-control" placeholder="Gênero" name="genero" type="text"><br>
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
