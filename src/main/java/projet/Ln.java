package projet;

import java.util.Map;

public class Ln extends OperationUnaire{

	
	public Ln(ExpressionArithmetique eaLeft) {
		super(eaLeft);
	}

	public String calculerWithVar(ExpressionArithmetique x) {
		return new StringBuilder().
					append(x.simplifier().afficher()).toString();
	}
	@Override
	public ExpressionArithmetique simplifie(ConstEntiere gauche) {
			
		return new Ln (gauche.simplifier());
		
	}
	
	@Override
	public double calculer(Map<String, ExpressionArithmetique> value)  {
		
				return Math.log(this.eaLeft.calculer(value));
			
	}
	
	@Override
	public String afficher() {
		
		return "ln("+ this.eaLeft.simplifier().afficher()+")";
	}
	@Override
    public boolean equals(Object obj) {
        boolean res = false;
        if (this.getClass().equals(obj.getClass())) {
            Ln cons1 = (Ln) this;
            Ln cons2 = (Ln) obj;
            if (cons1.eaLeft == cons2.eaLeft) {
                res = true;
            }
        }
        return res;

    }
	




}
