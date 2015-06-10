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
	public int etage;
	private boolean fini;
	public Personnage pj;
	public Case[][] lCase;
	public ArrayList<Entite> lEntite;
	/**
	 * constructeur de jeu avec un Personnage
	 */
	public MonJeu(Case[][] lC) {
		etage = 1;
		fini = false;
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
		if (!etreFini()){
			this.getPj().seDeplacer(commande);
			if(commande.attaque) {
				ArrayList<Entite> tmp = new ArrayList<Entite>();
				for(Entite e : lEntite) {
					getPj().attaquer(e);
					if (!e.etreMort()){
						tmp.add(e);
					}
				}
				lEntite = tmp;
			}
			getPj().changerImage(commande);
			for (Entite e : lEntite){
				evoluerEntite(e);
			}
		}
	}

	@Override
	public boolean etreFini() {
		// le jeu n'est jamais fini
		return fini;
	}
	public void evoluerEntite(Entite e){
		Commande c = e.IACommande();
		e.seDeplacer(c);
		e.changerImage(c);
		e.attaquer();
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
	public void seFinir(){
		fini = true;
	}
}
