package projet;

import java.util.Map;

public class Produit implements ExpressionArithmetique {

	protected ExpressionArithmetique eaRight;

    public int start;
    public int end;
    public ExpressionArithmetique eaLeft;
    public Produit(ExpressionArithmetique eaLeft,int start,int end) {
        this.eaLeft = eaLeft;
        this.start = start;
        this.end = end;
    }
   

    @Override
    public ExpressionArithmetique simplifier() {
    	
    	
       ExpressionArithmetique res ;
        ExpressionArithmetique res2;
        ExpressionArithmetique res3;
        res= new Multiplication(new VariableSymbolique("α"+this.start),new ConstEntiere(0));
        if (this.eaLeft instanceof Multiplication) {
            Multiplication mult = (Multiplication) this.eaLeft;
            if (mult.eaLeft instanceof VariableSymbolique && mult.eaRight instanceof VariableSymbolique) {
                VariableSymbolique u = (VariableSymbolique) mult.eaLeft;
                VariableSymbolique x = (VariableSymbolique) mult.eaRight;
                res2 = new Puissance(x,new ConstEntiere(0));
                res3 = new VariableSymbolique("α"+this.start);
                for (int i = start+1; i <= this.end; i++) {
                    Puissance p = new Puissance(x,new ConstEntiere(i));
                   
                    res2 = new Multiplication(res2,p);
                    res3 = new Multiplication(res3,new VariableSymbolique(u.getX()+i ));
                    res = new Multiplication(res3,res2);
                
                }
            }
        }
        return res;
    }



	@Override
    public double calculer(Map<String, ExpressionArithmetique> value) {
        return 0;
    }

    	@Override
    	public String afficher() {

    		return this.simplifier().afficher();
    }

}