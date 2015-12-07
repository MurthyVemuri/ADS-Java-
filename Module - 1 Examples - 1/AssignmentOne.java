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
		System.out.println(data);
		return data.toString();
	}

	public  String getCapital(String givenString) {

		String[] arr = givenString.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1)).append(" ");
		}
		return sb.toString();
	}
		
}

class AssignmentOne {
	public static void main(String[] args) {
		FileRead fileread = new FileRead();
		String content = fileread.getDataFromFile("Sample.txt");
		String output = fileread.getCapital(content);
		System.out.println("\n\n" + output);
	} 
}