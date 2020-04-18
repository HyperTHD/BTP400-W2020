/**
 * This is the FindWord class, a Thread class. 
 * It's purpose is to run an application that searches an ArrayList for rows that contain the word "java"
 * Implements the Runnable Interface
 * 
 * @author Abdulbasid Guled
 */
import java.util.ArrayList;
import java.util.Random;

public class FindWord implements Runnable {

	private ArrayList<String> data;
	private ArrayList<String> foundWord;
	private static final String word = "java"; // The word that we're trying to find inside the ArrayList
	
	
	/**
	 * Initializes the ArrayLists
	 * 
	 * @param String
	 */
	public FindWord(String[] s)
	{
		data = new ArrayList<String>();
		
		for (String word : s)
			data.add(word);
		
		foundWord = new ArrayList<String>();
	}
	
	/**
	 * Overridden method that runs the FindWord
	 * @param Nothing
	 * @return Nothing
	 */
	public void run()
	{
		Random rn = new Random();
		
		int random = rn.nextInt(2000 - 100 + 1) + 100;
		
		try 
		{
			Thread.sleep(random);
		}
		catch(InterruptedException ex) 
		{
			System.out.println(ex);
		}
		
		for (int i = 0; i < data.size(); ++i)
		{
			if (data.get(i).contains(word))
				foundWord.add(data.get(i));
		}
		
	}
	
	/**
	 * Returns the ArrayList with the found words
	 * @param Nothing
	 * @return ArrayList<String>
	 */
	
	public ArrayList<String> Found() 
	{
		return foundWord;
	}
	
	/**
	 * Public getter method to access static field variable
	 * @param nothing
	 * @return String
	 */
	
	public static String getWord()
	{
		return word;
	}
	
}
