<?php
	
	namespace app\model\usuario;

	include_once DIR."vendor/autoload.php";
    include_once DIR."bootstrap.php";

	class DAOusuario {

		function login($login, $senha) {
			global $entityManager;

			$query = $entityManager->createQuery('SELECT u FROM app\model\usuario\Comentarista u WHERE u.login = :login AND u.senha = :senha');

			$query->setParameter('login', $login);
			$query->setParameter('senha', sha1($senha));
			$user = $query->getResult();

			if ($user == null) {
				$query = $entityManager->createQuery('SELECT u FROM app\model\usuario\Administrador u WHERE u.login = :login AND u.senha = :senha');
				$query->setParameter('login', $login);
				$query->setParameter('senha', sha1($senha));
				$user = $query->getResult();
			}

			return $user;
		}

		function persistir($cpf, $nome, $login, $senha) {
			global $entityManager;
			$usuario = new \app\model\usuario\Comentarista();
			$usuario->setCpf($cpf);
			$usuario->setNome($nome);
			$usuario->setLogin($login);
			$usuario->setSenha(sha1($senha));


			$entityManager->persist($usuario);
			$entityManager->flush();
		}

		function listarUsuario($login) {
			global $entityManager;

			$query = $entityManager->createQuery('SELECT c FROM app\model\usuario\Comentarista c WHERE c.login like :login');
			$query->setParameter('login', $login);
			$valor = $query->getResult();

			return $valor;
		}

		function verificarAssistido($codigo) {
			global $entityManager;

			$login = $_SESSION["login"];
			$res = $this->listarUsuario($login);
			$usuario = $res[0];

			//procura na classe filmesassistidos com a chave composta: filme e usuario
			$res = $entityManager->find('app\model\usuario\FilmesAssistidos', array('filme' => $codigo, 'usuario' => $usuario->getCpf()));

			if ($res != null)
				return true;
			else
				return false;
		}

		function assistir($filme, $usuario) {
			global $entityManager;
			
			$filmesAssistidos = new \app\model\usuario\FilmesAssistidos();
			$filmesAssistidos->setFilme($filme);
			$filmesAssistidos->setUsuario($usuario);

			$entityManager->persist($filmesAssistidos);
			$entityManager->flush();
		}

		function listarAssistidos($cpf) {
			global $entityManager;
			
			//filmes assistidos do usuario $cpf
			$query = $entityManager->createQuery('SELECT a FROM app\model\usuario\FilmesAssistidos a');

			//$query->setParameter('cpf', $cpf);
			$result = $query->getResult();
			$assistidos = array();
			foreach ($result as $v) {
				if ($v->getUsuario()->getCpf() == $cpf)
					$assistidos[] = $v->getFilme()->getCodigo();

			}

			return $assistidos;
		}

		function desmarcar($codigo, $cpf) {
			global $entityManager;
			
			$res = $entityManager->find('app\model\usuario\FilmesAssistidos', array('filme' => $codigo, 'usuario' => $cpf));

			$entityManager->remove($res);
			$entityManager->flush();
		}

	}

?>