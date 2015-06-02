package TestZeldiablo;

import static org.junit.Assert.*;
import monJeu.Aventurier;
import monJeu.Entite;

import org.junit.Test;

public class TestSeDeplacer {

	@Test
	public void testSeDelacerGauche() {
		Aventurier hero = new Aventurier(0,0);
		hero.seDeplacer(Entite.gauche);
		assertEquals("le personnage devrait s'être déplacé à droite",-1,hero.getX());
		assertEquals("le personnage ne devrait pas se deplacer en bas ou en haut",0, hero.getY());
	}
	
	@Test
	public void testSeDelacerHaut() {
		Aventurier hero = new Aventurier(0,0);
		hero.seDeplacer(Entite.haut);
		assertEquals("le personnage devrait s'être déplacé en haut",-1,hero.getY());
		assertEquals("le personnage ne devrait pas se deplacer à droite ou a gauche",0, hero.getX());
	}
	
	@Test
	public void testSeDelacerDroite() {
		Aventurier hero = new Aventurier(0,0);
		hero.seDeplacer(Entite.droite);
		assertEquals("le personnage devrait s'être déplacé à droite",1, hero.getX());
		assertEquals("le personnage ne devrait pas se deplacer en bas ou en haut",0, hero.getY());
	}
	
	@Test
	public void testSeDelacerBas() {
		Aventurier hero = new Aventurier(0,0);
		hero.seDeplacer(Entite.bas);
		assertEquals("le personnage devrait s'être déplacé à droite",1, hero.getY());
		assertEquals("le personnage ne devrait pas se deplacer à droite ou a gauche",0, hero.getX());
		
	}
	
	@Test
	public void testSeDelacerErreur() {
		Aventurier hero = new Aventurier(0,0);
		hero.seDeplacer(42);
		assertEquals("le personnage ne devrait pas se deplacer",0,hero.getX());
		assertEquals("le personnage ne devrait pas se deplacer",0,hero.getY());
	}

}
