package td3;

import java.util.Map;

public class Ln extends OperationUnaire{

	public Ln(ExpressionArithmetique eaLeft) {
		super(eaLeft);
	}

	public String calculerWithVar(ExpressionArithmetique x) {
		return new StringBuilder().
					append(x.simplifier().afficher()).toString();
	}
	
	@Override
	public double calculer(Map<String, ExpressionArithmetique> value)  {
			try {
				return Math.log(this.eaLeft.calculer(value));
			
		} catch (NumberFormatException e ) {
			System.out.println("le resultat est "+"  "+ calculerWithVar(this)+"correcte mais on ne peut pas calculer la valiableSymbolique" );
	
		}
			return Math.log(this.eaLeft.calculer(value));
			
	}
	
	@Override
	public String afficher() {
		
		return  this.eaLeft.simplifier().afficher();
	}

}
