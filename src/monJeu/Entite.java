package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import moteurJeu.Commande;

public abstract class Entite {
	protected int x,y;
	protected int pv;
	protected int pvMax;
	protected int degats;
	final static int LIMIT_X = 15;
	final static int LIMIT_Y = 15;
	public final static int gauche = 0, haut = 1, droite = 2, bas = 3;
	protected MonJeu j;
	protected BufferedImage image;
	protected BufferedImage imageHaut;
	protected BufferedImage imageBas;
	protected BufferedImage imageGauche;
	protected BufferedImage imageDroite;
	protected BufferedImage imageHautAtt;
	protected BufferedImage imageBasAtt;
	protected BufferedImage imageGaucheAtt;
	protected BufferedImage imageDroiteAtt;
	protected int orientation;
	protected boolean etatAttaque;
	
	public Entite(int xParam, int yParam,MonJeu jeu) {
		j = jeu;
		x = xParam;
		y = yParam;
		etatAttaque = false;
	}
	
	public void changerImage(Commande c){
		if (c.bas){
			if(etatAttaque) image = imageBasAtt;
			else image = imageBas;
			orientation = Entite.bas;
		}
		if (c.haut){
			if(etatAttaque) image = imageHautAtt;
			else image = imageHaut;
			orientation = Entite.haut;
		}
		if (c.gauche){
			if(etatAttaque) image = imageGaucheAtt;
			else image = imageGauche;
			orientation = Entite.gauche;
		}
		if (c.droite){
			if(etatAttaque) image = imageDroiteAtt;
			else image = imageDroite;
			orientation = Entite.droite;
		}
	}
	public int getX(){
		return this.x;
	}

	public  int getY(){
		return this.y;
	}

	public int getPv(){
		return this.pv;
	}

	public  int getDegats(){
		return this.degats;
	}

	public void setDegats(int deg){
		this.degats = deg;
	}

	public void setPv(int pv1){
		this.pv = pv1;
	}
	
	public void subirDegats(int i){
		if(!etreMort()){
			this.setPv(this.getPv()-i);
		}
	}

	public void seDeplacer(Commande c) {
		
		if (c.gauche){
			if (this.x > 0)
			if (j.lCase[y][x-1].etreTraversable()){
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
			if (this.x <LIMIT_X)
			if (j.lCase[y][x+1].etreTraversable()){
				
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
			if(this.y > 0)
			if (j.lCase[y-1][x].etreTraversable()){
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
			if(this.y < LIMIT_X)
			if (j.lCase[y+1][x].etreTraversable()){
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
	
	public String toString(){
		return(x+";"+y);
	}
	public abstract Commande IACommande();
	public void afficher(Graphics2D g){
		if (pv>=0)g.setColor(new Color((int)((1-(double)pv/(double)pvMax)*255.0),(int)(((double)pv/(double)pvMax)*255.0),0));
		else g.setColor(Color.RED);
		g.fillRect(x * DessinMonJeu.TAILLE_CASE, y * DessinMonJeu.TAILLE_CASE,2,(int)(DessinMonJeu.TAILLE_CASE*(double)pv/(double)pvMax));
	}
	public boolean etreMort(){
		return pv <=0;
	}
	public abstract void attaquer();
}
