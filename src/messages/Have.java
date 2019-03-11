/**
 * This class provides request of type Haveto update peers of the recently received piece and this class extends Message.
 */
package messages;

public class Have extends MessageWithPayload {

    Have (byte[] piece_index) {
        super (Type.Have, piece_index);
    }

    public Have (int piece_index) {
        this (getPieceIndexBytes (piece_index));
    }
}
