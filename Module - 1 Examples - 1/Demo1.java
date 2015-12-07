/*
Capitalization Problem(Module1-Problem1). Only for words end with fullstop
and character next to the fullstop will be capital according to this code.
*/

import java.io.BufferedReader;
import java.io.FileReader;

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

	public  void getCapital(String givenString) {
		String[] tokens = givenString.split("\\.");
		String capitalLetter;
		String word;
		String capitalWord;
		for(String sentence: tokens) {
			capitalLetter = sentence.substring(0, 2).toUpperCase();
			word = sentence.substring(2);
			capitalWord = capitalLetter + word;
			System.out.print(capitalWord + "."); 
		} 
	}
}

class Demo {
	public static void main(String[] args) {
		FileRead fileread = new FileRead();
		String content = fileread.getDataFromFile("Sample.txt");
		fileread.getCapital(content);
	} 
}
