<?php 
	namespace app\model\filme;
	/**
	 * @Entity
	 * @Table(name="filme")
	 */
	class Filme {
		/** 
		* @Id @Column(type="integer") @GeneratedValue 
		*/
		private $codigo;
		/** 
		* @Column(type="string", nullable=false) 
		*/
		private $titulo;
		/** 
		* @Column(type="string", nullable=false) 
		*/
		private $sinopse;
		/** 
		* @Column(type="integer", nullable=false) 
		*/
		private $ano;
		/** 
		* @Column(type="string", nullable=false) 
		*/
		private $genero;
		/**
		 * @OneToMany(targetEntity="\app\model\comentario\Comentario", mappedBy="filme", cascade={"all"})
		 */
		private $comentarios=array();
		/**
		 * @OneToMany(targetEntity="\app\model\usuario\FilmesAssistidos", mappedBy="filme", cascade={"all"})
		 */
		private $assistidos=array();


		public function getCodigo() {
			return $this->codigo;
		}

		public function setCodigo($codigo) {
			$this->codigo = $codigo;
		}

		public function getTitulo() {
			return $this->titulo;
		}

		public function setTitulo($titulo) {
			$this->titulo = $titulo;
		}

		public function getSinopse() {
			return $this->sinopse;
		}

		public function setSinopse($sinopse) {
			$this->sinopse = $sinopse;
		}

		public function getAno() {
			return $this->ano;
		}

		public function setAno($ano) {
			$this->ano = $ano;
		}

		public function getGenero() {
			return $this->genero;
		}

		public function setGenero($genero) {
			$this->genero = $genero;
		}

		public function getComentarios() {
			return $this->comentarios;
		}

		public function adicionarComentario($comentario) {
			$this->comentarios[] = $comentario;
		}

		public function removerComentario($comentario) {
			#se nao funcionar, fazer com foreach
			$v = array_search($comentario, $this->comentarios);
			if($v !== false) {
				unset($this->comentarios[$v]);
				return true;
			} else {
				return false;
			}
		}

		public function localizarComentario($comentario) {
			#ver se dá pra fazer com array_search
			foreach($this->comentarios as $v) {
				if ($v === $comentario)
					return $v;
				else
					return null;
			} 
		}

		public function adicionarComentarista($comentarista) {
			$this->comentaristas[] = $comentarista;
		}

		public function removerComentarista($comentarista) {
			#se nao funcionar, fazer com foreach
			$v = array_search($comentarista, $this->comentaristas);
			if($v !== false) {
				unset($this->comentaristas[$v]);
				return true;
			} else {
				return false;
			}
		}

		public function localizarComentarista($comentarista) {
			#ver se dá pra fazer com array_search
			foreach($this->comentaristas as $v) {
				if ($v === $comentarista)
					return $v;
				else
					return null;
			} 
		}
	}

?>