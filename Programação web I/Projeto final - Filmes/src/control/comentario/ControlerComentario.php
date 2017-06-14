<?php 
	namespace app\control\comentario;

	class ControlerComentario {

		public function comentar() {
			$idFilme = $_POST["idfilme"];
			$loginUser = $_POST["user"];
			$comentario = $_POST["comentario"];

			$daocomentario = new \app\model\comentario\DAOcomentario();
			$daofilme = new \app\model\filme\DAOfilme();
			$daousuario = new \app\model\usuario\DAOusuario();
			$arrayFilme = $daofilme->listarfilme($idFilme);
			$arrayUser = $daousuario->listarUsuario($loginUser);
			$filme = $arrayFilme[0];
			$usuario = $arrayUser[0];
	
			$daocomentario->persistir($comentario, $filme, $usuario);
			header("Location:?do=detalhesFilme&sub=".$filme->getCodigo());
		}

		public function deletar($id) {
			$daousuario = new \app\model\usuario\DAOusuario();

			// $login=$_SESSION["login"];
			// $res = $daousuario->listarUsuario($login);
			// $usuario = $res[0];

			$daocomentario = new \app\model\comentario\DAOcomentario();
			$daocomentario->deletar($id);
			//atualizando a sessão
			
			header("Location:?do=perfil&sub=comentarista");
		}

	}

?>