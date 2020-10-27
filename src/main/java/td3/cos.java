package td3;

public class cos extends operationUnaire{

	
	public cos(ExpressionArithmetique eaLeft) {
		super(eaLeft);
	
	}

	@Override
	public ExpressionArithmetique simplifie(ConstEntiere x) {
		return x;
			
	}
	

	@Override
	public double calculer() {
		
		return 0;
	}

	@Override
	public String afficher() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
