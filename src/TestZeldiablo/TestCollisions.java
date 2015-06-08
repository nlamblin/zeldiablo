package TestZeldiablo;

import monJeu.Case;
import monJeu.Entite;
import monJeu.MonJeu;
import monJeu.Personnage;

import org.junit.Test;

public class TestCollisions {

	@Test
	public void testCollisionHaut() {
		MonJeu mj = new MonJeu(new Case[15][15]);
		Entite e = new Personnage(14, 14, mj);
		
		
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
