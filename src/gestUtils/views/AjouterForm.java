package gestUtils.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gestUtils.controllers.UtilisateurController;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class AjouterForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;


	/**
	 * Create the frame.
	 */
	public AjouterForm() {
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
		
		textField = new JTextField();
		Id.add(textField);
		textField.setColumns(10);
		
		JPanel Nom = new JPanel();
		Nom.setBounds(0, 39, 224, 24);
		contentPane.add(Nom);
		Nom.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoNom = new JLabel("Nom :");
		lblInfoNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoNom.setFont(new Font("Tahoma", Font.BOLD, 11));
		Nom.add(lblInfoNom);
		
		textField_1 = new JTextField();
		Nom.add(textField_1);
		textField_1.setColumns(10);
		textField_1.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		    	changedUpdate(e);
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
	            changedUpdate(e);
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		    	String nom = textField_1.getText();
		    	String prenom = textField_2.getText();
		    	String premiereLettrePrenom = "";
		    	if (prenom.length() > 0){
			    	premiereLettrePrenom=prenom.substring(0,1);
		    	}
		    	lblNewLabel.setText(premiereLettrePrenom + nom);
		    }
		});
		
		JPanel Prenom = new JPanel();
		Prenom.setBounds(0, 69, 224, 24);
		contentPane.add(Prenom);
		Prenom.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoPrenom = new JLabel("Prenom :");
		lblInfoPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoPrenom.setFont(new Font("Tahoma", Font.BOLD, 11));
		Prenom.add(lblInfoPrenom);
		
		textField_2 = new JTextField();
		Prenom.add(textField_2);
		textField_2.setColumns(10);
		textField_2.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		    	changedUpdate(e);
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
	            changedUpdate(e);
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		    	String nom = textField_1.getText();
		    	String prenom = textField_2.getText();
		    	String premiereLettrePrenom = "";
		    	if (prenom.length() > 0){
			    	premiereLettrePrenom=prenom.substring(0,1);
		    	}
		    	lblNewLabel.setText(premiereLettrePrenom + nom);
		    }
		});
		
		JPanel Login = new JPanel();
		Login.setBounds(0, 98, 224, 24);
		contentPane.add(Login);
		Login.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoLogin = new JLabel("Login :");
		lblInfoLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		Login.add(lblInfoLogin);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Login.add(lblNewLabel);
		
		JPanel Mdp = new JPanel();
		Mdp.setBounds(0, 127, 224, 24);
		contentPane.add(Mdp);
		Mdp.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoMdp = new JLabel("Mot de passe :");
		lblInfoMdp.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoMdp.setFont(new Font("Tahoma", Font.BOLD, 11));
		Mdp.add(lblInfoMdp);
		
		textField_4 = new JTextField();
		Mdp.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel Adresse = new JPanel();
		Adresse.setBounds(0, 157, 224, 24);
		contentPane.add(Adresse);
		Adresse.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoAdresse = new JLabel("Adresse :");
		lblInfoAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
		Adresse.add(lblInfoAdresse);
		
		textField_5 = new JTextField();
		Adresse.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel Cp = new JPanel();
		Cp.setBounds(0, 187, 224, 24);
		contentPane.add(Cp);
		Cp.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoCp = new JLabel("Code Postal :");
		lblInfoCp.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoCp.setFont(new Font("Tahoma", Font.BOLD, 11));
		Cp.add(lblInfoCp);
		
		textField_6 = new JTextField();
		Cp.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel Ville = new JPanel();
		Ville.setBounds(0, 217, 224, 24);
		contentPane.add(Ville);
		Ville.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoVille = new JLabel("Ville :");
		lblInfoVille.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoVille.setFont(new Font("Tahoma", Font.BOLD, 11));
		Ville.add(lblInfoVille);
		
		textField_7 = new JTextField();
		Ville.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel DateEmbauche = new JPanel();
		DateEmbauche.setBounds(0, 247, 224, 24);
		contentPane.add(DateEmbauche);
		DateEmbauche.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoDateEmbauche = new JLabel("Date d'embauche :");
		lblInfoDateEmbauche.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoDateEmbauche.setFont(new Font("Tahoma", Font.BOLD, 11));
		DateEmbauche.add(lblInfoDateEmbauche);
		
		textField_8 = new JTextField();
		DateEmbauche.add(textField_8);
		textField_8.setColumns(10);
		
		JPanel TypeProfil = new JPanel();
		TypeProfil.setBounds(0, 277, 224, 24);
		contentPane.add(TypeProfil);
		TypeProfil.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoTypeProfil = new JLabel("Type de profil :");
		lblInfoTypeProfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoTypeProfil.setFont(new Font("Tahoma", Font.BOLD, 11));
		TypeProfil.add(lblInfoTypeProfil);
		
		textField_9 = new JTextField();
		TypeProfil.add(textField_9);
		textField_9.setColumns(10);
		
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
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setFont(new Font("Tahoma", Font.BOLD, 12));
		Options.add(btnConfirmer);
	}
	
}
