package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	//Port number for the server to listen to
    private static final int sPort = 8000;

    public static void main(String[] args) throws Exception {
        System.out.println("Hey there!! I am here to serve you. I am currently open at port: " + sPort);
        ServerSocket listener = new ServerSocket(sPort);
        int clientNum = 1;
        try {
            while(true) {
                new Handler(listener.accept(),clientNum).start();
                System.out.println("The client" + clientNum + " is connected for sharing");
                clientNum++;
            }
        } finally {
            listener.close();
        }

    }

    /**
     * A handler thread class.  Handlers are spawned from the listening
     * loop and are responsible for dealing with a single client's requests.
     */
    private static class Handler extends Thread {
    	//message received by the client
        private String inMessage;    
        
        //message send from the client
        private String outMessage;   
        
        //Socket of the client
        private Socket connection;
        
        //input stream to read the message
        private ObjectInputStream inStream;
        
        //output stream to write the message
        private ObjectOutputStream outStream;
        
        ////The index number of the client
        private int index;

        public Handler(Socket connection, int index) {
            this.connection = connection;
            this.index = index;
        }

        public void run() {
            try{
                //initialize Input and Output streams
                outStream = new ObjectOutputStream(connection.getOutputStream());
                outStream.flush();
                inStream = new ObjectInputStream(connection.getInputStream());
                try{
                    while(true)
                    {
                        //receive the message sent from the client
                        inMessage = (String)inStream.readObject();
                        //show the message to the user
                        System.out.println("Receive message: " + inMessage + " from client " + index);
                        //Capitalize all letters in the message
                        outMessage = inMessage.toUpperCase();
                        //send outMessage back to the client
                        sendMessage(outMessage);
                    }
                }
                catch(ClassNotFoundException classnot){
                    System.err.println("Data received in unknown format");
                }
            }
            catch(IOException ioException){
                System.out.println("Disconnect with Client " + index);
            }
            finally{
                //Close connections
                try{
                    inStream.close();
                    outStream.close();
                    connection.close();
                }
                catch(IOException ioException){
                    System.out.println("Disconnect with Client " + index);
                }
            }
        }

        //send a message to the output stream
        public void sendMessage(String msg)
        {
            try{
                outStream.writeObject(msg);
                outStream.flush();
                System.out.println("Send message: " + msg + " to Client " + index);
            }
            catch(IOException ioException){
                ioException.printStackTrace();
            }
        }

    }

}

