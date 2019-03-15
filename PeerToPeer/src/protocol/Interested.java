/**
 * This class represents an Enum to inform peers that they possess
 * piece that node requires
 */
package protocol;

public class Interested extends Message {

	public Interested() {
		super(Type.Interested);
	}
}
