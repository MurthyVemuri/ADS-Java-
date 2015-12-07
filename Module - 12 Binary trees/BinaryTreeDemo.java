// Module 12 problem 1 and Problem 2: Module 13 problem 1:Inserting, printing in pre,post,level and In order. 
import java.util.*;

class Node {

	  public int value;
	  public Node left;
	  public Node right;

	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public Node getRight() {
		return this.right;
	}

	public Node getLeft() {
		return this.left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}

class SimpleBinaryTree {

	private Node root;

	public SimpleBinaryTree() {
		root = null;
	}


	public Node insert(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        } else {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while(!queue.isEmpty()) {
                Node current = queue.poll();
                if (current.getLeft() == null) {
                    current.setLeft(node);
                    queue.clear();
                } else if (current.getRight() == null) {
                    current.setRight(node);
                    queue.clear();
                } else {
                    queue.add(current.getLeft());
                    queue.add(current.getRight());
                }
            }
        }
        return node;
    }

	private Node insert(Node node, int data) {

		if (node == null)
			node = new Node(data);
		else {
			if (node.getRight() == null)
				node.setRight(insert(node.getRight(), data));
			else
				node.setLeft(insert(node.getLeft(), data));
		}
		return node;
	}  

	public void inorderPrinting() {
		inorderPrinting(root);
	}

	private void inorderPrinting(Node r) {
		if (r != null) {
			inorderPrinting(r.getLeft());
			System.out.print(r.getValue() + " ");
			inorderPrinting(r.getRight());
		}
	}

	public void preorderPrinting() {
		preorderPrinting(root);
	}

	private void preorderPrinting(Node r) {
		if (r != null) {
			System.out.print(r.getValue() +" ");
			preorderPrinting(r.getLeft());
			preorderPrinting(r.getRight());
		}
	}

	public void postorderPrinting() {
		postorderPrinting(root);
	}

	private void postorderPrinting(Node r) {
		if (r != null) {
			postorderPrinting(r.getLeft());
			postorderPrinting(r.getRight());
			System.out.print(r.getValue() +" ");
		}
	}  


	public void levelOrderPrinting() {
		levelOrderPrinting(root);
	}

	public void levelOrderPrinting(Node r){
		Queue<Node> level = new LinkedList<Node>();
		level.add(r);

		while(!level.isEmpty()){
			Node node = level.poll();
			System.out.print(node.getValue() + " ");
			if(node.getLeft()!= null)
				level.add(node.getLeft());
			if(node.getRight()!= null)
				level.add(node.getRight());
		}
	}

	public int getMin() {
		if (root == null) {
			return 0;
		}

		Node currNode = root;
		while (currNode.getLeft() != null) {
			currNode = currNode.getLeft();
		}
		return currNode.getValue();

	}

	public int getMax() {

		if (root == null) {
			return 0;
		}

		Node currNode = root;
		while (currNode.getRight()!= null) {
			currNode = currNode.getRight();
		}
		return currNode.getValue();

	}

	public int maxDepthTree() {
		return(maxDepthTree(root));
	}

	private int maxDepthTree(Node node) {
		if (node==null) {
			return(0);
		} else {
			int lDepth = maxDepthTree(node.getLeft());
			int rDepth = maxDepthTree(node.getRight());
			int depth = (Math.max(lDepth, rDepth) + 1);
			return depth;
		}
	}

}


public class BinaryTreeDemo {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		SimpleBinaryTree binarytree = new SimpleBinaryTree();
		char ch;
		do {
			System.out.println("\n1. Insert ");
			int choice = scan.nextInt();

			switch (choice){

				case 1 :
					System.out.println("Enter element to insert");
					binarytree.insert( scan.nextInt() );
				break;

				default :
					System.out.println(" Invalid value");
				break;

			}
			System.out.print("\nPost order ");
			binarytree.postorderPrinting();
			System.out.print("\nPre order ");
			binarytree.preorderPrinting();
			System.out.print("\nIn order ");
			binarytree.inorderPrinting();
			System.out.print("\nLevel order");
			binarytree.levelOrderPrinting();
			System.out.println();
			System.out.println("Depth " + binarytree.maxDepthTree());
			if(choice >= 2)
				break;
		} while (true);

	}

}
/*
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    public Node<T> insert(T data) {

        Node<T> node = new Node<T>(data);

        if (this.root == null) {
            this.root = node;
        } else {

            Queue<Node<T>> queue = new LinkedList<Node<T>>();
            queue.add(this.root);

            while(!queue.isEmpty()) {

                Node<T> current = queue.poll();

                if (current.left == null) {
                    current.left = node;
                    queue.clear();
                } else if (current.right == null) {
                    current.right = node;
                    queue.clear();
                } else {
                    queue.add(current.left);
                    queue.add(current.right);
                }

            }

        }

        return node;
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    public void postOrder() {
        this.postOrder(this.root);
    }

    public void inOrder(Node<T> node) {

        if (node == null)
            return;

        this.inOrder(node.left);
        System.out.println(node);
        this.inOrder(node.right);
    }

    public void preOrder(Node<T> node) {

        if (node == null)
            return;

        System.out.println(node);
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void postOrder(Node<T> node) {

        if (node == null)
            return;

        this.postOrder(node.left);
        this.postOrder(node.right);

        System.out.println(node);
    }

*/