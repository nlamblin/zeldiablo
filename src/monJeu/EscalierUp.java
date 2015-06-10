package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;

public class EscalierUp extends Escalier  implements Declencheur{

	@Override
	public void afficher(int i, int j, Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(i * DessinMonJeu.TAILLE_CASE, j * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
	}

	@Override
	public void effetCase(MonJeu j) {
		j.etage--;
		j.lCase = MoteurJeu.chargerLabyrinthe("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/Labyrinthe"+j.etage+".txt");
		j.lEntite = MoteurJeu.chargerMonstres("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/Monstres"+j.etage+".txt", j);
		j.pj.x = j.pj.x+1;
	}

}
