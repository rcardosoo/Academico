<?php 
	namespace app\control\usuario;

	class ControlerUsuario {

		public function cadastrar() {
			$nome=$_POST["nome"];
			$cpf=intval($_POST["cpf"]);
			$login=$_POST["login"];
			$senha=$_POST["senha"];
		
			$daousuario = new \app\model\usuario\DAOusuario();
			$daousuario->persistir($cpf, $nome, $login, $senha);
			header("Location:?do=cadastrar&msg=sucesso");
		}

		public function logar() {
			$user = null;
			$login=$_POST["login"];
			$senha=$_POST["senha"];

			$daousuario = new \app\model\usuario\DAOusuario();
			$user = $daousuario->login($login, $senha);

			$usuario = $user[0];		
			
			if($usuario != null) {
			    $_SESSION["logado"]=true;
			    $_SESSION["login"]=$login;
			  	$_SESSION["tipo"]=get_class($usuario);
			  	setcookie("userLogin", $login);
			    header("Location:?do=main");
		    } else{
	            header("Location:?do=login&msg=fail");
	        }
		}

		public function marcarAssistido($codigo) {
			$daousuario = new \app\model\usuario\DAOusuario();
			$daofilme = new \app\model\filme\DAOfilme();

			$login=$_SESSION["login"];
			$res = $daousuario->listarUsuario($login);
			$usuario = $res[0];

			$arrayFilme = $daofilme->listarfilme($codigo);
			$filme = $arrayFilme[0];

			$daousuario->assistir($filme, $usuario);
			header("Location:?do=detalhesFilme&sub=".$filme->getCodigo());

		}

		public function perfilComentarista() {
			$daousuario = new \app\model\usuario\DAOusuario();
			$daocomentario = new \app\model\comentario\DAOcomentario();
			unset($_SESSION["comentariosFilme"]);
			unset($_SESSION["filmesComentados"]);
			unset($_SESSION["assistidos"]);

			$login=$_SESSION["login"];
			$res = $daousuario->listarUsuario($login);
			$usuario = $res[0];
			
			$resultadoCom = $daocomentario->listarComentariosUsuario($usuario->getCpf());
			
			$comentarios = $resultadoCom[0];
			$filmes = $resultadoCom[1];

				if (!empty($comentarios)) {
					$_SESSION["comentariosFilme"] = $comentarios;
					$_SESSION["filmesComentados"] = $filmes;
				}

			$assistidos = $daousuario->listarAssistidos($usuario->getCpf());
			if (!empty($assistidos))
				$_SESSION["assistidos"] = $assistidos;

			header("Location:?do=pagePerfil");
		}

		public function desmarcar($codigo) {
			$daousuario = new \app\model\usuario\DAOusuario();


			$login=$_SESSION["login"];
			$res = $daousuario->listarUsuario($login);
			$usuario = $res[0];

			$daousuario = new \app\model\usuario\DAOusuario();
			$daousuario->desmarcar($codigo, $usuario->getCpf());

			//atualizando a sessão
			header("Location:?do=perfil&sub=comentarista");


		}
	}

?>