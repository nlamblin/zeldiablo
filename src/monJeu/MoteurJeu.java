package monJeu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MoteurJeu {
	private MonJeu jeu;
	private ArrayList<Entite> lEntite;
	private Case[][] lCases;
	private Personnage personnage;
	
	public MoteurJeu(){
		jeu = new MonJeu(MoteurJeu.chargerLabyrinthe("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/Labyrinthe0.txt"));
		lEntite = new ArrayList<Entite>();
		personnage = new Personnage(0,0);
	}
	public static Case[][] chargerLabyrinthe(String fileName){
		Case[][] lC = new Case[15][15];
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			for (int i =0;i<15;i++){
				String lab =br.readLine();
				for(int j = 0;j<15;j++){
					switch (lab.charAt(j)){
					case 'M':
						lC[i][j]=new Mur();
						break;
					case 'O':
						lC[i][j]=new CaseVide();
						break;
					case 'E':
						lC[i][j]=new Entree();
						break;
					case 'T':
						lC[i][j]=new Talisman();
						break;
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lC;
	}
}
