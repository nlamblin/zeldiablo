package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Activateur extends Case  implements Declencheur{
	private ArrayList<Coordonnee> aact;
	public Activateur(){
		try {
			image = ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/Sol.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aact = new ArrayList<Coordonnee>();
	}
	public void attacher(Coordonnee c){
		aact.add(c);
	}

	@Override
	public void afficher(int i, int j, Graphics2D g) {
		g.setColor(Color.LIGHT_GRAY);
		super.afficher(i, j, g);
		g.fillRect(i * DessinMonJeu.TAILLE_CASE, j * DessinMonJeu.TAILLE_CASE, DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE);
		if (image != null&&champ)g.drawImage(image, null, i*DessinMonJeu.TAILLE_CASE, j*DessinMonJeu.TAILLE_CASE);
	}


	@Override
	public void effetCase(MonJeu j) {
		for (Coordonnee attache : aact){
			j.lCase[attache.x][attache.y]= new CaseVide();
		}
	}

}
