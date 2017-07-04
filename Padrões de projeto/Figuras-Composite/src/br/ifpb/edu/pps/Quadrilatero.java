package br.ifpb.edu.pps;

public class Quadrilatero extends FiguraComposta {

	
	@Override
	public void areaFigura() {
		// TODO Auto-generated method stub
		System.out.println("Área Quadrilátero");
	}

	@Override
	public void perimetroFigura() {
		// TODO Auto-generated method stub
		System.out.println("Perímetro Quadrilátero");
	}

	@Override
	public void desenharFigura() {
		// TODO Auto-generated method stub
		System.out.println("Desenhando Quadrilátero");
	}

	@Override
	public String toString() {
		String texto = "[ Quadrilátero ]";
		if (!this.getFiguras().isEmpty()) {
			for(Figura f : this.getFiguras()) {
				texto += " + "+f.toString();
			}
		}
		return texto;
	}

}
