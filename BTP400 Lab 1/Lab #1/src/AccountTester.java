
public class AccountTester {
	
	public static void main(String[] args)
	{
		Account acc1, acc2, acc3;
		
		acc1 = new Account(null, null, -1);
		acc2 = new Account("Abdulbasid Guled", "TD67890", 9670.85);
		acc3 = new Account("Peter Liu", "TD12345", 1000.99);
		
		System.out.print(acc1);
		System.out.println();
		System.out.print(acc2);
		System.out.println();
		System.out.print(acc3);
	}
}
