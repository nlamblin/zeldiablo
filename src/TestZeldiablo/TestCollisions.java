package TestZeldiablo;

import static org.junit.Assert.*;
import monJeu.Case;
import monJeu.CaseVide;
import monJeu.Entite;
import monJeu.MonJeu;
import monJeu.Mur;
import monJeu.Personnage;
import moteurJeu.Commande;

import org.junit.Test;

public class TestCollisions {

	@Test
	public void testCollisionHaut() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		lc[13][14] = new Mur();
		MonJeu mj = new MonJeu(lc);
		Entite e = new Personnage(14, 14, mj);
		Commande c = new Commande();
		c.haut= true;
		e.seDeplacer(c);
		assertEquals("Le deplacement X ne doit pas pouvoir se faire",14,e.getX());
		assertEquals("Le deplacement Y ne doit pas pouvoir se faire",14,e.getY());
	}
	
	@Test
	public void testCollisionBas() {
		MonJeu mj = new MonJeu(new Case[15][15]);
		Entite e = new Personnage(14, 14, mj);
	}

	@Test
	public void testCollisionDroite() {
		MonJeu mj = new MonJeu(new Case[15][15]);
		Entite e = new Personnage(14, 14, mj);
	}
	
	@Test
	public void testCollisionGauche() {
		MonJeu mj = new MonJeu(new Case[15][15]);
		Entite e = new Personnage(14, 14, mj);
	}
	
	public void testCaseVide() {
		
	}
}
