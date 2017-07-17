import java.util.Scanner;

public class RomanConverter {
	public static int Convert(char numeral){
		int conversion = 0;
		int[]decimal = {1,5,10,50,100,500,1000};
		char[]roman = {'I','V','X','L','C','D','M'};
		for (int i = 0; i < 7; i++){
			if( numeral == roman[i]){
				conversion = decimal[i];
			}
		}
		return conversion;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		boolean calculated = true;
		int sum = 0;
			
				for (int i =0; i < input.length()-1; i++){
					int numeral1 = Convert(input.charAt(i));
					int numeral2 = Convert(input.charAt(i+1));
						if(numeral1 < numeral2){
							sum = sum-numeral1;
					} else {
						sum = sum + numeral1;
					}
						
				}
				int numeralf = Convert(input.charAt(input.length()-1));
				sum = sum + numeralf;
				System.out.println(sum);
	}

}
