package p2pcomm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface Serializable {
	public void read(DataInputStream in) throws IOException;
    public void write(DataOutputStream out) throws IOException;

}
