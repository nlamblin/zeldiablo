package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Orc extends Monstre{

	public Orc(int xParam, int yParam,MonJeu jeu) {
		super(xParam, yParam,jeu);
		pv = 2;
		try {
			imageHaut=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/OrcHaut.png"));
			imageBas=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/OrcBas.png"));
			imageGauche=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/OrcGauche.png"));
			imageDroite=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/OrcDroite.png"));
			image = imageDroite;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return super.toString();
	}

	@Override
	public void afficher(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		if (image ==null)g.fillOval(x * DessinMonJeu.TAILLE_CASE, y * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
		else g.drawImage(image, null, x * DessinMonJeu.TAILLE_CASE, y * DessinMonJeu.TAILLE_CASE);
	}


}
