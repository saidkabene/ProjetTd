package poo;

import static org.junit.Assert.assertEquals;

import java.awt.TrayIcon;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import projet.Addition;
import projet.ConstEntiere;
import projet.ConstRationnelle;
import projet.ConstanteSymbolique;
import projet.Cos;
import projet.Derivation;
import projet.Distibutivite;
import projet.Division;
import projet.ExpressionArithmetique;
import projet.Factorisation;
import projet.Ln;
import projet.Multiplication;
import projet.Produit;
import projet.Puissance;
import projet.RacineCarree;
import projet.Sin;
import projet.Somme;
import projet.Soustraction;
import projet.VariableSymbolique;


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
		ExpressionArithmetique div  = new Division(quatre,deux);
	
	
		assertEquals(6, ((ConstEntiere) add.simplifier()).getEntier());
		assertEquals(-2, ((ConstEntiere) sous.simplifier()).getEntier());
		assertEquals(8, ((ConstEntiere) mul.simplifier()).getEntier());
		assertEquals(2, div.calculer(null),2);
	
	}
	
	@Test 
	public void question1_1(){
		
		ExpressionArithmetique trois = new ConstRationnelle(9,3);
		ExpressionArithmetique cinq = new ConstRationnelle(10,2);
		
		ExpressionArithmetique addd  = new Addition (trois,cinq);
		assertEquals("8", addd.simplifier().afficher());
		
		
		ExpressionArithmetique aaa  = new Soustraction (trois,cinq);	
		assertEquals("-2", aaa.simplifier().afficher());
		
		ExpressionArithmetique lum  = new Multiplication(trois,cinq);
		assertEquals("15", lum.simplifier().afficher());
		
		ExpressionArithmetique dic  = new Division(trois,cinq);
		assertEquals("(3/5)", dic.simplifier().afficher());
	}
	
	@Test
	public void question2(){
		
		ExpressionArithmetique var = new VariableSymbolique("x");
		ExpressionArithmetique deux = new ConstEntiere(0);
		
		ExpressionArithmetique add = new Addition(deux,var);
		System.out.println(add.simplifier().afficher());
		
		assertEquals("x",add.simplifier().afficher());
		

	}
	 @Test 
	 public void question3() {
		
		 ExpressionArithmetique sept = new ConstEntiere(7);
		 ExpressionArithmetique cos = new Cos (sept);
		 System.out.println(cos.calculer(null));
		 assertEquals(0.7539022543433046, cos.calculer(null),1e-4);
		 
		 ExpressionArithmetique huit = new ConstRationnelle(8,4);
		 ExpressionArithmetique yyy = new Cos (huit);
		 assertEquals(-0.4161468365471424, yyy.calculer(null),1e-4);
		 
		 ExpressionArithmetique neuf = new ConstEntiere(9);
		 ExpressionArithmetique neu = new Sin (neuf);
		 
		 System.out.println(neu.calculer(null));
		 assertEquals(0.4121184852417566, neu.calculer(null),1e-4);
		 
		 
		 ExpressionArithmetique quatre = new ConstRationnelle(8,4);
		 ExpressionArithmetique sinquatre = new Cos (quatre);
		 assertEquals(-0.4161468365471424,sinquatre.calculer(null),1e-4);
		 
		 ExpressionArithmetique ooo = new ConstEntiere(3);
		 ExpressionArithmetique iii = new ConstEntiere(5);
		 ExpressionArithmetique p = new Puissance(ooo,iii);
		 assertEquals(243 ,p.calculer(null),1e-4);
		
		 
		 ExpressionArithmetique lnquatre = new ConstEntiere(4);
		 ExpressionArithmetique ln = new Ln(lnquatre);
		 assertEquals(1.3862943611198906,ln.calculer(null),1e-4);
	
		 
		 ExpressionArithmetique consquatre = new ConstRationnelle(18,2);
		 ExpressionArithmetique lnneuf = new Ln(consquatre);
		 System.err.println(lnneuf.calculer(null));
		 assertEquals(2.1972245773362196,lnneuf.calculer(null),1e-4);
		 
		 
		 ExpressionArithmetique Rcquartre = new ConstEntiere(4);
		 ExpressionArithmetique sqrt = new RacineCarree(Rcquartre);
		 System.out.println(sqrt.calculer(null));
		 assertEquals(2,sqrt.calculer(null),1e-4);
		 
		 ExpressionArithmetique Rcsept = new ConstRationnelle(7,2);
		 ExpressionArithmetique sqrtsept = new RacineCarree(Rcsept);
		 System.out.println(sqrtsept.calculer(null));
		 assertEquals(1.8708286933869707,sqrtsept.calculer(null),1e-4);
	 }
	 @Test
	 public void question4() {
		 
		 ExpressionArithmetique sym = new ConstanteSymbolique("pi");
		 
		 assertEquals(3.1415, sym.calculer(null), 1e-4);
		 
		 ExpressionArithmetique e = new ConstanteSymbolique("e");
		 assertEquals(2.7182, e.calculer(null),1e-4);
		
	 }
	 
	 @Test
	 public void question5() {
		 
		 ExpressionArithmetique cons = new ConstRationnelle(1, 4);
		 ExpressionArithmetique cons2 = new ConstRationnelle(3, 4);
		 ExpressionArithmetique v = new VariableSymbolique("x");
		 
		 
		 
		 ExpressionArithmetique add = new Addition(cons, cons2);
		 ExpressionArithmetique add2 = new Addition(add,v);
		
		 assertEquals("(1+x)", add2.simplifier().afficher());
		  
	 }
	 
	 @Test
		public void question6() {
			ExpressionArithmetique un = new ConstEntiere(1);
			ExpressionArithmetique fraction = new ConstRationnelle(3,4);
			ExpressionArithmetique racine = new Addition(un, fraction);
			assertEquals(1.7500, racine.calculer(null),1e-4);
			
			ExpressionArithmetique pi = new ConstanteSymbolique("pi");
			
			ExpressionArithmetique add = new Addition(un, pi);
			System.out.println(add.calculer(null));
			assertEquals(4.141592653589793,add.calculer(null),1e-4);
		}
	 
	
	
		 
		 @Test 
	     public void question7() {
	        ExpressionArithmetique un   = new ConstEntiere(1);
	        ExpressionArithmetique deux = new ConstEntiere(2);
	        ExpressionArithmetique var  = new VariableSymbolique("x"); 
	        ExpressionArithmetique add1 = new Addition(un,un);
	        ExpressionArithmetique add2 = new Addition(add1,var);
	        ExpressionArithmetique add3 = new Addition(deux,var);
	        System.out.println(add2.equals(add3));
	        System.out.println(add3.simplifier().afficher());
	        System.out.println(add2.simplifier().afficher());
	        assertEquals(true,add2.equals(add3));
	 }
	

	
	
		 @Test
			public void question8() {
				Map<VariableSymbolique, ExpressionArithmetique> map = new HashMap<>();
				ExpressionArithmetique un = new ConstEntiere(1);
				map.put(new VariableSymbolique("x"), un);
				map.put(new VariableSymbolique("y"), un);
				ExpressionArithmetique add1 = new Addition(new VariableSymbolique("y"),un);
				ExpressionArithmetique div = new Division(new VariableSymbolique("x"),add1);
				ExpressionArithmetique add2 = new Addition(un,div);
				assertEquals(1.5,add2.calculer(map),1e-4);
				
			}
	
	@Test
	public void question9() {
		
		ExpressionArithmetique un = new ConstEntiere( 1);
		ExpressionArithmetique ver = new VariableSymbolique ("x");
		
		ExpressionArithmetique cons = new ConstRationnelle(1, 2);
		
		ExpressionArithmetique pi = new ConstanteSymbolique("pi");
		ExpressionArithmetique cos = new Cos(ver);
		
		ExpressionArithmetique mul = new Multiplication(cons, pi);
		
		ExpressionArithmetique add =  new Addition(cos,mul);
		
		assertEquals("(Cos(x)+((1/2)*π))",add.simplifier().afficher());
		
	}
	
	@Test 
	public void question10() {
		
		ExpressionArithmetique un = new ConstEntiere(1);
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique zz = new Ln(un);
		ExpressionArithmetique add = new Addition(deux,zz);
		assertEquals("2",add.simplifier().afficher());
		
		ExpressionArithmetique cinq = new ConstEntiere(5);
		ExpressionArithmetique cos = new ConstEntiere(2);
		ExpressionArithmetique zzz = new Ln(cinq);
		ExpressionArithmetique addd = new Addition(cos,zzz);
		assertEquals("(2+ln(5))", addd.simplifier().afficher());
		
		ExpressionArithmetique n = new ConstEntiere(1);
		ExpressionArithmetique z = new ConstEntiere(0);
		ExpressionArithmetique v = new ConstanteSymbolique("e");
		ExpressionArithmetique p = new Puissance(z,v);
		ExpressionArithmetique d = new Addition(n, p);
		//assertEquals("2", d.simplifier().afficher());
		System.out.println(d.simplifier().afficher());
		
		
		ExpressionArithmetique u = new ConstEntiere(1);
		ExpressionArithmetique deuxx = new ConstEntiere(2);
		ExpressionArithmetique pi = new ConstanteSymbolique("pi");
		ExpressionArithmetique div = new Division(pi, deuxx);
		ExpressionArithmetique sinn = new Sin(div);
		ExpressionArithmetique ads = new Addition(u, sinn);
		System.out.println(ads.simplifier().afficher());
		assertEquals("2",ads.simplifier().afficher());
		

		ExpressionArithmetique deuxxx = new ConstEntiere(5);
		ExpressionArithmetique pii = new ConstanteSymbolique("pi");
		ExpressionArithmetique divv = new Division(pii, deuxxx);
		ExpressionArithmetique sins = new Sin(divv);
	
		assertEquals("sin((π/5))",sins.simplifier().afficher());
		
		
		ExpressionArithmetique quatre = new ConstEntiere(4);
		ExpressionArithmetique rc = new RacineCarree(quatre);
		assertEquals("2",rc.simplifier().afficher());
		
		ExpressionArithmetique trois = new ConstEntiere(3);
		ExpressionArithmetique rcc = new RacineCarree(trois);
		assertEquals("√3",rcc.simplifier().afficher());
	
	
}
	

	@Test 
	public void  question11() {
		
		
		ExpressionArithmetique d = new VariableSymbolique("α");
		
		ExpressionArithmetique y = new VariableSymbolique("x");
		ExpressionArithmetique b = new Multiplication(d,y);
		ExpressionArithmetique s = new Somme(b,1,4);
		
		System.out.println(s.simplifier().afficher());
		

		
	} 
	
	@Test 
	public void question12() {
		ExpressionArithmetique x = new VariableSymbolique("x");
		ExpressionArithmetique y = new VariableSymbolique("α");
		
		ExpressionArithmetique m = new Multiplication(y, x);
        ExpressionArithmetique s = new Produit(m,0,4);
        System.out.println(s.afficher());
        assertEquals("α0*α1*α2*α3*α4*x^10", s.simplifier().afficher());
    }
	
	@Test 
	public void question14() {
		
			ExpressionArithmetique cinq   = new ConstEntiere(5);
	        ExpressionArithmetique quatre = new ConstEntiere(4);
	        ExpressionArithmetique trois = new ConstEntiere(3);
	        ExpressionArithmetique dix   = new ConstEntiere(10);
	        ExpressionArithmetique deux  = new ConstEntiere(2);
	        ExpressionArithmetique x     = new VariableSymbolique("x");
	        ExpressionArithmetique p4    = new Puissance(x,quatre);
	        ExpressionArithmetique p3    = new Puissance(x,trois);
	        ExpressionArithmetique p2    = new Puissance(x,deux);
	        ExpressionArithmetique mult1 = new Multiplication(cinq, p4);
	        ExpressionArithmetique mult2 = new Multiplication(quatre, p3);
	        ExpressionArithmetique mult3 = new Multiplication(trois, p2);
	        ExpressionArithmetique mult4 = new Multiplication(cinq, x);
	        ExpressionArithmetique d1    = new Derivation(mult1,3);
	        ExpressionArithmetique d2    = new Derivation(mult2,3);
	        ExpressionArithmetique d3    = new Derivation(mult3,3);
   	        ExpressionArithmetique d4    = new Derivation(mult4,3);
	        ExpressionArithmetique d5    = new Derivation(dix);
	        ExpressionArithmetique add1  = new Addition(d1,d2);
	        ExpressionArithmetique add2  = new Addition(d3,d4);
	        ExpressionArithmetique add3  = new Addition(add1,add2);
	        ExpressionArithmetique add4  = new Addition(add3,d5);
	        System.out.println();
	        assertEquals("((120*x)+24)", add4.simplifier().afficher());
	    }
	@Test
    public void question13() {
        ExpressionArithmetique trois = new ConstEntiere(3);
        ExpressionArithmetique deux  = new ConstEntiere(2);
        ExpressionArithmetique cinq  = new ConstEntiere(5);
        ExpressionArithmetique dix   = new ConstEntiere(10);
        ExpressionArithmetique x     = new VariableSymbolique("x");
        ExpressionArithmetique p     = new Puissance(x,deux);
        ExpressionArithmetique mult  = new Multiplication(trois,p);
        ExpressionArithmetique mult2 = new Multiplication(cinq,x);
        ExpressionArithmetique d1    = new Derivation(mult);
        ExpressionArithmetique d2    = new Derivation(mult2);
        ExpressionArithmetique d3    = new Derivation(dix);
        ExpressionArithmetique add1  = new Addition(d1,d2);
        ExpressionArithmetique add2  = new Addition(add1,d3);
       
        assertEquals("((6*x)+5)", add2.simplifier().afficher());
    }
	
	@Test 
	public void question15() {
		
		
		ExpressionArithmetique 	a = new VariableSymbolique("x");
		ExpressionArithmetique un = new ConstEntiere(1);
		ExpressionArithmetique mul = new Multiplication(a, un);
		System.out.println(mul.simplifier().afficher());
		assertEquals("x", mul.simplifier().afficher());
		
		
		ExpressionArithmetique zero = new ConstEntiere(0);
		ExpressionArithmetique 	b = new VariableSymbolique("x");
		ExpressionArithmetique add = new Addition(zero, b);
		
		assertEquals("x",add.simplifier().afficher());
		
		ExpressionArithmetique z = new ConstEntiere(0);
		ExpressionArithmetique c = new VariableSymbolique("x");
		ExpressionArithmetique addz = new Soustraction(z, c);
		
		assertEquals("x",addz.simplifier().afficher());
		
		ExpressionArithmetique e = new ConstEntiere(0);
		ExpressionArithmetique f = new VariableSymbolique("x");
		ExpressionArithmetique addf = new Soustraction(f, e);
		
		
		assertEquals("x",addf.simplifier().afficher());
		
		ExpressionArithmetique y = new VariableSymbolique("x");		
		ExpressionArithmetique t = new ConstEntiere(1);
		ExpressionArithmetique div =  new Division(y,t);
		
		System.out.println(div.simplifier().afficher());
		assertEquals("x", div.simplifier().afficher());
		
		ExpressionArithmetique cs = new ConstEntiere(0);
		ExpressionArithmetique d = new VariableSymbolique("x");
		ExpressionArithmetique k = new Cos(d);
		
		System.out.println(k.simplifier().afficher());
		
		assertEquals("Cos(x)", k.simplifier().afficher());
		
		ExpressionArithmetique 	hhh = new VariableSymbolique("x");
		ExpressionArithmetique  kkk = new ConstEntiere(5);
		ExpressionArithmetique  mmm = new ConstEntiere(4);
		ExpressionArithmetique  fff = new Soustraction(kkk, mmm);
		ExpressionArithmetique  lll = new Multiplication(hhh,fff);
		System.out.println(lll.simplifier().afficher());
		assertEquals("x", lll.simplifier().afficher());
		
	}	
	// supporter la distributivit´e du produit sur l’addition et la soustraction.
	@Test 
	public void question16() {
		
		
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique var  = new VariableSymbolique("x");	
		ExpressionArithmetique cons = new ConstRationnelle(1,2);
		ExpressionArithmetique add = new Addition(var, cons);
		ExpressionArithmetique mul = new Multiplication(deux,add);
		ExpressionArithmetique ex = new Distibutivite(mul);
		System.out.println(ex.simplifier().afficher());
		assertEquals("((2*x)+1)",ex.simplifier().afficher() );//2*(x+1/2)=2x+1
		
		ExpressionArithmetique deu = new ConstEntiere(2);
		ExpressionArithmetique va  = new VariableSymbolique("x");	
		ExpressionArithmetique con = new ConstRationnelle(1,2);
		ExpressionArithmetique ad = new Soustraction(va, con);
		ExpressionArithmetique mu = new Multiplication(deu,ad);
		ExpressionArithmetique exx = new Distibutivite(mu);
		System.out.println(exx.simplifier().afficher());
		assertEquals("((2*x)-1)",exx.simplifier().afficher() );
		
		
	}
	// supporter l’associativité des sommes et des multiplications :   
	@Test  
	public void  question17() {
		
		ExpressionArithmetique un = new ConstEntiere(1);
		ExpressionArithmetique x = new VariableSymbolique("x");
		ExpressionArithmetique add = new Addition(un , x);
		ExpressionArithmetique mui = new Addition(un,add);
		
		System.out.println(mui.simplifier().afficher());
		assertEquals("(2+x)", mui.simplifier().afficher());           // 1 + (1 + x) = 2 + x
		
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique cons =  new ConstRationnelle(1,2);	
		ExpressionArithmetique v    = new VariableSymbolique("x");
		ExpressionArithmetique mul  = new Multiplication(cons, v);
		ExpressionArithmetique mlk  = new Multiplication(deux,mul);
		
	    System.out.println(mlk.simplifier().afficher());
		assertEquals("x", mlk.simplifier().afficher());               //  2(1/2* x) = x
		
                                                       
 
		
	}
	 @Test 
     public void question18() {
        ExpressionArithmetique trois   = new ConstEntiere(3);
        ExpressionArithmetique deux    = new ConstEntiere(2);
        ExpressionArithmetique six     = new ConstEntiere(6);
        ExpressionArithmetique b       = new VariableSymbolique("b");
        ExpressionArithmetique a       = new VariableSymbolique("a");
        ExpressionArithmetique p       = new Puissance(	a, deux);
        ExpressionArithmetique mul	   = new Multiplication(trois, p);
        ExpressionArithmetique mull    = new Multiplication(six, a);
        ExpressionArithmetique mulll   = new Multiplication(mull, b);
        ExpressionArithmetique fac     = new Addition(mul,mulll);
        
        ExpressionArithmetique z	   = new Puissance(b, deux);
        ExpressionArithmetique k	   = new Multiplication(trois, z);
        ExpressionArithmetique add     = new Addition(fac,k);
        ExpressionArithmetique l       = new Factorisation(add);
        System.out.println();
        assertEquals("(3*(a+b))^2", l.simplifier().afficher());
      
 }
		
	

	


	
	
	
	
}
