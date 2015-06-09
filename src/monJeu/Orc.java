package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import moteurJeu.Commande;

public class Orc extends Monstre{

	public Orc(int xParam, int yParam,MonJeu jeu) {
		super(xParam, yParam,jeu);
		pv = 5;
		pvMax = 5;
		try {
			imageHaut=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/OrcHaut.png"));
			imageBas=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/OrcBas.png"));
			imageGauche=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/OrcGauche.png"));
			imageDroite=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/OrcDroite.png"));
			image = imageDroite;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return super.toString();
	}

	@Override
	public void afficher(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		if (image ==null)g.fillOval(x * DessinMonJeu.TAILLE_CASE, y * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
		else g.drawImage(image, null, x * DessinMonJeu.TAILLE_CASE, y * DessinMonJeu.TAILLE_CASE);
	}
	@Override
	public Commande IACommande(){
		Commande c = new Commande();
		int deplacement=-1;
		if (x < j.pj.x+3 && x > j.pj.x-3 && y < j.pj.y+3 && y > j.pj.y -3){
			if(x >= j.pj.x && y >= j.pj.y){
				if (x-j.pj.x >= y-j.pj.y)deplacement = Entite.gauche;
				else deplacement = Entite.haut;
			}
			if (x >= j.pj.x && y < j.pj.y){
				if (x-j.pj.x > j.pj.y-y)deplacement = Entite.gauche;
				else deplacement = Entite.bas;
			}
			if (x < j.pj.x && y >= j.pj.y){
				if (j.pj.x-x > y-j.pj.y)deplacement = Entite.droite;
				else deplacement = Entite.haut;
			}
			if (x < j.pj.x && y < j.pj.y){
				if (j.pj.x-x > j.pj.y-y)deplacement = Entite.droite;
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
		return c;
	}
	
	public int getPv(){
		return pv;
	}
	
	public int getDegats(){
		return degats;
	}
	public void attaquer(){
		super.attaquer();
	}
	
}
