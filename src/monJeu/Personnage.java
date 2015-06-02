package monJeu;

import moteurJeu.Commande;

/**
 * la classe correspondant au Personnage
 */
public class Personnage extends Entite{

	/**
	 * taille de l'environnement
	 */
	final static int LIMIT_X = 15;
	final static int LIMIT_Y = 15;

	/**
	 * constructeur vide
	 */
	public Personnage(int xParam, int yParam) {
		super(xParam, yParam);
		this.x = LIMIT_X / 2;
		this.y = LIMIT_Y / 2;
	}

	/**
	 * deplacer le personnage dans une direction
	 * 
	 * @param m
	 *            la chaine permettant de deplacer le personnage (N,S, E ou O)
	 */
	public void seDeplacer(Commande c) {
		
		if (c.gauche)
		{
			this.x--;
			if (this.x < 0)
				this.x = 0;
		}

		if (c.droite)
		{
			this.x++;
			if (this.x >LIMIT_X)
				this.x = LIMIT_X;
		}
		if (c.haut)
		{	
			this.y--;
			if(this.y < 0)
				this.y = 0;
		}
		if (c.bas)
		{
			this.y++;
			if(this.y > LIMIT_X)
				this.y = LIMIT_X;
		}
	}

	public String toString() {
		return ("(" + this.x+","+this.y+")");
	}

}