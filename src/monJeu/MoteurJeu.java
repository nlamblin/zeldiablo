package monJeu;

import java.util.ArrayList;
import java.util.Scanner;

public class MoteurJeu {
	private MonJeu jeu;
	private ArrayList<Entite> lEntite;
	private Personnage personnage;
	public MoteurJeu(){
		jeu = new MonJeu();
		lEntite = new ArrayList<Entite>();
		personnage = new Personnage(0,0);
	}
}
