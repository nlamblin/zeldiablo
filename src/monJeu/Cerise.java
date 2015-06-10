package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.prism.Graphics;


public class Cerise extends Case implements Declencheur {
	
	public Cerise() {
		try {
			image=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/CERISE.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public boolean etreTraversable() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void effetCase(MonJeu j) {
		// TODO Auto-generated method stub
		j.pj.setPv(j.pj.getPv()+10);
	}
	
	public void afficher(int i, int j, Graphics2D g) {
		g.setColor(Color.DARK_GRAY);
		super.afficher(i, j, g);
		if (image != null)g.drawImage(image, null, i, j);
		else g.fillRect(i * DessinMonJeu.TAILLE_CASE, j * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
	}

}
