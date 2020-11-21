package projet;

import java.util.Map;

public class Soustraction extends OperationBinaire {

	public Soustraction(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft, eaRight);

	}

	@Override
	public double calculer(Map<VariableSymbolique, ExpressionArithmetique> value)   {
		return this.eaLeft.calculer(value) - this.eaRight.calculer(value);
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstEntiere droite) {
		return new ConstRationnelle((int) (gauche.getNumerateur() * droite.getEntier() - gauche.getDenominateur() * 1),
				1 * gauche.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstRationnelle droite) {
		return new ConstRationnelle(
				gauche.getNumerateur() * droite.getDenominateur() - gauche.getDenominateur() * droite.getNumerateur(),
				droite.getDenominateur() * gauche.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstEntiere droite) {
		return new ConstEntiere(gauche.getEntier() - droite.getEntier()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstRationnelle droite) {
		return new ConstRationnelle((int) (droite.getDenominateur() * gauche.getEntier() - droite.getNumerateur() * 1),
				1 * droite.getDenominateur()).simplifier();
	}
	
	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche , VariableSymbolique droite) {
		if(gauche.getEntier()== 0) {
			return droite.simplifier();
		}
		return this.simplifie(gauche.simplifier(), droite);		
	}
	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche , VariableSymbolique droite) {
		return simplifie(gauche.simplifier(), droite);	
	}
	@Override
	protected ExpressionArithmetique simplifie(VariableSymbolique gauche , ConstEntiere droite) {
		if( droite.getEntier()== 0) {
			return gauche.simplifier();
		}
		return simplifie( droite.simplifier(),gauche);
		
	}
	@Override
	protected ExpressionArithmetique simplifie(VariableSymbolique gauche , ConstRationnelle droite) {
		return simplifie(droite.simplifier(),gauche );
		
	}
	
	@Override
	public String afficher() {
		
		return "("+ this.eaLeft.afficher() + "-" + this.eaRight.afficher() +")";
	}
	


}
