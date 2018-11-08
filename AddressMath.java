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
		
		String word1 = addressWords.get(0);
		
		for (int i=0; i < addressWords.size(); i++)
		{
			String word2 = addressWords.get(i);
			
			//compares each following word, eventually setting word1 equal to the longest word
			if (word2.length()>word1.length())
			{
				word1 = word2;
			}
			
		}
		
		System.out.print("longest: " + word1);
		
	}
}
