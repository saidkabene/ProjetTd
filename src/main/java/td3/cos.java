

public class cos extends operationUnaire{
	
	public cos(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft, eaRight);
	}

	private VariableSymbolique x;
	private ConstanteSymbolique i ;
	
	public cos (VariablesSymbolique x) {
		super();
		this.x=x;
	}
	public cos (ConstanteSymbolique i) {
		this.i=i;
	}

	
	
	@Override
	public ExpressionArithmetique simplifie(ConstEntiere gauche) {
		return simplifie( (ConstEntiere) gauche.simplifier());
	}
	
	


	@Override
	public double calculer() {
		return Math.cos(this.eaLeft.calculer());
	}

	@Override
	public String afficher() {
		
		return "Cos("+this.eaLeft.afficher()+")"+ this.eaLeft.simplifier();
	}

	
	

	
}
