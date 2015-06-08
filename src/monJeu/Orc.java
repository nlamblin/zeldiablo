package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;

public class Orc extends Monstre{

	public Orc(int xParam, int yParam,MonJeu jeu) {
		super(xParam, yParam,jeu);
		pv = 2;
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return super.toString();
	}

	@Override
	public void afficher(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillOval(x * DessinMonJeu.TAILLE_CASE, y * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
	}

}
