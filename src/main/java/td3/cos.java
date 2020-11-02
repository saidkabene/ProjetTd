package td3;

public class cos extends operationUnaire {
	
	public cos(ExpressionArithmetique eaLeft) {
		super(eaLeft);
	}

	public cos(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft);
	}



	@Override
	public ExpressionArithmetique simplifie(ConstEntiere gauche) {
		return  this.simplifie( gauche.simplifier());
				
	}
	
	@Override
	public ExpressionArithmetique simplifie(VariableSymbolique gauche) {
		return new cos (gauche.simplifier());
		
	}
	

	@Override
	public ExpressionArithmetique simplifie(ConstRationnelle gauche) {
		return new cos (gauche.simplifier());
		
	}
	
	public String calculerWithVar(ExpressionArithmetique x) {
		return new StringBuilder().
					append(x.simplifier().afficher()).toString();
	}

	@Override
	public double calculer()  {
			try {
				return Math.cos(this.eaLeft.calculer());
			
		} catch (NumberFormatException e ) {
			System.out.println("le resultat est "+"  "+ calculerWithVar(this)+"correcte mais on ne peut pas calculer la valiableSymbolique" );
	
		}
			return Math.cos(this.eaLeft.calculer());
			
	}
	
	
	
	@Override
	public String afficher() {
		
		return "Cos("+this.eaLeft.afficher()+")";
	}

	public String toString() {
		
		
		return this.eaLeft.simplifier().afficher()  ;
	}
	
	

	
}
