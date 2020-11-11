package td3;

import java.util.Map;

public class Cos extends OperationUnaire {
	
	public Cos(ExpressionArithmetique eaLeft) {
		super(eaLeft);
	}

	public Cos(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		super(eaLeft);
	}



	@Override
	public ExpressionArithmetique simplifie(ConstEntiere gauche) {
		return  this.simplifie( gauche.simplifier());
				
	}
	
	@Override
	public ExpressionArithmetique simplifie(VariableSymbolique gauche) {
		return new Cos (gauche.simplifier());
		
	}
	

	@Override
	public ExpressionArithmetique simplifie(ConstRationnelle gauche) {
		return new Cos (gauche.simplifier());
		
	}
	
	public String calculerWithVar(ExpressionArithmetique x) {
		return new StringBuilder().
					append(x.simplifier().afficher()).toString();
	}

	@Override
	public double calculer(Map<String, ExpressionArithmetique> value)  {
		
			return Math.cos(this.eaLeft.calculer(value));
			
	}
	
	@Override
	public String afficher() {
		
		return "Cos("+this.eaLeft.afficher()+")";
	}

	public String toString() {
		
		
		return this.eaLeft.simplifier().afficher()  ;
	}
	
	

	
}
