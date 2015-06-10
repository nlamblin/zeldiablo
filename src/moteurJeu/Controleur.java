package moteurJeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.sun.xml.internal.ws.api.pipe.ServerPipeAssemblerContext;

/**
 * classe qui represente un controleur en lien avec un KeyListener
 * 
 * @author vthomas
 * 
 */
public class Controleur implements KeyListener {

	/**
	 * commande en cours
	 */
	private Commande commandeEnCours;
	/**
	 * commande a retourner la difference avec la commandeencours vient du fait
	 * qu'on veut memoriser une touche appuyee
	 */
	private  Commande commandeARetourner;

	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */
	public Controleur() {
		this.commandeEnCours = new Commande();
	}

	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Commande getCommande() {
		return this.commandeEnCours;
	}

	@Override
	/**
	 * met a jour les commandes en fonctions des touches appuyees
	 */
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyChar()) {
		// si on appuie sur 'q',commande joueur est gauche
		case 'q':
			this.commandeEnCours.gauche = true;
			break;
		// si on appuie sur 'd',commande joueur est droite
		case 'd':
			this.commandeEnCours.droite = true;
			break;
		// si on appuie sur 'z',commande joueur est haut
		case 'z':
			this.commandeEnCours.haut = true;
			break;
		// si on appuie sur 's',commande joueur est bas
		case 's':
			this.commandeEnCours.bas = true;
			break;
		}
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_SPACE :
			this.commandeEnCours.attaque = true;
		}

	}

	@Override
	/**
	 * met a jour les commandes quand le joueur relache une touche
	 */
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'q':
			this.commandeEnCours.gauche = false;
			break;
		case 'd':
			this.commandeEnCours.droite = false;
			break;
		case 'z':
			this.commandeEnCours.haut = false;
			break;
		case 's':
			this.commandeEnCours.bas = false;
			break;
		}
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_SPACE :
			this.commandeEnCours.attaque = false;
		}

	}

	@Override
	/**
	 * ne fait rien
	 */
	public void keyTyped(KeyEvent e) {

	}

}