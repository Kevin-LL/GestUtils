/**
 * 
 */
package gestUtils.metier;


/**
 * Modélise un utilisateur : classe classique (POJO)
 * @author Zanati
 * @version février 2017
 */
public class Utilisateur  {
	
	private String id;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private String adresse;
	private String cp;
	private String ville;
	private String dateEmbauche;
	private String typeProfil;
	
	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 */
	public Utilisateur(String id, String nom, String prenom, String login, String mdp, String adresse, String cp, String ville, String dateEmbauche, String typeProfil) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.dateEmbauche = dateEmbauche;
		this.typeProfil = typeProfil;
	}
	
	/**
	 * 
	 */
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param prenom the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the password
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * @param prenom the password to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}
	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the date d'embauche
	 */
	public String getDateEmbauche() {
		return dateEmbauche;
	}
	/**
	 * @param date d'embauche the date d'embauche to set
	 */
	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	/**
	 * @return the type de profil
	 */
	public String getTypeProfil() {
		return typeProfil;
	}
	/**
	 * @param type de profil the type de profil to set
	 */
	public void setTypeProfil(String typeProfil) {
		this.typeProfil = typeProfil;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Utilisateur : " + id + ", " + nom + ", " + prenom + ", " + login + ", " + mdp + ", " + adresse + ", " + cp + ", " + ville + ", " + dateEmbauche + ", " + typeProfil;
	}

}
