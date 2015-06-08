package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;

import moteurJeu.Commande;

public class Fantome extends Monstre{

	public Fantome(int xParam, int yParam,MonJeu jeu) {
		super(xParam, yParam,jeu);
		pv = 1;
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return super.toString();
	}

	@Override
	public void afficher(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillOval(x * DessinMonJeu.TAILLE_CASE, y * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
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
}