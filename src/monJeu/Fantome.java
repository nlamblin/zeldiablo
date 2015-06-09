package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import moteurJeu.Commande;

public class Fantome extends Monstre{

	public Fantome(int xParam, int yParam,MonJeu jeu) {
		super(xParam, yParam,jeu);
		pv = 1;
		try {
			imageHaut=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/FantomeHaut.png"));
			imageBas=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/FantomeBas.png"));
			imageGauche=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/FantomeGauche.png"));
			imageDroite=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/FantomeDroite.png"));
			image = imageDroite;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
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
	public void seDeplacer(Commande c) {
		
		if (c.gauche){
			if (this.x > 0){
				boolean Ent = false;
				if (j.pj.x == x-1 && j.pj.y== y){
					Ent = true;
				}
				for (Entite e: j.lEntite){
					if (this.x-1==e.x && this.y == e.y){
						Ent = true;
					}
				}
				if (!Ent){
					this.x--;
					if (this.x < 0)
						this.x = 0;
				}
			}
		}

		if (c.droite)
		{
			if (this.x <LIMIT_X){
				
				boolean Ent = false;
				if (j.pj.x == x+1 && j.pj.y== y){
					Ent = true;
				}
				for (Entite e: j.lEntite){
					if (this.x+1==e.x && this.y == e.y){
						Ent = true;
					}
				}
				if (!Ent){
					this.x++;
					if (this.x >LIMIT_X)
						this.x = LIMIT_X;
				}
			}
		}
		if (c.haut)
		{	
			if(this.y > 0){
				boolean Ent = false;
				if (j.pj.x == x && j.pj.y== y-1){
					Ent = true;
				}
				for (Entite e: j.lEntite){
					if (this.x==e.x && this.y-1 == e.y){
						Ent = true;
					}
				}
				if (!Ent){
					this.y--;
					if(this.y < 0)
						this.y = 0;
				}
				
			}
		}
		if (c.bas)
		{
			if(this.y < LIMIT_X){
				boolean Ent = false;
				if (j.pj.x == x && j.pj.y== y+1){
					Ent = true;
				}
				for (Entite e: j.lEntite){
					if (this.x==e.x && this.y+1 == e.y){
						Ent = true;
					}
				}
				if (!Ent){
					this.y++;
					if(this.y > LIMIT_X)
						this.y = LIMIT_X;
				}
				
			}
		}
	}

	@Override
	public Commande IACommande() {
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
		return pv =5;
	}
	
	public int getDegats(){
		return degats=1;
	}
	
	public void attaquer(){
		// TODO 
	}
	
	public void subirDegats(int i){
		// TODO
	}
	
}