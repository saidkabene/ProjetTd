package td3;

public class VariableSymbolique implements ExpressionArithmetique{

	private char value ;
	
	public VariableSymbolique(char x) {
		super();
		this.value = x;
	}

	@Override
	public ExpressionArithmetique simplifier() {
	
		return this;
	}

	@Override
	public double calculer() {
		
		return this.getValue();
	}

	@Override
	public String afficher() {

		return null;
	}

	public char getValue() {
		return value;
	}

}
