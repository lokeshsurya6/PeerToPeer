/**
 * This class represents a piece of message to send to its peers
 */
package protocol;

import java.util.Arrays;

public class Piece extends MessageWithPayload {

	Piece(byte[] py_load) {
		super(Type.Piece, py_load);
	}

	public Piece(int piece_index, byte[] bt_cnt) {
		super(Type.Piece, join(piece_index, bt_cnt));
	}

	public byte[] getContent() {
		if ((_payload == null) || (_payload.length <= 4)) {
			return null;
		}
		return Arrays.copyOfRange(_payload, 4, _payload.length);
	}

	/**
	 * Concat 4 byte piece index and piece for payload
	 */
	private static byte[] join(int piece_index, byte[] byte_piece) {
		byte[] pay_load = new byte[4 + (byte_piece == null ? 0 : byte_piece.length)];
		System.arraycopy(getPieceIndexBytes(piece_index), 0, pay_load, 0, 4);
		System.arraycopy(byte_piece, 0, pay_load, 4, byte_piece.length);
		return pay_load;
	}
}
