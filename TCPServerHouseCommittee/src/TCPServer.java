import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class TCPServer {
    public static void main(String argv[]) throws Exception
    {

        ServerSocket s = null;
        Sql sql =new Sql(); //create sql object
        
        try {
            s = new ServerSocket(10000); // creat a new socket in port 10000
            sql.ConectingToSQL();  //connecting to the sql database
            System.out.println("Server is On:");
        } catch(IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        // A loop that the server will always be available...
        while (true) {
            Socket incoming = null;
            try {
            	// Listens for a connection to be made to this socket and acceptsit.
            	// The method blocks until a connection is made. 
                incoming = s.accept(); 
            } catch(IOException e) {
                System.out.println(e);
                continue;
            }
            // create a new socket and start connection with the client.
            new socketHandler(incoming,sql).start();

        }
    }
}
