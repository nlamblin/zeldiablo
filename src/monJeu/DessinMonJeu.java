package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

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
	private static int TAILLE_CASE = 25;

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
			crayon.setColor(Color.blue);
			crayon.fillOval(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
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
		for (int i = 0;i < 15;i++){
			for (int j = 0;j < 15;j++){
				if (cases[j][i] instanceof CaseVide){
					crayon.setColor(Color.LIGHT_GRAY);
					System.out.print("O ");
				}
				else if(cases[j][i] instanceof Mur){
					crayon.setColor(Color.DARK_GRAY);
					System.out.print("M ");
				}
				else if(cases[j][i] instanceof Entree){
					crayon.setColor(Color.GREEN);
					System.out.print("E ");
				}
				else if(cases[j][i] instanceof Talisman){
					crayon.setColor(Color.RED);
					System.out.print("T ");
				}
				crayon.fillRect(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE,TAILLE_CASE);
			}
		}
	}
	/**
	 * methode dessiner redefinie de Afficheur retourne une image du jeu
	 */
	public void dessiner(BufferedImage im) {
		// no sait que c'est un jeuTest
		MonJeu j = (MonJeu) jeu;
		dessinerCases(j.lCase,im);
		Personnage pj = j.getPj();
		this.dessinerObjet("PJ", pj.x, pj.y, im);
	}

}