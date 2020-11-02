package td3;
import java.util.Map;
import java.util.TreeMap;
	
public class VariableSymbolique implements ExpressionArithmetique{
	private String x ;
	Map<String, ExpressionArithmetique> value = new TreeMap<>();
		
	public VariableSymbolique(String x) {
		super();
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
		return String.valueOf(this.x);
	}
	@Override
	public double calculer() {
			
		return Double.valueOf(x);
		}
	}
	






	

