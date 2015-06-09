package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;

public class Entree extends Case{

	@Override
	public void afficher(int i,int j,Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillRect(i * DessinMonJeu.TAILLE_CASE, j * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
	}
	@Override
	public void effetCase() {
		// TODO Auto-generated method stub
		
	}
}
