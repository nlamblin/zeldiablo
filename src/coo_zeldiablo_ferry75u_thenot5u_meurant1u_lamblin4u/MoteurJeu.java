package coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u;

import java.util.ArrayList;
import java.util.Scanner;

public class MoteurJeu {
	private Jeu j;
	private ArrayList<Entite> lEntite;
	private Aventurier av;
	public MoteurJeu(){
		j = new Jeu();
		lEntite = new ArrayList<Entite>();
		av = new Aventurier();
	}
	public static void main(String[] args){
		MoteurJeu m = new MoteurJeu();
		for (int i =0;i<5;i++){
			m.continuerJeu();
		}
	}
	public void continuerJeu(){
		
	}
	public int demanderDirection(){
		Scanner sc = new Scanner(System.in);
		switch (sc.nextLine()){
		case "z":
			return ;
		case "q":
			return;
		case "s": 
			return;
		case "d":
			return;
		default:
			return -1;
		}
	}
}
