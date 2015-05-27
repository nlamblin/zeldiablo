package TestZeldiablo;

import static org.junit.Assert.*;

import org.junit.Test;

import coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u.Aventurier;
import coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u.Entite;

public class TestSeDeplacer {

	@Test
	public void testSeDelacerGauche() {
		Aventurier hero = new Aventurier(0,0);
		hero.seDeplacer(Entite.gauche);
		assertEquals("le personnage devrait s'être déplacé à droite",-1,hero.getX());
		assertEquals("le personnage devrait ne devrait pas se deplacer en bas ou en haut",0, hero.getY());
	}
	
	@Test
	public void testSeDelacerHaut() {
		Aventurier hero = new Aventurier(0,0);
		hero.seDeplacer(Entite.haut);
		assertEquals("le personnage devrait s'être déplacé en haut",-1,hero.getY());
		assertEquals("le personnage devrait ne devrait pas se deplacer à droite ou a gauche",0, hero.getX());
	}
	
	@Test
	public void testSeDelacerDroite() {
		Aventurier hero = new Aventurier(0,0);
		hero.seDeplacer(Entite.droite);
		assertEquals("le personnage devrait s'être déplacé à droite",1, hero.getX());
		assertEquals("le personnage devrait ne devrait pas se deplacer en bas ou en haut",0, hero.getY());
	}
	
	@Test
	public void testSeDelacerBas() {
		Aventurier hero = new Aventurier(0,0);
		hero.seDeplacer(Entite.bas);
		assertEquals("le personnage devrait s'être déplacé à droite",1, hero.getY());
		assertEquals("le personnage devrait ne devrait pas se deplacer à droite ou a gauche",0, hero.getX());
		
	}
	
	public void testSeDelacerErreur() {
		Aventurier hero = new Aventurier(0,0);
		hero.seDeplacer(42);
		assertEquals("le personnage devrait ne devrait pas se deplacer",0,hero.getX());
		assertEquals("le personnage devrait ne devrait pas se deplacer",0,hero.getY());
	}

}
