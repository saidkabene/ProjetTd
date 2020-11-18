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
	
		if( this.eaLeft instanceof Addition) {
			Addition add = (Addition)this.eaLeft;
			Multiplication mul1 = (Multiplication)add.eaLeft;
			Multiplication mul2 = (Multiplication)add.eaRight;
			Multiplication mul = (Multiplication)add.eaRight;
			ExpressionArithmetique ex = (ExpressionArithmetique)add.eaLeft;
		
			if(add.eaLeft instanceof Multiplication && add.eaRight instanceof Multiplication) {
				;
				
					if( mul1.eaLeft instanceof ConstEntiere && mul1.eaRight instanceof Puissance) {
					ConstEntiere cons = (ConstEntiere)mul1.eaLeft;
					Puissance    p    = (Puissance)mul1.eaRight;
				
					} 
					if (mul2.eaLeft instanceof Multiplication && mul2.eaRight instanceof VariableSymbolique ) {
					Multiplication mul3    = (Multiplication)mul2.eaLeft;
					VariableSymbolique b = (VariableSymbolique)mul2.eaRight;
					
					ConstEntiere c = (ConstEntiere )mul3.eaLeft;
					VariableSymbolique a =  (VariableSymbolique)mul3.eaRight;
					
					}
					
			}
			else if(add.eaLeft instanceof ExpressionArithmetique && add.eaRight instanceof Multiplication) {
			
					
				    if(mul.eaLeft instanceof ConstEntiere && mul.eaRight instanceof Puissance) {
				    	
				    	ConstEntiere c = (ConstEntiere)mul.eaLeft;
				    	Puissance p = (Puissance)mul.eaRight;	
				    }
					
				
			}
				
			return new Addition(ex,mul);			
			
		}
		return this;
	}

	@Override
	public double calculer(Map<String, ExpressionArithmetique> value) {
		
		return 0;
	}

	@Override
	public String afficher() {
	
		return this.eaLeft.simplifier().afficher();
	}

	
	
}
