package projet;

import java.util.Map;

public final class ConstEntiere implements ExpressionArithmetique {

	public ConstEntiere(int value) {
		this.entier = value;
	}
	
	public int getEntier() {
		return entier;
	}

	private final int entier;

	
	@Override
	public double calculer(Map<String, ExpressionArithmetique> value) {
		return this.getEntier();
	}

	@Override
	public String afficher() {
		
		return  String.valueOf(entier);
	}
	@Override
	public ExpressionArithmetique simplifier() {
	
		return this;
	}
	@Override
    public boolean equals(Object obj) {
        boolean res = false;
        if (this.getClass().equals(obj.getClass())) {
            ConstEntiere cons1 = (ConstEntiere) this;
            ConstEntiere cons2 = (ConstEntiere) obj;
            if (cons1.getEntier() == cons2.getEntier()) {
                res = true;
            }
        }
        return res;
    }
	
}
