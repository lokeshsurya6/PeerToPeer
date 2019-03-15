package p2p;

/**
 * @author Prudhvee Narasimha Sadha
 * @version 1.0
 * This class will provide k preferred neighbors and one optimistically unchoked neighbor for every unchoking interval.
 */
public class PeerManager implements Runnable {
    private final int numberOfOptimisticallyUnchokedNeighbors = 1;
    private final int optimisticUnchokingInterval;
    private final int unchokingInterval;

    public PeerManager(int unchokingInterval,int optimisticUnchokingInterval) {
        this.unchokingInterval = unchokingInterval;
        this.optimisticUnchokingInterval = optimisticUnchokingInterval;
    }

    /**
     * Every unchoking interval, perform following steps :
     * calculate downloading speed in previous interval
     * get list of interested neighbors
     * select top k according to download speed and unchoke the choked ones among them
     * Every optimistic unchoking interval, select a random choked and interested neighbour and unchoke it.
     */
    @Override
    public void run() {

    }

	public int getNumberOfOptimisticallyUnchokedNeighbors() {
		return numberOfOptimisticallyUnchokedNeighbors;
	}

	public int getOptimisticUnchokingInterval() {
		return optimisticUnchokingInterval;
	}

	public int getUnchokingInterval() {
		return unchokingInterval;
	}
}
