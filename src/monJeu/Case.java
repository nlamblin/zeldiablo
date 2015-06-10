package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Case {

	public boolean champ=false;
	public void afficher(int i,int j,Graphics2D g){
		if (!champ){
			g.setColor(Color.BLACK);
		}
	}
	public boolean etreTraversable() {
		return true;
	}

}
