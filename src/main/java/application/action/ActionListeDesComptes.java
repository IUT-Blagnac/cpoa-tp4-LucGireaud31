package application.action;

import banque.AgenceBancaire;

public class ActionListeDesComptes implements Action{

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
	public void execute(AgenceBancaire ag) throws Exception {
		ag.afficher();
	}

}
