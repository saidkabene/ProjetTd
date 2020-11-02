package td3;

public class Puissance extends operationUnaire {

	private ExpressionArithmetique eaRight;
	
	public Puissance(ExpressionArithmetique eaLeft) {
		super(eaLeft);
	}
	
	public Puissance (ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft);
		this.eaRight= eaRight;
	}

	@Override
	public double calculer() {
		
		return Math.pow(this.eaLeft.calculer(),this.eaRight.calculer());
	}

	@Override
	public String afficher() {
		return this.eaLeft.afficher()+"^"+this.eaRight.afficher();
	}
	
	@Override
	public ExpressionArithmetique simplifie(ExpressionArithmetique  gauche) {
		System.out.println("qsf");
		return new Puissance(eaLeft);
		
	}
	
	
	public String toString() {
		
	return  Double.toString(this.calculer());
	}
}
