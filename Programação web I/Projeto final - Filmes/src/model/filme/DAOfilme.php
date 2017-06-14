<?php 

	namespace app\model\filme;

	include_once DIR."vendor/autoload.php";
    include_once DIR."bootstrap.php";

	class DAOfilme {

		function listar() {
			global $entityManager;

			$query = $entityManager->createQuery('SELECT f FROM app\model\filme\Filme f');
			$result = $query->getResult();
			return $result;
		}

		function atualizar($titulo, $sinopse, $ano, $genero, $id) {
			global $entityManager;
			$filme = $entityManager->find('\app\model\filme\Filme', $id);
			$filme->setTitulo($titulo);
			$filme->setSinopse($sinopse);
			$filme->setAno($ano);
			$filme->setGenero($genero);

			$entityManager->merge($filme);
			$entityManager->flush();
			return $filme;
		}

		function deletar($id) {
			global $entityManager;
			$filme = $entityManager->find('\app\model\filme\Filme', $id);
			$entityManager->remove($filme);
			$entityManager->flush();
			// $query = $entityManager->createQuery('DELETE FROM app\model\filme\Filme f WHERE f.codigo = :cod');
			// $query->setParameter('cod', $id);
			// $valor = $query->getResult();
		}

		function persistir($titulo, $ano, $sinopse, $genero) {
			global $entityManager;
			$filme = new \app\model\filme\Filme();
			$filme->setTitulo($titulo);
			$filme->setAno($ano);
			$filme->setSinopse($sinopse);
			$filme->setGenero($genero);


			$entityManager->persist($filme);
			$entityManager->flush();
		}

		function listarfilme($cod) {
			global $entityManager;

			$query = $entityManager->createQuery('SELECT f FROM app\model\filme\Filme f WHERE f.codigo = :cod');
			$query->setParameter('cod', $cod);
			$valor = $query->getResult();
			return $valor;
		}

		function buscar($busca){
			global $entityManager;

			$query = $entityManager->createQuery('select f from app\model\filme\Filme f where f.titulo like :busca or f.genero like :busca');

			$query->setParameter('busca', '%'.$busca.'%');
			$result = $query->getResult();

			return $result;
		}
	}

?>