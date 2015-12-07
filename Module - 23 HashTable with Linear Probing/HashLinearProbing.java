/*Module 23: Problem 1 HashTable using linear probing to resolve collisions */

import java.util.*;

class HashingLinear {
	
	int size;
	int[] hashArray;
	int count;

	HashingLinear(int size) {
		this.size = size;
		hashArray = new int[size];
		count = 0;
	}

	private int myHashFunction(int key){
		int hash = key % size;
		return hash;
	}

	public void insertValue(int dataValue){
		int temp = myHashFunction(dataValue);
		int i = temp;
		do{
			if (hashArray[i] == 0){
				hashArray[i] = dataValue;
				return;
			}
			i = (i + 1) % size;
		} while (i != temp);  
		count++;
	}

	public void remove(int data) {

		int i = myHashFunction(data);

		while (data != (hashArray[i]) ) 
			i = (i + 1) % size;
		hashArray[i] = 0;

		for (i = (i + 1) % size; hashArray[i] != 0; i = (i + 1) % size) {
			int tmp1 = hashArray[i];
			hashArray[i] = 0;
			insertValue(tmp1);
		}
	}

	public int getKey(int dataValue) {
		int  i = myHashFunction(dataValue);
		while (hashArray[i] != 0) {
			if (hashArray[i] == dataValue)
				return i;
			i = (i + 1) % size;
		}
		return 0;
	}

	public void getAllValues() {
		for(int i = 0; i < size ;i++) {
			System.out.println(i + "." + hashArray[i]);
		}
	}
 
}


public class HashLinearProbing {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		HashingLinear hl = new HashingLinear(size);
		hl.insertValue(97);
		hl.insertValue(88);
		hl.insertValue(67);
		// hl.insertValue(55);
		// hl.insertValue(84);
		// hl.insertValue(43);
		// hl.insertValue(32);
		// hl.insertValue(21);
		// hl.insertValue(17);
		// hl.insertValue(7);

		hl.getAllValues();

		hl.remove(97);
		//hl.remove(84);
		System.out.println("////////////////");
		hl.getAllValues();
	}
}

/*

import java.util.*;

class HashingLinear {
	
	int size;
	int[] hashArray;
	int count;

	HashingLinear(int size) {
		this.size = size;
		hashArray = new int[size];
		count = 0;
	}
	
	private int hash(int value) {
		return value.hashCode() % size;
	} 

	public void insertValue(int dataValue){

		int temp = hash(dataValue);
		int i = temp;
		do{
			if (hashArray[i] == 0){
				hashArray[i] = dataValue;
				return;
			}
			i = (i + 1) % size;
		} while (i != temp);
		count++;
	}

	public void remove(int data) {
		if (!contains(data)) 
			return;
		int i = hash(data);

		while (!data == (hashArray[i])) 
			i = (i + 1) % size;
		hashArray[i] = 0;

		for (i = (i + 1) % size; hashArray[i] != 0; i = (i + 1) % size) {
			int tmp1 = hashArray[i];
			hashArray[i] = 0;
			size--;  
			insertValue(tmp1);
		}
		size--;
	}

	public int getKey(int dataValue) {
		int i = dataValue % size;
		while (hashArray[i] != 0) {
			if (hashArray[i] == dataValue)
				return i;
			i = (i + 1) % size;
		}
		return 0;
	}

	public void getAllValues() {
		for(int i = 0; i < size ;i++) {
			System.out.println(i + "." + hashArray[i]);
		}
	}
 
}


public class HashLinearProbing {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		HashingLinear hl = new HashingLinear(size);
		hl.insertValue(96);
		hl.insertValue(43);
		hl.insertValue(72);
		hl.insertValue(68);
		hl.insertValue(63);
		hl.insertValue(28);

		hl.getAllValues();
		System.out.println(hl.getKey(96) );
		System.out.println(hl.getKey(43) );
		System.out.println(hl.getKey(72) );
		System.out.println(hl.getKey(68) );
		System.out.println(hl.getKey(63) );
		System.out.println(hl.getKey(28) );
	}
}
*/