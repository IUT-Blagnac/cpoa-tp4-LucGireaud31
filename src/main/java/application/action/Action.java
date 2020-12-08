package application.action;

/**
 * An Action is an object that implements some action of a user's menu.<BR>
 * It is defined by a message, an optional code, an execute method to "do" the action.<BR>
 * It is parameterized by the  type of object on which the action may act on (execute on).
 *
 * @param <E> The type of object on which the action may act on.
 */
public interface Action <E> {
	/**
	 * Message of the action (to show on screen).
	 *
	 * @return the message of the action
	 */
	public String actionMessage();

	/**
	 * Le code permet de savoir si on réaffiche u menu ou si on retourne dans l'ancien menu
	 * 0 correspond à un nouveau tour de la boucle
	 * -1 ferme le menu courant, si il y avait un menu avant celui-ci, il est affiché, sinon met fin au programme
	 *
	 * @return le code de cette action
	 */
	public String actionCode();

	/**
	 * The method to call in order to "execute" the action on <code>e</code>.
	 *
	 * @param e the object on which the action may act on
	 * @throws Exception when an uncaught exception occurs during execution
	 */
	public void execute(E e) throws Exception;
}
