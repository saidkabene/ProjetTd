package poo;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import td3.Addition;
import td3.ConstEntiere;
import td3.ConstRationnelle;
import td3.Division;
import td3.ExpressionArithmetique;
import td3.Multiplication;
import td3.Puissance;
import td3.RacineCarree;
import td3.Soustraction;
import td3.VariableSymbolique;
import td3.cos;
import td3.ln;
import td3.sin;


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
	public void question1() {
		
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique quatre = new ConstEntiere(4);
		ExpressionArithmetique add  = new Addition (deux,quatre); 
		ExpressionArithmetique sous = new Soustraction(deux,quatre);
		ExpressionArithmetique mul  = new Multiplication(deux,quatre);
		ExpressionArithmetique div  = new Division(deux,quatre);
		
		assertEquals(2+2, add.calculer(), 4);
		assertEquals(2-4, sous.calculer(), 2);
		assertEquals(2*4, mul.calculer(), 8);
		assertEquals(2/4, div.calculer(),0.5);
	
	}
	
	@Test 
	public void question11(){
		
		ExpressionArithmetique trois = new ConstRationnelle(9,3);
		ExpressionArithmetique cinq = new ConstRationnelle(10,2);
		
		ExpressionArithmetique addd  = new Addition (trois,cinq);
		
		
		assertEquals(8, addd.calculer(),9/3 + 10/5);
		
		ExpressionArithmetique aaa  = new Soustraction (trois,cinq);
		assertEquals(-2,aaa.calculer() ,9/3 - 10/5);
		
		ExpressionArithmetique lum  = new Multiplication(trois,cinq);
		assertEquals(15, lum.calculer(), 9/3 * 10/5);
		
		ExpressionArithmetique dic  = new Division(trois,cinq);
		assertEquals(0.6, dic.calculer(), 9/3 / 10/5);
	}
	 @Test 
	 public void question3() {
		
		 ExpressionArithmetique sept = new ConstEntiere(7);
		 ExpressionArithmetique cos = new cos (sept);
		 assertEquals(0.7539022543433046, cos.calculer(),1e-4);
		 
		 ExpressionArithmetique huit = new ConstRationnelle(8,4);
		 ExpressionArithmetique yyy = new cos (huit);
		 assertEquals(-0.4161468365471424, yyy.calculer(),Math.cos(8));
		 
		 ExpressionArithmetique neuf = new ConstEntiere(9);
		 ExpressionArithmetique neu = new sin (neuf);
		 assertEquals(0.4121184852417566, neu.calculer(),Math.cos(9));
		 
		 ExpressionArithmetique quatre = new ConstRationnelle(8,4);
		 ExpressionArithmetique sinquatre = new cos (quatre);
		 assertEquals(-0.4161468365471424,sinquatre.calculer(),Math.sin(4));
		 
		 ExpressionArithmetique ooo = new ConstEntiere(3);
		 ExpressionArithmetique iii = new ConstEntiere(5);
		 ExpressionArithmetique p = new Puissance(ooo,iii);
		 assertEquals(243 ,p.calculer(),Math.pow(3, 5));
		
		 
		 ExpressionArithmetique lnquatre = new ConstEntiere(4);
		 ExpressionArithmetique ln = new ln(lnquatre);
		 assertEquals(1.3862943611198906,ln.calculer(),Math.log(4));
	
		 
		 ExpressionArithmetique consquatre = new ConstRationnelle(18,2);
		 ExpressionArithmetique lnneuf = new ln(consquatre);
		 System.err.println(lnneuf.calculer());
		 assertEquals(2.1972245773362196,lnneuf.calculer(),Math.log(18/2));
		 
		 
		 ExpressionArithmetique Rcquartre = new ConstEntiere(4);
		 ExpressionArithmetique sqrt = new RacineCarree(Rcquartre);
		 System.out.println(sqrt.calculer());
		 assertEquals(2,sqrt.calculer(),Math.sqrt(4));
		 
		 ExpressionArithmetique Rcsept = new ConstRationnelle(7,2);
		 ExpressionArithmetique sqrtsept = new RacineCarree(Rcsept);
		 System.out.println(sqrtsept.calculer());
		 assertEquals(1.7320508075688772,sqrtsept.calculer(),Math.sqrt(7/2));
	 }
	 
	 @Test
	 public void question5() {
		 
		 ExpressionArithmetique cons = new ConstRationnelle(1, 4);
		 ExpressionArithmetique cons2 = new ConstRationnelle(3, 4);
		 ExpressionArithmetique v = new VariableSymbolique("x");
		 ExpressionArithmetique add = new Addition(cons, cons2);
		 ExpressionArithmetique add2 = new Addition(add,v);
		 System.out.println(add2);
		 
		 
	
		  
	 }
	 
	
	@Test 
	 public void question7() {
		 
		 ExpressionArithmetique deux = new ConstEntiere(2);
		 
		 ExpressionArithmetique trois = new ConstEntiere(3);
		 ExpressionArithmetique add = new Addition(deux, trois);
		
		 
		 ExpressionArithmetique dix = new ConstEntiere(10);
		 ExpressionArithmetique cinq = new ConstEntiere(5);
		 ExpressionArithmetique sous = new Soustraction(dix,cinq);
		
		 
		 assertEquals(5,add.calculer(),1e-4);
		 
		 
	 }
	 
	
	
	
	
	
	/*
	
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
	*/
	/*
	@Test
	
	public void additionConsVar () {
		
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		
		ExpressionArithmetique ver = new VariableSymbolique("x");
		
		ExpressionArithmetique as = new Multiplication(deux,trois);
		System.out.println(as.calculer());
		ExpressionArithmetique qs = new Addition(as, ver);
		
		System.out.println(qs.simplifier().afficher());
	}
	/*
	/*
	@Test
	public void CosAvecConstEntiere() {
		
		ExpressionArithmetique quatre = new ConstEntiere(1);
		ExpressionArithmetique cool = new cos(quatre);
		System.out.println(cool.calculer());
	}
	*/
	
	/*
	@Test
	public void CosAvecConstRationnel() {
		
		ExpressionArithmetique ration = new ConstRationnelle(6, 3);
		System.out.println(ration.calculer());
		ExpressionArithmetique cossq = new ConstEntiere(6);
		System.out.println(cossq.afficher());
		ExpressionArithmetique res = new cos (ration);
		System.out.println(res.afficher());
		ExpressionArithmetique ads = new Addition(res, cossq); 
		System.out.println(ads.afficher());
		ExpressionArithmetique mlk = new Multiplication(ads, cossq);
		System.out.println(mlk.calculer());
		
	}
	*/
	/*
	@Test
	public void VariableSymAvecConsrationnel()  {
		
		ExpressionArithmetique ver = new VariableSymbolique("x");
		
		ExpressionArithmetique con = new ConstRationnelle(10,5);
		ExpressionArithmetique mil = new Addition(ver, con);
		System.out.println(mil.calculer());
		
	}
	
	 */
	/*
	@Test
	public void additionConsVarsim ()  {
		
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		
		ExpressionArithmetique ver = new VariableSymbolique("x");
		
		ExpressionArithmetique as = new Multiplication(deux,trois);
		ExpressionArithmetique qs = new Addition(ver,as);
		
		
	
		
		
	}
	*/
	
	
	/*
	@Test
	public void additionConsVar () throws varException {
		
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		
		ExpressionArithmetique ver = new VariableSymbolique("x");
		
		ExpressionArithmetique as = new Multiplication(deux,trois);
		ExpressionArithmetique qs = new Addition(ver,as);
		
		System.out.println(qs.simplifier().afficher());
		assertEquals(qs.toString(), qs.simplifier().afficher());
		
	}
	@Test
	public void cosAvecEntiere() {
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		
		ExpressionArithmetique cinq = new ConstRationnelle(9, 3);
		ExpressionArithmetique dix = new ConstRationnelle(10, 5);
		
		ExpressionArithmetique ad = new Addition(cinq , dix);
		System.out.println(ad.simplifier().afficher());
		System.out.println(ad.calculer());
		
		
		ExpressionArithmetique add = new Addition(deux, trois);
		ExpressionArithmetique sss = new cos(add);
		
		System.out.println(sss.simplifier().afficher());
		System.out.println(sss.calculer());
		
		ExpressionArithmetique mul = new Multiplication(deux, trois);
		ExpressionArithmetique aaa = new cos (mul);
		
		System.out.println(aaa.simplifier().afficher());
		System.out.println(aaa.calculer());
		
	}
	
	@Test
	public void cosAvecVariable() {
		ExpressionArithmetique ver = new  VariableSymbolique("x");
		
		ExpressionArithmetique sss = new ConstEntiere(3);
		
		ExpressionArithmetique eee = new ConstEntiere(3);
		ExpressionArithmetique qqq= new cos (ver);
		ExpressionArithmetique iii = new ConstRationnelle(2,2);
		ExpressionArithmetique ad = new Addition(qqq,iii);
		
		

		System.out.println(qqq.calculer());
		
		
	}
	
	@Test 
	public void sinAvecConst() {
		
		
		
		ExpressionArithmetique eee = new VariableSymbolique("y");
		ExpressionArithmetique trois = new ConstEntiere(3);
		ExpressionArithmetique quatre = new ConstEntiere(4);
		
		
 		ExpressionArithmetique zzz = new Puissance(trois,quatre);
 		
 		System.out.println(zzz.toString());
 		System.out.println(zzz.simplifier().afficher());
 		assertEquals(zzz.toString(), zzz.simplifier().afficher());
			
		
	}
	*/
	
}
