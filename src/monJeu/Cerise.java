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
		j.lCase[j.pj.y][j.pj.x]= new CaseVide();
		if (j.pj.pv+10 > j.pj.pvMax)j.pj.pv=j.pj.pvMax;
		else j.pj.pv+=10;
	}
	
	public void afficher(int i, int j, Graphics2D g) {
		g.setColor(Color.DARK_GRAY);
		super.afficher(i, j, g);
		g.fillRect(i * DessinMonJeu.TAILLE_CASE, j * DessinMonJeu.TAILLE_CASE,i* DessinMonJeu.TAILLE_CASE,j*DessinMonJeu.TAILLE_CASE);
		if (image != null&&champ)g.drawImage(image, null, i*DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE* j);
	}

}
