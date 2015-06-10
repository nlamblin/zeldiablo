package monJeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;

import javafx.geometry.Orientation;

import javax.imageio.ImageIO;

import moteurJeu.Commande;

/**
 * la classe correspondant au Personnage
 */
public class Personnage extends Entite{
	private boolean talisman;
	private int etage = 0;
	/**
	 * constructeur vide
	 */
	public Personnage(int xParam, int yParam,MonJeu jeu) {
		super(xParam, yParam,jeu);
		talisman = false;
		
		try {
			orientation = Entite.bas;
			imageGauche=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/PersoGauche.png"));
			imageHaut=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/PersoHaut.png"));
			imageDroite=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/PersoDroite.png"));
			imageBas=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/PersoBas.png"));
			imageHautAtt=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/PersoHautAtt.png"));
			imageBasAtt=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/PersoBasAtt.png"));
			imageGaucheAtt=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/PersoGaucheAtt.png"));
			imageDroiteAtt=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/PersoDroiteAtt.png"));
			image = imageBas;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pv = 10;
		pvMax = 10;
		degats=2;
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
		super.afficher(g);
		if (image ==null)g.fillOval(x * DessinMonJeu.TAILLE_CASE, y * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
		else g.drawImage(image, null, x * DessinMonJeu.TAILLE_CASE, y * DessinMonJeu.TAILLE_CASE);
		if (talisman){
			g.setColor(Color.BLUE);
			g.fillOval(x * DessinMonJeu.TAILLE_CASE, y * DessinMonJeu.TAILLE_CASE-5,5,5);
		}
	}
	@Override
	public void seDeplacer(Commande c){
		if (!etreMort()){
			super.seDeplacer(c);
			if (j.lCase[y][x] instanceof Talisman){
				talisman = true;
				j.lCase[y][x] = new CaseVide();
			}
			if (j.lCase[y][x] instanceof Entree && talisman){
				j.seFinir();
			}
			if (j.lCase[y][x] instanceof EscalierDown){
				etage++;
				j.lCase = MoteurJeu.chargerLabyrinthe("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/Labyrinthe"+etage+".txt");
				j.lEntite = MoteurJeu.chargerMonstres("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/Monstres"+etage+".txt", j);
				this.x = this.x+1;
			}
			if (j.lCase[y][x] instanceof EscalierUp){
				etage--;
				j.lCase = MoteurJeu.chargerLabyrinthe("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/Labyrinthe"+etage+".txt");
				j.lEntite = MoteurJeu.chargerMonstres("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/Monstres"+etage+".txt", j);
				this.x = this.x+1;
			}
			if (j.lCase[y][x] instanceof Activateur){
				((Activateur)j.lCase[y][x]).activer(j);
			}
		}
		else j.seFinir();
	}

	@Override
	public Commande IACommande() {
		// TODO Auto-generated method stub
		return new Commande();
	}

	public boolean getTalisman() {
		return talisman;
	}

	public int getPv(){
		return pv;
	}
	
	public int getDegats(){
		return degats;
	}
	
	public void attaquer(Entite e){
		if(!etreMort()) {
			switch(orientation) {
			case Entite.haut:
				if(this.x == e.getX() && this.y-1 == e.getY()) {
					e.subirDegats(this.getDegats());
				}
					break;
			case Entite.bas:
				if(this.x == e.getX() && this.y+1 == e.getY()) {
					e.subirDegats(this.getDegats());
				}
				break;
			case Entite.gauche:
				if(this.x-1 == e.getX() && this.y == e.getY()) {
					e.subirDegats(this.getDegats());
				}
				break;
			case Entite.droite:
				if(this.x+1 == e.getX() && this.y == e.getY()) {
					e.subirDegats(this.getDegats());
				}
				break;
			}
		}
	}

	@Override
	public void attaquer() {
		// TODO Auto-generated method stub
		
	}
	
}
