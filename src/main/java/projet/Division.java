package projet;

import java.util.Map;

public class Division extends OperationBinaire {

	public Division(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft, eaRight);

	}

	@Override
	public double calculer(Map<String, ExpressionArithmetique> value)  {
		return this.eaLeft.calculer(value) / this.eaRight.calculer(value);
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstEntiere droite) {
		return new ConstRationnelle(gauche.getNumerateur(), (int) (gauche.getDenominateur() * droite.getEntier())).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstRationnelle droite) {
		return new ConstRationnelle((int) (gauche.getEntier() * droite.getNumerateur()), droite.getDenominateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstRationnelle droite) {
		return new ConstRationnelle(gauche.getNumerateur() * droite.getDenominateur(),
				gauche.getDenominateur() * droite.getNumerateur()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstEntiere droite) {
		return new ConstRationnelle(gauche.getEntier(), droite.getEntier()).simplifier();
	}

	@Override
	protected ExpressionArithmetique simplifie(ExpressionArithmetique gauche, ExpressionArithmetique droite) {
		return this;
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
		return simplifie(droite.simplifier(),gauche );
		
	}
	
	@Override
	protected ExpressionArithmetique simplifie(VariableSymbolique gauche ,ConstEntiere droite) {
		if(droite.getEntier() == 1) {
			return gauche.simplifier();
		}
		return simplifie( droite.simplifier(),gauche);
		
	}
	@Override
	protected ExpressionArithmetique simplifie(Cos gauche ,VariableSymbolique droite) {
		
		return simplifie( droite.simplifier(),gauche);
		
	}
	
	
	@Override
	protected ExpressionArithmetique simplifie(ConstanteSymbolique gauche ,ConstEntiere droite) {
		return simplifie( droite,gauche);
		
	}
	

	@Override
	public String afficher() {
		return "("+this.eaLeft.simplifier().afficher()+"/"+ this.eaRight.simplifier().afficher()+")";
	}


}
