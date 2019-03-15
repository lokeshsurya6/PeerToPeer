/**
 * This class represents a request to appeal a particular piece from its peers
 */
package protocol;

public class Request extends MessageWithPayload {

	Request(byte[] piece_index) {
		super(Type.Request, piece_index);
	}

	public Request(int piece_index) {
		this(getPieceIndexBytes(piece_index));
	}
}
