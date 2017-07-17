import java.util.Scanner;

public class Palindrome {

	public static boolean checker(String word){
		boolean result = false;
		//String first =word.substring(0,1);
		//String last = word.substring(word.length()-1);
		
		//Checks base case if the length of the word is either 0 or 1
		if (word.length() == 1 || word.length() == 0){
			result = true;
		}
		//Checks if the first and last letter of the substrings are the same
		else if(word.substring(0,1).equals(word.substring(word.length()-1))){
			if (checker(word.substring(1, word.length()-1))){
				result = true;
			}
		} 
		return result;
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter your Palindrome ");
		String word = reader.nextLine();
		word = word.replace(" ", "");
		word = word.toLowerCase();
		System.out.println(checker(word));
	}

}
