/**
 * This class provides request of type Not Interested type to inform the peers that they don't possess the piece that node requires and the class extends Message .
 */
package messages;

public class NotInterested  extends Message {

    public NotInterested() {
        super (Type.NotInterested);
    }
}
