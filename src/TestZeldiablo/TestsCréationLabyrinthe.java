package TestZeldiablo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import jdk.nashorn.internal.ir.annotations.Ignore;
import monJeu.Case;
import monJeu.MonJeu;
import monJeu.MoteurJeu;
import monJeu.Personnage;

import org.junit.Test;

public class TestsCréationLabyrinthe {

	@Test
	public void testTailleLabyrinthe() {
		assertEquals("le personnage devrait être de 14,14",14, Personnage.getLimitX());
		assertEquals("le personnage devrait être de 14,14",14, Personnage.getLimitY());

		
}
	
	@Test
	public void testPositionPersonnage() {
		Personnage hero = new Personnage(8,8,new MonJeu(new Case[15][15]));
		assertEquals("le personnage devrait être placé en position 8,8",8,hero.getX());
		assertEquals("le personnage devrait être placé en position 8,8",8,hero.getY());

	}
	
	@Ignore
	public void testMonstreCaseVide() {
		fail("Not yet implemented");
	}
	


}
