/**
 *  Choke class renders request of type Choke for choking nodes and class extends Message.
 */
package messages;

public class Choke extends Message {

    public Choke() {
        super (Type.Choke);
    }
}
