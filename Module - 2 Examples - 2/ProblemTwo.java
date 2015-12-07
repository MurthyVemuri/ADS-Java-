/*
ADS_Module-2_Problem solving using Java Strings and Collections Library-2.
Plagiarism code which gives the percentage of match found if the words are equal.
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

class FileContent {
 
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

	
	public List<String> getTokens(String content , String delim) {
		StringTokenizer st = new StringTokenizer(content,delim);
		List<String> contents = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			contents.add(st.nextToken());
		}

		return contents;
	}

}


class ProblemTwo {
	public static void main(String[] args) {
		FileContent filecontent = new FileContent();
		
		String contentOne = filecontent.getDataFromFile("Sample.txt");
		List<String> fileOne =	filecontent.getTokens(contentOne , " ");

		String contentTwo = filecontent.getDataFromFile("format.txt");
		List<String> fileTwo = filecontent.getTokens(contentTwo , " ");

		int count =0;
		for(int i = 0 ; i < fileOne.size(); i++) {
			for(int j = 0; j < fileTwo.size(); j++) {
				if(fileOne.get(i).equals(fileTwo.get(j))) {
					count++;
					break;
				}
			}
		}

		System.out.println( (count * 100)/fileOne.size());
	}
}