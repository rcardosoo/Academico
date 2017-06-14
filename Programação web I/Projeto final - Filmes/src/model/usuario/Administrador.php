<?php 
	namespace app\model\usuario;
	/**
	 * @Entity
	 * @Table(name="administrador")
	 */
	class Administrador extends Usuario {

		function __construct() {}

		// public function __construct($cpf, $nome, $login, $senha) {
  //      		parent::__construct($cpf, $nome, $login, $senha);
  // 		}

	}

?>