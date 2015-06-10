package monJeu;

import java.awt.Graphics2D;

public abstract class Case {

	
	public abstract void afficher(int i,int j,Graphics2D g);
	public boolean etreTraversable() {
		return true;
	}

}
