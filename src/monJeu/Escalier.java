package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Escalier extends Case {
	
	@Override
	public boolean etreTraversable() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void afficher(int i, int j, Graphics2D g) {
		super.afficher(i, j, g);
		g.fillRect(i * DessinMonJeu.TAILLE_CASE, j * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
	}
}
