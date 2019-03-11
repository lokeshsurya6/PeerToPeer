/**
 * This class provides request of type request to appeal particular piece from its peers and the class extends Message .
 */
package messages;

public class Request extends MessageWithPayload {

    Request (byte[] piece_index) {
        super (Type.Request, piece_index);
    }

    public Request (int piece_index) {
        this (getPieceIndexBytes (piece_index));
    }
}
