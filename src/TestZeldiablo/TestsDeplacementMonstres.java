package TestZeldiablo;

import static org.junit.Assert.assertEquals;
import monJeu.Case;
import monJeu.CaseVide;
import monJeu.Entite;
import monJeu.MonJeu;
import monJeu.Mur;
import monJeu.Orc;
import monJeu.Personnage;

import org.junit.Test;

public class TestsDeplacementMonstres {

	@Test
	public void testCreationMonstre() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		lc[14][15] = new Mur();
		MonJeu mj = new MonJeu(lc);
		Entite e = new Orc(14, 14, mj);
		assertEquals("L'orc devrait être créé à la case 14,14",14,e.getX());
		assertEquals("L'orc devrait être créé à la case 14,14",14,e.getX());
	}
	
	@Test
	public void testMonstreSeRapprocheDuHero() {
		// lorsqu'ils sont à moins de 3 cases
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		MonJeu mj = new MonJeu(lc);
		Entite e = new Orc(13, 13, mj);
		Personnage e2 = new Personnage(11, 11, mj);
		mj.pj=e2;
		mj.evoluerEntite(e);
		assertEquals("Le personnage ne devrait pas bouger",11,e2.getX());
		assertEquals("Le personnage ne devrait pas bouger",11,e2.getY());
		assertEquals("L'orc devrait se rapprocher du personnage",12,e.getX());
		assertEquals("L'orc devrait se rapprocher du personnage",13,e.getY());

	}
	


}
