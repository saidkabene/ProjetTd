package poo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import td3.Addition;
import td3.ConstEntiere;
import td3.ConstRationnelle;
import td3.ExpressionArithmetique;
import td3.Multiplication;
import td3.Soustraction;
import td3.VariableSymbolique;
import td3.cos;

/**
 * Unit test for simple App.
 */
public class AppTest {


	@Test
	public void simpleSum() {

		ConstEntiere neuf = new ConstEntiere(9);
		ConstEntiere deux = new ConstEntiere(2);
		Addition racine = new Addition(neuf, deux);
		

		assertEquals(11, ((ConstEntiere) racine.simplifier()).getEntier());

	}

  
	@Test
	public void classExample() {

		ExpressionArithmetique neuf = new ConstEntiere(9);
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		ExpressionArithmetique cr = new ConstRationnelle(1, 17);
		
		ExpressionArithmetique plus = new Addition(neuf, deux);

		ExpressionArithmetique minus = new Soustraction(trois, cr);
		ExpressionArithmetique times = new Multiplication(plus, minus);


		assertEquals(550, ((ConstRationnelle) times.simplifier()).getNumerateur());
		assertEquals(17, ((ConstRationnelle) times.simplifier()).getDenominateur());	

	}
	
	
	
	
	
	

	
	@Test
	public void exempleCalculer() {

		ExpressionArithmetique neuf = new ConstEntiere(9);
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		
		
		ExpressionArithmetique cr = new ConstRationnelle(1, 17);
		ExpressionArithmetique plus = new Addition(neuf, deux);
		ExpressionArithmetique minus = new Soustraction(trois, cr);
		ExpressionArithmetique times = new Multiplication(plus, minus);
		
		ExpressionArithmetique results = new ConstRationnelle(550, 17);
	
		assertEquals(550/17.0, times.calculer(),0.00001);
		
	}
	@Test
	public void question2(){
		
		ExpressionArithmetique var = new VariableSymbolique("x");
		ExpressionArithmetique un = new ConstEntiere(1);
		ExpressionArithmetique deux = new ConstEntiere(2);
		
		ExpressionArithmetique add = new Addition(deux,var);
	
		

	}
	
	@Test
	public void question3() {
		ExpressionArithmetique def = new VariableSymbolique("y");
		ExpressionArithmetique con = new ConstRationnelle(6, 3);
		System.out.println(con.afficher());
		ExpressionArithmetique qs = new Soustraction(def, con);
		System.out.println(qs.simplifier().afficher());
		
	}
	@Test
	public void question4(){
		
		ExpressionArithmetique var = new VariableSymbolique("x");
		ExpressionArithmetique un = new ConstEntiere(1);
		ExpressionArithmetique deux = new  ConstRationnelle(8,4);
		
		ExpressionArithmetique add = new Multiplication(deux,var);
		System.out.println(add.simplifier().afficher());
	

	}
	@Test
	
	public void Serine () {
		
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		
		ExpressionArithmetique ver = new VariableSymbolique("x");
		
		ExpressionArithmetique as = new Multiplication(deux,trois);
		
		ExpressionArithmetique qs = new Multiplication(as, ver);
		
		System.out.println(qs.afficher());
	}
	
	@Test
	public void coss() {
		ExpressionArithmetique deux = new VariableSymbolique("x");
		ExpressionArithmetique quatre = new ConstEntiere(4);
		
		ExpressionArithmetique cool = new cos(deux, quatre);
		System.out.println(cool.calculer());
	}

}
