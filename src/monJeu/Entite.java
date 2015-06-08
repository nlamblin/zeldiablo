package monJeu;

import moteurJeu.Commande;

public abstract class Entite {
	protected int x,y;
	final static int LIMIT_X = 14;
	final static int LIMIT_Y = 14;
	public final static int gauche = 1, haut = 2, droite = 3, bas = 4;
	private MonJeu j;
	
	public Entite(int xParam, int yParam,MonJeu jeu) {
		j = jeu;
		x = xParam;
		y = yParam;
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
				this.x--;
				if (this.x < 0)
					this.x = 0;
			}
		}

		if (c.droite)
		{
			if (this.x <LIMIT_X)
			if (j.lCase[y][x+1].etreTraversable()){
				this.x++;
				if (this.x >LIMIT_X)
					this.x = LIMIT_X;
			}
		}
		if (c.haut)
		{	
			if(this.y > 0)
			if (j.lCase[y-1][x].etreTraversable()){
				this.y--;
				if(this.y < 0)
					this.y = 0;
				}
		}
		if (c.bas)
		{
			if(this.y < LIMIT_X)
			if (j.lCase[y+1][x].etreTraversable()){
				this.y++;
				if(this.y > LIMIT_X)
					this.y = LIMIT_X;
			}
		}
	}
	
	public String toString(){
		return(x+";"+y);
	}
}
