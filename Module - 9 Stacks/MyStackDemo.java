// Using LinkedList

import java.util.*;

class MyStack {

	private Node head;
	private int top;


	public MyStack() {

		head = new Node(null);
		top = 0;
	}

	public void push(Object newData) {
		Node temp = new Node(newData);
		Node current = head;
		Node ref = null;
		boolean flag = false;
		while(current != null) {
				ref = current;
				flag = true;
				break;
		}
		if(flag) {
			temp.setNext(current.getNext());
			ref.setNext(temp);
		}
		top++;
	}


	public void pop(){
		if (top == 0) {
			System.out.println("Stack is underflow");
		} else {
			Node current = head;
			current.setNext(current.getNext().getNext());
			top--; 
		}
	}


	public Object getTop(){
		if(isEmpty()){
			return null;
		}else {
			Node current = head;
			return current.getNext().getData();
		}
	}

	public int size(){
		return top;
	}

	public boolean isEmpty() {
		if(top == 0)
			return true;
		else
			return false;
	}


	public String toString() {
		Node current = head.getNext();
		String output = "";
		if(current == null) 
			return "Stack is empty";
		while (current != null) {
			output += "[" + current.getData().toString() + "]";
			current = current.getNext();
		}
		return output;
	}
}

class Node {

	Node next;
	Object data;

	public Node(Object dataValue) {
		next = null;
		data = dataValue;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object dataValue) {
		data = dataValue;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node nextValue) {
		next = nextValue;
	}
}


public class MyStackDemo {

	public static void main(String[] args) {
		MyStack linkedlist = new MyStack();
		MyStack linkedlistIntegers = new MyStack();
		MyStack linkedlistFloat = new MyStack();
		Scanner scan = new Scanner(System.in);

		String record = scan.nextLine();
		if(record.equals("S")) {
			do{
				System.out.println("1. PushElement");
				System.out.println("2. Stack size ");
				System.out.println("3. PopElement");
				System.out.println("4. Top element");
				System.out.println("5. Is Stack Empty ?");
				int choice = scan.nextInt();
				switch(choice) {
					case 1:
						String elementFirst = scan.next();
						linkedlist.push(elementFirst);
					break;

					case 2:
						System.out.println(linkedlist.size());
					break;

					case 3:
						linkedlist.pop();
					break;

					case 4:
						linkedlist.getTop();
					break;

					case 5:
						System.out.println(linkedlist.isEmpty());
					break;
						
					default:
					System.out.println("Invalid option");
				}
				System.out.println(linkedlist);
				if(choice >= 6) {
					break;
				}
			} while(true);
		}else if(record.equals("I")) {
			do{
				System.out.println("1. PushElement");
				System.out.println("2. Stack size ");
				System.out.println("3. PopElement");
				System.out.println("4. Top element");
				System.out.println("5. Is Stack Empty ?");
				int choice = scan.nextInt();
				switch(choice) {
					case 1:
						int elementFirst = scan.nextInt();
						linkedlistIntegers.push(elementFirst);
					break;

					case 2:
						System.out.println(linkedlistIntegers.size());
					break;

					case 3:
						linkedlistIntegers.pop();
					break;

					case 4:
						linkedlistIntegers.getTop();
					break;

					case 5:
						System.out.println(linkedlistIntegers.isEmpty());
					break;	

					default:
					System.out.println("Invalid option");
				}
				System.out.println(linkedlistIntegers);
				if(choice >= 6) {
					break;
				}
			} while(true);
		} else if(record.equals("F")) {
			do{
				System.out.println("1. PushElement");
				System.out.println("2. Stack size ");
				System.out.println("3. PopElement");
				System.out.println("4. Top element");
				int choice = scan.nextInt();
				switch(choice) {
					case 1:
						Float elementFirst = scan.nextFloat();
						linkedlistFloat.push(elementFirst);
					break;

					case 2:
						System.out.println(linkedlistFloat.size());
					break;

					case 3:
						linkedlistFloat.pop();
					break;

					case 4:
						linkedlistFloat.getTop();
					break;

					case 5:
						System.out.println(linkedlistFloat.isEmpty());
					break;	

					default:
					System.out.println("Invalid option");
				}
				System.out.println(linkedlistFloat);
				if(choice >= 6) {
					break;
				}
			} while(true);
		}

	}
}


/*
	public static void main(String[] args) {
		MyStack linkedlist = new MyStack();
		MyStack linkedlist1 = new MyStack();

		linkedlist.addElementLast("1");
		linkedlist.addElementLast("2");
		linkedlist.addElementLast("3");
		linkedlist.addElementLast("4");
		linkedlist.addElementLast("5");

		linkedlist1.addElementLast("1");
		linkedlist1.addElementLast("2");
		linkedlist1.addElementLast("3");
		linkedlist1.addElementLast("4");
		linkedlist1.addElementLast("5");

		System.out.println("Print linkedlist: " + linkedlist);

		System.out.println("Print linkedlist size: " + linkedlist.size());

		System.out.println("Get 3rd element: " + linkedlist.get(3));

		linkedlist.pop(2);

		System.out.println("Get 3rd element: " + linkedlist.get(3));
		System.out.println("Print linkedlist size: " + linkedlist.size());
		System.out.println("Print linkedlist: " + linkedlist);
	}

*/
