/**
 * Other synonyms for different Request types
 */
package messages;

public enum Type {
    Choke ((byte) 0),
    Unchoke ((byte) 1),
    Interested ((byte) 2),
    NotInterested ((byte) 3),
    Have ((byte) 4),
    BitField ((byte) 5),
    Request ((byte) 6),
    Piece ((byte) 7);

    private final byte types;
    
    Type (byte mg_type) {
        types = mg_type;
    }

    public byte getValue() {
        return types;
    }

    public static Type valueOf (byte bt) {
        for (Type iter_tp : Type.values()) {
            if (iter_tp.types == bt) {
                return iter_tp;
            }
        }
        throw new IllegalArgumentException();
    }
}
