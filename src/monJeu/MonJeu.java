package monJeu;

import java.util.ArrayList;

import moteurJeu.Commande;
import moteurJeu.Jeu;

/**
 * classe qui contient les donnees du jeu. Pour le moment, il ne possede qu'un
 * personnage
 *
 */
public class MonJeu implements Jeu {

	/**
	 * le personnage du jeu
	 */
	public Personnage pj;
	public Case[][] lCase;
	public ArrayList<Entite> lEntite;
	/**
	 * constructeur de jeu avec un Personnage
	 */
	public MonJeu(Case[][] lC) {
		lEntite = new ArrayList<Entite>();
		lCase = lC;
		int i = 0;
		int j = 0;
		boolean trouv = false;
		for(i = 0,j=0;i<lC.length&&!trouv;i++){
			for (j = 0;j< lC.length&&!trouv;j++){
				if (lC[i][j] instanceof Entree){
					trouv = true;
				}
			}
		}
		this.pj=new Personnage(j-1,i-1,this);
	}

	/**
	 * surcharge toString
	 */
	public String toString() {
		return ("" + this.getPj());
	}

	/**
	 * demande a deplacer le personnage
	 * 
	 * @param commande
	 *            chaine qui donne ordre
	 */
	public void evoluer(Commande commande) {
		this.getPj().seDeplacer(commande);
		getPj().changerImage(commande);
		try{
			Thread.sleep(100);
		}
		catch(Exception e){}
		for (Entite e : lEntite){
			evoluerEntite(e);
		}
	}

	@Override
	public boolean etreFini() {
		// le jeu n'est jamais fini
		return false;
	}
	public void evoluerEntite(Entite e){
		Commande c = new Commande();
		int deplacement=-1;
		
		if (e.x < pj.x+3 && e.x > pj.x-3 && e.y < pj.y+3 && e.y > pj.y -3){
			if(e.x >= pj.x && e.y >= pj.y){
				if (e.x-pj.x >= e.y-pj.y)deplacement = Entite.gauche;
				else deplacement = Entite.haut;
			}
			if (e.x >= pj.x && e.y < pj.y){
				if (e.x-pj.x > pj.y-e.y)deplacement = Entite.gauche;
				else deplacement = Entite.bas;
			}
			if (e.x < pj.x && e.y >= pj.y){
				if (pj.x-e.x > e.y-pj.y)deplacement = Entite.droite;
				else deplacement = Entite.haut;
			}
			if (e.x < pj.x && e.y < pj.y){
				if (pj.x-e.x > pj.y-e.y)deplacement = Entite.droite;
				else deplacement = Entite.bas;
			}
		}
		else{
			deplacement = (int)(Math.random()*10);
		}
		switch (deplacement){
		case Entite.gauche:
			c.gauche = true;
			break;
		case Entite.droite:
			c.droite = true;
			break;
		case Entite.haut:
			c.haut = true;
			break;
		case Entite.bas:
			c.bas = true;
			break;
		}
		e.seDeplacer(c);
		e.changerImage(c);
	}
	/**
	 * getter pour l'affichage
	 * 
	 * @return personnage du jeu
	 */
	public Personnage getPj() {
		return pj;
	}
	public void setMonstres(ArrayList<Entite> le){
		lEntite = le;
	}
}
