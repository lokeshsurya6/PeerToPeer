package p2pcomm;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.OutputStream;

import protocol.Handshake;
import protocol.Message;

public class SerializableOutputStream extends DataOutputStream implements ObjectOutput {

    public SerializableOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void writeObject (Object obj) throws IOException {
        if (obj instanceof Handshake) {
            ((Handshake) obj).write(this);
        }
        else if (obj instanceof Message) {
            ((Message) obj).write (this);
        }
        else if (obj instanceof Serializable) {
            throw new UnsupportedOperationException ("Message of type " + obj.getClass().getName() + " not yet supported.");
        }
        else {
            throw new UnsupportedOperationException ("Message of type " + obj.getClass().getName() + " not supported.");
        }
    }
}