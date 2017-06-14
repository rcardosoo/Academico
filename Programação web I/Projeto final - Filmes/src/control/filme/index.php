<?php 
	#instanciar controler
	$controler = new \app\control\filme\ControlerFilme();
	
	if (isset($_POST["op"])) {
		# veio alguma operação
		$op = $_POST["op"];

		switch ($op) {
			case 'alterar':
				$controler->alterar();
				break;
			case 'deletar':
				$controler->deletar();
				break;
			case 'cadastrar':
				$controler->cadastrar();
				break;
		}

	} else {
		if (isset($_GET["id"]))
			$controler->localizarFilme($_GET["id"]);
		elseif (isset($_POST["busca"]))
			$controler->buscar();
		elseif (isset($_GET["sub"]))
			$controler->detalhe($_GET["sub"]);
		else
			$controler->listarTodos();
	}


?>