import java.util.*;        

class Node{

	int data;
	int numNodes;
	Node arr[];

	public Node(int k) {
		data = -1;
		numNodes = k;
		arr = new Node[numNodes];
	}

}

class BinomialTree {

	private Node root;
	private int order, size;

	public BinomialTree(int k) {
		size = 0;
		order = k;
		root = new Node(order);
		createTree(root);
	}

	private void createTree(Node r) {
		int n = r.numNodes;        
		if (n == 0)
		return;            
		for (int i = 0; i < n; i++) {
			r.arr[i] = new Node(i);
			createTree(r.arr[i]);
		}
	}

	public void clear() {
		size = 0;
		root = new Node(order);
		createTree(root);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	public void insert(int val) {
		try {
			insert(root, val);
		}catch (Exception e) { }
	}

	private void insert(Node r, int val) throws Exception {
		if (r.data == -1) {
			r.data = val;
			size++;
			throw new Exception("inserted !");
		}
		int n = r.numNodes;        
		for (int i = 0; i < n; i++)
			insert(r.arr[i], val);
	}


	public void printTree() {
		printTree(root);
		System.out.println();
	}

	private void printTree(Node r) {
		if (r.data != -1)
			System.out.print(r.data +" ");        
		int n = r.numNodes;
		if (n == 0)
			return;
		for (int i = 0; i < n; i++)
			printTree(r.arr[i]);
	}

}

    
public class BinomialTreeArrayTest {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Binomial Tree Test\n");
		System.out.println("\nEnter order of binomial tree");
		BinomialTree bt = new BinomialTree(scan.nextInt());
		char ch;
		do {
			System.out.println("\nBinomial Tree Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. size");
			System.out.println("3. check empty");
			System.out.println("4. clear");
			int choice = scan.nextInt();
			switch (choice){

				case 1 :
					System.out.println("Enter integer element to insert");
					bt.insert( scan.nextInt() );
				break;
			
				case 2 :
					System.out.println("Nodes = "+ bt.getSize());
				break;
			
				case 3 :
					System.out.println("Empty status = "+ bt.isEmpty());
				break;
			
				case 4 :
					bt.clear();
					System.out.println("\nTree Cleared\n");
				break;
			
				default :
					System.out.println("Wrong Entry \n ");
				break;
			}
			bt.printTree();
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y'|| ch == 'y');
	}
}