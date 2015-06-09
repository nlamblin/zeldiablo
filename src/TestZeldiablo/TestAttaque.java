package TestZeldiablo;

import static org.junit.Assert.*;
import monJeu.Case;
import monJeu.CaseVide;
import monJeu.Entite;
import monJeu.MonJeu;
import monJeu.Mur;
import monJeu.Orc;
import monJeu.Personnage;

import org.junit.Ignore;
import org.junit.Test;

public class TestAttaque {

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAttaqueBonnePorteeOrcVersPersonnage() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		MonJeu mj = new MonJeu(lc);
		Personnage p = new Personnage(14, 14, mj);
		Orc o = new Orc(13, 14, mj);
		int pvAvantAttaque = p.getPv();
		
		o.attaquer();
	
		assertEquals("Le personnage aurait du perdre des point de vie", p.getPv(), pvAvantAttaque-o.getDegats());
	}
	
	@Test
	public void testAttaqueMauvaisePorteeOrcVsPersonnage() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		MonJeu mj = new MonJeu(lc);
		Personnage p = new Personnage(14, 14, mj);
		Orc o = new Orc(6, 10, mj);
		int pvAvantAttaque = p.getPv();
		
		o.attaquer();
	
		assertEquals("Le personnage n'aurait pas du perdre de point de vie", p.getPv(), pvAvantAttaque);
	}
	
	@Test
	public void testAttaqueBonnePorteePersonnageVsOrc() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		MonJeu mj = new MonJeu(lc);
		Personnage p = new Personnage(14, 14, mj);
		Orc o = new Orc(13, 14, mj);
		int pvAvantAttaque = o.getPv();
		
		p.attaquer(o);
	
		assertEquals("Le personnage n'aurait pas du perdre de point de vie", o.getPv(), pvAvantAttaque-p.getDegats());
	}

	@Test
	public void testAttaqueMauvaisePorteePersonnageVsOrc() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		MonJeu mj = new MonJeu(lc);
		Personnage p = new Personnage(14, 14, mj);
		Orc o = new Orc(11, 8, mj);
		int pvAvantAttaque = o.getPv();
		
		p.attaquer(o);
	
		assertEquals("Le personnage n'aurait pas du perdre de point de vie", o.getPv(), pvAvantAttaque);
	}
}
