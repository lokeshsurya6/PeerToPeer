package p2p;

import java.util.BitSet;
import java.util.Vector;

/**
 * @author Prudhvee Narsimha Sadha
 * @version 1.0
 * The class represents a Local Node in the network
 */

public class Node implements Runnable {
	//IP Address of the node
    private final int ipAddress;
    
    //Port number to connect to the node.
    private final int port;
    
    //flag to tell if the Node has the file
    private final boolean hasFile;
    
    //Peer Manager for the node.
    private final PeerManager peerMgr;
    
    //List of all the remote peers
    private Vector<RemotePeerInfo> remotePeers;
    
    //Bits
    public BitSet bitSet;

    public Node(int peerId, String address, int port, boolean hasFile, Vector<RemotePeerInfo> peerInfo) {
        ipAddress = peerId;
        this.port = port;
        this.hasFile = hasFile;
        this.remotePeers = peerInfo;
        this.peerMgr = new PeerManager(5,10);
    }

    /**
     * 1.Opens the socket connection at the mentioned port
     * 2.Initialize the peer manager to select the k preferred neighbors and one optimistically unchoked neighbor.
     * 3.Maintains a list of its own bitset
     * 4.Establishes connection to remote peers
     * 5.Informs remote peers about the new piece it received by sending haveRequest.
     */
    @Override
    public void run() {
    }

    //Getters and Setters for the variables
	public Vector<RemotePeerInfo> getRemotePeers() {
		return remotePeers;
	}

	public void setRemotePeers(Vector<RemotePeerInfo> remotePeers) {
		this.remotePeers = remotePeers;
	}

	public BitSet getBitSet() {
		return bitSet;
	}

	public void setBitSet(BitSet bitSet) {
		this.bitSet = bitSet;
	}

	public int getIpAddress() {
		return ipAddress;
	}

	public int getPort() {
		return port;
	}

	public boolean isHasFile() {
		return hasFile;
	}

	public PeerManager getPeerMgr() {
		return peerMgr;
	}
}

