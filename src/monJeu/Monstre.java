package monJeu;

import java.awt.Graphics2D;

public abstract class Monstre extends Entite{

	public Monstre(int xParam, int yParam,MonJeu jeu) {
		super(xParam, yParam,jeu);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return super.toString();
	}
	
	public void attaquer() {
		switch(orientation) {
		case Entite.haut:
			if(this.x == j.pj.getX() && this.y-1 == j.pj.getY()){
				j.pj.subirDegats(this.getDegats());
				etatAttaque = true;
			}
			else etatAttaque = false;
			break;
		case Entite.bas:
			if(this.x == j.pj.getX() && this.y+1 == j.pj.getY()) {
				j.pj.subirDegats(this.getDegats());
				etatAttaque = true;
			}
			else etatAttaque = false;
			break;
		case Entite.gauche:
			if(this.x-1 == j.pj.getX() && this.y == j.pj.getY()) {
				j.pj.subirDegats(this.getDegats());
				etatAttaque = true;
			}
			else etatAttaque = false;
			break;
		case Entite.droite:
			if(this.x+1 == j.pj.getX() && this.y == j.pj.getY()) {
				j.pj.subirDegats(this.getDegats());
				etatAttaque = true;
			}
			else etatAttaque = false;
			break;
		}
	}
	
	public void afficher(Graphics2D g) {
		super.afficher(g);
	}
}
