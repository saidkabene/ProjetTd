package td3;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.Map;

	
public class VariableSymbolique  implements ExpressionArithmetique{
	

	private String x ;
	Map<String, ExpressionArithmetique> value = new HashMap<>();
	
	public VariableSymbolique(ExpressionArithmetique s ) {
		super();
	}
	public VariableSymbolique(String x) {
	
		this.x=(x);
		
	}
		
	public VariableSymbolique(Map<String, ExpressionArithmetique> value) {
		
		this.value = value;
	}
	
	@Override
	public ExpressionArithmetique simplifier() {
	
		return this;
	}



	@Override
	public String afficher() {
		if(!value.isEmpty()) {
			return value.toString();
		}
		return x;
	}
	
	@Override
	public double calculer(Map<String, ExpressionArithmetique> value) {
	
			return value.get(x).calculer(value);
	
	}

	public String getX() {
		return x;
	}

	
	}
	






	

