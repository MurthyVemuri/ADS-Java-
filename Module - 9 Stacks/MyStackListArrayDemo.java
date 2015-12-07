//Using arrays

import java.util.*;

class MyStackArraysConcept<E> {

	public E[] values;
	private int size;
	private int top;

	@SuppressWarnings("unchecked")
	public MyStackArraysConcept(int arraySize) {
		size = arraySize;
		top = -1;
		values = (E[])new Object[size];
	}

	public void push(E e) {
		if(top == size){
			System.out.println("Stack is overflow");
		}else {
			top++;
			values[top] = e;	
		}
	}

	public void pop() {
		if(top <= -1){
			System.out.println("Stack is underflow");
		}else {
			top--;
		}
	}

	public int size(){
		return top+1;
	}

	@SuppressWarnings("unchecked")
	public E getTop() {
		if(isEmpty()){
			return (E)"Stack is underflow";
		}else {
			return values[top];
		}	
	}

	public boolean isEmpty() {
		if(top <= -1)
			return true;
		else
			return false;
	}


	public void printValues() {
		if(top <= -1) {
			System.out.println("stack is underflow");
		}else if(top == size - 1 ) {
			System.out.println("Stack is overflow");
		}else {
			for( int i = 0; i <= top; i++) {
				System.out.print(values[i] + " ");
			}
		}
	}
}

public class MyStackListArrayDemo {
	public static void main(String[] args) {
		MyStackArraysConcept<String> linkedlist = new MyStackArraysConcept<String>(6);
		MyStackArraysConcept<Integer> linkedlistIntegers = new MyStackArraysConcept<Integer>(6);
		MyStackArraysConcept<Float> linkedlistFloat = new MyStackArraysConcept<Float>(6);
		Scanner scan = new Scanner(System.in);

		String record = scan.nextLine();
		if(record.equals("S")) {
			do{
				System.out.println();
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
						System.out.println(linkedlist.getTop());
					break;

					case 5:
						System.out.println(linkedlist.isEmpty());
					break;
						
					default:
					System.out.println("Invalid option");
				}
				linkedlist.printValues();
				if(choice >= 6) {
					break;
				}
			} while(true);
		}else if(record.equals("I")) {
			do{
				System.out.println();
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
						System.out.println(linkedlistIntegers.getTop());
					break;

					case 5:
						System.out.println(linkedlistIntegers.isEmpty());
					break;	

					default:
					System.out.println("Invalid option");
				}
				linkedlistIntegers.printValues();
				if(choice >= 6) {
					break;
				}
			} while(true);
		} else if(record.equals("F")) {
			do{
				System.out.println();
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
						System.out.println(linkedlistFloat.getTop());;
					break;

					case 5:
						System.out.println(linkedlistFloat.isEmpty());
					break;	

					default:
					System.out.println("Invalid option");
				}
				linkedlistFloat.printValues();
				if(choice >= 6) {
					break;
				}
			} while(true);
		}
	}
}
