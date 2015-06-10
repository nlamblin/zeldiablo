package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mur extends Case{
	public Mur(){
		try {
			image = ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/MUR.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean etreTraversable() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void afficher(int i,int j,Graphics2D g) {
		g.setColor(Color.DARK_GRAY);
		super.afficher(i, j, g);
		g.fillRect(i * DessinMonJeu.TAILLE_CASE, j * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
		if (image != null&&champ)g.drawImage(image, null, i*DessinMonJeu.TAILLE_CASE, j*DessinMonJeu.TAILLE_CASE);
		
	}
}
