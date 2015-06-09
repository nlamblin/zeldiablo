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
		if ((this.x == j.pj.x+1 || this.x == j.pj.x-1) && (this.y == j.pj.y+1 || this.y == j.pj.y-1)){
			j.pj.subirDegats(this.getDegats());
		}
	}
}
