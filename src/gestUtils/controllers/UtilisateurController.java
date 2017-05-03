package gestUtils.controllers;

import java.util.List;

import gestUtils.metier.Utilisateur;
import gestUtils.models.dataAccess.UtilisateurDAO;

/**
 * Contrôleur des fonctionnalités liées aux utilisateurs
 * Opère le lien entre l'interface graphique et les modèles
 * 
 * @author Administrateur
 *
 */
public class UtilisateurController {
	// l'objet qui donne accès aux données des utilisateurs dans la BdD
	private UtilisateurDAO dao ;

	/**
	 * constructeur
	 */
	public UtilisateurController() {
		super();
		dao = new UtilisateurDAO();
	}

	/**
	 * @return the dao
	 */
	public UtilisateurDAO getDao() {
		return dao;
	}
	

	/**
	 * Renvoie la liste des utilisateurs qui correspondent à un filtre de 
	 * recherche portant sur le nom
	 * 
	 * @param nomUtilisateur : le motif à rechercher dans le nom de l'utilisateur
	 * @return une liste d'utilisateurs dont le nom contient le paramètre fournit 
	 */
	public List<Utilisateur> findByNom(String filtreNom) {

		return dao.findByNom(filtreNom + "%");
	}
	
	/**
	 * Renvoie l'utilisateur qui dont l'id est transmis
	 * 
	 * @param idUtilisateur : identifiant utilisateur recherché
	 * @return l'utilisateur dont l'identifiant est celui transmis 
	 */
	public Utilisateur findById(String idUtilisateur) {

		return dao.findById(idUtilisateur);
	}
}
