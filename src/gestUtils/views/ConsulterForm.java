package gestUtils.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestUtils.controllers.UtilisateurController;
import gestUtils.metier.Utilisateur;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Window.Type;

public class ConsulterForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -771555626038459978L;
	private JPanel contentPane;
	private JLabel lblId;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblLogin;
	private JLabel lblMdp;
	private JLabel lblAdresse;
	private JLabel lblCp;
	private JLabel lblVille;
	private JLabel lblDateEmbauche;
	private JLabel lblTypeProfil;
	private Utilisateur utilisateur;

	/**
	 * Create the frame.
	 */
	public ConsulterForm(Utilisateur utilisateur) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Id = new JPanel();
		Id.setBounds(0, 11, 224, 24);
		contentPane.add(Id);
		Id.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoId = new JLabel("Id :");
		lblInfoId.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoId.setFont(new Font("Tahoma", Font.BOLD, 11));
		Id.add(lblInfoId);
		
		lblId = new JLabel(utilisateur.getId());
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		Id.add(lblId);
		
		JPanel Nom = new JPanel();
		Nom.setBounds(0, 39, 224, 24);
		contentPane.add(Nom);
		Nom.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoNom = new JLabel("Nom :");
		lblInfoNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoNom.setFont(new Font("Tahoma", Font.BOLD, 11));
		Nom.add(lblInfoNom);
		
		lblNom = new JLabel(utilisateur.getNom());
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		Nom.add(lblNom);
		
		JPanel Prenom = new JPanel();
		Prenom.setBounds(0, 69, 224, 24);
		contentPane.add(Prenom);
		Prenom.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoPrenom = new JLabel("Prenom :");
		lblInfoPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoPrenom.setFont(new Font("Tahoma", Font.BOLD, 11));
		Prenom.add(lblInfoPrenom);
		
		lblPrenom = new JLabel(utilisateur.getPrenom());
		lblPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		Prenom.add(lblPrenom);
		
		JPanel Login = new JPanel();
		Login.setBounds(0, 98, 224, 24);
		contentPane.add(Login);
		Login.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoLogin = new JLabel("Login :");
		lblInfoLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		Login.add(lblInfoLogin);
		
		lblLogin = new JLabel(utilisateur.getLogin());
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		Login.add(lblLogin);
		
		JPanel Mdp = new JPanel();
		Mdp.setBounds(0, 127, 224, 24);
		contentPane.add(Mdp);
		Mdp.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoMdp = new JLabel("Mot de passe :");
		lblInfoMdp.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoMdp.setFont(new Font("Tahoma", Font.BOLD, 11));
		Mdp.add(lblInfoMdp);
		
		lblMdp = new JLabel(utilisateur.getMdp());
		lblMdp.setHorizontalAlignment(SwingConstants.CENTER);
		Mdp.add(lblMdp);
		
		JPanel Adresse = new JPanel();
		Adresse.setBounds(0, 157, 224, 24);
		contentPane.add(Adresse);
		Adresse.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoAdresse = new JLabel("Adresse :");
		lblInfoAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
		Adresse.add(lblInfoAdresse);
		
		lblAdresse = new JLabel(utilisateur.getAdresse());
		lblAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		Adresse.add(lblAdresse);
		
		JPanel Cp = new JPanel();
		Cp.setBounds(0, 187, 224, 24);
		contentPane.add(Cp);
		Cp.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoCp = new JLabel("Code Postal :");
		lblInfoCp.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoCp.setFont(new Font("Tahoma", Font.BOLD, 11));
		Cp.add(lblInfoCp);
		
		lblCp = new JLabel(utilisateur.getCp());
		lblCp.setHorizontalAlignment(SwingConstants.CENTER);
		Cp.add(lblCp);
		
		JPanel Ville = new JPanel();
		Ville.setBounds(0, 217, 224, 24);
		contentPane.add(Ville);
		Ville.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoVille = new JLabel("Ville :");
		lblInfoVille.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoVille.setFont(new Font("Tahoma", Font.BOLD, 11));
		Ville.add(lblInfoVille);
		
		lblVille = new JLabel(utilisateur.getVille());
		lblVille.setHorizontalAlignment(SwingConstants.CENTER);
		Ville.add(lblVille);
		
		JPanel DateEmbauche = new JPanel();
		DateEmbauche.setBounds(0, 247, 224, 24);
		contentPane.add(DateEmbauche);
		DateEmbauche.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoDateEmbauche = new JLabel("Date d'embauche :");
		lblInfoDateEmbauche.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoDateEmbauche.setFont(new Font("Tahoma", Font.BOLD, 11));
		DateEmbauche.add(lblInfoDateEmbauche);
		
		lblDateEmbauche = new JLabel(utilisateur.getDateEmbauche());
		lblDateEmbauche.setHorizontalAlignment(SwingConstants.CENTER);
		DateEmbauche.add(lblDateEmbauche);
		
		JPanel TypeProfil = new JPanel();
		TypeProfil.setBounds(0, 277, 224, 24);
		contentPane.add(TypeProfil);
		TypeProfil.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoTypeProfil = new JLabel("Type de profil :");
		lblInfoTypeProfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoTypeProfil.setFont(new Font("Tahoma", Font.BOLD, 11));
		TypeProfil.add(lblInfoTypeProfil);
		
		lblTypeProfil = new JLabel(utilisateur.getTypeProfil());
		lblTypeProfil.setHorizontalAlignment(SwingConstants.CENTER);
		TypeProfil.add(lblTypeProfil);
		
		JPanel Options = new JPanel();
		Options.setBounds(0, 312, 224, 40);
		contentPane.add(Options);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFermer.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		    	dispose();
			}
		});
		Options.add(btnFermer);
	}
}
