import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Description: <br/>
 * The attribution of the code is from the website:
 * <p>
 * https://www.runoob.com/java/net-serversocket-socket.html
 * 
 * @author Yun Zhou 300442776
 * @version 1.0
 */
@SuppressWarnings("unused")
public class MyClient {

    // private final String IP_ADDRESS = "52.4.118.218";

    /**
     * challenge2 part 1 ip address.
     */
    private final String IP_ADDRESS = "3.80.30.33";

    private final int PORT = 5555;

    /**
     * 
     * Description: <br/>
     * Set up the Client.
     * 
     * The attribution of the code is from the website:
     * <p>
     * https://www.runoob.com/java/net-serversocket-socket.html
     * 
     * @author Yun Zhou
     */
    private void setUp() {
        try {
            // Socket socket = new Socket(IP_ADDRESS, PORT);// for docker

            // for lab2 part2_A
            // Socket socket = new Socket("54.89.69.172", 5555);

            // for lab2 part2_B
            // Socket socket = new Socket("100.24.64.74", 5555);

            // Socket socket = new
            // Socket("LoadBalancer-337451979.us-east-1.elb.amazonaws.com",
            // 5555);

            // Socket socket = new Socket("100.26.110.212", 5555);
            Socket socket = new Socket("54.89.172.149", 5555);

            // Construct IO
            InputStream inputStream = socket.getInputStream();

            // OutputStream outputStream = socket.getOutputStream();
            // write a message to the Server
            // BufferedWriter bufferedWriter = new BufferedWriter(new
            // OutputStreamWriter(outputStream));
            // bufferedWriter.write("Hi, I am a client and I need a joke\n");
            // bufferedWriter.flush();

            // read the returned message from the Server and print it
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String message = null;

            // print everything until the end
            while ((message = bufferedReader.readLine()) != null) {
                System.out.println(message);
            }
            Thread.sleep(2500);

            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * A constructor. It construct a new instance of MyClient.
     *
     */
    public MyClient() {
        // for (var i = 0; i < 10; i++) {
        setUp();
        // }
    }

    public static void main(String[] args) {
        new MyClient();
    }

}
