package TestZeldiablo;

import static org.junit.Assert.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import monJeu.Case;
import monJeu.CaseVide;
import monJeu.Entite;
import monJeu.MonJeu;
import monJeu.Mur;
import monJeu.Orc;
import monJeu.Personnage;
import monJeu.Talisman;
import moteurJeu.Commande;

import org.junit.Test;

public class TestsTalisman {

	@Test
	public void testSituationSurTalisman() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		lc[13][14] = new Talisman();
		MonJeu mj = new MonJeu(lc);
		Personnage p = new Personnage(14, 14, mj);
		Commande c = new Commande();
		c.haut = true;
		
		p.seDeplacer(c);
		
		assertEquals("Le joueur aurait du prendre le talisman", true, p.getTalisman());
	}
	
	@Test
	public void testPlusSurLePlateauApresRecuperation() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		
		lc[13][14] = new Talisman();
		MonJeu mj = new MonJeu(lc);
		Personnage p = new Personnage(14, 14, mj);
		Commande c = new Commande();
		c.haut = true;
		
		p.seDeplacer(c);
		
		assertTrue("La case talismant devrait �tre une case vide", lc[13][14] instanceof CaseVide);
	}
	
	@Test
	public void testMonstreRecupererPasTalisman() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		lc[13][14] = new Talisman();
		MonJeu mj = new MonJeu(lc);
		Orc o = new Orc(14, 14, mj);
		Commande c = new Commande();
		c.haut = true;
		
		o.seDeplacer(c);
		
		assertTrue("La case talismant devrait encore �tre une case Talismant", lc[13][14] instanceof Talisman);
	}
}
