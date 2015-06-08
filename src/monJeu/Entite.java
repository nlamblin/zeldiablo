package monJeu;

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
	final static int LIMIT_X = 15;
	final static int LIMIT_Y = 15;
	public final static int gauche = 0, haut = 1, droite = 2, bas = 3;
	protected MonJeu j;
	protected BufferedImage image;
	protected BufferedImage imageHaut;
	protected BufferedImage imageBas;
	protected BufferedImage imageGauche;
	protected BufferedImage imageDroite;
	public Entite(int xParam, int yParam,MonJeu jeu) {
		j = jeu;
		x = xParam;
		y = yParam;
	}
	public void changerImage(Commande c){
		if (c.bas){
			image = imageBas;
		}
		if (c.haut){
			image = imageHaut;
		}
		if (c.gauche){
			image = imageGauche;
		}
		if (c.droite){
			image = imageDroite;
		}
	}
	public int getX(){
		return this.x;
	}

	public  int getY(){
		return this.y;
	}

	public void setX(int x1){
		this.x += x1;

	}

	public void setY(int y1){
		this.y += y1;
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
	public abstract void afficher(Graphics2D g);
	public boolean etreMort(){
		return pv <=0;
	}
}
