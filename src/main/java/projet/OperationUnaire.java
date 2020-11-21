package projet;

public abstract class OperationUnaire implements ExpressionArithmetique {
	protected ExpressionArithmetique eaLeft;

	
	public ExpressionArithmetique getEaLeft() {
		return eaLeft;
	}


	public OperationUnaire (ExpressionArithmetique eaLeft) {
		this.eaLeft = eaLeft;
	}

	protected ExpressionArithmetique simplifie(ConstRationnelle c) {
		
		return this;
	}

	protected ExpressionArithmetique simplifie(VariableSymbolique gauche) {
		return this;
		
	}
	protected ExpressionArithmetique simplifie(ExpressionArithmetique gauche) {
		return this;
		
	}
	protected ExpressionArithmetique simplifie(Puissance p) {
		
		return this;
	}
	protected ExpressionArithmetique simplifie(Multiplication p) {
		
		return this;
	}

	
	
	

	protected ExpressionArithmetique simplifie(ConstEntiere gauche) {
		return this;
	}
	


	public ExpressionArithmetique simplifie(Division gauche) {	
		return this;
	}
	public ExpressionArithmetique simplifie(Addition gauche) {	
		return this;
	}

	

	@Override
	public ExpressionArithmetique simplifier() {

		ExpressionArithmetique res;
		this.eaLeft = this.eaLeft.simplifier();
		

		if (this.eaLeft instanceof ConstEntiere) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			
		
		res = simplifie (gauche);
		}
		else if (this.eaLeft instanceof Division) {
			Division gauche = (Division) this.eaLeft;
			
			res = simplifie(gauche);

		}
		 else if (this.eaLeft instanceof ConstRationnelle ) {
			ConstRationnelle gauche = (ConstRationnelle) this.eaLeft;
			

			res = simplifie(gauche);

		} else if (this.eaLeft instanceof ConstanteSymbolique) {
			ConstanteSymbolique gauche = (ConstanteSymbolique) this.eaLeft;
			

			res = simplifie(gauche);

		}else if (this.eaLeft instanceof VariableSymbolique) {
		
			VariableSymbolique gauche = (VariableSymbolique) this.eaLeft;
			

			res = simplifie(gauche);

		}
		else if (this.eaLeft instanceof Puissance) {
			Puissance gauche = (Puissance) this.eaLeft;
			

			res = simplifie(gauche);

		}
		else if (this.eaLeft instanceof Addition) {
			Addition gauche = (Addition) this.eaLeft;
			

			res = simplifie(gauche);

		}
		else if (this.eaLeft instanceof Ln) {
			Ln gauche = (Ln) this.eaLeft;
			

			res = simplifie(gauche);

		}else if (this.eaLeft instanceof Multiplication) {
            Multiplication m = (Multiplication) this.eaLeft;
            if(m.eaLeft instanceof ConstEntiere && m.eaRight instanceof Puissance) {
                m.eaRight = ((Puissance) m.eaRight).simplifier();
            }else if(m.eaLeft instanceof ConstEntiere && m.eaRight instanceof VariableSymbolique) {
                m.eaLeft = ((ConstEntiere) m.eaLeft);
                m.eaRight = (VariableSymbolique) m.eaRight;
            }
            res = simplifie(m);
		}
		else if (this.eaLeft instanceof Puissance) {
            Puissance p = (Puissance) this.eaLeft;
            if(p.eaLeft instanceof VariableSymbolique && p.eaRight instanceof ConstEntiere) {
                p.eaLeft = (VariableSymbolique) p.eaLeft;
                p.eaRight = (ConstEntiere) p.eaRight;
            }
            res = simplifie(p);

        }
		
		else {
			res = this;
		}

		return res;

	}













}
