package td3;

import java.util.Map;

public class Ln extends OperationUnaire{

	public Ln(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft);
	}
	public Ln(ExpressionArithmetique eaLeft) {
		super(eaLeft);
	}

	public String calculerWithVar(ExpressionArithmetique x) {
		return new StringBuilder().
					append(x.simplifier().afficher()).toString();
	}
	@Override
	public ExpressionArithmetique simplifie(ConstRationnelle gauche) {
		return this.simplifie (gauche.simplifier());
		
	}
	
	@Override
	public double calculer(Map<String, ExpressionArithmetique> value)  {
		
				return Math.log(this.eaLeft.calculer(value));
			
	}
	
	@Override
	public String afficher() {
		
		return  this.eaLeft.simplifier().afficher();
	}
	




}
