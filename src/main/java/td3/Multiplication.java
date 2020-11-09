package td3;

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
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ExpressionArithmetique droite) {
		 	
		/*if (gauche instanceof ConstEntiere && ((Addition) droite).eaLeft.simplifier() instanceof VariableSymbolique &&((Addition) droite).eaRight.simplifier() instanceof ConstRationnelle ) {
			
			System.out.println(((ConstEntiere) gauche).getEntier()*((Addition) droite).eaLeft.calculer()+"+"+((ConstEntiere) gauche).getEntier()*((Addition) droite).eaRight.calculer());
		}
		else if (gauche instanceof ConstEntiere && ((Soustraction) droite).eaLeft.simplifier() instanceof VariableSymbolique && ((Soustraction) droite).eaRight.simplifier() instanceof ConstRationnelle ) {
			
			System.out.println(((ConstEntiere) gauche).getEntier()*((Soustraction) droite).eaLeft.calculer()+"+"+((ConstEntiere) gauche).getEntier()*((Soustraction) droite).eaRight.calculer());
		}
		if (gauche instanceof ConstEntiere && ((Multiplication) droite).eaLeft.simplifier() instanceof VariableSymbolique && ((Multiplication)droite).eaRight.simplifier() instanceof ConstRationnelle) {
			
			System.out.println("dzzd");
		}
		//System.out.println();((ConstEntiere) gauche).getEntier()*((Addition) droite).eaLeft.calculer()
		
		//System.out.println(new ConstEntiere(((ConstEntiere) gauche).getEntier()*((Addition) droite).eaLeft.calculer()));
		//new ConstEntiere(((ConstEntiere) gauche).getEntier()*((Addition) droite).eaRight.calculer())
		*/
		
		
		//System.out.println(new ConstEntiere(gauche.calculer() * ((Addition)droite).eaRight.calculer()));
		//System.out.println(new ConstEntiere(gauche.calculer() * ((Addition)droite).eaLeft.calculer()));
	
		return this.simplifie(gauche,droite.simplifier()) ;
	}
	
	
	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstanteSymbolique droite) {
		return this.simplifie(gauche.simplifier(), droite);
	}

	@Override
	protected ExpressionArithmetique simplifie(ConstanteSymbolique droite, ConstRationnelle gauche) {
		return this.simplifie(droite, gauche.simplifier());
	}

	@Override
	protected ExpressionArithmetique simplifie(VariableSymbolique gauche, ConstRationnelle droite) {
	
		return this.simplifie(droite.simplifier(), gauche);
	}
	@Override
	protected ExpressionArithmetique simplifie(Cos gauche, ConstRationnelle droite) {
		return this.simplifie(gauche,droite.simplifier());
	}

	
	
	@Override
	public double calculer(Map<String, ExpressionArithmetique> value) {
		
		return this.eaLeft.calculer(value) * this.eaRight.calculer(value);
	}	

	@Override
	public String afficher() {
		
		return this.eaLeft.simplifier().afficher() +"*"+ this.eaRight.simplifier().afficher();
		
	}
	

}
