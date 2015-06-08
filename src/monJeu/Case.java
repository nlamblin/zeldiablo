package monJeu;

import java.awt.Graphics2D;

public interface Case {
	public boolean etreTraversable();
	public void afficher(int i,int j,Graphics2D g);
}
