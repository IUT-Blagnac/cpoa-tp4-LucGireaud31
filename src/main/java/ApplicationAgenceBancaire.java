import java.util.ArrayList;

import application.action.Action;
import application.action.ActionList;
import application.action.ActionListeDesComptes;
import application.action.ActionVoirCompteNumero;
import application.actionList.ActionListAgenceBancaire;
import banque.AgenceBancaire;


public class ApplicationAgenceBancaire {
	
	

	public static void main(String argv[]) {
		AgenceBancaire ab = new AgenceBancaire("Caisse ecureuil", "Pibrac");
		Action a1 = new ActionListeDesComptes("Afficher les comptes de l'agence");
		Action a2 = new ActionVoirCompteNumero("Afficher le compte (par son numéro)");
		
		Action a3 = new ActionListeDesComptes("Afficher les comptes de l'agence v2");
		Action a4 = new ActionVoirCompteNumero("Afficher le compte (par son numéro) v2");
		
		ArrayList<Action> liste1 = new ArrayList<>();
		ArrayList<Action> liste2 = new ArrayList<>();
		
		liste1.add(a1);
		liste1.add(a2);
		
		liste2.add(a3);
		liste2.add(a4);
		
		Action a12 = new ActionListAgenceBancaire("Afficher menu v2", "V2", liste2);
		liste1.add(a12);

		
		ActionList al = new ActionListAgenceBancaire("Menu principal","Général", liste1);
		try {
			
			al.execute(ab);
			
			

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
