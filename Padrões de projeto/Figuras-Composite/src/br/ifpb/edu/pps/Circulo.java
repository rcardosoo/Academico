package br.ifpb.edu.pps;

public class Circulo extends FiguraComposta {

	@Override
	public void areaFigura() {
		// TODO Auto-generated method stub
		System.out.println("Área Círculo");
	}

	@Override
	public void perimetroFigura() {
		// TODO Auto-generated method stub
		System.out.println("Perímetro Círculo");
	}

	@Override
	public void desenharFigura() {
		// TODO Auto-generated method stub
		System.out.println("Desenhando Círculo");
	}

	@Override
	public String toString() {
		String texto = "[ Círculo ]";
		if (!this.getFiguras().isEmpty()) {
			for(Figura f : this.getFiguras()) {
				texto += " + "+f.toString();
			}
		}
		return texto;
	}

	
}
