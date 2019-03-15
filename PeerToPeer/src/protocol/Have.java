/**
 * This class updates peers of the recently received piece
 */
package protocol;

public class Have extends MessageWithPayload {

	Have(byte[] piece_index) {
		super(Type.Have, piece_index);
	}

	public Have(int piece_index) {
		this(getPieceIndexBytes(piece_index));
	}
}
