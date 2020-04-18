/*public class BankTester {

	public static void main(String[] args) {
		
		String accountNames[]   = { "John Doe", "Mary Ryan", "Peter Liu", 
                "John Doe", "Peter Liu" };
		String accountNumbers[] = { "A1234", "B5678", "C9999", "A1234", "D8901" };
		int accountBalances[]   = { 1000, 3000, 5000, 7000, 3000 };

		Bank myBank = new Bank("Abdulbasid Guled");
		Bank newBank = new Bank();
		
		Account[] totalAccounts = new Account[5];
		
		System.out.println(myBank);
		
		for (int i = 0; i < totalAccounts.length; ++i)
		{
			totalAccounts[i] = new Account(accountNames[i], accountNumbers[i], accountBalances[i]);
			myBank.addAccount(totalAccounts[i]);
		}
		
	
		System.out.println(myBank);
		
		System.out.println(myBank.addAccount(null));
		
		System.out.println();
		
		Account found[] = myBank.searchByBalance(3000);
		
		System.out.println();
		
		Account nothing[] = myBank.searchByBalance(-1111);
		
		System.out.println();
		
		for (int i = accountNames.length - 1; i >= 0; --i)
		{
			Account temp = new Account(accountNames[i], accountNumbers[i], accountBalances[i]);
			newBank.addAccount(temp);
		}

		if (newBank.equals(newBank))
			System.out.println("Same Bank!");
		else
			System.out.println("Different Bank!");
		
		System.out.println();
		
		if (newBank.equals(myBank))
			System.out.println("Same Bank!");
		else
			System.out.println("Different Bank!");
		
		
		
	}

}
*/
