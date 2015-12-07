/*
var re = /(\b[a-z](?!\s))/g

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
	    char[] characters = givenString.toCharArray();
	    boolean capitalizeWord = true;
	    for (int i = 0; i < characters.length; i++) {
	        char c = characters[i];
	        if (Character.isWhitespace(c)) {
	            capitalizeWord = true;
	        }
	        else if (capitalizeWord) {
	            capitalizeWord = false;
	            characters[i] = Character.toUpperCase(c);
	        }
	        else {
	            characters[i] = Character.toLowerCase(c);
	        }
	    }
	    System.out.println(characters);
	}
}

class Demo {
	public static void main(String[] args) {
		FileRead fileread = new FileRead();
		String content = fileread.getDataFromFile("Sample.txt");
		fileread.getCapital(content);
	} 
}
