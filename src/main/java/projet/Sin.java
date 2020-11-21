package projet;

import java.util.Map;



public class Sin extends OperationUnaire{
 
	
	
	public Sin (ExpressionArithmetique eaLeft) {
		super(eaLeft);
			
	}


	@Override
	public ExpressionArithmetique simplifie(ConstEntiere gauche) {
		if(gauche.getEntier() == 0) {
			
			return new ConstEntiere(0);
			
		}
		if(Math.sin(gauche.getEntier())% 1 == 0) {
			
			return new ConstEntiere((int) Math.sqrt(gauche.getEntier()));
		}
		
		return  gauche.simplifier();
				
	}
	
	@Override
	public ExpressionArithmetique simplifie(VariableSymbolique gauche) {
		
		return new Sin (gauche);
		
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
		    
			if(deux.getEntier() == 2 && pii.getSymb().equals("pi") && entierr.getEntier()==3 ) {
				
				return new Division(new RacineCarree(new ConstEntiere(3)), new ConstEntiere(2));	
			
			}else if(deux.getEntier() == 3 && pii.getSymb().equals("pi") && entierr.getEntier()==4 ) {
				
				return new Division(new RacineCarree(new ConstEntiere(2)), new ConstEntiere(2));
						
			} else if(deux.getEntier() == 5 && pii.getSymb().equals("pi") && entierr.getEntier()==6 ) {
				
				return new Division(new ConstEntiere(1), new ConstEntiere(2));	
			} 
				
	   }
		return new Sin( new Division(gauche.eaLeft, gauche.eaRight));
		
	}
	@Override
    public boolean equals(Object obj) {
        boolean res = false;
        if (this.getClass().equals(obj.getClass())) {
            Sin cons1 = (Sin) this;
            Sin cons2 = (Sin) obj;
            if (cons1.eaLeft == cons2.eaLeft) {
                res = true;
            }
        }
        return res;
}
	
	@Override
	public double calculer(Map<VariableSymbolique, ExpressionArithmetique> value)  {
	
			return Math.sin(this.eaLeft.calculer(value));
			
	}
	


	@Override
	public String afficher() {
		return "sin("+ this.eaLeft.afficher()+ ")";
	}
	

}
