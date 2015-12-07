import java.util.Scanner;

class Node {

	private Object data;
	private Node next;
	private Node prev;

	public Node() {
		next = null;
		prev = null;
		data = 0;
	}

	public Node(Object data, Node next, Node prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public void setLinkNext(Node next) {
		this.next = next;
	}

	public void setLinkPrev(Node prev) {
		this.prev = prev;
	}

	public Node getLinkNext() {
		return this.next;
	}


	public Node getLinkPrev() {
		return this.prev;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return this.data;
	}

}


class linkedListTest {
	private Node start;
	private Node end ;
	public int size;

	public linkedListTest() {
		start = null;
		end = null;
		size = 0;
	}

	public boolean isEmpty() {
		return start == null;
	}

	public int getSize() {
		return size;
	}

	// public void insertAtStart(Object value) {

	// 	Node temp = new Node(value, null, null);
	// 	if(start == null) {
	// 		start = temp;
	// 		end = start;
	// 	}else {
	// 		start.setLinkPrev(temp);
	// 		temp.setLinkNext(start);
	// 		start = temp;
	// 	}
	// 	size++;

	// }

	public void insertAtEnd(Object value) {

		Node temp = new Node(value, null, null);
		if(start == null) {
			start = temp;
			end = start;
		}else{
			temp.setLinkPrev(end);
			end.setLinkNext(temp);
			end = temp;
		}
		size++;
	}

	// public void insertAtPos(Object value , int pos) {

	// 	Node temp = new Node(value, null, null);
	// 	if (pos == 1) {
	// 		insertAtStart(value);
	// 		return;
	// 	}

	// 	Node ref = start;
	// 	for (int i = 2; i <= size; i++) {
	// 		if (i == pos) {
	// 			Node tmp = ref.getLinkNext();
	// 			ref.setLinkNext(temp);
	// 			temp.setLinkPrev(ref);
	// 			temp.setLinkNext(tmp);
	// 			tmp.setLinkPrev(temp);
	// 		}
	// 		ref = ref.getLinkNext();
	// 	}
	// 	size++ ;
	// }


	public void display(){

		if (size == 0) {
			System.out.print("empty");
			return;
		}
		if (start.getLinkNext() == null){
			System.out.println(start.getData() );
			return;
		}
		Node temp = start;
		System.out.print(start.getData()+ " <-> ");
		temp = start.getLinkNext();
		while (temp.getLinkNext() != null) {
			System.out.print(temp.getData()+ " <-> ");
			temp = temp.getLinkNext();
		}
		System.out.print(temp.getData()+ "\n");
	}

	// public void preOrderSort(Node root) {
	// 	if(root == null) {
	// 		return;
	// 	}
	// 	String v = (String)root.getData();
	// 	System.out.println(v);
	// 	preOrderSort(root.getLinkPrev());
	// 	preOrderSort(root.getLinkNext());
	// }

	// public void postOrderSort(Node root) {
	// 	if(root == null) {
	// 		return;
	// 	}
	// 	postOrderSort(root.getLinkPrev());
	// 	postOrderSort(root.getLinkNext());
	// 	System.out.println(root.getData());
	// }

	// public void inOrderSort(Node root) {
	// 	if(root == null) {
	// 		return;
	// 	}
	// 	inOrderSort(root.getLinkPrev());
	// 	System.out.println(root.getData());
	// 	inOrderSort(root.getLinkNext());
	// }

}


public class DoublyOrder {
	public static void main(String[] args) { 
		linkedListTest listObject = new linkedListTest();
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("\nDoubly Linked List Operations\n");
			System.out.println("1. insert at end");
			System.out.println("2. get size");
			System.out.println("3. PreOrder");
			System.out.println("4. PostOrder");
			System.out.println("5. InOrder");
			int choice = scan.nextInt();
			switch (choice) {
				case 1 :
					System.out.println("Enter element to insert");
					listObject.insertAtEnd( scan.next() );
					break;

				case 2 :
					System.out.println(listObject.getSize());
					break;

				case 3 :
					Node temp1 = new Node("F", null, null);
					listObject.preOrderSort(temp1);
					break;
				case 4 :
					Node temp2 = new Node("F", null, null);
					listObject.postOrderSort(temp2);
					break;
				case 5 :
					Node temp = new Node("F", null, null);
					listObject.inOrderSort(temp);
					break;
				default :
					System.out.println("Invalid input");
					break;
			}
			listObject.display();
			if(choice >= 6)
			break;
		} while (true);
	}
}