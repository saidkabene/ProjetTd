package projet;

import java.util.Map;

public interface ExpressionArithmetique {
	public ExpressionArithmetique simplifier();
	public double calculer(Map<VariableSymbolique, ExpressionArithmetique> value) ;
	public String afficher();
	
}