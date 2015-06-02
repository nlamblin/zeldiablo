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
	public static void main(String[] args){
		MoteurJeu m = new MoteurJeu();
		for (int i =0;i<5;i++){
			m.continuerJeu();
		}
	}
	public void continuerJeu(){
		personnage.seDeplacer(demanderDirection());
		System.out.println(personnage.toString()+"\n");
		for (Entite e : lEntite){
			e.seDeplacer((int)(Math.random()*4+1));
			System.out.println(e.toString()+"\n");
		}
	}
	public int demanderDirection(){
		System.out.println("Entrez la direction");
		Scanner sc = new Scanner(System.in);
		switch (sc.nextLine()){
		case "z":
			return Entite.haut;
		case "q":
			return Entite.gauche;
		case "s": 
			return Entite.bas;
		case "d":
			return Entite.droite;
		default:
			return -1;
		}
	}
}
