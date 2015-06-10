package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;

public class CaseVide extends Case{

	@Override
	public void afficher(int i,int j,Graphics2D g) {
		g.setColor(Color.LIGHT_GRAY);
		super.afficher(i, j, g);
		g.fillRect(i * DessinMonJeu.TAILLE_CASE, j * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
	}

}
