package projet;

import java.util.Map;

public final class ConstEntiere implements ExpressionArithmetique {

	public ConstEntiere(int value) {
		this.entier = value;
	}
	
	public int getEntier() {
		return entier;
	}

	private final int entier;

	
	@Override
	public double calculer(Map<String, ExpressionArithmetique> value) {
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
