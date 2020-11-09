package td3;

import java.util.Map;

public class RacineCarree extends OperationUnaire {

	public RacineCarree(ExpressionArithmetique eaLeft) {
		super(eaLeft);

	}

	@Override
	public double calculer(Map<String, ExpressionArithmetique> value) {
		
		return Math.sqrt(this.eaLeft.calculer(value));
	}

	@Override
	public String afficher() {
		
		return "sqrt" + this.eaLeft.simplifier().afficher();
	}
	
	

}
