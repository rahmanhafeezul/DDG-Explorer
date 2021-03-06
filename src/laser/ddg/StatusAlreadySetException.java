package laser.ddg;

/**
 * Status Already Set Exception
 */
public class StatusAlreadySetException extends IllegalStateException {
	/**
	 * used for serializable objects in order to verify that the same version of
	 * the class definition is used to serialize the object as to unserialize it
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param s
	 */
	public StatusAlreadySetException(String s) {
		super(s);
	}
}
