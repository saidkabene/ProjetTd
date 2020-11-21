package projet;

import java.util.Map;

public class Multiplication extends OperationBinaire {

	public Multiplication(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft, eaRight);

	}


	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstEntiere droite) {
	
		
		return new ConstRationnelle(droite.getEntier() * gauche.getNumerateur(), gauche.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstRationnelle droite) {
		
		return new ConstRationnelle(gauche.getNumerateur() * droite.getNumerateur(),
				droite.getDenominateur() * gauche.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstEntiere droite) {
		return new ConstEntiere(gauche.getEntier() * droite.getEntier()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstRationnelle droite) {
		
		
		return new ConstRationnelle(gauche.getEntier()* droite.getNumerateur(),droite.getDenominateur()).simplifier();
	}
	@Override
      protected ExpressionArithmetique simplifie(ConstEntiere gauche, VariableSymbolique droite) {
		
		if (gauche.getEntier() == 1) {
			
			return droite.simplifier();
		}
		
		return this.simplifie(droite.simplifier(), gauche);
	}
	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, VariableSymbolique droite) {
		
		return this.simplifie(gauche.simplifier(),droite);
	}
	@Override
	protected ExpressionArithmetique simplifie(VariableSymbolique gauche, ConstEntiere droite) {
		if (droite.getEntier() == 1) {
			
			return gauche.simplifier();
		}
		return this.simplifie(droite.simplifier(), gauche);
	}
	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Addition droite) {
	
	
		return new Addition(new Multiplication(gauche, droite.eaLeft),new Multiplication(gauche, droite.eaRight).simplifier());
	}
	@Override

	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Soustraction droite) {
	
	
		return new Soustraction(new Multiplication(gauche, droite.eaLeft),new Multiplication(gauche, droite.eaRight).simplifier());
	}
	@Override
    protected ExpressionArithmetique simplifie(Puissance gauche, Puissance droite) {
    
            return new Puissance(gauche.eaLeft,new Addition(gauche.getEaRight(),droite.getEaRight()).simplifier());
       
     
    }

	


	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Multiplication droite) {
	
		return new Multiplication( new Multiplication(gauche, droite.eaLeft),droite.eaRight.simplifier()).simplifier();
	}

	
	@Override
	protected ExpressionArithmetique simplifie(VariableSymbolique gauche, ConstRationnelle droite) {
		
		return this.simplifie(droite, gauche).simplifier();
	}
	

	
	
	@Override
	public double calculer(Map<VariableSymbolique, ExpressionArithmetique> value) {
		
		return this.eaLeft.calculer(value) * this.eaRight.calculer(value);
	}	

	@Override
    public String afficher() {
    
        if (this.eaLeft instanceof Multiplication || this.eaLeft instanceof Puissance || this.eaLeft instanceof VariableSymbolique) {
            
            return this.eaLeft.simplifier().afficher() +"*"+ this.eaRight.simplifier().afficher();

        }
        
       
        return "("+this.eaLeft.simplifier().afficher() +"*"+ this.eaRight.simplifier().afficher()+")";
	
	}
}
