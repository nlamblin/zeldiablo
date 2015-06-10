package monJeu;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.prism.Graphics;


public class Cerise extends Case implements Declencheur {
	
	private BufferedImage image;
	
	public Cerise() {
		try {
			image=ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/CERISE.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void effetCase(MonJeu j) {
		// TODO Auto-generated method stub
		
	}
	
	public void afficher(Graphics g) {
		
	}

}
