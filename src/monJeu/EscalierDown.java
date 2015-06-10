package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import moteurJeu.Commande;

public class EscalierDown extends Escalier implements Declencheur{
	public EscalierDown(){
		// TODO Auto-generated constructor stub
		try {
			image = ImageIO.read(new File("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/src/image/EscalierDescendre.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void afficher(int i, int j, Graphics2D g) {
		g.setColor(Color.CYAN);
		super.afficher(i, j, g);
		g.fillRect(i * DessinMonJeu.TAILLE_CASE, j * DessinMonJeu.TAILLE_CASE,i* DessinMonJeu.TAILLE_CASE,j*DessinMonJeu.TAILLE_CASE);
		if (image != null&&champ)g.drawImage(image, null, i*DessinMonJeu.TAILLE_CASE,DessinMonJeu.TAILLE_CASE* j);
	}
	
	@Override
	public void effetCase(MonJeu j) {
		// TODO Auto-generated method stub
		j.etage++;
		j.lCase = MoteurJeu.chargerLabyrinthe("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/Labyrinthe"+j.etage+".txt");
		j.lEntite = MoteurJeu.chargerMonstres("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/Monstres"+j.etage+".txt", j);
		Commande c = new Commande();
		c.droite = true;
		j.pj.seDeplacer(c);
	}

}
