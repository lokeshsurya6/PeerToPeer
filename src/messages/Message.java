/**
 * This is for creating messages of all types and it is the base class
 */
package messages;

import java.io.Serializable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Message implements Serializable {

    private int mg_lgth;
    private final Type msg_type;
    protected byte[] _payload;

    protected Message (Type mg_tp) {
        this (mg_tp, null);
    }

    protected Message (Type mg_tp, byte[] pay_load) {
        mg_lgth = (pay_load == null ? 0 : pay_load.length)
                + 1; // for the _type
        msg_type = mg_tp;
        _payload = pay_load;
    }

    public Type get_type() {
        return msg_type;
    }

    public void read (DataInputStream in) throws IOException {
        if ((_payload != null) && (_payload.length) > 0) {
            in.readFully(_payload, 0, _payload.length);
        }
    }

    public void write (DataOutputStream out) throws IOException {
        out.writeInt (mg_lgth);
        out.writeByte (msg_type.getValue());
        if ((_payload != null) && (_payload.length > 0)) {
            out.write (_payload, 0, _payload.length);
        }
    }

    public static Message getInstance (int lgth, Type types) throws ClassNotFoundException, IOException {
        switch (types) {
            case Choke:
                return new Choke();

            case Unchoke:
                return new Unchoke();

            case Interested:
                return new Interested();

            case NotInterested:
                return new NotInterested();

            case Have:
                return new Have (new byte[lgth]);

            case BitField:
                return new Bitfield (new byte[lgth]);

            case Request:
                return new Request (new byte[lgth]);

            case Piece:
                return new Piece (new byte[lgth]);

            default:
                throw new ClassNotFoundException ("message type not handled: " + types.toString());
        }
    }
}
