<?php 
	namespace app\model\comentario;
	/**
	 * @Entity
	 * @Table(name="comentario")
	 */
	class Comentario {
		/** 
		* @Id @Column(type="integer") @GeneratedValue 
		*/
		private $id;
		/**
		 * @ManyToOne(targetEntity="\app\model\filme\Filme", inversedBy="comentarios")
		 * @JoinColumn(name="codigo", referencedColumnName="codigo", nullable=false)
		 */
		private $filme;
		/**
		 * @ManyToOne(targetEntity="\app\model\usuario\Comentarista", inversedBy="comentarios")
		 * @JoinColumn(name="cpf", referencedColumnName="cpf", nullable=false)
		 */
		private $usuario;
		/** 
		* @Column(type="string", nullable=false) 
		*/
		private $texto;

		public function getId() {
			return $this->id;
		} 

		public function getFilme() {
			return $this->filme;
		} 

		public function setFilme($filme) {
			$this->filme = $filme;
		}

		public function getUsuario() {
			return $this->usuario;
		}

		public function setUsuario($usuario) {
			$this->usuario = $usuario;
		}  

		public function getTexto() {
			return $this->texto;
		}

		public function setTexto($texto) {
			$this->texto = $texto;
		}
	}

?>