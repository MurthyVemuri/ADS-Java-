/*
ADS_Module-2_Problem solving using Java Strings and Collections Library-2.
In this code, counts the frequency of the letter given by user in the file
by reading the file contents. 

Gives the frequency of the given letter in the file content.
*/


import java.io.*;
import java.util.*;

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
}

public class Simple {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        SimpleDemo sd = new SimpleDemo();
        String str  = sd.getDataFromFile("Sample.txt");

        System.out.print("\nEnter the letter to be searched : ");
        String letter = scan.next();
        for( int i = 0; i < str.length(); i++ ){
            if(str.charAt(i) == letter.charAt(0))
                count++;
            else
                continue;
        }
        System.out.print("\nFrequency of the letter : "+count);
 
    }
}