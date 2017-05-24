package gestUtils.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestUtils.controllers.UtilisateurController;
import gestUtils.models.dataAccess.UtilisateurDAO;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;

public class ConnexionForm extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField textMdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionForm frame = new ConnexionForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConnexionForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Top = new JPanel();
		Top.setBounds(5, 5, 224, 28);
		contentPane.add(Top);
		Top.setLayout(null);
		
		JLabel lblInfo = new JLabel("Veuillez vous connecter :");
		lblInfo.setBounds(30, 5, 164, 18);
		lblInfo.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		Top.add(lblInfo);
		
		JPanel Middle = new JPanel();
		Middle.setBounds(5, 33, 224, 91);
		contentPane.add(Middle);
		Middle.setLayout(null);
		
		JPanel login = new JPanel();
		login.setBounds(6, 5, 212, 21);
		Middle.add(login);
		login.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setBounds(10, 0, 96, 21);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		login.add(lblLogin);
		
		textLogin = new JTextField("lvillachane");
		textLogin.setBounds(106, 0, 96, 21);
		textLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		login.add(textLogin);
		textLogin.setColumns(10);
		
		JPanel mdp = new JPanel();
		mdp.setBounds(6, 31, 212, 21);
		Middle.add(mdp);
		mdp.setLayout(null);
		
		JLabel lblMdp = new JLabel("Mot de passe :");
		lblMdp.setBounds(10, 0, 96, 21);
		lblMdp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mdp.add(lblMdp);
		
		textMdp = new JPasswordField("jux7g");
		textMdp.setBounds(106, 0, 96, 21);
		textMdp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mdp.add(textMdp);
		
		JPanel btn = new JPanel();
		btn.setBounds(0, 57, 224, 34);
		Middle.add(btn);
		
		JButton btnConnexion = new JButton("Se connecter");
		btnConnexion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConnexion.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		    	Connexion();
			}
		});
		btn.add(btnConnexion);
		
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAnnuler.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		    	textLogin.setText("");
		    	textMdp.setText("");
			}
		});
		btn.add(btnAnnuler);
		
		JPanel Bottom = new JPanel();
		Bottom.setBounds(0, 135, 234, 22);
		contentPane.add(Bottom);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuitter.addActionListener(new QuitterProg());
		Bottom.setLayout(new GridLayout(0, 1, 0, 0));
		Bottom.add(btnQuitter);
	}
	
	public void Connexion() {
    	String login = textLogin.getText();
    	String mdp = new String(textMdp.getPassword());
    	UtilisateurDAO unUtilisateur = new UtilisateurDAO();
    	if(unUtilisateur.Connexion(login, mdp)){
    		final UtilisateurController utilisateurController = new UtilisateurController();
			RechercheForm frame = new RechercheForm(utilisateurController);
			frame.setVisible(true);
			frame.getRecherche();
			this.dispose();
    	}
	}
	
	private class QuitterProg implements ActionListener{
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        System.exit(0);
	    }
	}
}
