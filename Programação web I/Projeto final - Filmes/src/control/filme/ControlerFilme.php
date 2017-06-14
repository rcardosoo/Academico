<?php 
	namespace app\control\filme;

	class ControlerFilme {

		public function listarTodos() {
			$daofilme = new \app\model\filme\DAOfilme();
			$filmes = $daofilme->listar();

			if (!empty($filmes)) {
				# como passar a variavel post
				$_SESSION["filmes"]=$filmes;
				header("Location:?do=paineladm");
			} else {
				header("Location:?do=paineladm");
			}
		}

		public function alterar() {
			$daofilme = new \app\model\filme\DAOfilme();
			$id = $_POST["id"];
			$titulo=$_POST["titulo"];
			$sinopse=$_POST["sinopse"];
			$ano=$_POST["ano"];
			$genero=$_POST["genero"];
			$daofilme->atualizar($titulo, $sinopse, $ano, $genero, $id);
			//atualizando a sessão
			$_SESSION["filmes"]=$daofilme->listar();
			header("Location:?do=paineladm&msg=alterado");

		}

		public function deletar() {
			$daofilme = new \app\model\filme\DAOfilme();
			$id = $_POST["id"];
			$daofilme->deletar($id);
			//atualizando a sessão
			$_SESSION["filmes"]=$daofilme->listar();
			header("Location:?do=paineladm&msg=deletado");

		}

		public function cadastrar() {
			$titulo=$_POST["titulo"];
			$ano=intval($_POST["ano"]);
			$sinopse=$_POST["sinopse"];
			$genero=$_POST["genero"];
		
			$daofilme = new \app\model\filme\DAOfilme();
			$daofilme->persistir($titulo, $ano, $sinopse, $genero);
			//atualizando a sessão
			$_SESSION["filmes"]=$daofilme->listar();
			header("Location:?do=paineladm&msg=cadastrado");
		}

		public function localizarFilme($cod) {
			$daofilme = new \app\model\filme\DAOfilme();
			$valor = $daofilme->listarfilme($cod);

			if (empty($valor))
				return null;
			
			return $valor;
		}

		public function buscar(){
			$busca = $_POST["busca"];

			$daofilme = new \app\model\filme\DAOfilme();
			$resultados = $daofilme->buscar($busca);

			#$_POST["result"] = $resultado;

			if(!empty($resultados)){
				$_SESSION["resultados"] = $resultados;
				$_SESSION["busca"] = $busca;
				header("Location:?do=main");
			}else{
				header("Location:?do=main&msg=fail");
			}

			/*if(empty($_POST["result"])){
				header("Location:?do=main&msg=fail");
			}else{ 
				header("Location:?do=resultadosBusca");
			}*/
		}

		public function detalhe($id) {
			$daofilme = new \app\model\filme\DAOfilme();
			$daocomentario = new \app\model\comentario\DAOcomentario();
			$daousuario = new \app\model\usuario\DAOusuario();
			$valor = $daofilme->listarfilme($id);

			if (!empty($valor)) {
				$resultadoCom = $daocomentario->listarComentarios($id);
				if (isset($_SESSION["logado"]))
					if ($_SESSION["tipo"] == "app\model\usuario\Comentarista")
						$resultadoUs = $daousuario->verificarAssistido($id);

				$comentarios = $resultadoCom[0];
				$usuarios = $resultadoCom[1];

				if (!empty($comentarios)) {
					$_SESSION["comentariosFilme"] = $comentarios;
					$_SESSION["comentaristas"] = $usuarios;
				}

				if ($resultadoUs)
					$_SESSION["assistido"] = true;
				else
					$_SESSION["assistido"] = false;

				$_SESSION["detalheFilme"] = $valor;
				header("Location:?do=pageDetalhesFilme");
			}
		}
	}

?>