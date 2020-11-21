package projet;

import java.util.Map;

public class RacineCarree extends OperationUnaire {

	public RacineCarree(ExpressionArithmetique eaLeft) {
		super(eaLeft);

	}
	@Override
	public ExpressionArithmetique simplifie(ConstEntiere gauche) {
			if(Math.sqrt(gauche.getEntier())% 1 == 0) {
				return new ConstEntiere((int) Math.sqrt(gauche.getEntier()));
			}
		return this.simplifie(gauche.simplifier());
			
	}

	@Override
	public double calculer(Map<VariableSymbolique, ExpressionArithmetique> value) {
		
		return Math.sqrt(this.eaLeft.calculer(value));
	}

	@Override
	public String afficher() {
			
		return "√" + this.eaLeft.simplifier().afficher();
	}
	
	@Override
    public boolean equals(Object obj) {
        boolean res = false;
        if (this.getClass().equals(obj.getClass())) {
            RacineCarree cons1 = (RacineCarree) this;
            RacineCarree cons2 = (RacineCarree) obj;
            if (cons1.eaLeft == cons2.eaLeft) {
                res = true;
            }
        }
        return res;
    }

}
