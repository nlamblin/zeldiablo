package TestZeldiablo;

import static org.junit.Assert.*;

import java.awt.Graphics2D;

import monJeu.Case;
import monJeu.CaseVide;
import monJeu.EscalierDown;
import monJeu.EscalierUp;
import monJeu.MonJeu;
import monJeu.Monstre;
import monJeu.Orc;
import monJeu.Personnage;
import moteurJeu.Commande;

import org.junit.Ignore;
import org.junit.Test;

public class TestEscaliers {

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testMonstreVeutMonter() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		lc[10][10] = new EscalierUp();
		MonJeu mj = new MonJeu(lc);
		Orc o = new Orc(9, 10, mj);
		Commande c = new Commande();
		c.droite = true;
		o.seDeplacer(c);
		
		assertEquals("La position X du monstre ne devrait pas avoir changer", o.getX(), 10);
		assertEquals("La position Y du monstre ne devrait pas avoir changer", o.getY(), 10);
	}
	
	@Test
	public void testMonstreVeutDescendre() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		lc[10][10] = new EscalierDown();
		MonJeu mj = new MonJeu(lc);
		Orc o = new Orc(9, 10, mj);
		Commande c = new Commande();
		c.droite = true;
		o.seDeplacer(c);
		
		assertEquals("La position X du monstre ne devrait pas avoir changer", o.getX(), 10);
		assertEquals("La position Y du monstre ne devrait pas avoir changer", o.getY(), 10);
	}
	
	@Test
	public void testPersonnageVeutDescendre() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		lc[10][10] = new EscalierDown();
		MonJeu mj = new MonJeu(lc);
		Personnage p = new Personnage(9, 10, mj);
		Commande c = new Commande();
		c.droite = true;
		p.seDeplacer(c);
		
		assertEquals("La position X du personnage devrait avoir changer (+1)", p.getX(), 11);
		assertEquals("La position Y du personnage ne pas devrait avoir changer", p.getY(), 10);
	}

}
