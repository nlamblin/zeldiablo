package monJeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;

import javax.imageio.ImageIO;

/**
 * la classe correspondant au Personnage
 */
public class Personnage extends Entite{
	/**
	 * constructeur vide
	 */
	public Personnage(int xParam, int yParam,MonJeu jeu) {
		super(xParam, yParam,jeu);
		try {
			attacherImage(ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/PersoBas.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pv = 10;
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

	@Override
	public void afficher(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		if (image ==null)g.fillOval(x * DessinMonJeu.TAILLE_CASE, y * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
		else g.drawImage(image, null, x * DessinMonJeu.TAILLE_CASE, y * DessinMonJeu.TAILLE_CASE);
	}
}
