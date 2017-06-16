package gestUtils.views;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import gestUtils.controllers.UtilisateurController;
import gestUtils.metier.Utilisateur;
import gestUtils.models.UtilisateurJTableModel;
import gestUtils.models.dataAccess.UtilisateurDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class RechercheForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private static UtilisateurController utilisateurController ;
			
	// les propriétés graphiques
	private JPanel contentPane;
	private JPanel Top;
	private JLabel lblNomUtilisateur;
	private static JTextField textNomUtil;
	private JButton btnRechercher;
	private static UtilisateurJTableModel utilisateurJTableModel = new UtilisateurJTableModel();
	private JTable jtable = new JTable(utilisateurJTableModel);
	private JScrollPane Table = new JScrollPane(jtable);
	private JPanel Middle;
	private JButton btnConsulter;
	private JButton btnModifier;
	private JButton btnAjouter;
	private JPanel RechercherProfil;
	private JButton btnSupprimer;

	/**
	 * Create the frame.
	 */
	public RechercheForm(UtilisateurController utilisateurController) {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				getRecherche();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		this.utilisateurController = utilisateurController ;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTop());
		Table.setBounds(5, 46, 424, 178);
		getContentPane().add(Table);
		contentPane.add(getMiddle());
		
		JPanel Bottom = new JPanel();
		Bottom.setBounds(0, 267, 434, 24);
		contentPane.add(Bottom);
		Bottom.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnDeconnecter = new JButton("Se déconnecter");
		btnDeconnecter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeconnecter.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		    	Deconnexion();
			}
		});
		Bottom.add(btnDeconnecter);
	}
	
	public void Deconnexion() {
    	ConnexionForm frame = new ConnexionForm();
        frame.setVisible(true);
		this.dispose();
	}

	private JPanel getTop() {
		if (Top == null) {
			Top = new JPanel();
			Top.setBounds(5, 5, 424, 41);
			Top.setLayout(null);
			Top.add(getRechercherProfil());
		}
		return Top;
	}
	
	private JLabel getLblNomUtilisateur() {
		if (lblNomUtilisateur == null) {
			lblNomUtilisateur = new JLabel("Nom utilisateur :");
			lblNomUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblNomUtilisateur;
	}
	
	private JTextField getTextNomUtil() {
		if (textNomUtil == null) {
			textNomUtil = new JTextField();
			textNomUtil.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textNomUtil.setColumns(10);
		}
		return textNomUtil;
	}
	
	private JButton getBtnRechercher() {
		if (btnRechercher == null) {
			btnRechercher = new JButton("Rechercher");
			btnRechercher.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnRechercher.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					recherche();
				}
			});
		}
		return btnRechercher;
	}
	
	public void getRecherche() {
	String nom = textNomUtil.getText();
	List<Utilisateur> lesUtilisateurs = utilisateurController.findByNom(nom);
		if (lesUtilisateurs.size() > 0)
		{
			utilisateurJTableModel.loadData(lesUtilisateurs); //maj du contenu de la JTable
		}
	}
	protected void recherche() {
		String nom = textNomUtil.getText();
		if (nom == null)
		{ //afficher message erreur
			JOptionPane.showMessageDialog(this, 
	                   "Il faut saisir un nom !",
	                   "Recherche", 
	                   JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			List<Utilisateur> lesUtilisateurs = utilisateurController.findByNom(nom);
			if (lesUtilisateurs.size() > 0)
			{
				utilisateurJTableModel.loadData(lesUtilisateurs); //maj du contenu de la JTable
			}
			else {
				JOptionPane.showMessageDialog(this, 
		                   "Pas d'utilisateur avec ce nom " + nom,
		                   "Résultat", 
		                   JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	private JPanel getMiddle() {
		if (Middle == null) {
			Middle = new JPanel();
			Middle.setBounds(5, 224, 424, 33);
			Middle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			Middle.add(getBtnConsulter());
			Middle.add(getBtnModifier());
			Middle.add(getBtnAjouter());
			Middle.add(getBtnSupprimer());
		}
		return Middle;
	}
	private JButton getBtnConsulter() {
		if (btnConsulter == null) {
			btnConsulter = new JButton("Consulter");
			btnConsulter.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnConsulter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					  if(jtable.getSelectedRowCount() > 0){
			        	  String idUtilisateur = new String();
			        	  idUtilisateur = (String) jtable.getValueAt(jtable.getSelectedRow(), 0);
			        	  Utilisateur util = getUtilisateur(idUtilisateur);
			        	  System.out.println(util.getTypeProfil());
			        	  System.out.println(util.getVille());
			        	  ConsulterForm frame = new ConsulterForm(util);
			        	  frame.setVisible(true);
					  }else{
						  JOptionPane.showMessageDialog(null, "Vous devez selectionner un utilisateur.");
					  }
				}
			});
		}
		return btnConsulter;
	}
	
	private JButton getBtnModifier() {
		if (btnModifier == null) {
			btnModifier = new JButton("Modifier");
			btnModifier.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnModifier.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
		}
		return btnModifier;
	}
	private JButton getBtnAjouter() {
		if (btnAjouter == null) {
			btnAjouter = new JButton("Ajouter");
			btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnAjouter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		        	  AjouterForm frame = new AjouterForm();
		        	  frame.setVisible(true);
				}
			});
		}
		return btnAjouter;
	}
	
	
	private JPanel getRechercherProfil() {
		if (RechercherProfil == null) {
			RechercherProfil = new JPanel();
			RechercherProfil.setBounds(0, 0, 424, 41);
			RechercherProfil.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			RechercherProfil.add(getLblNomUtilisateur());
			RechercherProfil.add(getTextNomUtil());
			RechercherProfil.add(getBtnRechercher());
		}
		return RechercherProfil;
	}
	
	
	/*FONCTION SUPPRIMER | EPREUVE E4*/
	private JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			btnSupprimer = new JButton("Supprimer");
			btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnSupprimer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					  if(jtable.getSelectedRowCount() > 0){
						  
						  int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer l'utilisateur selectionné?", "Confirmation de la suppression", JOptionPane.YES_NO_OPTION);
						  if(dialogResult == JOptionPane.YES_OPTION){
						
						  //Trouve l'utilisateur
			        	  String idUtilisateur = new String();
			        	  idUtilisateur = (String) jtable.getValueAt(jtable.getSelectedRow(), 0);
			        	  Utilisateur util = getUtilisateur(idUtilisateur);
			        	  System.out.println(util.getId());
			        	  
			        	  //Exécute la requête
					      UtilisateurDAO unUtilisateurDAO = new UtilisateurDAO();
					      unUtilisateurDAO.supprUtilisateur(idUtilisateur);
					      
					      //Met à jour la liste
					      jtable.repaint();
					      
						  } else {
						  //Ne fait rien
							;
						  } 
						  
					  }else{
						  JOptionPane.showMessageDialog(null, "Vous devez selectionner un utilisateur.");
					  }
				}
			});
		}
		return btnSupprimer;
	}
	
	public Utilisateur getUtilisateur(String id){
		Utilisateur utilisateur;
		utilisateur = this.utilisateurController.findById(id);
		
		return utilisateur;
	}

}
