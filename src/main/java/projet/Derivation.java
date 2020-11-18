package projet;

import java.util.Map;

public class Derivation extends OperationUnaire {
	public int ordre;

	public Derivation(ExpressionArithmetique eaLeft) {
		super(eaLeft);
	}
	public Derivation(ExpressionArithmetique eaLeft, int ordre) {
		super(eaLeft);
		this.ordre = ordre;
	}
	
	
	public ExpressionArithmetique derivePuissance(Puissance p) {
		ExpressionArithmetique res = null;
		if (p.eaRight instanceof ConstEntiere) {
			ConstEntiere c = (ConstEntiere)p.eaRight;
			ConstEntiere un = new ConstEntiere(1);
			Puissance blou = new Puissance(p.eaLeft,new Soustraction(c, un).simplifier());
			if (blou.eaRight instanceof ConstEntiere) {
				ConstEntiere cons = (ConstEntiere) blou.eaRight;
				if(cons.getEntier() == 1) {
					res = new Multiplication(p.eaRight,blou.eaLeft).simplifier();
				}else {
					res = new Multiplication(p.eaRight,blou).simplifier();			
				}
				
			}
		}
		return res;
	}
	
	@Override
	protected ExpressionArithmetique simplifie(Puissance p) {
		ExpressionArithmetique res = null;
		if (p.eaRight instanceof ConstEntiere) {
			ConstEntiere c = (ConstEntiere)p.eaRight;
			ConstEntiere un = new ConstEntiere(1);
			Puissance blou = new Puissance(p.eaLeft,new Soustraction(c, un).simplifier());
			if (blou.eaRight instanceof ConstEntiere) {
				ConstEntiere cons = (ConstEntiere) blou.eaRight;
				if(cons.getEntier() == 1) {
					res = new Multiplication(p.eaRight,blou.eaLeft).simplifier();
				}else {
					res = new Multiplication(p.eaRight,blou).simplifier();			
				}
				
			}
			if (this.ordre > 1) {
				for (int i = 1; i < this.ordre; i++) {
					if(res instanceof Multiplication) {
						Multiplication res2 = (Multiplication) res;
						 if (res2.eaLeft instanceof ConstEntiere && res2.eaRight instanceof Puissance) {
							 Puissance p2 = (Puissance) res2.eaRight;
							 Multiplication ea = (Multiplication)this.derivePuissance(p2);
							 res = new Multiplication(new Multiplication(res2.eaLeft,ea.eaLeft),ea.eaRight).simplifier();
							}else if (res2.eaLeft instanceof ConstEntiere && res2.eaRight instanceof VariableSymbolique) {
								ConstEntiere cons = (ConstEntiere)res2.eaLeft;
								res = new ConstEntiere(cons.getEntier());
								ConstEntiere cons1 = (ConstEntiere) p.eaRight;
								if (this.ordre > cons1.getEntier()) {
									res = new ConstEntiere(0);
								}
							}
					}
				}
			}
		}else if (p.eaRight instanceof ConstRationnelle) {
			ConstRationnelle c = (ConstRationnelle)p.eaRight;
			ConstRationnelle un = new ConstRationnelle(1,1);
			Puissance blou = new Puissance(p.eaLeft,new Soustraction(c, un).simplifier());
			res = new Multiplication(p.eaRight,blou).simplifier();
		}
		return res;
	}
	
	
	@Override
	protected ExpressionArithmetique simplifie(Multiplication m) {
		ExpressionArithmetique res = null;
		if (m.eaLeft instanceof ConstEntiere && m.eaRight instanceof Puissance) {
			Puissance p = (Puissance) m.eaRight;
			ConstEntiere c = (ConstEntiere)m.eaLeft;
			Multiplication ex = (Multiplication) this.derivePuissance(p);
			Multiplication mult = new Multiplication(c, ex.eaLeft);	
			res = new Multiplication(mult,ex.eaRight).simplifier();	
	
		if (this.ordre > 1) {
			for (int i = 1; i < this.ordre; i++) {
				if(res instanceof Multiplication) {
					Multiplication res2 = (Multiplication) res;
					 if (res2.eaLeft instanceof ConstEntiere && res2.eaRight instanceof Puissance) {
						 Puissance p2 = (Puissance) res2.eaRight;
						 Multiplication ea = (Multiplication) this.derivePuissance(p2);
						 res = new Multiplication(new Multiplication(res2.eaLeft,ea.eaLeft),ea.eaRight).simplifier();
						}else if (res2.eaLeft instanceof ConstEntiere && res2.eaRight instanceof VariableSymbolique) {
							ConstEntiere cons = (ConstEntiere)res2.eaLeft;
							res = new ConstEntiere(cons.getEntier());
							Puissance p1 = (Puissance) m.eaRight;
							ConstEntiere c1 = (ConstEntiere) p1.eaRight;
							if (this.ordre > c1.getEntier()) {
								res = new ConstEntiere(0);
							}
						}
				}
			}
		}
	}
		
		else if (m.eaLeft instanceof ConstEntiere && m.eaRight instanceof VariableSymbolique) {
			ConstEntiere cons = (ConstEntiere)m.eaLeft;
			res = new ConstEntiere(cons.getEntier());
			if (this.ordre > 1) {
				res = new ConstEntiere(0);
			}
		}else if (m.eaLeft instanceof ConstRationnelle && m.eaRight instanceof Puissance) {
			Puissance p = (Puissance) m.eaRight;
			ConstRationnelle c = (ConstRationnelle)m.eaLeft;
			Multiplication ex = (Multiplication) this.simplifie(p);
			Multiplication mult = new Multiplication(c, ex.eaLeft);	
			res = new Multiplication(mult,ex.eaRight).simplifier();	
		}else if (m.eaLeft instanceof ConstRationnelle && m.eaRight instanceof VariableSymbolique) {
			ConstRationnelle cons = (ConstRationnelle)m.eaLeft;
			res = new ConstRationnelle(cons.getNumerateur(),cons.getDenominateur());
		}
		
		return res;	
		
	}
	
	@Override
	protected ExpressionArithmetique simplifie(VariableSymbolique var) {
		return new ConstEntiere(1);
	}
	
	@Override
	protected ExpressionArithmetique simplifie(ConstEntiere c) {
		return new ConstEntiere(0);
	}
	
	@Override
	protected ExpressionArithmetique simplifie(ConstRationnelle c) {
		return new ConstEntiere(0);
	}
	

	@Override
	public String afficher() {
		String res = null;
		if(this.eaLeft instanceof Puissance) {
			ExpressionArithmetique ps = this.simplifie(this.eaLeft);
			res = ps.afficher();
		}else if (this.eaLeft instanceof Addition) {
			ExpressionArithmetique ps = this.simplifie(this.eaLeft);
			res = ps.afficher();
		}
		return res;
	}
	@Override
	public double calculer(Map<String, ExpressionArithmetique> value) {
		return 0;
	}


}
