/**
 * This class represents a message with payload
 */
package protocol;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class MessageWithPayload extends Message {
	protected MessageWithPayload(Type mg_type, byte[] mg_pay_load) {
		super(mg_type, mg_pay_load);
	}

	public int getPieceIndex() {
		return ByteBuffer.wrap(Arrays.copyOfRange(_payload, 0, 4)).order(ByteOrder.BIG_ENDIAN).getInt();
	}

	protected static byte[] getPieceIndexBytes(int piece_index) {
		return ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(piece_index).array();
	}
}
