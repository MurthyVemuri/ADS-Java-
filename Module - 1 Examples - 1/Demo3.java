/*
Capitalization Problem(Module1-Problem1). Only for words end with fullstop
and character next to the fullstop will be capital according to this code.
*/

import java.util.*;


class Demo3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		input += scan.nextLine();

		String output = "";
		output += Character.toUpperCase(input.charAt(0));

		for(int i = 1; i < input.length() - 1; i++) {

			if(input.charAt(i) == '.' || input.charAt(i) == '!' || input.charAt(i) == '?') {
				output = output + (input.charAt(i)) + " ";
				i++;
				while((input.charAt(i)) == ' ') {
					i++;
				}
				output= output + (Character.toUpperCase(input.charAt(i))) ; 

			} else {
				output = output + (input.charAt(i)) ; 
			}

		}
		output = output + input.charAt(input.length() - 1);
		System.out.println(output);
	}
}

