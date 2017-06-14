<?php 
	namespace app\model\usuario;
	/** @MappedSuperclass */
	abstract class Usuario {
		/**
		 * @Id
		 * @Column(type="integer", name="cpf")
		 */
		protected $cpf;
		/** 
		 * @Column(type="string", name="nome")
		 */
		protected $nome;
		/** 
		 * @Column(type="string", length=40, name="login") 
		 */
		protected $login;
		/** 
		 * @Column(type="string", length=40, name="senha") 
		 */
		protected $senha;

		function __construct() {}

		// function __construct($cpf, $nome, $login, $senha) {
		// 	$this->cpf = $cpf;
		// 	$this->nome = $nome;
		// 	$this->login = $login;
		// 	$this->senha = $senha;
		// }

		public function getCpf() {
			return $this->cpf;
		}
		/**
		* @param mixed $cpf
		*/
		public function setCpf($cpf) {
			$this->cpf = $cpf;
		}

		public function getNome() {
			return $this->nome;
		}
		/**
		* @param mixed $nome
		*/
		public function setNome($nome) {
			$this->nome = $nome;
		}

		public function getLogin() {
			return $this->login;
		}

		public function setLogin($login) {
			$this->login = $login;
		}

		public function getSenha() {
			return $this->senha;
		}

		public function setSenha($senha) {
			$this->senha = $senha;
		}      
	}
?>