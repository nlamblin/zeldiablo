package TestZeldiablo;

import static org.junit.Assert.*;
import monJeu.Case;
import monJeu.CaseVide;
import monJeu.Entite;
import monJeu.MonJeu;
import monJeu.Personnage;
import moteurJeu.Commande;

import org.junit.Test;

public class TestSeDeplacer {

	@Test
	public void testSeDelacerGauche() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		Personnage hero = new Personnage(1,0,new MonJeu(lc));
		Commande c = new Commande();
		c.gauche = true;
		hero.seDeplacer(c);
		assertEquals("le personnage devrait s'être déplacé à droite",0,hero.getX());
		assertEquals("le personnage ne devrait pas se deplacer en bas ou en haut",0, hero.getY());
	}
	
	@Test
	public void testSeDelacerHaut() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		Personnage hero = new Personnage(0,1,new MonJeu(lc));
		Commande c = new Commande();
		c.haut = true;
		hero.seDeplacer(c);
		assertEquals("le personnage devrait s'être déplacé en haut",0,hero.getY());
		assertEquals("le personnage ne devrait pas se deplacer à droite ou a gauche",0, hero.getX());
	}
	
	@Test
	public void testSeDelacerDroite() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		Personnage hero = new Personnage(0,0,new MonJeu(lc));
		Commande c = new Commande();
		c.droite = true;
		hero.seDeplacer(c);
		assertEquals("le personnage devrait s'être déplacé à droite",1, hero.getX());
		assertEquals("le personnage ne devrait pas se deplacer en bas ou en haut",0, hero.getY());
	}
	
	@Test
	public void testSeDelacerBas() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		Personnage hero = new Personnage(0,0,new MonJeu(lc));
		Commande c = new Commande();
		c.bas = true;
		hero.seDeplacer(c);
		assertEquals("le personnage devrait s'être déplacé à droite",1, hero.getY());
		assertEquals("le personnage ne devrait pas se deplacer à droite ou a gauche",0, hero.getX());
		
	}
	
	@Test
	public void testSeDelacerErreur() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		Personnage hero = new Personnage(0,0,new MonJeu(lc));
		Commande c = new Commande();
		hero.seDeplacer(c);
		assertEquals("le personnage ne devrait pas se deplacer",0,hero.getX());
		assertEquals("le personnage ne devrait pas se deplacer",0,hero.getY());
	}

}
