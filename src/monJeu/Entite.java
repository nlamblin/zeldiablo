package monJeu;

public abstract class Entite {
	protected int x,y;

	public final static int gauche = 1, haut = 2, droite = 3, bas = 4;

	public Entite(int xParam, int yParam) {
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

	public void seDeplacer(int direction) {
		switch(direction){
		case 1:
			setX(-1);
			break;

		case 2 :
			setY(-1);
			break;

		case 3 :
			setX(1);
			break;

		case 4 :
			setY(1);
			break;

		}
		
	}
	
	public String toString(){
		return(x+";"+y);
	}
}
