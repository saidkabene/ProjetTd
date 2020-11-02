package td3;

public class sin extends operationUnaire{
	private String x ; 
	
	
	public sin (ExpressionArithmetique eaLeft) {
		super(eaLeft);
			
	}
	public sin(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft);
	}

	@Override
	public ExpressionArithmetique simplifie(ConstEntiere gauche) {
		return  this.simplifie( gauche.simplifier());
				
	}
	
	@Override
	public ExpressionArithmetique simplifie(VariableSymbolique gauche) {
		System.out.println("dqsd");
		return new sin (gauche);
		
	}
	

	@Override
	public ExpressionArithmetique simplifie(ConstRationnelle gauche) {
		return this.simplifie (gauche.simplifier());
		
	}


	@Override
	public double calculer()  {
			try {
				return Math.sin(this.eaLeft.calculer());
			
		} catch (NumberFormatException e ) {
			 System.out.println("le resultat est "+"  "+ calculerWithVar(this.eaLeft)+"correcte mais on ne peut pas calculer la valiableSymbolique" );
	
		}
			return Math.cos(this.eaLeft.calculer());
			
	}
	
	public String calculerWithVar(ExpressionArithmetique x) {
		return new StringBuilder().
					append(x.simplifier().afficher()).toString();
	}


	@Override
	public String afficher() {
		return "sin("+ this.eaLeft.afficher()+ ")";
	}
	public String toString() {
		
		
		return this.eaLeft.simplifier().afficher()  ;
	}

}
