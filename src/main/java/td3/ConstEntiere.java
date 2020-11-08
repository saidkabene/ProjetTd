package td3;

public final class ConstEntiere implements ExpressionArithmetique {

	public ConstEntiere(int value) {
		this.entier = value;
	}
	


	public ConstEntiere(double d) {
		this.entier = (int) d;
	}


	public int getEntier() {
		return entier;
	}

	private final int entier;

	
	@Override
	public double calculer() {
		return this.getEntier();
	}

	@Override
	public String afficher() {
		
		return  String.valueOf(entier);
	}
	@Override
	public ExpressionArithmetique simplifier() {
	
		return this;
	}
	@Override
	public String toString() {
		return String.valueOf(entier);
	}
	
	
}
