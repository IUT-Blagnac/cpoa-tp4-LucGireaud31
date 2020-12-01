package application.action;

import java.util.Scanner;

import banque.AgenceBancaire;
import banque.Compte;

public class ActionDeposerArgent<E> implements Action<E> {

	String message;
	String code;
	
	
	public ActionDeposerArgent(String message) {
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
		System.out.println("Saisir numéro du compte:");
		Scanner scan = new Scanner(System.in);
		String num = scan.nextLine();
		System.out.println("Saisir le montant à déposer");
		double depot = scan.nextDouble();

		((AgenceBancaire)e).getCompte(num).deposer(depot);
	}

}
