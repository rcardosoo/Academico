package br.ifpb.edu.pps;

public class Triangulo extends FiguraComposta {

	@Override
	public void areaFigura() {
		// TODO Auto-generated method stub
		System.out.println("Área Triângulo");
	}

	@Override
	public void perimetroFigura() {
		// TODO Auto-generated method stub
		System.out.println("Perímetro Triângulo");
	}

	@Override
	public void desenharFigura() {
		// TODO Auto-generated method stub
		System.out.println("Desenhando Triângulo");
	}

	@Override
	public String toString() {
		String texto = "[ Triângulo ]";
		if (!this.getFiguras().isEmpty()) {
			for(Figura f : this.getFiguras()) {
				texto += " + "+f.toString();
			}
		}
		return texto;
	}
	
}
