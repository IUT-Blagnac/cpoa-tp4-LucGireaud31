package application.action;

import banque.AgenceBancaire;

public class ActionListeDesComptes<E> implements Action<E>{

	private String message;
	private String code;

	public ActionListeDesComptes(String message) {
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
		((AgenceBancaire) e).afficher();
	}

}
