package application.action;

import java.util.Scanner;

import banque.AgenceBancaire;
import banque.Compte;

public class ActionAjouterCompte<E> implements Action<E>{
	private String message;
	private String code;
	
	public ActionAjouterCompte(String message) {
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
	public void execute(E e) throws Exception {
		System.out.println("Saisir le numéro du compte:");
		Scanner scan = new Scanner(System.in);
		String num = scan.nextLine();
		System.out.println("Saisir le propriétaire");

		String prop = scan.nextLine();
		
		Compte c = new Compte(num,prop);
		((AgenceBancaire) e).addCompte(c);


		
		
	}
}
