package td3;

public final class ConstRationnelle  implements ExpressionArithmetique {

	@Override
	public String toString() {
		return "ConstRationnelle [numerateur=" + numerateur + ", denominateur=" + denominateur + "]";
	}

	public ConstRationnelle(int d, int e) {
		this.numerateur = d;
		this.denominateur = e;
	}
	

	public int getNumerateur() {
		return numerateur;
	}

	public int getDenominateur() {
		return denominateur;
	}

	private final int numerateur;
	private final int denominateur;

	@Override
	public ExpressionArithmetique simplifier() {
		int pgcd = gcd(this.numerateur, this.denominateur);
		return new ConstRationnelle(this.numerateur / pgcd, this.denominateur / pgcd);
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
	
	@Override
	public double calculer() {
	return  (double )this.getNumerateur() / this.getDenominateur() ;
	}

	@Override
	public String afficher() {
		return getNumerateur()+ "/" +getDenominateur();
	}

}
