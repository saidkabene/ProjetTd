package td3;



public class VariableSymbolique implements ExpressionArithmetique{

	
	private String x ;

	
	public VariableSymbolique(String x) {
		super();
		this.x=x;
	}
	
	@Override
	public ExpressionArithmetique simplifier() {
	
	return this;
	}



	@Override
	public String afficher() {

		return this.x;
	}

	@Override
	public double  calculer() {
		
		
		return Double.valueOf(x);
	
	}






	
}
