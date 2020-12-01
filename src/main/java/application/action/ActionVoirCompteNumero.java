package application.action;

import java.util.Scanner;

import banque.AgenceBancaire;

public class ActionVoirCompteNumero implements Action {

	private String message;
	private String code;
	
	public ActionVoirCompteNumero(String message) {
		this.message = message;
		this.code = "0";
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
		System.out.println("Saisir numéro du compte:");
		Scanner scan = new Scanner(System.in);
		String num = scan.nextLine();
		System.out.println("Affichage du compte:\n");
		System.out.println(ag.getCompte(num)+"\n");
		
		
	}

}
