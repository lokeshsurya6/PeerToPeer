package main;

/**
 * @author Prudhvee Narasimha Sadha
 * @version 1.0
 * This class will includes the functionality to allow a local peer to download the 
 * piece from the remote peer when unchoked by the remote peer 
 */

public class PeerContentDownloader implements Runnable {
    private final int localPeerId;
    private final int localPort;
    private final int remotePeerId;
    private final int remotePort;

    public PeerContentDownloader(int localPeerId, int remotePeerId, int remotePort, int localPort) {
        this.localPeerId = localPeerId;
        this.remotePeerId = remotePeerId;
        this.remotePort = remotePort;
        this.localPort = localPort;
    }

    /**
     * When unchoked, the following steps are performed:
     * 1.randomly select a piece that is not available with the local peer and
     * is not requested from any other peer and should be available with the remote peer.
     * 2.Request this piece from the remote peer
     * 3.When piece is available, repeat Step 1 until choked or not interested in the piece available with the remote peer.
     */
    @Override
    public void run() {

    }

    
    //Getters and Setters for the variables
	public int getLocalPeerId() {
		return localPeerId;
	}

	public int getRemotePeerId() {
		return remotePeerId;
	}

	public int getRemotePort() {
		return remotePort;
	}

	public int getLocalPort() {
		return localPort;
	}
}
