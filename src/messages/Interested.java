/**
 * This class provides request of type Interested to inform peers that they have piece that node needs and this class extends Message.
 */
package messages;

public class Interested  extends Message {

    public Interested() {
        super (Type.Interested);
    }
}
