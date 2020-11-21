package projet;

import java.util.Map;

public class Factorisation implements ExpressionArithmetique {
	
	
	protected ExpressionArithmetique eaLeft;

	public Factorisation(ExpressionArithmetique eaLeft) {
		super();
		this.eaLeft = eaLeft;
	}

	@Override
	public ExpressionArithmetique simplifier() {
		ConstEntiere cons = null;
		VariableSymbolique b= null;
		VariableSymbolique a = null;
		ConstEntiere i = null;;
		
		if( this.eaLeft instanceof Addition) {
			Addition add = (Addition)this.eaLeft;
			Addition mlk = (Addition)add.eaLeft;
			Multiplication s = (Multiplication)add.eaRight;
			if(add.eaLeft instanceof Addition && add.eaRight instanceof Multiplication) {				
				
				if(mlk.eaLeft instanceof Multiplication && mlk.eaRight instanceof Multiplication) {
					Multiplication k = (Multiplication)mlk.eaLeft;
					Multiplication j = (Multiplication)mlk.eaRight;
					if(k.eaLeft instanceof ConstEntiere && k.eaRight instanceof Puissance) {
						 	cons = (ConstEntiere)k.eaLeft;
					      Puissance p = (Puissance)k.eaRight;
					}
					if(j.eaLeft instanceof Multiplication && j.eaRight instanceof VariableSymbolique) {
						Multiplication m = (Multiplication)j.eaLeft;
						 b = (VariableSymbolique)j.eaRight;
						if(m.eaLeft instanceof ConstEntiere && m.eaRight instanceof VariableSymbolique) {
							ConstEntiere co = (ConstEntiere)m.eaLeft;
								a = (VariableSymbolique)m.eaRight;
					
					}
					if(s.eaLeft instanceof ConstEntiere && s.eaRight instanceof Puissance) {
						ConstEntiere y = (ConstEntiere)s.eaLeft;
						 Puissance n = (Puissance)s.eaRight;
						if(n.eaLeft instanceof VariableSymbolique && n.eaRight instanceof ConstEntiere) {
							 i = (ConstEntiere)n.eaRight;
							VariableSymbolique x = (VariableSymbolique)n.eaLeft;
						}
					 }
						
        		  }
			   }
				
			}		
		}	
			
		return new Puissance(new Multiplication(cons, new Addition(a, b)), i) ;
	}

	@Override
	public double calculer(Map<VariableSymbolique, ExpressionArithmetique> value) {
		
		return this.eaLeft.calculer(value);
	}

	@Override
	public String afficher() {
	
		return this.eaLeft.simplifier().afficher();
	}

	
	
}
