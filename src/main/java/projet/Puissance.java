package projet;

import java.util.Map;



public class Puissance extends OperationUnaire {

	private ExpressionArithmetique eaRight;

	
	public Puissance (ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft);
		this.eaRight= eaRight;
	}

	public ExpressionArithmetique getEaRight() {
		return eaRight;
	}

	public void setEaRight(ExpressionArithmetique eaRight) {
		this.eaRight = eaRight;
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
	public ExpressionArithmetique simplifie(ConstEntiere droite) {
		if (droite.getEntier() == 0) {
			return new ConstEntiere(1);
		}
		
		return this;
		
	} 
	
	
}
