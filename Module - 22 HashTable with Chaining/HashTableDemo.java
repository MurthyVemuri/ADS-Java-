/*Module 22: Problem 1 HashTable using chaining to resolve collisons*/

import java.io.*;
import java.util.*;

class Node {  

	private int dataValue;
	public Node next;

	public Node(int it) { 
		dataValue= it; 
	}

	public int getKey() { 
		return dataValue; 
	}

	public void getValue() { 
		System.out.print(dataValue + " "); 
	}
}


class MyList {

	private Node head;

	public void MyList() { 
		head = null; 
	}

	public void insert(Node givenNode) {
		int key = givenNode.getKey();
		Node temp = null;
		Node current = head;
		while( current != null && key > current.getKey() ) {
			temp = current;
			current = current.next;
		}
		if(temp==null)
			head = givenNode;
		else
			temp.next = givenNode;
		givenNode.next = current;
	} 


	public void delete(int key) {
		Node temp = null;
		Node current = head;

		while( current != null && key != current.getKey() ) {
			temp = current;
			current = current.next;
		}

		if(temp==null)
			head = head.next;
		else
			temp.next = current.next;
	} 


	public Node find(int key) {
		Node current = head;
		int count = 0;
		while(current != null &&  current.getKey() <= key) {
			count++;
			if(current.getKey() == key) {
				System.out.println(count);
				return current;
			}
			current = current.next;
		}
		System.out.println("Searching for value: " + count);
		return null;
	} 


	public void displayList() {
		Node current = head;
		while(current != null){
			current.getValue();
			current = current.next;
		}
		System.out.println("");
	}
}  


class HashTable {

	private MyList[] hashArray;
	private int arraySize;

	public HashTable(int size) {
		arraySize = size;
		hashArray = new MyList[arraySize];
		for(int j=0; j<arraySize; j++)
			hashArray[j] = new MyList();
	}

	public int hashFunc(int key) {
		return key % arraySize;
	}

	public void insertValue(Node givenNode) {
		int key = givenNode.getKey();
		int hashVal = hashFunc(key);
		hashArray[hashVal].insert(givenNode);
	}

	public void deleteValue(int key) {
		int hashVal = hashFunc(key);
		hashArray[hashVal].delete(key);
	}

	public Node findValue(int key){
		int hashVal = hashFunc(key);
		Node givenNode = hashArray[hashVal].find(key);
		return givenNode;
	}

	public void displayTable() {
		for(int j=0; j<arraySize; j++){
			System.out.print(j + ". ");
			hashArray[j].displayList();
		}
	}
}


class HashTableDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int aKey;
		Node dataNode;
		System.out.print("size of hash table: ");
		int size = scan.nextInt();

		HashTable theHashTable = new HashTable(size);

		do{
			System.out.print("1.show, 2.insert, 3.delete, 4.find, 5.end ");
			int choice = scan.nextInt();

			switch(choice) {
				case 1:
					theHashTable.displayTable();
				break;
				case 2:
					System.out.print("key value to insert: ");
					aKey = scan.nextInt();
					dataNode = new Node(aKey);
					theHashTable.insertValue(dataNode);
				break;
				case 3:
					System.out.print("key value to delete: ");
					aKey = scan.nextInt();
					theHashTable.deleteValue(aKey);
				break;
				case 4:
					System.out.print("key value to find: ");
					aKey = scan.nextInt();
					dataNode = theHashTable.findValue(aKey);
					if(dataNode != null)
						System.out.println("Found " + aKey);
					else
						System.out.println("Could not find " + aKey);
				break;
				default:
					System.out.print("Invalid entry");
			} if(choice == 5 )
			break;
		} while(true);
	}
}
