package p2pcomm;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;

import protocol.Handshake;
import protocol.Message;
import protocol.Type;


public class SerializableInputStream extends DataInputStream implements ObjectInput {

    private boolean isHandshakeDone = false;

    public SerializableInputStream(InputStream in) {
        super(in);
    }

    @Override
    public Object readObject() throws ClassNotFoundException, IOException {
        if (isHandshakeDone) {
            final int length = readInt();
            final int payloadLength = length - 1; // subtract 1 for the message type
            Message message = Message.getInstance(payloadLength, Type.valueOf (readByte()));
            message.read(this);
            return message;
        }
        else {
            Handshake handshake = new Handshake();
            handshake.read(this);
            isHandshakeDone = true;
            return handshake;
        }
    }
}