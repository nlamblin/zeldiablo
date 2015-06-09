package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Activateur extends Case {
	private ArrayList<Coordonnee> aact;
	public Activateur(){
		aact = new ArrayList<Coordonnee>();
	}
	public void attacher(Coordonnee c){
		aact.add(c);
	}

	@Override
	public void afficher(int i, int j, Graphics2D g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(i * DessinMonJeu.TAILLE_CASE, j * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
	}
	public void activer(MonJeu j){
		for (Coordonnee attache : aact){
			j.lCase[attache.x][attache.y]= new CaseVide();
		}
	}

	@Override
	public void effetCase() {
		// TODO Auto-generated method stub
		
	}

}
