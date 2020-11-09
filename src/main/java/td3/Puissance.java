package td3;

import java.util.Map;

public class Puissance extends OperationUnaire {

	private ExpressionArithmetique eaRight;
	
	public Puissance(ExpressionArithmetique eaLeft) {
		super(eaLeft);
	}
	
	public Puissance (ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft);
		this.eaRight= eaRight;
	}

	@Override
	public double calculer(Map<String, ExpressionArithmetique> value) {
		
		return Math.pow(this.eaLeft.calculer(value),this.eaRight.calculer(value));
	}

	@Override
	public String afficher() {
		return this.eaLeft.afficher()+"^"+this.eaRight.afficher();
	}
	
	@Override
	public ExpressionArithmetique simplifie(ExpressionArithmetique  gauche) {
		System.out.println("qsf");
		return this;
		
	}
	
	
}
