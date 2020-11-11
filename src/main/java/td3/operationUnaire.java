package td3;

public abstract class OperationUnaire implements ExpressionArithmetique {
	protected ExpressionArithmetique eaLeft;

	
	public ExpressionArithmetique getEaLeft() {
		return eaLeft;
	}


	public OperationUnaire (ExpressionArithmetique eaLeft) {
		this.eaLeft = eaLeft;
	}

	protected ExpressionArithmetique simplifie(ConstanteSymbolique gauche) {
		return this;
	}

	protected ExpressionArithmetique simplifie(VariableSymbolique gauche) {
		return this;
		
	}
	
	protected ExpressionArithmetique simplifie(ExpressionArithmetique gauche) {
		return this;
	}

	protected ExpressionArithmetique simplifie(ConstEntiere gauche) {
		return this;
	}
	
	protected ExpressionArithmetique simplifie(ConstRationnelle droite) {
		return this;
	}
	protected ExpressionArithmetique simplifie(Puissance gauche) {
		return this;
	}
	

	@Override
	public ExpressionArithmetique simplifier() {

		ExpressionArithmetique res;
		this.eaLeft = this.eaLeft.simplifier();
		

		if (this.eaLeft instanceof ConstEntiere) {
			ConstEntiere gauche = (ConstEntiere) this.eaLeft;
			
			res = simplifie (gauche);
		} else if (this.eaLeft instanceof ConstRationnelle ) {
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
		else if (this.eaLeft instanceof Ln) {
			Ln gauche = (Ln) this.eaLeft;
			

			res = simplifie(gauche);

		}
		

		else {
			res = this;
		}

		return res;

	}



}
