package p2p;
import java.net.*;
import java.io.*;

/**
 * 
 * @author Prudhvee Narasimha Sadha
 * @version 1.0
 * 
 * Client class represents a Client in the protocol
 *
 */
public class Client {
	
	//Socket used to connect to the server
    private Socket clientSocket;           
    
    //Output stream to write the data to the socket
    private ObjectOutputStream outStream;        
    
    //Input stream to read the data from the socket
    private ObjectInputStream inStream;
    
    //message to send to the server
    private String outMessage;
    
    //Message to read from the server.
    private String inMessage;

    void run()
    {
        try{
            //Creating the client socket
            clientSocket = new Socket("localhost", 8000);
            System.out.println("created the socket at localhost:8000");
            
            //Initializing the Input and Output Stream
            outStream = new ObjectOutputStream(clientSocket.getOutputStream());
            outStream.flush();
            inStream = new ObjectInputStream(clientSocket.getInputStream());

            //Continuously, read the data from STDIN and send the message
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while(true)
            {
                System.out.print("Hey!!I am here to send your message. Please type in your message");
                outMessage = bufferedReader.readLine();
                sendMessage(outMessage);
                inMessage = (String)inStream.readObject();
                System.out.println("Got a message for you: " + inMessage);
            }
        }
        catch (ConnectException e) {
            System.err.println("Connection refused. Sorry, I cannot run without a server");
        }
        catch ( ClassNotFoundException e ) {
            System.err.println("Class not found");
        }
        catch(UnknownHostException unknownHost){
            System.err.println("Sorry!! I couldn't understand the host information");
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
        finally{
            //Close connections
            try{
                inStream.close();
                outStream.close();
                clientSocket.close();
            }
            catch(IOException ioException){
                ioException.printStackTrace();
            }
        }
    }
    
    //write the input message to the output stream
    void sendMessage(String msg)
    {
        try{
            outStream.writeObject(msg);
            outStream.flush();
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    
    
    public static void main(String args[])
    {
        Client client = new Client();
        client.run();
    }

    
    //Getters and Setters for the variables
	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public ObjectOutputStream getOutStream() {
		return outStream;
	}

	public void setOutStream(ObjectOutputStream outStream) {
		this.outStream = outStream;
	}

	public ObjectInputStream getInStream() {
		return inStream;
	}

	public void setInStream(ObjectInputStream inStream) {
		this.inStream = inStream;
	}

	public String getOutMessage() {
		return outMessage;
	}

	public void setOutMessage(String outMessage) {
		this.outMessage = outMessage;
	}

	public String getInMessage() {
		return inMessage;
	}

	public void setInMessage(String inMessage) {
		this.inMessage = inMessage;
	}

}
