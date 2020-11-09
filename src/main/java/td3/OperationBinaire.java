package td3;

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
	protected ExpressionArithmetique simplifie(ConstRationnelle gauche, ConstanteSymbolique droite) {
		return this;
	}
	
	protected ExpressionArithmetique simplifie(ConstanteSymbolique droite, ConstRationnelle gauche) {
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
	protected ExpressionArithmetique simplifie(Cos gauche ,ConstEntiere droite) {
		return simplifie(gauche, droite.simplifier());
		
	}
	protected ExpressionArithmetique simplifie(Cos gauche, ConstRationnelle droite) {
		return this;
	}
	protected ExpressionArithmetique simplifie(Cos gauche, VariableSymbolique droite) {
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

		}
		else if (this.eaLeft instanceof ConstEntiere && this.eaRight instanceof ExpressionArithmetique) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			ExpressionArithmetique droite = (ExpressionArithmetique) this.eaRight;
			
			res = this.simplifie(gauche, droite);

		}
		
		else {
			res = this;
		}

		return res;

	}


	protected ExpressionArithmetique simplifie(ConstEntiere gauche, ExpressionArithmetique droite) {
		// TODO Auto-generated method stub
		return this;
	}

	


	


	
	}

