<?php 
	#instanciar controler
	$controler = new \app\control\usuario\ControlerUsuario();
	
	if (isset($_POST["op"])) {
		# veio alguma operação
		$op = $_POST["op"];

		switch ($op) {
			case 'cadastrar':
				$controler->cadastrar();
				break;
			case 'logar':
				$controler->logar();
				break;
		}

	} elseif($_GET["sub"]) {
		if ($_GET["sub"] == "assistir")
			$controler->marcarAssistido($_GET["id"]);
		if ($_GET["sub"] == "comentarista")
			$controler->perfilComentarista();
	} elseif($_GET["desmarcar"]) {
		$controler->desmarcar($_GET["desmarcar"]);
	} else {
		session_destroy();
		header("Location:?do=main");
	}


?>