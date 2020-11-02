package td3;

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
		return this.simplifie(droite, gauche).simplifier();
	}
	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, VariableSymbolique droite) {
		return this.simplifie(gauche.simplifier(), droite);
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
	protected ExpressionArithmetique simplifie(VariableSymbolique gauche, ConstRationnelle droite) {
		return this.simplifie(droite.simplifier(), gauche);
	}
	@Override
	protected ExpressionArithmetique simplifie(cos gauche, ConstRationnelle droite) {
		return this.simplifie(gauche,droite.simplifier());
	}

	@Override
	public double calculer() {

		return this.eaLeft.calculer() * this.eaRight.calculer();
	}	

	@Override
	public String afficher() {
		
		return this.eaLeft.afficher() +"*"+ this.eaRight.afficher();
		
	}
	
	public String toString() {
		if (this.eaRight.calculer() == 1) {
			
			return eaLeft.simplifier().afficher();
		}
		else if (this.eaLeft.calculer() ==1) {
			return eaRight.simplifier().afficher();
			
		}
		return this.eaLeft.simplifier().afficher() + "*" + this.eaRight.simplifier().afficher() ;
	}

}
