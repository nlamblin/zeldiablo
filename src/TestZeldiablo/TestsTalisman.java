package TestZeldiablo;

import static org.junit.Assert.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import monJeu.Case;
import monJeu.CaseVide;
import monJeu.Entite;
import monJeu.MonJeu;
import monJeu.Mur;
import monJeu.Personnage;
import monJeu.Talisman;
import moteurJeu.Commande;

import org.junit.Test;

public class TestsTalisman {

	/*@Test
	public void testTalismanCaseVide() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		lc[14][14] = new CaseVide();
		lc[14][14] = new Talisman();	
		MonJeu mj = new MonJeu(lc);
		
		assertEquals("Le talisman devrait être sur la case d'abcisse 10", 14);
		assertEquals("Le talisman devrait être sur la case d'ordonnée 10", 14);
	}*/

	@Ignore
	public void testSituationSurTalisman() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		lc[13][14] = new Talisman();
		MonJeu mj = new MonJeu(lc);
		Entite e = new Personnage(14, 14, mj);
		Commande c = new Commande();
		c.haut = true;
		e.seDeplacer(c);
		assertEquals("Le joueur aurait du etre sur le talisman", lc[13][14], e.);
	}
	
	@Ignore
	public void testPlusSurLePlateauApresRecuperation() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		Talisman t = new Talisman();
		lc[14][15] = new Mur();
		MonJeu mj = new MonJeu(lc);
	}
	
	@Ignore
	public void testMonstreRecupererPasTalisman() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		Talisman t = new Talisman();
		lc[14][15] = new Mur();
		MonJeu mj = new MonJeu(lc);
	}
}
