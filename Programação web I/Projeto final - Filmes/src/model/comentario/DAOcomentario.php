<?php 
	
	namespace app\model\comentario;

	include_once DIR."vendor/autoload.php";
    include_once DIR."bootstrap.php";

	class DAOcomentario {

		public function listarComentarios($codigo) {
			global $entityManager;

			//comentarios do filme $codigo
			$query = $entityManager->createQuery('SELECT c FROM app\model\comentario\Comentario c JOIN c.filme f WHERE f.codigo = :cod');

			$query->setParameter('cod', $codigo);
			$result = $query->getResult();
			$usuarios = array();
			foreach ($result as $r) {
				$usuarios[] = $r->getUsuario()->getNome();
			}
			return array($result, $usuarios);
		}

		public function persistir($texto, $filme, $usuario) {
			global $entityManager;
			$comentario = new \app\model\comentario\Comentario();
			$comentario->setFilme($filme);
			$comentario->setUsuario($usuario);
			$comentario->setTexto($texto);
			$entityManager->persist($comentario);
			$entityManager->flush();
		}

		public function listarComentariosUsuario($cpf) {
			global $entityManager;
			
			//comentarios do usuario $cpf
			$query = $entityManager->createQuery('SELECT c FROM app\model\comentario\Comentario c JOIN c.usuario u WHERE u.cpf = :cpf');

			$query->setParameter('cpf', $cpf);
			$result = $query->getResult();
			$filmes = array();
			foreach ($result as $r) {
				$filmes[] = $r->getFilme()->getCodigo();
			}
			return array($result, $filmes);
		}

		function deletar($id) {
			global $entityManager;
		
			$res = $entityManager->find('app\model\comentario\Comentario', $id);
			$entityManager->remove($res);
			$entityManager->flush();
		}
	}

?>