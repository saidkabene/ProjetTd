package projet;

public abstract class OperationBinaire implements ExpressionArithmetique {
	protected  ExpressionArithmetique eaLeft;
	protected ExpressionArithmetique eaRight;

	public OperationBinaire(ExpressionArithmetique eaLeft, ExpressionArithmetique eaRight) {
		this.eaLeft = eaLeft;
		this.eaRight = eaRight;
	}


	protected ExpressionArithmetique simplifie(ExpressionArithmetique gauche, ExpressionArithmetique droite) {
		return this;
	}
	
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Addition droite) {
		return this;
	}
	
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Division droite) {
		return this;
	}


	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstEntiere droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstRationnelle droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstEntiere droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ConstRationnelle droite) {
		return this;
	}
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, VariableSymbolique droite) {
		return this;
	}
	
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche ,VariableSymbolique droite) {
		return this;
		
	}
	protected ExpressionArithmetique simplifie(VariableSymbolique gauche ,ConstRationnelle droite) {
		return this;
		
	}
	protected ExpressionArithmetique simplifie(VariableSymbolique gauche ,ConstEntiere droite) {
		return this;
		
	}
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Multiplication droite) {
		return this;
	}
	
	protected ExpressionArithmetique simplifie(Addition gauche,Multiplication droite) {
		return this;
	}
	protected ExpressionArithmetique simplifie(Puissance gauche, Puissance droite) {

		return this;
	}

	protected ExpressionArithmetique simplifie(Cos gauche ,ConstEntiere droite) {
		return simplifie(gauche, droite.simplifier());
		
	}

	protected ExpressionArithmetique simplifie(Cos gauche, VariableSymbolique droite) {
		return this;
	}
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Ln droite) {
		return this;
	}
	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Puissance droite) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstEntiere gauche, Soustraction droite) {
		
		return this;
	}
	

	
	

	@Override
	public ExpressionArithmetique simplifier() {

		ExpressionArithmetique res;
		this.eaLeft = this.eaLeft.simplifier();
		this.eaRight = this.eaRight.simplifier();

		if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof ConstEntiere) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			ConstEntiere droite = (ConstEntiere) this.eaRight;
			res = simplifie(gauche, droite);
		} else if (this.eaLeft instanceof ConstRationnelle && this.eaRight instanceof ConstRationnelle) {
			ConstRationnelle gauche = (ConstRationnelle) this.eaLeft;
			ConstRationnelle droite = (ConstRationnelle) this.eaRight;

			res = simplifie(gauche, droite);

		} else if (this.eaLeft instanceof ConstRationnelle && this.eaRight instanceof ConstEntiere)

		{
			ConstRationnelle gauche = (ConstRationnelle) this.eaLeft;
			ConstEntiere droite = (ConstEntiere) this.eaRight;

			res = simplifie(gauche, droite);

		} else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof ConstRationnelle) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			ConstRationnelle droite = (ConstRationnelle) this.eaRight;

			res = simplifie(gauche, droite);

		}else if (this.eaLeft instanceof ConstRationnelle && this.eaRight instanceof VariableSymbolique) {
			ConstRationnelle gauche = (ConstRationnelle) this.eaLeft;
			VariableSymbolique droite = (VariableSymbolique) this.eaRight;

			res = simplifie(gauche, droite);

		}else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof VariableSymbolique) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			VariableSymbolique droite = (VariableSymbolique) this.eaRight;

			res = simplifie(gauche , droite);

		}
		else if (this.eaLeft instanceof VariableSymbolique && this.eaRight instanceof ConstEntiere) {
			VariableSymbolique gauche = (VariableSymbolique) this.eaLeft;
			ConstEntiere droite = (ConstEntiere) this.eaRight;

			res = simplifie(gauche, droite);

		}
		else if (this.eaLeft instanceof VariableSymbolique && this.eaRight instanceof ConstRationnelle) {
			VariableSymbolique gauche = (VariableSymbolique) this.eaLeft;
			ConstRationnelle droite = (ConstRationnelle) this.eaRight;

			res = simplifie(gauche, droite);

		}
		else if (this.eaLeft instanceof ConstRationnelle && this.eaRight instanceof ConstanteSymbolique) {
			ConstRationnelle gauche = (ConstRationnelle) this.eaLeft;
			ConstanteSymbolique droite = (ConstanteSymbolique) this.eaRight;

			res = simplifie(gauche, droite);

		}else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof Addition) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			Addition droite = (Addition) this.eaRight;

			res = simplifie(gauche, droite);

		}
		else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof Multiplication) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			Multiplication droite = (Multiplication) this.eaRight;
			
			res = this.simplifie(gauche, droite);

		}
	
		else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof Ln) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			Ln droite = (Ln) this.eaRight;
			
			res = this.simplifie(gauche, droite);

		}
		else if (this.eaLeft instanceof ConstanteSymbolique && this.eaRight instanceof ConstEntiere) {
			ConstanteSymbolique gauche = (ConstanteSymbolique) this.eaLeft;
			ConstEntiere droite = (ConstEntiere) this.eaRight;
			
			res = this.simplifie(gauche, droite);

		}
		else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof Puissance) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			Puissance droite = (Puissance) this.eaRight;
			
			res = this.simplifie(gauche, droite);

		}
		else if (this.eaLeft instanceof Addition && this.eaRight instanceof Multiplication) {
			Addition gauche = (Addition) this.eaLeft;
			Multiplication droite = (Multiplication) this.eaRight;
			
			res = this.simplifie(gauche, droite);

		}
		else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof Division) {
			
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			Division droite = (Division) this.eaRight;
			
			res = this.simplifie(gauche, droite);
			

		}
		else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof Soustraction) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			Soustraction droite = (Soustraction) this.eaRight;
			
			res = this.simplifie(gauche, droite);

		}else if (this.eaLeft instanceof Puissance && this.eaRight instanceof Puissance) {
            Puissance gauche = (Puissance) this.eaLeft;
            Puissance droite = (Puissance) this.eaRight;

        res = this.simplifie(gauche, droite);

    }

		
		else {
			res = this;
		}

		return res;
	}
	@Override
    public boolean equals(Object obj) {
		boolean res = false ;
        if (this.getClass().equals(obj.getClass())) {
            OperationBinaire op = (OperationBinaire)obj;
                if(this.eaLeft.simplifier().getClass().equals(op.eaLeft.simplifier().getClass())
                        && this.eaRight.simplifier().getClass().equals(op.eaRight.simplifier().getClass()) 

                   && this.eaLeft.simplifier().equals(op.eaLeft.simplifier()) && this.eaRight.simplifier().equals(op.eaRight.simplifier())){
                    	
                    
                    res = true;
             
                }

            }
        return res;
        }


	
	}

