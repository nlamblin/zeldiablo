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
	private static Activateur act;
	private static ArrayList<Coordonnee> aact;
	public MoteurJeu(){
		jeu = new MonJeu(MoteurJeu.chargerLabyrinthe("../coo_zeldiablo_ferry75u_thenot5u_meurant1u_lamblin4u/Labyrinthe0.txt"));
		lEntite = new ArrayList<Entite>();
		personnage = new Personnage(0,0,jeu);
	}
	public static Case[][] chargerLabyrinthe(String fileName){
		aact = new ArrayList<Coordonnee>();
		Case[][] lC = new Case[16][16];
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			for (int i =0;i<16;i++){
				String lab =br.readLine();
				for(int j = 0;j<16;j++){
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
					case 'U':
						lC[i][j]=new EscalierUp();
						break;
					case 'D':
						lC[i][j]=new EscalierDown();
						break;
					case 'A':
						lC[i][j]=new Activateur();
						act = (Activateur) lC[i][j];
						break;
					case 'S':
						lC[i][j]=new Mur();
						aact.add(new Coordonnee(i,j));
					case 'C':
						lC[i][j]=new Cerise();
						break;
					}
				}
			}
			if (act != null){
				for (Coordonnee a: aact){
					act.attacher(a);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lC;
	}
	public static ArrayList<Entite> chargerMonstres(String fileName,MonJeu jeu){
		ArrayList<Entite> le = new ArrayList<Entite>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			for (int i =0;i<16;i++){
				String lab =br.readLine();
				for(int j = 0;j<16;j++){
					switch (lab.charAt(j)){
					case 'F':
						Fantome f = new Fantome(j,i, jeu);
						le.add(f);
						break;
					case 'O':
						Orc o = new Orc(j,i, jeu);
						le.add(o);
						break;
					}
				}
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return le;
	}
}
