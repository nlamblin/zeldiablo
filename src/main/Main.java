package main;

import monJeu.DessinMonJeu;
import monJeu.MonJeu;
import monJeu.MoteurJeu;
import moteurJeu.MoteurGraphique;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier et de son afficheur
		MonJeu jeu = new MonJeu(MoteurJeu.chargerLabyrinthe("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/Labyrinthe1.txt"));
		jeu.setMonstres(MoteurJeu.chargerMonstres("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/Monstres1.txt", jeu));
		DessinMonJeu aff = new DessinMonJeu(jeu);

		// classe qui lance le moteur de jeu generique
		MoteurGraphique moteur = new MoteurGraphique(jeu, aff);
		moteur.lancerJeu(400,400);
	}

}