/**
 * This class provides request of type Handshake in the initial connection phase and the class extends Message 
 */
package messages;

import java.io.Serializable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class Handshake implements Serializable {
    private final static String handshakeHeader = "P2PFILESHARINGPROJ";
    private final byte[] zero_bits = new byte[10];
    private final byte[] id_peers = new byte[4];

    public Handshake() {
    }

    public Handshake (int peer_ids) { this (ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(peer_ids).array());
    }

    private Handshake (byte[] peer_id){
        int iter = 0;
        //TODO: int to byte
        for (byte bts : peer_id) {
            this.id_peers[iter++] = bts;
        }
    }

    public void write(DataOutputStream output_stream) throws IOException {
        byte[] handshakeHeaderBytes = handshakeHeader.getBytes(Charset.forName("US-ASCII"));
        output_stream.write (handshakeHeaderBytes, 0, handshakeHeaderBytes.length);
        output_stream.write(zero_bits, 0, zero_bits.length);
        output_stream.write(id_peers, 0, id_peers.length);
    }

    public void read (DataInputStream inputStream) throws IOException {
        // check the header of handshake after reading
        byte[] receive_handshake = new byte[handshakeHeader.length()];
        byte[] zero_received = new byte[zero_bits.length];
        byte[] peer_id_received = new byte[id_peers.length];
        inputStream.read(receive_handshake, 0, handshakeHeader.length());
        if (handshakeHeader.equals((new String(receive_handshake, "US-ASCII")))) {
            throw new ProtocolException ("Header of handshake is invalid");
        }

        //check the zero bits after reading
        inputStream.read(zero_received, 0, zero_bits.length);
        if (zero_received != zero_bits) {
            throw new ProtocolException ("Zero bits is invalid");
        }

        // first read and then check the peer id
        inputStream.read(peer_id_received, 0, id_peers.length);
        if (peer_id_received != id_peers) {
            throw new ProtocolException ("Peer Id is not valid" + id_peers);
        }
    }

}
