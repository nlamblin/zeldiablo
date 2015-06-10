package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;

public class Talisman extends Case implements Declencheur{

	@Override
	public void afficher(int i,int j,Graphics2D g) {
		g.setColor(Color.YELLOW);
		super.afficher(i, j, g);
		g.fillRect(i * DessinMonJeu.TAILLE_CASE, j * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
	}
	@Override
	public void effetCase(MonJeu j) {
		// TODO Auto-generated method stub
		j.pj.talisman = true;
		j.lCase[j.pj.y][j.pj.x] = new CaseVide();
	}
}
