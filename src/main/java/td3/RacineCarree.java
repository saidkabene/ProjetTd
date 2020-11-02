package td3;

public class RacineCarree extends operationUnaire {

	public RacineCarree(ExpressionArithmetique eaLeft) {
		super(eaLeft);

	}

	@Override
	public double calculer() {
		
		return Math.sqrt(this.eaLeft.calculer());
	}

	@Override
	public String afficher() {
		
		return "sqrt" + this.eaLeft.simplifier().afficher();
	}
	
	

}
