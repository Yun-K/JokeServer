
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description: <br/>
 * Single Thread version of the Server. The multi Thread version is on the
 * MultiThreadServer Class.
 * <p>
 * The attribution of the code is from the website:
 * <p>
 * https://www.runoob.com/java/net-serversocket-socket.html
 * <p>
 * 1. The server establishes the communication ServerSocket
 * 
 * 2. The server establishes a Socket to receive client connections
 * 
 * 3.Create an IO input stream to read the data sent by the client
 * 
 * 4.Set up IO output flow to send data message to client
 * 
 * @author Yun Zhou 300442776
 * @version 1.0
 */
public class SingleThreadServer {

    /**
     * Jokes are from the website: https://www.rd.com/list/short-jokes/
     */
    private final String[] JOKES = {
            "What’s the best thing about Switzerland?\nI don’t know, but the flag is a big plus.",
            "Did you hear about the mathematician who’s afraid of negative numbers?\nHe'll stop at nothing to avoid them.",
            "Why do we tell actors to 'break a leg?'\nBecause every play has a cast.",
            "Hear about the new restaurant called Karma?\nThere’s no menu: You get what you deserve.",
            "Why don’t scientists trust atoms?\nBecause they make up everything.",
            "Why did the chicken go to the séance?\nTo get to the other side."
    };

    /**
     * Description: <br/>
     * Set up the Server.
     * 
     * The attribution of the code is from the website:
     * https://www.runoob.com/java/net-serversocket-socket.html
     * 
     * @author Yun Zhou
     */
    public void setUp() {
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            System.out.println(
                    "This is the normal single thread Server!\n" +
                               "Waiting for the Client to connect....");
            Socket socket = serverSocket.accept();

            // FOR LAB 2, PART2
            String ip_prefix = (InetAddress.getLocalHost().getHostAddress());

            socket.getInetAddress();
            System.out.println("Client:" + InetAddress.getLocalHost() +
                               " connected to the Server Successfully!\n" +
                               "The connection is established successfully!");

            //
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            // pick a joke and then write it and flush it
            String jokeString = pick_Joke();
            bw.write("\nIP:" + ip_prefix + " says: ");// prefix FOR LAB2,PART2
            bw.write(jokeString);
            bw.flush();
            bw.close();

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * Description: <br/>
     * Construct a String which contains: my name,Student ID and a joke from the
     * array.
     * 
     * The string is used for writing to the Client and will print it on the
     * Client consle
     * 
     * @author Yun Zhou
     * @return my name,Student ID and a joke from the array.
     */
    public String pick_Joke() {
        // random get the joke from the joke array
        int randomIndex = (int) (Math.random() * JOKES.length);
        String toReturn = "\nHello, Yun Zhou!\nYour Student ID: 300442776\n" +
                          "There is a joke for you. Enjoy :)\n";
        toReturn += JOKES[randomIndex];
        toReturn += "\n";
        return toReturn;
    }

    /**
     * A constructor. It construct a new instance of MyServer.
     *
     */
    public SingleThreadServer() {
        int i = 0;

        // once the Server send a joke to the CLient successfully, it will still
        // wait for the new CLient
        while (true) {
            // set up the Server
            setUp();
            i++;
            String suffix = "st";
            if (i == 2) {
                suffix = "nd";
            } else if (i == 3) {
                suffix = "rd";
            } else if (i >= 4) {
                suffix = "th";
            }

            System.out.println("\nThis is the " + i + suffix +
                               " time that this Server send a Joke to the Client\n");
        }
    }

    public static void main(String[] args) {
        new SingleThreadServer();
    }

}
