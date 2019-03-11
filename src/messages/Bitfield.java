/**
 * Class provides bit_field as payload for request of type BitField and it also extends message
 */
package messages;

import java.util.BitSet;

public class Bitfield extends Message {

    Bitfield (byte[] bit_field) {
        super (Type.BitField, bit_field);
    }

    public Bitfield (BitSet bit_set) {
        super (Type.BitField, bit_set.toByteArray());
    }

    public BitSet get_bit_set() {
        return BitSet.valueOf (_payload);
    }
}
