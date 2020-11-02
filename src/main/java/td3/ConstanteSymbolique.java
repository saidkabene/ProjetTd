package td3;

public class ConstanteSymbolique implements ExpressionArithmetique{

	private String symb;

	
	
	public ConstanteSymbolique (String symb) {
		this.symb = symb;
	}
	
	public double calculer() {
		double res = 0;
		if(this.symb == "pi") {
			res = Math.PI;
		} else if(this.symb == "e") {
			res = Math.E;
		}
		return res;
	}
	
	@Override
	public String afficher() {
		
		String res = null;
		if(this.symb == "pi") {
			res = "π";
		} else if(this.symb == "e") {
			res = "e";
		}
		return res;
	}
	@Override
	public ExpressionArithmetique simplifier() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
