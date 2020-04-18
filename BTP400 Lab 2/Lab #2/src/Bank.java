import java.util.ArrayList;

public class Bank {

	private ArrayList<Account> user;
	private String name;
	
	public Bank()
	{
		user = new ArrayList<Account>();
		name = "Seneca@York";
	}
	
	public Bank(String name)
	{
		this.name = name;
		user = new ArrayList<Account>();
	}
	
	
	public String getName() { return name; }
	
	public boolean addAccount(Account newAccount)
	{
		boolean result = false; // assume we haven't added any account yet
		
		if (newAccount == null)
		{
			return result; // if the added account is null, immediately return false
		}
				
		else 
		{
			for (Account account : user)
			{
				if (account.getAccountNumber().equals(newAccount.getAccountNumber()))
				{
					return result;
				}
			}
		
			user.add(newAccount);
			result = true;			
		}
		
		return result;
	}
	
	public String toString()
	{

		String result;

		result = "*** Welcome to the Bank of " + 
		this.name + " ***\n" + "It has " + this.user.size() + " user.\n";

		for (int i = 0; i < user.size(); i++) {
			result += i + 1 + ". number: " + this.user.get(i).getAccountNumber() + ", name: " + this.user.get(i).getFullName()
					+ ", balance: $" + String.format("%d", (int) this.user.get(i).getAccountBalance()) + "\n";
		}
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		boolean result = false; // Assume they aren't equal
		
		if (obj instanceof Bank)
		{
			
			Bank temp = (Bank) obj;
			
			if(this.name.equals(temp.name))
			{
				for (int i = 0; i < user.size(); ++i)
				{
					if(this.user.get(i).equals(temp.user.get(i)))
					{
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	
	public Account[] searchByBalance(double balance)
	{
		int count = 1;
		Account[] found = null;
		ArrayList<Account> toBeCopied = new ArrayList<Account>();
		
		if (balance < 0)
		{
			System.out.println("*** NO ACCOUNT FOUND ***");
			return found;
		}
		
		for (Account acc : user)
		{
			if (acc.getAccountBalance() == balance)
			{	
				toBeCopied.add(acc);
			}
		}
		
		found = new Account[toBeCopied.size()];
		
		found = toBeCopied.toArray(found);
		
		System.out.println("We have found " + found.length + " accounts whose balance is " + String.format("%d", (int)balance) + ".");
		
		for (int i = 0; i < found.length; ++i)
		{
			System.out.println(count + ". number: " + found[i].getAccountNumber() + ", name: " + found[i].getFullName());
			count++;
		}
		
		
		return found;
	}
}
