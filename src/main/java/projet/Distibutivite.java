package projet;

import java.util.Map;

public class Distibutivite  extends OperationUnaire{

	public Distibutivite(ExpressionArithmetique eaLeft) {
		super(eaLeft);
		
	}
	@Override
	protected ExpressionArithmetique simplifie(ExpressionArithmetique gauche) {
		
		Multiplication res = (Multiplication)this.eaLeft;
		
		Addition add = (Addition)res.eaRight;
		ConstEntiere x = null;
		
		VariableSymbolique v = null;
		ConstRationnelle y = null;
		if( res.eaLeft instanceof ConstEntiere && res.eaRight instanceof Addition) {
			
			 x = (ConstEntiere)res.eaLeft;
			
			if(add.eaLeft instanceof VariableSymbolique && add.eaRight instanceof ConstRationnelle) {
				
				 v = (VariableSymbolique)add.eaLeft;
				 y = (ConstRationnelle)add.eaRight;
			}
		
	
			return new Addition(new Multiplication(x, v),new Multiplication(x, y).simplifier());
		}
		else if (res.eaLeft instanceof ConstEntiere && res.eaRight instanceof Soustraction) {
				 Soustraction sous;
				 x = (ConstEntiere)res.eaLeft;
				 sous = (Soustraction)res.eaRight;
				if(sous.eaLeft instanceof VariableSymbolique && sous.eaRight instanceof ConstRationnelle) {
					
					 v = (VariableSymbolique)sous.eaLeft;
					 y = (ConstRationnelle)sous.eaRight;
				}
			
			}
			return new Soustraction(new Multiplication(x, v),new Multiplication(x, y).simplifier()) ;
			
		
	}
	
	@Override
	public double calculer(Map<VariableSymbolique, ExpressionArithmetique> value) {
		
		return this.eaLeft.calculer(value);
	}

	@Override
	public String afficher() {
	
		return  this.eaLeft.simplifier().afficher();
	}

}
