package application.actionList;

import java.util.ArrayList;
import java.util.Scanner;

import application.action.Action;
import application.action.ActionList;
import banque.AgenceBancaire;

public class ActionListAgenceBancaire implements ActionList{

	private String message;
	private String code;
	private String title;
	private ArrayList<Action> listeActions;
	
	public ActionListAgenceBancaire(String message,String title, ArrayList<Action> listeActions) {
		this.message = message;
		this.code = "0";
		this.title = title;
		this.listeActions = listeActions;
	}

	@Override
	public String actionMessage() {
		return message;
	}

	@Override
	public String actionCode() {
		return code;
	}

	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		while(code != "-1") {
			System.out.println("--");
			System.out.println("Agence "+ag.getNomAgence()+" de "+ag.getLocAgence());
			System.out.println("Menu "+listTitle());
			System.out.println("--");
			System.out.println("\n  Choisir :");
			
			for (int i = 0; i < listeActions.size(); i++) {
				
				System.out.println("    "+(i+1)+" - "+listeActions.get(i).actionMessage());
					
			}
			System.out.println("\n    0 - Pour quitter ce menu");
			System.out.println("Choisir");
			Scanner scan = new Scanner(System.in);
			int rep = scan.nextInt();
			
			if(rep != 0) {
				listeActions.get(rep-1).execute(ag);
				
			}else {
				code = "-1";
			}
		}
		this.code = "0";
		System.out.println("Fin de "+this.message);

		
		
	}

	@Override
	public String listTitle() {
		return title;
	}

	@Override
	public int size() {
		return listeActions.size();
	}

	@Override
	public boolean addAction(Action ac) {
		for (Action action : listeActions) {
			if(ac.actionMessage().equals(action.actionMessage())) {
				return false;
			}
		}
		listeActions.add(ac);
		return true;
	}

}
