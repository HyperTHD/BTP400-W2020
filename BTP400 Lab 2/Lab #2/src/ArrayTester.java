
public class ArrayTester {

	public static void main(String[] args) {
		
		Account list[] = new Account[7];
		
		list[0] = new Account("Peter Liu", "A12345", 5000);
		list[1] = new Account("Peter Liu", "A67890", 6000);
		list[2] = new Account("Abraham Lincoln", "Z6789", 7777);
		list[3] = new Account("Peter Liu", "A12345", 5000);
		list[4] = new Account("Abdulbasid Guled", "E3333", 9000);
		list[5] = new Account("Abraham Lincoln", "Z6789", 7777);
		list[6] = new Account("Abraham Lincoln", "Z6789", 7777);
		
		
		int counterList[] = new int[list.length];
		
		boolean continueOn = true; // exit condition
		
		System.out.println("COUNTING SUMMARY");
		System.out.println("+ total number of accounts: " + list.length);
		
		int i = 0, count = 1;
		
		int grab[] = {0, 1, 2, 4};
				
		do {
		
			counterList[i] = counter(list, list[grab[i]]);
			
			System.out.println(count + ". " + list[grab[i]].getFullName() + ", " + list[grab[i]].getAccountNumber() + ", " + String.format("%.2f", list[grab[i]].getAccountBalance()) + ": " + counterList[i]);
			
			count++;
			i++;
			
			if (i >= 4) // Should exit do-while when completed
				continueOn = false;
			
		} while (continueOn);
		
	}
	
	
	public static int counter(Account[] array, Account obj)
	{
		int counter = 0;
		
		if (array.length == 0)
			return counter;
			
			
		for (int i = 0; i < array.length; ++i)
		{
			if (array[i].equals(obj))
			{
				counter++;
			}
		}
		
		return counter;
	}
}
