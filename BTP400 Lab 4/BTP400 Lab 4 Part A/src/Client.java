/**
 * This is the Client Class
 * It creates an Account object, then uses object serialization to pass the account object to the server class along with 
 * whatever request the client would like to have accomplished by the server
 * @author Abdulbasid Guled
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

	public static void main(String[] args)
	{
		Bank bank = new Bank("Seneca@York");
		
		Account myAccount = new Account("Abdulbasid,Guled", "A5689", 1000.00);
		
		bank.addAccount(myAccount);
		
		Socket clientSocket;
		
		System.out.println(myAccount);
		
		try 
		{
			clientSocket = new Socket(InetAddress.getByName("localhost"), 4000);
			ObjectInputStream fromServer = new ObjectInputStream(clientSocket.getInputStream());
			ObjectOutputStream toServer = new ObjectOutputStream(clientSocket.getOutputStream());
			Scanner input = new Scanner(System.in);
			
			try
			{
				while (true)
				{
					System.out.println("Please state your operation of choice!");
					System.out.println("You can either deposit an amount, withdraw an amount, or quit to leave the server!");
					System.out.println("Enter (deposit/withdraw) followed by a space and then the amount you wish to deposit/withdraw, or type (quit) to close the application");
					
					String choice = input.nextLine();
					String[] userInput = choice.split("\\s");
					
					if (choice.equals("quit"))
					{
						System.out.println("Quitting the application, thank you!");
						toServer.writeObject("quit");
						toServer.flush();
						toServer.close();
						fromServer.close();
						clientSocket.close();
						break;
					}
					else if (userInput[0].equals("deposit"))
					{
						toServer.writeObject(choice);
						
						toServer.writeObject(myAccount);
						
						myAccount = (Account) fromServer.readObject();
						
						System.out.println();
						
						System.out.println(myAccount);
					}
					else if (userInput[0].equals("withdraw"))
					{
						toServer.writeObject(choice);
						toServer.writeObject(myAccount);
						
						myAccount = (Account) fromServer.readObject();
						
						System.out.println();
						
						System.out.println(myAccount);
					}
				}
			}
			catch (IOException io)
			{
				System.out.println("There was an I/O error, sorry!");
				io.getMessage();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}
}
