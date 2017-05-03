package gestUtils.models.dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gestUtils.metier.Utilisateur;


/**
 * Classe technique permettant le mapping entre les instances d'Utilisateur
 * et la table Utilisateur dans la BdD
 * Définit les opérations autorisées : Create, Read et Update (CRU)
 * Elle modélise un objet d'accès aux données (Data Access Object)
 * @author Zanati
 * @version février 2017
 */

public class UtilisateurDAO {

	public static Connection connect;
	
	public UtilisateurDAO () {
		connect = ConnectDAO.getInstance();
	}
	
/**
 * @param id identifant de l'utilsateur à rechercher dans la BdD
 * @return un objet Utilisateur ou null
 */
	public Utilisateur findById(String id) {

		Utilisateur unUtilisateur = null;
		try {
			PreparedStatement statement = connect.prepareStatement("select * from visiteur where id =  ?");
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if (result.first())
				unUtilisateur = 
					new Utilisateur(id, 
					result.getString("nom"), 
					result.getString("prenom"), 
					result.getString("login"), 
					result.getString("mdp"), 
					result.getString("adresse"), 
					result.getString("cp"), 
					result.getString("ville"), 
					result.getString("dateEmbauche"), 
					result.getString("idProfil"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return unUtilisateur;
	}
	
	/**
	 * @param filtreNom nom de l'utilisateur à rechercher dans la BdD
	 * @return une liste d'objets Utilisateur 
	 */
	public List<Utilisateur> findByNom(String filtreNom) {

		Utilisateur unUtilisateur = null;
		List<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();
		try {
			PreparedStatement statement = connect.prepareStatement("select * from visiteur where nom like  ?");
			statement.setString(1, filtreNom);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				System.out.println(result.getString("id"));
				unUtilisateur = 
					new Utilisateur(result.getString("id"), 
					result.getString("nom"),
					result.getString("prenom"), 
					result.getString("login"),
					result.getString("mdp"), 
					result.getString("adresse"), 
					result.getString("cp"), 
					result.getString("ville"), 
					result.getString("dateEmbauche"), 
					result.getString("idProfil"));
				lesUtilisateurs.add(unUtilisateur);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesUtilisateurs;
	}
	
    public boolean Connexion(String login, String mdp) {
        boolean ok = false;
		try {
			PreparedStatement statement = connect.prepareStatement("SELECT * FROM visiteur WHERE login = ? && mdp = ?");
			statement.setString(1, login);
			statement.setString(2, mdp);
			ResultSet result = statement.executeQuery();
		    if (result.first()) {
		        ok = true;
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
    }
}
