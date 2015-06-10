package TestZeldiablo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import monJeu.Case;
import monJeu.CaseVide;
import monJeu.Cerise;
import monJeu.MonJeu;
import monJeu.Orc;
import monJeu.Personnage;
import monJeu.Talisman;
import moteurJeu.Commande;

import org.junit.Test;

public class TestsCerises {

	@Test
	public void testSituationSurCerise() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		lc[13][14] = new Cerise();
		MonJeu mj = new MonJeu(lc);
		Personnage p = new Personnage(14, 14, mj);
		Commande c = new Commande();
		c.haut = true;
		int pvAvant = p.getPv();
		p.seDeplacer(c);
		
		assertEquals("Le joueur aurait du prendre la cerise", pvAvant, p.getPv());
	}	

	
	@Test
	public void testPlusSurLePlateauApresRecuperation() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		lc[13][14] = new Cerise();
		MonJeu mj = new MonJeu(lc);
		Personnage p = new Personnage(14, 14, mj);
		Commande c = new Commande();
		c.haut = true;
		p.seDeplacer(c);
		
		assertFalse("La case cerise devrait être une case vide", lc[13][14] instanceof CaseVide);
	}
	
	@Test
	public void testMonstreRecuperePasCerise() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		lc[13][14] = new Cerise();
		MonJeu mj = new MonJeu(lc);
		Orc o = new Orc(14, 14, mj);
		Commande c = new Commande();
		c.haut = true;
		o.seDeplacer(c);
		
		assertTrue("La case cerise devrait encore être une case cerise", lc[13][14] instanceof Cerise);
	}

}
