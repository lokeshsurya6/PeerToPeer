package p2p;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This Class maintains states of Remote Peers
 */
public class RemotePeerInfo {
    public final String peerId;
    public final String ipAddress;
    public final String port;
    public final boolean hasFile;
    public AtomicInteger bytesDownloaded;
    public BitSet bitSet;
    private final AtomicBoolean isInterested;

    public RemotePeerInfo (int peerId) {
        this (Integer.toString (peerId), "127.0.0.1", "0", false);
    }

    public RemotePeerInfo(String pId, String pAddress, String pPort, boolean hasFile) {
        peerId = pId;
        ipAddress = pAddress;
        port = pPort;
        this.hasFile = hasFile;
        bytesDownloaded = new AtomicInteger (0);
        bitSet = new BitSet();
        isInterested = new AtomicBoolean (false);
    }

    public int getPeerId() {
        return Integer.parseInt(peerId);
    }

    public int getPort() {
        return Integer.parseInt(port);
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public boolean hasFile() {
        return hasFile;
    }

    public boolean isInterested() {
        return isInterested.get();
    }

    public void setInterested() {
        isInterested.set (true);
    }

    public void setNotIterested() {
        isInterested.set (false);
    }

}
