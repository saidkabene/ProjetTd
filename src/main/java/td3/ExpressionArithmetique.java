package td3;

import java.util.Map;

public interface ExpressionArithmetique {
	public ExpressionArithmetique simplifier();
	public double calculer(Map<String, ExpressionArithmetique> value) ;
	public String afficher();
	
}