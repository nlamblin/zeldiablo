package TestZeldiablo;

import static org.junit.Assert.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import monJeu.Case;
import monJeu.CaseVide;
import monJeu.MonJeu;
import monJeu.Mur;
import monJeu.Talisman;

import org.junit.Test;

public class TestsTalisman {

	@Test
	public void testTalismanCaseVide() {
		Case [][] lc =new Case[16][16];
		for (int i = 0;i<15;i++){
			for (int j = 0;j<15;j++){
				lc [i][j] = new CaseVide();
			}
		}
		lc[14][15] = new Mur();		
		Talisman t = new Talisman();
		MonJeu mj = new MonJeu(lc);
	}

	@Ignore
	public void testSituationSurTalisman() {
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
