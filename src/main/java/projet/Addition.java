
package projet;


import java.util.Map;
public class Addition extends OperationBinaire {

	public Addition(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft, eaRight);

	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstEntiere droite) {
		
		return new ConstRationnelle(gauche.getNumerateur() * droite.getEntier() + gauche.getDenominateur() * 1,
				1 * gauche.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstRationnelle droite) {
		return new ConstRationnelle(
				gauche.getNumerateur() * droite.getDenominateur() + gauche.getDenominateur() * droite.getNumerateur(),
				droite.getDenominateur() * gauche.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstEntiere droite) {
		

		
		return new ConstEntiere(gauche.getEntier() + droite.getEntier()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstRationnelle droite) {
		
		return new ConstRationnelle((gauche.getEntier() * droite.getDenominateur() )+ droite.getNumerateur(), droite.getDenominateur());
		}
	
	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, VariableSymbolique droite) {
		
		if(gauche.getEntier() ==0 ) {
			return droite.simplifier();
		}
		return simplifie(gauche.simplifier(), droite);
	}
	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche ,VariableSymbolique droite) {
		if (((ConstRationnelle)gauche).getDenominateur() == ((ConstRationnelle)gauche).getNumerateur()){
			return droite.simplifier();
		}
		return simplifie(gauche.simplifier(), droite);
		
	}
	
	@Override
	protected ExpressionArithmetique simplifie(VariableSymbolique gauche ,ConstRationnelle droite) {
			
		return this.simplifie(gauche,droite.simplifier()) ;
		
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche ,Division droite) {
	
		return new Addition(new Addition(gauche, droite.eaLeft),droite.eaRight).simplifier();
		
	}
	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche ,Addition droite) {
	
		return new Addition(new Addition(gauche, droite.eaLeft),droite.eaRight).simplifier();
		
	}
	
	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Ln droite) {
		
		if (droite.eaLeft instanceof ConstEntiere && ((ConstEntiere)droite.eaLeft).getEntier()==1 ) {	
		
			return gauche.simplifier();
			
	}
		
		return  new Addition(gauche, droite);	
	}
	@Override
	protected ExpressionArithmetique simplifie(VariableSymbolique gauche, ConstEntiere droite) {
		if(droite.getEntier() ==0) {
			
			return gauche.simplifier();
		}
		
		return this.simplifie(droite.simplifier(), gauche);
	}
	
	@Override
	
	protected ExpressionArithmetique simplifie(Cos gauche ,VariableSymbolique droite) {
		return new Cos( droite,gauche.simplifier());
		
	}
	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Puissance droite) {
		
		return  this.simplifie(gauche, droite.simplifier());
    }
	@Override
	protected ExpressionArithmetique simplifie(Addition gauche, Multiplication droite) {
		
		return  this.simplifie(gauche, droite.simplifier());
    }
	
	@Override
	public double calculer(Map<String, ExpressionArithmetique> value)  {
				
		return this.eaLeft.calculer(value) + this.eaRight.calculer(value);
				
		} 
		
	@Override
	public String afficher() {
		if( this.eaLeft instanceof Addition && this.eaRight instanceof Multiplication ) {
			
			return this.eaLeft.simplifier().afficher() + "+" + this.eaRight.simplifier().afficher() 	;
		}
		return "("+this.eaLeft.simplifier().afficher() + "+" + this.eaRight.simplifier().afficher() + ")"	;
	}
		
	}

