/**
 * @author Prudhvee Narasimha Sadha
 * @version 1.0
 * Enum of all the fields in a sharing process
 */
package protocol;

public enum Type {
	Choke((byte) 0), Unchoke((byte) 1), Interested((byte) 2), NotInterested((byte) 3), Have((byte) 4),
	BitField((byte) 5), Request((byte) 6), Piece((byte) 7);

	private final byte type;

	Type(byte mg_type) {
		type = mg_type;
	}

	public byte getValue() {
		return type;
	}

	public static Type valueOf(byte bt) {
		for (Type iter_tp : Type.values()) {
			if (iter_tp.type == bt) {
				return iter_tp;
			}
		}
		return null;
	}
}
