package br.ifpb.edu.pps;

public class FiguraAdapter extends Figura {
	private Figura figura;
	
	public FiguraAdapter(Figura f) {
		this.figura = f;
	}
	
	@Override
	public void areaFigura() {
		// TODO Auto-generated method stub
		this.figura.areaFigura();
	}

	@Override
	public void perimetroFigura() {
		// TODO Auto-generated method stub
		this.figura.perimetroFigura();
	}

	@Override
	public void desenharFigura() {
		// TODO Auto-generated method stub
		this.figura.desenharFigura();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.figura.toString();
	}

}
