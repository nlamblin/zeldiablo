package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;

public class EscalierUp extends Escalier {

	@Override
	public void afficher(int i, int j, Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(i * DessinMonJeu.TAILLE_CASE, j * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
	}

}
