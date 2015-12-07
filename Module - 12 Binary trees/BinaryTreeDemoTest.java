import java.util.*;
class Node<T> {

	  public int value;
	  public Node left;
	  public Node right;

	public Node(int value) {
		this.value = value;
	}
}

class BinarySearchTree {

	public Node root;
	public int count = 0;

	public BinarySearchTree insert(int value) {
		Node node = new Node(value);
		
		if (root == null) {
			root = node;
			return this;
		}
		insertRec(root, node);
		count++;
		return this;
	}


	private void insertRec(Node latestRoot, Node node) {

		if (latestRoot.value > node.value) {
			if (latestRoot.left == null) {
				latestRoot.left = node;
				return;
			} else {

				insertRec(latestRoot.left, node);
			}
		} else {
			if (latestRoot.right == null) {
				latestRoot.right = node;
				return;
			} else {
			insertRec(latestRoot.right, node);
			}
		}
	}



	public int findMinimum() {
		if (root == null) {
			return 0;
		}
		Node currNode = root;
		while (currNode.left != null) {
			currNode = currNode.left;
		}

		return currNode.value;

	}

	public int findMaximum() {

		if (root == null) {
			return 0;
		}

		Node currNode = root;
		while (currNode.right != null) {
			currNode = currNode.right;
		}
		return currNode.value;
	}

	public void printInorder() {
		printInOrderRec(root);
		System.out.println();
	}

	private void printInOrderRec(Node currRoot) {
		if (currRoot == null) {
			return;
		}
		printInOrderRec(currRoot.left);
		System.out.print(currRoot.value);
		System.out.print(",");
		printInOrderRec(currRoot.right);
	}
}

	 

public class BinaryTreeDemoTest {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Scanner scan = new Scanner(System.in);
		String output = scan.nextLine();	
		bst.printInorder();
		String[] function = output.split(",");
		for (int i = 0; i < function.length;i++) {
			if(function[i].contains("I")){
				String[] val = function[i].split(" ");
				bst.insert(Integer.valueOf(val[1]));
				bst.printInorder();
			}else if(function[i].contains("R")) {
				//bst.printInorder();
			}else if(function[i].contains("S")) {
				//bst.printInorder();
			}else{
				break;
			}
		}
	}
}