package application.action;

import banque.AgenceBancaire;
/**
 * An Action is an object that implements some action of a user's menu.<BR>
 * It is defined by a message, an optional code, an execute method to "do" the action.
 */
public interface Action  {
	/**
	 * Message of the action (to show on screen).
	 *
	 * @return the message of the action
	 */
	public String actionMessage ();

	/**
	 * Le code permet de savoir si on réaffiche u menu ou si on retourne dans l'ancien menu
	 * 0 correspond à un nouveau tour de la boucle
	 * -1 ferme le menu courant, si il y avait un menu avant celui-ci, il est affiché, sinon met fin au programme
	 *
	 * @return le code de cette action
	 */
	public String actionCode ();

	/**
	 * The method to call in order to "execute" the action on <code>ag</code>.
	 *
	 * @param ag the AgenceBancaire on which the action may act on
	 * @throws Exception when an uncaught exception occurs during execution
	*/
	public void execute(AgenceBancaire ag) throws Exception;
}
