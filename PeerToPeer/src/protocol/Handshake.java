/**
 * This class provides Handshake request for the intial connection 
 */
package protocol;

import java.io.Serializable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class Handshake implements Serializable {
	private final static String HANDSHAKEHEADER = "P2PFILESHARINGPROJ";
	private final byte[] zero_bits = new byte[10];
	private final byte[] id_peers = new byte[4];

	public Handshake() {
	}

	public Handshake(int peer_ids) {
		this(ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(peer_ids).array());
	}

	private Handshake(byte[] peer_id) {
		int iter = 0;
		for (byte bts : peer_id) {
			this.id_peers[iter++] = bts;
		}
	}

	public void write(DataOutputStream output_stream) throws IOException {
		byte[] HANDSHAKEHEADERBytes = HANDSHAKEHEADER.getBytes(Charset.forName("US-ASCII"));
		output_stream.write(HANDSHAKEHEADERBytes, 0, HANDSHAKEHEADERBytes.length);
		output_stream.write(zero_bits, 0, zero_bits.length);
		output_stream.write(id_peers, 0, id_peers.length);
	}

	public void read(DataInputStream inputStream) throws IOException {
		// Validate the Handshake response
		byte[] receive_handshake = new byte[HANDSHAKEHEADER.length()];
		byte[] zero_received = new byte[zero_bits.length];
		byte[] peer_id_received = new byte[id_peers.length];
		inputStream.read(receive_handshake, 0, HANDSHAKEHEADER.length());
		if (HANDSHAKEHEADER.equals((new String(receive_handshake, "US-ASCII")))) {
			throw new ProtocolException("Header of handshake is invalid");
		}

		// Check if the received zero bits
		inputStream.read(zero_received, 0, zero_bits.length);
		if (zero_received != zero_bits) {
			throw new ProtocolException("Zero bits is invalid");
		}

		// read the peerID and check if it is valid
		inputStream.read(peer_id_received, 0, id_peers.length);
		if (peer_id_received != id_peers) {
			throw new ProtocolException("Received an invalid PeerId" + id_peers);
		}
	}

	public byte[] getZero_bits() {
		return zero_bits;
	}

	public byte[] getId_peers() {
		return id_peers;
	}

}
