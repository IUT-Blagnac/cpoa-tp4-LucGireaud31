package Banque;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import application.action.Action;
import application.action.ActionList;
import application.action.ActionListeDesComptes;
import application.action.ActionVoirCompteNumero;
import application.actionList.ActionListAgenceBancaire;
import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.ABCompteDejaExistantException;
import banque.exception.ABCompteNullException;


public class StepDefinitions {


	AgenceBancaire ab;
	ArrayList<Action<AgenceBancaire>> liste = new ArrayList<>();
	ActionList<AgenceBancaire> menu;
	
	@Given("une agence vide")
	public void creerAgence() {
		ab = new AgenceBancaire("Agence Test", "L'ordi");
	}
	@When("un compte est ajouté")
	public void ajouter1compte() {
		Compte c = new Compte();
		try {
			ab.addCompte(c);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	@Then("l'agence a un compte")
	public void agence1Compte() {
		assertEquals(ab.getNbComptes(), 1);
	}
	

	@Given("Un menu")
	public void creerMenu() {
		 menu = new ActionListAgenceBancaire<AgenceBancaire>("Menu principal","Général", liste);
	}
	@When("On ajoute 2 options")
	public void ajouter2Options() {
		Action<AgenceBancaire> o1 = new ActionListeDesComptes<AgenceBancaire>("Afficher les comptes de l'agence");
		Action<AgenceBancaire> o2 = new ActionVoirCompteNumero<AgenceBancaire>("Afficher le compte (par son numéro)");
		menu.addAction(o1);
		menu.addAction(o2);
	}
	@Then("le menu a 2 options")
	public void taille2Options() {
		assertEquals(2, ((ActionListAgenceBancaire<AgenceBancaire>)menu).size());
	}
	
	
	
	@When("On ajoute 2 options A et B")
	public void ajouter2OptionsAB() {
		Action<AgenceBancaire> o1 = new ActionListeDesComptes<AgenceBancaire>("A");
		Action<AgenceBancaire> o2 = new ActionVoirCompteNumero<AgenceBancaire>("B");
		menu.addAction(o1);
		menu.addAction(o2);
	}
	@When("ferme menu")
	public void fermerMenu() {
		try {
			menu.execute(ab);
			InputStream sysInBackup = System.in; // backup System.in to restore it later
			ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
			System.setIn(in);
			//le code va passer à -1 puis va repasser à 0 pour le cas ou on voudrait y retourner, on vérifie que le code reste à 0
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Then("le menu a 2 options A et B")
	public void taille2OptionsAB() {
		assertEquals(((ActionListAgenceBancaire<AgenceBancaire>)menu).getListeActions().get(0).actionMessage(),"A");
		assertEquals(((ActionListAgenceBancaire<AgenceBancaire>)menu).getListeActions().get(1).actionMessage(),"B");
	}
	
	
	@Then("code à {string}")
	public void codemenu(String code) {
		assertEquals(code, menu.actionCode());
	}
	
	

}
