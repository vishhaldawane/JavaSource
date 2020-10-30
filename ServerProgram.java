import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//port number 4000 is now occupied by us
		//default machine ip/localhost is considered
		//hence this socket is (localhost+4000)
public class ServerProgram {
	public static void main(String[] args) {
		try {
			System.out.println("Trying to create server...");
			ServerSocket servSock =new ServerSocket(4000);
			System.out.println("Server created...");
			
			
			
			boolean isRunning=true;
			while(isRunning)
			{
				System.out.println("Waiting for the client...");
				Socket clientSockHere = servSock.accept();
				System.out.println("Welcome Client!!! You are connected here : "+clientSockHere);
			}
			
			System.out.println("Trying to CLOSE server...");
			servSock.close();
			System.out.println("Server CLOSED");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
}
