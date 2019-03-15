/**
 * This class represents the type Not Interestedto inform the peers 
 * that they don't possess the piece that node requires
 */
package protocol;

public class NotInterested extends Message {

	public NotInterested() {
		super(Type.NotInterested);
	}
}
