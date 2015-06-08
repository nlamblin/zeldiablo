package monJeu;

import moteurJeu.Commande;

/**
 * la classe correspondant au Personnage
 */
public class Personnage extends Entite{

	/**
	 * taille de l'environnement
	 */
	

	/**
	 * constructeur vide
	 */
	public Personnage(int xParam, int yParam,MonJeu jeu) {
		super(xParam, yParam,jeu);
		
	}

	/**
	 * deplacer le personnage dans une direction
	 * 
	 * @param m
	 *            la chaine permettant de deplacer le personnage (N,S, E ou O)
	 */
	
	
	public static int getLimitX() {
		return LIMIT_X;
	}

	public static int getLimitY() {
		return LIMIT_Y;
	}

	public String toString() {
		return ("(" + this.x+","+this.y+")");
	}

}
