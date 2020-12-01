import java.util.ArrayList;

import application.action.Action;
import application.action.ActionAjouterCompte;
import application.action.ActionDeposerArgent;
import application.action.ActionList;
import application.action.ActionListeDesComptes;
import application.action.ActionRetirerArgent;
import application.action.ActionSupprimerCompte;
import application.action.ActionVoirCompteNumero;
import application.actionList.ActionListAgenceBancaire;
import banque.AgenceBancaire;


public class ApplicationAgenceBancaire {
	
	

	public static void main(String argv[]) {
		AgenceBancaire ab = new AgenceBancaire("Caisse ecureuil", "Pibrac");
		Action<AgenceBancaire> a1 = new ActionListeDesComptes<AgenceBancaire>("Afficher les comptes de l'agence");
		Action<AgenceBancaire> a2 = new ActionVoirCompteNumero<AgenceBancaire>("Afficher le compte (par son numéro)");
		Action<AgenceBancaire> a3 = new ActionAjouterCompte<>("Ajouter un compte");
		Action<AgenceBancaire> a4 = new ActionSupprimerCompte<>("Supprimer un compte");
		Action<AgenceBancaire> a5 = new ActionDeposerArgent<>("Deposer");
		Action<AgenceBancaire> a6 = new ActionRetirerArgent<>("Retirer");
		
		ArrayList<Action<AgenceBancaire>> liste1 = new ArrayList<>();
		ArrayList<Action<AgenceBancaire>> liste2 = new ArrayList<>();
		ArrayList<Action<AgenceBancaire>> liste3 = new ArrayList<>();
		
		liste2.add(a5);
		liste2.add(a6);
		
		liste3.add(a3);
		liste3.add(a4);
		
		Action<AgenceBancaire> m1 = new ActionListAgenceBancaire<>("Afficher le menu des opérations sur comptes", "Opérations comptes", liste2);
		Action<AgenceBancaire> m2 = new ActionListAgenceBancaire<>("Afficher le menu de gestion des comptes", "Gestions comptes", liste3);
		
		
		
		liste1.add(a1);
		liste1.add(a2);
		liste1.add(m1);
		liste1.add(m2);
		
		ActionList<AgenceBancaire> al = new ActionListAgenceBancaire<AgenceBancaire>("Menu principal","Général", liste1);
		try {			
			al.execute(ab);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
