/**
 * This is the Server Class
 * It accepts an Account object passed from a Client code through object de-serialization which 
 * is then used to process the request the clients wants to accomplish, before sending the updated object
 * back to the client
 * 
 * @author Abdulbasid Guled
 */
import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) throws ClassNotFoundException
	{
		ServerSocket serverSocket;
		
		System.out.println("Seneca@York Bank Server is running!");
		
		try
		{

			serverSocket = new ServerSocket(4000);
			Socket socketConnection = serverSocket.accept();
			ObjectOutputStream toClient = new ObjectOutputStream( socketConnection.getOutputStream() );
			ObjectInputStream  fromClient = new ObjectInputStream( socketConnection.getInputStream() );
		
		
			try
			{
				while (true) 
				{
					String userInput = (String) fromClient.readObject();
					String[] input = userInput.split("\\s");
					
					if (input[0].equals("quit")) 
					{
						System.out.println("Thank you for using this application! We hope to see you again soon!");
						toClient.flush();
						toClient.close();
						fromClient.close();
						socketConnection.close();
					}
					else if (input[0].equals("deposit"))
					{
						double toDeposit = Double.parseDouble(input[1]);
						Account obj = (Account) fromClient.readObject();
						System.out.println("Depositing $" + String.format("%.2f", toDeposit));
						obj.deposit(toDeposit);
						toClient.writeObject(obj);
						toClient.flush();
					}
					else if (input[0].equals("withdraw"))
					{
						double toDeposit = Double.parseDouble(input[1]);
						Account obj = (Account) fromClient.readObject();
						System.out.println("Withdrawing $" + String.format("%.2f", toDeposit));
						obj.withdraw(toDeposit);
						toClient.writeObject(obj);
						toClient.flush();
					}
				}
			}
			catch (EOFException eof)
			{
				System.out.println("The client has disconnected from the server!");
			}
			
		}
		catch(IOException ex)
		{
			System.out.println("There was an I/O error during the socket connection");
			System.out.println(ex.getMessage());
		}
	}
}
