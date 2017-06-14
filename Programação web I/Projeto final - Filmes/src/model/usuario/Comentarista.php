<?php 
	namespace app\model\usuario;
	/**
	 * @Entity
	 * @Table(name="comentarista")
	 */
	class Comentarista extends Usuario {
		/**
		 * @OneToMany(targetEntity="\app\model\comentario\Comentario", mappedBy="usuario", cascade={"all"})
		 */
		private $comentarios=array();
		/**
		 * @OneToMany(targetEntity="\app\model\usuario\FilmesAssistidos", mappedBy="usuario")
		 */
		private $assistidos=array();

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

		//------------------------------------------------

		public function adicionarFilme($filme) {
			$this->filmesAssistidos[] = $filme;
		}

		public function removerFilme($filme) {
			#se nao funcionar, fazer com foreach
			$v = array_search($filme, $this->filmesAssistidos);
			if($v !== false) {
				unset($this->filmesAssistidos[$v]);
				return true;
			} else {
				return false;
			}
		}

		public function localizarFilme($filme) {
			#ver se dá pra fazer com array_search
			foreach($this->filmesAssistidos as $v) {
				if ($v === $filme)
					return $v;
				else
					return null;
			} 
		}
	}

?>