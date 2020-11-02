package td3;

public class ln extends operationUnaire{

	public ln(ExpressionArithmetique eaLeft) {
		super(eaLeft);
	}

	public String calculerWithVar(ExpressionArithmetique x) {
		return new StringBuilder().
					append(x.simplifier().afficher()).toString();
	}
	
	@Override
	public double calculer()  {
			try {
				return Math.log(this.eaLeft.calculer());
			
		} catch (NumberFormatException e ) {
			System.out.println("le resultat est "+"  "+ calculerWithVar(this)+"correcte mais on ne peut pas calculer la valiableSymbolique" );
	
		}
			return Math.log(this.eaLeft.calculer());
			
	}
	
	@Override
	public String afficher() {
		
		return "ln"+ this.eaLeft.simplifier().afficher();
	}

}
