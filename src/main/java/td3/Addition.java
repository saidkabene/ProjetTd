
package td3;

public class Addition extends OperationBinaire {

	public Addition(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft, eaRight);

	}

	public Addition(int i, ExpressionArithmetique ver) {
		super(ver, ver);
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
				
		return new ConstRationnelle(gauche.getEntier() * droite.getNumerateur(), droite.getDenominateur()).simplifier();
		}
	
	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, VariableSymbolique droite) {
	
		return simplifie(gauche.simplifier(), droite);
	}
	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche ,VariableSymbolique droite) {
		return simplifie(gauche.simplifier(), droite);
		
	}
	
	@Override
	protected ExpressionArithmetique simplifie(VariableSymbolique gauche ,ConstRationnelle droite) {
		
		return this.simplifie(gauche,droite.simplifier()) ;
		
	}
	
	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche ,ExpressionArithmetique droite) {
		if (gauche instanceof ConstEntiere && ((Addition) droite).eaLeft.simplifier() instanceof ConstEntiere &&((Addition) droite).eaRight.simplifier() instanceof VariableSymbolique ) {
			System.out.println(((ConstEntiere) gauche).getEntier()+((Addition) droite).eaLeft.calculer() +"+" +((Addition)droite).eaRight.simplifier().afficher())  ;
		}
		return gauche;
		
	}
	@Override
	protected ExpressionArithmetique simplifie(VariableSymbolique gauche, ConstEntiere droite) {
		if(droite.getEntier() ==0) {
			
			return gauche.simplifier();
		}
		return this.simplifie(droite.simplifier(), gauche);
	}
	
	@Override
	
	protected ExpressionArithmetique simplifie(cos gauche ,VariableSymbolique droite) {
		return new cos( droite,gauche.simplifier());
		
	}
	
	@Override
	public double calculer()  {
			try {
				
				return this.eaLeft.calculer() + this.eaRight.calculer();
				
			
		} catch (NumberFormatException e ) {
			 System.out.println("le resultat" +"  " + calculerWithVar(eaLeft,eaRight)+" "+"est correcte mais on ne peut pas calculer la valiableSymbolique" );
	
		}
			return Double.valueOf(calculerWithVar(this.eaLeft,this.eaRight));
			
	}
	
	public String calculerWithVar(ExpressionArithmetique x,ExpressionArithmetique y) {
		return new StringBuilder().
					append(x.simplifier().afficher()).
					append("+").
					append(y.simplifier().afficher()).toString();
	}

	
	@Override
	public String afficher() {
		
	
		return this.eaLeft.simplifier().afficher() + "+" + this.eaRight.simplifier().afficher()	;
	}
	
		
		
	}

