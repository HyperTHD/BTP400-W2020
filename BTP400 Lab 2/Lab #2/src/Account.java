/**
 * @author: Abdulbasid Guled, 
 * Student ID: 156024184
 * Email: aguled5@myseneca.ca
 * @version: 1.0
 * Last Modified: 13/01/2020
 * An Account object holds information about a person's name, account number, and current balance
 */
public class Account {

	private String fullName;
	private String accountNumber;
	private double balance;
	
	/**
	 * @param: Nothing
	 * @return: An object in an empty state
	 */
	public Account()
	{
		this(null, null, -1);
	}
	
	/**
	 * @param: String, String, double
	 * @return: An object with the data passed in
	 */
	
	public Account(String fullName, String accountNumber, double balance)
	{
		this.fullName = fullName;
		this.accountNumber = accountNumber;
		this.balance = balance;
		
		// Sets an object to an empty state if any of the conditions for the fields are satisfied
		
		if (fullName == null || accountNumber == null || balance < 0)
		{
			this.fullName = "";
			this.accountNumber = "";
			this.balance = 0;
		}
	}
	
	/**
	 * @param: Nothing
	 * @return: The person's full-name
	 */
	
	public String getFullName()
	{
		return fullName;
	}
	
	/**
	 * @param: Nothing
	 * @return: The person's account number
	 */
	
	public String getAccountNumber()
	{
		return accountNumber;
	}
	
	/**
	 * @param: Nothing
	 * @return: The person's balance
	 */
	
	public double getAccountBalance()
	{
		return balance;
	}
	
	/**
	 * @param: String
	 * @return: Nothing
	 */
	
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}
	
	/**
	 * @param: String
	 * @return: Nothing
	 */
	
	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	
	/**
	 * @param: int
	 * @return: Nothing
	 */
	
	public void setAccountBalance(double balance)
	{
		this.balance = balance;
	}

	/**
	 * @param: Nothing
	 * @return: A string representation of an Account object
	 */
	
	public String toString()
	{
		return "Account Name   : " + getFullName() + "\n"
			+   "Account Number : " + getAccountNumber() + "\n"
			+ "Balance        : $" + String.format("%.2f", getAccountBalance()) + "\n";
	}
	
	/**
	 * Equals method checks if 2 Account objects are equal to each other.
	 * 2 Account objects are equal if both of their full names, account number, and account balance are equal
	 * 
	 * @Param: An object that can be typecasted
	 * @return: A boolean that resolves to either true or false if the 2 objects are the same
	 */
	
	@Override
	public boolean equals(Object obj)
	{
		boolean result = false; // By default, 2 objects are not equal to each other
		
		if (!(obj instanceof Account))
		{
			return result; // Return immediately if obj is not an Account object
		}
		else
		{
			Account temp = (Account) obj;
			
			if (fullName != null && accountNumber != null)
			{
				result = temp.accountNumber.equals(accountNumber) && temp.fullName.equals(fullName) && temp.balance == balance;
			}
		}
		return result;
	}
}
