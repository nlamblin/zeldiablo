package TestZeldiablo;

import static org.junit.Assert.*;
import monJeu.Entite;
import monJeu.Personnage;

import org.junit.Test;

public class TestSeDeplacer {

	@Test
	public void testSeDelacerGauche() {
		Personnage hero = new Personnage(0,0);
		hero.seDeplacer(Entite.gauche);
		assertEquals("le personnage devrait s'�tre d�plac� � droite",-1,hero.getX());
		assertEquals("le personnage ne devrait pas se deplacer en bas ou en haut",0, hero.getY());
	}
	
	@Test
	public void testSeDelacerHaut() {
		Personnage hero = new Personnage(0,0);
		hero.seDeplacer(Entite.haut);
		assertEquals("le personnage devrait s'�tre d�plac� en haut",-1,hero.getY());
		assertEquals("le personnage ne devrait pas se deplacer � droite ou a gauche",0, hero.getX());
	}
	
	@Test
	public void testSeDelacerDroite() {
		Personnage hero = new Personnage(0,0);
		hero.seDeplacer(Entite.droite);
		assertEquals("le personnage devrait s'�tre d�plac� � droite",1, hero.getX());
		assertEquals("le personnage ne devrait pas se deplacer en bas ou en haut",0, hero.getY());
	}
	
	@Test
	public void testSeDelacerBas() {
		Personnage hero = new Personnage(0,0);
		hero.seDeplacer(Entite.bas);
		assertEquals("le personnage devrait s'�tre d�plac� � droite",1, hero.getY());
		assertEquals("le personnage ne devrait pas se deplacer � droite ou a gauche",0, hero.getX());
		
	}
	
	@Test
	public void testSeDelacerErreur() {
		Personnage hero = new Personnage(0,0);
		hero.seDeplacer(42);
		assertEquals("le personnage ne devrait pas se deplacer",0,hero.getX());
		assertEquals("le personnage ne devrait pas se deplacer",0,hero.getY());
	}

}
