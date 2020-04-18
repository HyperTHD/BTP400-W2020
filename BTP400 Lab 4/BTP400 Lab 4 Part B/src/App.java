import java.util.ArrayList;
public class App {

	public static void main(String[] args)
	{
		 String [][] data = {
				 { "java", "I love java", "c++", "python" },
				 { "c programs", "cookies", "java developers", "oops"},
				 { "john", "doe", "mary", "mark holmes"},
				 { "hello java java", "byebye", "java again?", "java what?"},
				 { "toronto", "montreal", "quebec city", "calgary"} 
		 };
		
		 ArrayList<String> found = new ArrayList<String>();
		 
		 Thread[] th = new Thread[data.length];
		 FindWord[] toFind = new FindWord[data.length];
		 
		 for (int i = 0; i < data.length; ++i)
		 {
			 toFind[i] = new FindWord(data[i]);
			 th[i] = new Thread(toFind[i]);
			 th[i].start();
		 }
		 
		 int counter = 0;
		 
		 System.out.println("+ search word: " + FindWord.getWord());
	     System.out.println("+ summary");
		 try {
		      for(int i = 0; i < data.length; i++) {

		        th[i].join();
		        found = toFind[i].Found();
		        counter += found.size();
		       
		        if(found.size() > 0) {
		          System.out.print("  row " + (i+1) + ": ");
		          String del = "";
		          for(String s : found) {
		            System.out.print(del + s);
		            del = ", ";
		          }
		          System.out.print("\n");
		        } 
		        else
		          System.out.println("  row " + (i+1) + ": ***");
			    }
		    }
		    catch(InterruptedException ex) {
		    	System.out.println(ex);
		    }

		    System.out.println("+ total number of strings found: " + counter);
			}
	}
	

