package gestUtils;
import java.awt.EventQueue;

import gestUtils.controllers.UtilisateurController;
import gestUtils.views.ConnexionForm;

/**
 * Classe de lancement de l'application
 * 
 * @author Administrateur
 *
 */
public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			// instanciation et affichage du formulaire de recherche
			ConnexionForm frame = new ConnexionForm();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
