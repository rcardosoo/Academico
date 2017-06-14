<?php 
	#instanciar controler
	$controler = new \app\control\comentario\ControlerComentario();
	
	if (isset($_POST["op"])) {
		# veio alguma operação
		$op = $_POST["op"];

		switch ($op) {
			case 'comentar':
				$controler->comentar();
				break;
		}

	} else {
		if (isset($_GET["id"]))
			$controler->deletar($_GET["id"]);
	}


?>