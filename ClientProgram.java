import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientProgram {
	public static void main(String[] args) {
		try {
			System.out.println("Trying to connect to the server...");
			Socket sock =new Socket("DESKTOP-EPTT35F",4000);
			System.out.println("Aha!! Connected to the server..."+sock);
			System.out.println("Trying to CLOSE the Client's connection...");
			sock.close();
			System.out.println("Client is CLOSED");
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
}
