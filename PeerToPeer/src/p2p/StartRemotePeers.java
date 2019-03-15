package p2p;
/*
 * This is the program starting remote peer processes..
 * If you use another environment, for example, linux environment in CISE
 * or other environments not in CISE, it is not guaranteed to work properly.
 * It is your responsibility to adapt this program to your running environment.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

/*
 * The StartRemotePeers class begins remote peer processes.
 * It reads configuration file PeerInfo.cfg and starts remote peer processes.
 * Please look at the lines below the comment saying IMPORTANT.
 */
public class StartRemotePeers {

    public Vector<RemotePeerInfo> peerInfoVector;

    public void getConfiguration(Vector<RemotePeerInfo> peerInfoVector)
    {
        String st;
        try {
            BufferedReader in = new BufferedReader(new FileReader("PeerInfo.cfg"));
            while((st = in.readLine()) != null) {

                String[] tokens = st.split("\\s+");
                peerInfoVector.addElement(new RemotePeerInfo(tokens[0], tokens[1], tokens[2], tokens[3].equals("1")));
            }
            in.close();
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public static void main(String[] args) {
        try {
            StartRemotePeers myStart = new StartRemotePeers();
            Vector<RemotePeerInfo> peerInfoVector = new Vector<RemotePeerInfo>();
            myStart.getConfiguration(peerInfoVector);

            //Get the user directory
            String path = System.getProperty("user.dir");

            final int peerId = Integer.parseInt(args[0]);
            String address = "localhost";
            int port = 6003;
            boolean hasFile = false;

            // start all the client at the remote hosts
            for (int i = 0; i < myStart.peerInfoVector.size(); i++) {
                RemotePeerInfo pInfo = (RemotePeerInfo) myStart.peerInfoVector.elementAt(i);

                System.out.println("Start remote peer " + pInfo.getPeerId() +  " at " + pInfo.getIpAddress() );

                Runtime.getRuntime().exec("ssh " + pInfo.getIpAddress() + " cd " + path + "; java peerProcess " + pInfo.peerId);

            }
            System.out.println("Starting all remote peers has done." );

            //Node localNode = new Node (peerId, address, port, hasFile, peerInfoVector);

        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
