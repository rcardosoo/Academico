<?php 
	namespace app\model\usuario;
	/**
	 * @Entity
	 * @Table(name="filmesassistidos")
	 */
	class FilmesAssistidos {
		/**
		 * @Id
		 * @ManyToOne(targetEntity="\app\model\filme\Filme", inversedBy="assistidos")
		 * @JoinColumn(name="filme", referencedColumnName="codigo", nullable=false)
		 */
		private $filme;
		/**
		 * @Id
		 * @ManyToOne(targetEntity="\app\model\usuario\Comentarista", inversedBy="assistidos")
		 * @JoinColumn(name="usuario", referencedColumnName="cpf", nullable=false)
		 */
		private $usuario;


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
	}

?>