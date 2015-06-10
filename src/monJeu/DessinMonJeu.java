package monJeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import moteurJeu.DessinJeu;

/**
 * un afficheur graphique associe au JeuTest fourni
 * 
 * @author vthomas
 */
public class DessinMonJeu implements DessinJeu {

	/**
	 * constante pour gerer la taille des cases
	 */
	public static int TAILLE_CASE = 25;

	/**
	 * lien vers le jeu a afficher
	 */
	private MonJeu jeu;

	/**
	 * appelle constructeur parent
	 * 
	 * @param j
	 *            le jeutest a afficher
	 */
	public DessinMonJeu(MonJeu j) {
		this.jeu = j;
	}

	/**
	 * dessiner un objet consiste a dessiner sur l'image suivante methode
	 * redefinie de Afficheur
	 */
	private void dessinerObjet(String s, int x, int y, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		switch (s) {
		case "PJ":
			jeu.pj.afficher(crayon);
			break;
		case "MUR":
			crayon.setColor(Color.gray);
			crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		default:
			throw new AssertionError("objet inexistant");
		}
	}
	private void dessinerCases(Case[][] cases,BufferedImage im){
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		for (int i = 0;i < 16;i++){
			for (int j = 0;j < 16;j++){
				cases[i][j].afficher(j, i, crayon);
			}
		}
	}
	private void dessinerEntite(ArrayList<Entite> le,BufferedImage im){
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		for (Entite e : le){
			e.afficher(crayon);
		}
	}
	private void dessinerFin(BufferedImage im){
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		if(jeu.pj.etreMort()){
			crayon.setFont(new Font(Font.SERIF,Font.PLAIN,80));
			crayon.setColor(Color.RED);
			crayon.drawString("Game over !",0,200);
		}
		else {
			crayon.setFont(new Font(Font.SERIF,Font.PLAIN,100));
			crayon.setColor(Color.GREEN);
			crayon.drawString("You win !",0,200);
		}
	}
	/**
	 * methode dessiner redefinie de Afficheur retourne une image du jeu
	 */
	public void dessiner(BufferedImage im) {
		// no sait que c'est un jeuTest
		MonJeu j = (MonJeu) jeu;
		dessinerCases(j.lCase,im);
		dessinerEntite(j.lEntite,im);
		Personnage pj = j.getPj();
		this.dessinerObjet("PJ", pj.x, pj.y, im);
		if (jeu.etreFini()){
			dessinerFin(im);
		}
	}

}