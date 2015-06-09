package monJeu;

public abstract class Monstre extends Entite{

	public Monstre(int xParam, int yParam,MonJeu jeu) {
		super(xParam, yParam,jeu);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return super.toString();
	}
	
	public void attaquer(){
		switch(orientation) {
		case Entite.haut:
			if(this.x == j.pj.getX() && this.y == j.pj.getY()-1)
				j.pj.subirDegats(this.getDegats());
			break;
		case Entite.bas:
			if(this.x == j.pj.getX() && this.y == j.pj.getY()+1)
				j.pj.subirDegats(this.getDegats());
			break;
		case Entite.gauche:
			if(this.x == j.pj.getX()-1 && this.y == j.pj.getY())
				j.pj.subirDegats(this.getDegats());
			break;
		case Entite.droite:
			if(this.x == j.pj.getX()+1 && this.y == j.pj.getY())
				j.pj.subirDegats(this.getDegats());
			break;
		}
	}
}
