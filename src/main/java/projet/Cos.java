package projet;

import java.util.Map;

public class Cos extends OperationUnaire {
	
	public Cos(ExpressionArithmetique eaLeft) {
		super(eaLeft);
	}

	public Cos(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft);
	}

	@Override
	public ExpressionArithmetique simplifie(ConstEntiere gauche) {
		if(gauche.getEntier() == 0) {
			
			return new ConstEntiere(1);
		}
		
		return new ConstEntiere((int) Math.cos(gauche.getEntier()));
				
	}
	
	
	@Override
	public ExpressionArithmetique simplifie(VariableSymbolique gauche) {
		return new Cos (gauche.simplifier());
		
	}
	


	@Override
	public ExpressionArithmetique simplifie(Division gauche) {
		
		if(gauche.eaLeft instanceof ConstanteSymbolique && gauche.eaRight instanceof ConstEntiere) {
		
			ConstanteSymbolique pi = (ConstanteSymbolique )gauche.eaLeft;
			ConstEntiere entier = (ConstEntiere) gauche.eaRight;
		
			if(pi.getSymb().equals("pi") && entier.getEntier() == 2 ) {
				return new ConstEntiere(1);
			
			} else if (pi.getSymb().equals("pi") && entier.getEntier() == 4) {
				return new Division(new RacineCarree(new ConstEntiere(2)),new ConstEntiere(2));
			
			}else if (pi.getSymb().equals("pi") && entier.getEntier() == 3) {	
				return new Division(new RacineCarree(new ConstEntiere(3)),new ConstEntiere(2));
			
			}else if (pi.getSymb().equals("pi") && entier.getEntier() == 6) {
				return new Division(new ConstEntiere(1),new ConstEntiere(2));
			}
			
		}

		if(gauche.eaLeft instanceof Multiplication && gauche.eaRight instanceof ConstEntiere) {
			Multiplication mul = (Multiplication) gauche.eaLeft;
		    ConstEntiere deux = (ConstEntiere)mul.eaLeft;
		    ConstanteSymbolique pii = (ConstanteSymbolique)mul.eaRight;
		
		    ConstEntiere entierr = (ConstEntiere) gauche.eaRight;
		    
			if(deux.getEntier() == 2 && pii.getSymb().equals("pi")  && entierr.getEntier()==3 ) {
				
				return new Division(new ConstEntiere(-1), new ConstEntiere(2));	
			
			}else if(deux.getEntier() == 3 && pii.getSymb().equals("pi") && entierr.getEntier()==4 ) {
				
				return new Division(new RacineCarree(new ConstEntiere(-2)), new ConstEntiere(2));
				
			} else if(deux.getEntier() == 5 && pii.getSymb().equals("pi") && entierr.getEntier()==6 ) {
				
				return  new Division(new RacineCarree(new ConstEntiere(3)), new ConstEntiere(2));	
			} 
				
		  }
		return new Cos( new Division(gauche.eaLeft, gauche.eaRight));
		
	}


	@Override
	public double calculer(Map<String, ExpressionArithmetique> value)  {
		
			return Math.cos(this.eaLeft.calculer(value));
			
	}
	
	@Override
	public String afficher() {
		
		return "Cos("+this.eaLeft.afficher()+")";
	}
	@Override
    public boolean equals(Object obj) {
        boolean res = false;
        if (this.getClass().equals(obj.getClass())) {
            Cos cons1 = (Cos) this;
            Cos cons2 = (Cos) obj;
            if (cons1.eaLeft == cons2.eaLeft) {
                res = true;
            }
        }
        return res;
    }
	
	

	
}
