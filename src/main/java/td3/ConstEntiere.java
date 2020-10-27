package td3;

public final class ConstEntiere implements ExpressionArithmetique {

	public ConstEntiere(int value) {
		this.entier = value;
	}
	public ConstEntiere(int value, VariableSymbolique x ) {
		this.entier = value;
	}

	public int getEntier() {
		return entier;
	}

	private final int entier;

	@Override
	public ExpressionArithmetique simplifier() {
		return this;
	}

	@Override
	public double calculer() {
		return this.getEntier();
	}

	@Override
	public String afficher() {
		
		return  String.valueOf(entier);
	}
}
