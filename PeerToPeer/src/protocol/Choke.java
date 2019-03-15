/**
 *  This class represents Choke enum for choking node
 */
package protocol;

public class Choke extends Message {

	public Choke() {
		super(Type.Choke);
	}
}
