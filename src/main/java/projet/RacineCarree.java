package projet;

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
			
		return "√" + this.eaLeft.simplifier().afficher();
	}
	@Override
	public ExpressionArithmetique simplifie(ConstEntiere gauche) {
			if(Math.sqrt(gauche.getEntier())% 1 == 0) {
				return new ConstEntiere((int) Math.sqrt(gauche.getEntier()));
			}
		return this.simplifie(gauche.simplifier());
			
	}

}
