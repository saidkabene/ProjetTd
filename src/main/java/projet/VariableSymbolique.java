package projet;
import java.util.HashMap;
import java.util.Map;

	
public class VariableSymbolique  implements ExpressionArithmetique{
	

	private String x ;
	Map<String, ExpressionArithmetique> value = new HashMap<>();
	
	
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
	
	@Override
    public boolean equals(Object obj) {
        boolean res = false;
        if (this.getClass().equals(obj.getClass())) {
            VariableSymbolique var1 = (VariableSymbolique) this;
            VariableSymbolique var2 = (VariableSymbolique) obj;
            if (var1.getX() == var2.getX()) {
                res = true;
            }
        }
        return res;
    }
	
	}
	






	

