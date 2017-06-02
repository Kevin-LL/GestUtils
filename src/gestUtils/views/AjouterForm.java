package gestUtils.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gestUtils.controllers.UtilisateurController;
import gestUtils.metier.Utilisateur;
import gestUtils.models.dataAccess.UtilisateurDAO;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.awt.event.InputMethodEvent;
import java.util.Random;

import javax.swing.JComboBox;
import java.util.concurrent.ThreadLocalRandom;

public class AjouterForm extends JFrame {

	private JPanel contentPane;
	private JLabel tfId;
	private JTextField tfNom;
	private JTextField tfPrenom;
	private JLabel lblLogin;
	private JTextField tfMdp;
	private JTextField tfAdresse;
	private JTextField tfCp;
	private JTextField tfVille;
	private JDateChooser dcDateEmbauche;
	private JComboBox<String> cbTypeProfil;


	/**
	 * Create the frame.
	 */
	public AjouterForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		//Panel Id
		JPanel Id = new JPanel();
		Id.setBounds(0, 11, 224, 24);
		contentPane.add(Id);
		Id.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoId = new JLabel("Id :");
		lblInfoId.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoId.setFont(new Font("Tahoma", Font.BOLD, 11));
		Id.add(lblInfoId);
		
		tfId = new JLabel();
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 1; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		int randomNum = ThreadLocalRandom.current().nextInt(0, 999);
		tfId.setText(output + randomNum);
		tfId.setHorizontalAlignment(SwingConstants.CENTER);
		Id.add(tfId);
		
		
		
		
		//Panel Nom
		JPanel Nom = new JPanel();
		Nom.setBounds(0, 39, 224, 24);
		contentPane.add(Nom);
		Nom.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoNom = new JLabel("Nom :");
		lblInfoNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoNom.setFont(new Font("Tahoma", Font.BOLD, 11));
		Nom.add(lblInfoNom);
		
		tfNom = new JTextField();
		Nom.add(tfNom);
		tfNom.setColumns(10);
		tfNom.getDocument().addDocumentListener(new DocumentListener() {
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
		    	String nom = tfNom.getText();
		    	String prenom = tfPrenom.getText();
		    	String premiereLettrePrenom = "";
		    	if (prenom.length() > 0){
			    	premiereLettrePrenom=prenom.substring(0,1);
		    	}
		    	lblLogin.setText(premiereLettrePrenom.replaceAll("\\s+","").toLowerCase() + nom.replaceAll("\\s+","").toLowerCase());
		    }
		});
		
		
		
		
		//Panel Prenom
		JPanel Prenom = new JPanel();
		Prenom.setBounds(0, 69, 224, 24);
		contentPane.add(Prenom);
		Prenom.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoPrenom = new JLabel("Prenom :");
		lblInfoPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoPrenom.setFont(new Font("Tahoma", Font.BOLD, 11));
		Prenom.add(lblInfoPrenom);
		
		tfPrenom = new JTextField();
		Prenom.add(tfPrenom);
		tfPrenom.setColumns(10);
		tfPrenom.getDocument().addDocumentListener(new DocumentListener() {
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
		    	String nom = tfNom.getText();
		    	String prenom = tfPrenom.getText();
		    	String premiereLettrePrenom = "";
		    	if (prenom.length() > 0){
			    	premiereLettrePrenom=prenom.substring(0,1);
		    	}
		    	lblLogin.setText(premiereLettrePrenom.replaceAll("\\s+","").toLowerCase() + nom.replaceAll("\\s+","").toLowerCase());
		    }
		});
		
		
		
		
		//Panel Login
		JPanel Login = new JPanel();
		Login.setBounds(0, 98, 224, 24);
		contentPane.add(Login);
		Login.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoLogin = new JLabel("Login :");
		lblInfoLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		Login.add(lblInfoLogin);
		
		lblLogin = new JLabel("");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		Login.add(lblLogin);
		
		
		
		
		//Panel Mdp
		JPanel Mdp = new JPanel();
		Mdp.setBounds(0, 127, 336, 24);
		contentPane.add(Mdp);
		Mdp.setLayout(null);
		
		JLabel lblInfoMdp = new JLabel("Mot de passe :");
		lblInfoMdp.setBounds(0, 0, 112, 24);
		lblInfoMdp.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoMdp.setFont(new Font("Tahoma", Font.BOLD, 11));
		Mdp.add(lblInfoMdp);
		
		tfMdp = new JTextField();
		tfMdp.setBounds(112, 0, 112, 24);
		Mdp.add(tfMdp);
		tfMdp.setColumns(10);
		
		JButton btnGenerer = new JButton("Générer");
		btnGenerer.setBounds(234, 0, 92, 24);
		btnGenerer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGenerer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] chars = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
				StringBuilder sb = new StringBuilder();
				Random random = new Random();
				for (int i = 0; i < 5; i++) {
				    char c = chars[random.nextInt(chars.length)];
				    sb.append(c);
				}
				String output = sb.toString();
				tfMdp.setText(output);
			}
		});
		Mdp.add(btnGenerer);
		
		
		
		
		//Panel Adresse
		JPanel Adresse = new JPanel();
		Adresse.setBounds(0, 157, 224, 24);
		contentPane.add(Adresse);
		Adresse.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoAdresse = new JLabel("Adresse :");
		lblInfoAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
		Adresse.add(lblInfoAdresse);
		
		tfAdresse = new JTextField();
		Adresse.add(tfAdresse);
		tfAdresse.setColumns(10);
		
		
		
		
		//Panel Cp
		JPanel Cp = new JPanel();
		Cp.setBounds(0, 187, 224, 24);
		contentPane.add(Cp);
		Cp.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoCp = new JLabel("Code Postal :");
		lblInfoCp.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoCp.setFont(new Font("Tahoma", Font.BOLD, 11));
		Cp.add(lblInfoCp);
		
		tfCp = new JTextField();
		Cp.add(tfCp);
		tfCp.setColumns(10);
		KeyListener keyListener= new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE))) {
		        getToolkit().beep();
		        e.consume();
		      }
		    }
		};
		tfCp.addKeyListener(keyListener);
		
		
		
		
		//Panel Ville
		JPanel Ville = new JPanel();
		Ville.setBounds(0, 217, 224, 24);
		contentPane.add(Ville);
		Ville.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoVille = new JLabel("Ville :");
		lblInfoVille.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoVille.setFont(new Font("Tahoma", Font.BOLD, 11));
		Ville.add(lblInfoVille);
		
		tfVille = new JTextField();
		Ville.add(tfVille);
		tfVille.setColumns(10);
		
		
		
		
		//Panel DateEmbauche
		JPanel DateEmbauche = new JPanel();
		DateEmbauche.setBounds(0, 247, 224, 24);
		contentPane.add(DateEmbauche);
		DateEmbauche.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoDateEmbauche = new JLabel("Date d'embauche :");
		lblInfoDateEmbauche.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoDateEmbauche.setFont(new Font("Tahoma", Font.BOLD, 11));
		DateEmbauche.add(lblInfoDateEmbauche);
		
		dcDateEmbauche = new JDateChooser();
		dcDateEmbauche.getDateEditor().setEnabled(false);
	    ((JTextFieldDateEditor)dcDateEmbauche.getDateEditor())
        .setDisabledTextColor(Color.darkGray);
		dcDateEmbauche.setDateFormatString("yyyy-MM-dd");
		DateEmbauche.add(dcDateEmbauche);
		
		
		
		
		//Panel TypeProfil
		JPanel TypeProfil = new JPanel();
		TypeProfil.setBounds(0, 277, 224, 24);
		contentPane.add(TypeProfil);
		TypeProfil.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblInfoTypeProfil = new JLabel("Type de profil :");
		lblInfoTypeProfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoTypeProfil.setFont(new Font("Tahoma", Font.BOLD, 11));
		TypeProfil.add(lblInfoTypeProfil);
		
		cbTypeProfil = new JComboBox<String>();
		cbTypeProfil.addItem("v");
		cbTypeProfil.addItem("c");
		TypeProfil.add(cbTypeProfil);
		
		
		
		
		//Panel Options
		JPanel Options = new JPanel();
		Options.setBounds(0, 342, 336, 40);
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
		btnConfirmer.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				      String tfIdValue = tfId.getText();
				      String tfNomValue = tfNom.getText();
				      String tfPrenomValue = tfPrenom.getText();
				      String lblLoginValue = lblLogin.getText();
				      String tfMdpValue = tfMdp.getText();
				      String tfAdresseValue = tfAdresse.getText();
				      String tfCpValue = tfCp.getText();
				      String tfVilleValue = tfVille.getText();
				      String dcDateEmbaucheValue = ((JTextField)dcDateEmbauche.getDateEditor().getUiComponent()).getText();
				      String cbTypeProfilValue = cbTypeProfil.getSelectedItem().toString();
				      /*System.out.println(tfIdValue + tfNomValue + tfPrenomValue + lblLoginValue + tfMdpValue + tfAdresseValue + tfCpValue + tfVilleValue + tfDateEmbaucheValue + tfTypeProfilValue);*/
				      Utilisateur unUtilisateur = new Utilisateur(tfIdValue, tfNomValue, tfPrenomValue, lblLoginValue, tfMdpValue, tfAdresseValue, tfCpValue, tfVilleValue, dcDateEmbaucheValue, cbTypeProfilValue);
				      UtilisateurDAO unUtilisateurDAO = new UtilisateurDAO();
				      unUtilisateurDAO.saveUtilisateur(unUtilisateur);
				      dispose();
		        	  AjouterForm frame = new AjouterForm();
		        	  frame.setVisible(true);
			   }
		});
		
	}
}
