package td3;

public final class ConstEntiere implements ExpressionArithmetique {

	public ConstEntiere(int value) {
		this.entier = value;
	}
	public ConstEntiere(int value, VariableSymbolique x ){
		super();
		this.entier = value;
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
		// TODO Auto-generated method stub
		return this;
	}
}
