/**
 * This class provides request of type UnChoke for nodes which un-choke and class extends Message
 */
package messages;

public class Unchoke extends Message {

    public Unchoke() {
        super (Type.Unchoke);
    }
}
