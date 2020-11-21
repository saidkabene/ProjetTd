package projet;

import java.util.Map;

public class Somme implements ExpressionArithmetique{
    private int start;
    private int end;
    private ExpressionArithmetique eaLeft;
    
    
    public Somme(ExpressionArithmetique eaLeft, int start , int end ) {
        this.eaLeft = eaLeft;
        this.start = start;
        this.end = end ;
    }

    @Override
    public ExpressionArithmetique simplifier() {
        ExpressionArithmetique res;
        res= new Addition(new VariableSymbolique("α0"),new ConstEntiere(0));
        if (this.eaLeft instanceof Multiplication) {
            Multiplication mult = (Multiplication) this.eaLeft;
            if (mult.eaLeft instanceof VariableSymbolique && mult.eaRight instanceof VariableSymbolique) {
                VariableSymbolique u = (VariableSymbolique) mult.eaLeft;
                VariableSymbolique x = (VariableSymbolique) mult.eaRight;
                for (int i = start; i <= this.end; i++) {
                    Puissance p = new Puissance(x,new ConstEntiere(i));
                    Multiplication multi = new Multiplication(new VariableSymbolique(u.getX()+i ),p);
                    res = new Addition(res,multi);
                }

            }
        }
        return res;
    }

    @Override
    public String afficher() {

        return this.eaLeft.simplifier().afficher();
    }

  



	@Override
	public double calculer(Map<VariableSymbolique, ExpressionArithmetique> value) {
		return this.eaLeft.calculer(value);
	}
	}
