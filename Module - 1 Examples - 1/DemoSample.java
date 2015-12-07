/*
Capitalization Problem(Module1-Problem1). Only for words end with fullstop
and character next to the fullstop will be capital according to this code.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

class FileRead {
	public String getDataFromFile(String fileName) {
		String line = null;
		StringBuffer data = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while((line = br.readLine())!=null) {
				data.append(line);
			}
			br.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(data + "\n");
		return data.toString();
	}

public String getCapital(String givenString , String token) {
		
		StringTokenizer str = new StringTokenizer(givenString,token);
		String temp = null;
		String firstLetter = null;
		String append = null;
		String fullText = null;
		String word = null;
		String digit = null;
		while(str.hasMoreTokens()){

			temp = str.nextToken();
			for(int i = 0; i <= temp.length(); i++) {
			if (Character.isDigit(temp.charAt(i))) {
				while(Character.isDigit(temp.charAt(i))) {
					digit += String.valueOf(temp.charAt(i));
					i++;
				}
			i--;
			} else if (Character.isLetter(temp.charAt(i))) {
				while(Character.isLetter(temp.charAt(i))) {
					word = String.valueOf(temp.charAt(i));
					i++;
					break;
				}
				firstLetter = word.toUpperCase();
				append = firstLetter + temp.substring(i);
				break;
			}
		}

		fullText = fullText + digit + append  + token +" ";
		}
		return fullText;
	}
}

class DemoSample {
	public static void main(String[] args) {
		FileRead fileread = new FileRead();
		String content = fileread.getDataFromFile("Sample.txt");

		String fullText = fileread.getCapital(content,".");
    	String fullText1 = fileread.getCapital(fullText,"?");
    	String fullText2 = fileread.getCapital(fullText1,"!");
    	String out = fullText2.substring(0,fullText2.length()-4);
		System.out.println(out);
	}
}
