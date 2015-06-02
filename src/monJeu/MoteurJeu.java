package monJeu;

import java.util.ArrayList;
import java.util.Scanner;

public class MoteurJeu {
	private Jeu j;
	private ArrayList<Entite> lEntite;
	private Aventurier av;
	public MoteurJeu(){
		j = new Jeu();
		lEntite = new ArrayList<Entite>();
		av = new Aventurier(0,0);
	}
	public static void main(String[] args){
		MoteurJeu m = new MoteurJeu();
		for (int i =0;i<5;i++){
			m.continuerJeu();
		}
	}
	public void continuerJeu(){
		av.seDeplacer(demanderDirection());
		System.out.println(av.toString()+"\n");
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
