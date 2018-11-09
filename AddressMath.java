import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressMath {

	public static void main(String[] args) throws FileNotFoundException
	{
		//creates scanner object and new array list
		Scanner file = new Scanner(new File("GettysburgAddress"));
		ArrayList<String> addressWords = new ArrayList<String>();
		
		//adds all words in speech to array list
		while (file.hasNext())
		{
			String word = file.next();
			addressWords.add(word);
		}
		
		//for each word in array list
		for (int i=0; i < addressWords.size(); i++)
		{
			String currentWord = addressWords.get(i);
			
			//removes punctuation from each word in list
			for (int n=0; n < currentWord.length(); n++)
			{
				//accounts for spaces, commas, and periods
				if (currentWord.charAt(n)==' '|| currentWord.charAt(n)==',' || currentWord.charAt(n)=='.')
				{
					addressWords.set(i, currentWord.substring(0, n));
				}
				
				//accounts for hyphens
				if (currentWord.charAt(n)=='-' && currentWord.charAt(n+1)!='-')
				{
					addressWords.set(i, currentWord.substring(0, n));
					addressWords.add(i+1, currentWord.substring(n+1));
				}
				
				//accounts for em dashes i.e. double hyphens
				else if (currentWord.charAt(n)=='-' && currentWord.charAt(n+1)=='-')
				{
					addressWords.set(i, currentWord.substring(0, n));
					addressWords.add(i+1, currentWord.substring(n+2));
				}
			}
		}
		
		//compares each element in array list to find and print longest word
		String longestWord = addressWords.get(0);
		for (int i=0; i < addressWords.size(); i++)
		{
			String currentWord = addressWords.get(i);
			if (currentWord.length() > longestWord.length())
				longestWord = currentWord;
		}
		System.out.println("The longest word is '" + longestWord + "' with a length of " + longestWord.length());
		
		//finds and prints average word length by dividing total characters over number of words
		double totalCharacters = 0;
		for (int i=0; i < addressWords.size(); i++)
		{
			//finds total number of characters by adding length of each word in array list
			totalCharacters += (addressWords.get(i)).length();
		}
		System.out.println("Average word length: " + totalCharacters/addressWords.size() );
	}
}
