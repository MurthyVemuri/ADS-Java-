import java.util.*;

class Node {

	  public String value;
	  public Node left;
	  public Node right;

	public Node(String value) {
		this.value = value;
	}

	public String getValue() {
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


	public Node insert(String data) {
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


	public void getLevelOrder() {
		printLevelOrder(root);
	}

	public void printLevelOrder(Node node) {
		int h = maxDepthTree();
		for(int i = 0; i <= h; i++) {
			printGivenLevel(root , i);
			System.out.println();
		}
	}	
	private List<String> levelList = new ArrayList<String>();
	public void printGivenLevel(Node node , int level) {
		if(node == null) {
			return;
		}
		if(level == 1 && node.getValue()!= null) {
			levelList.add(node.getValue());
			System.out.print(levelList);
		}else if(level > 1) {
			printGivenLevel(node.getLeft() , level-1);
			printGivenLevel(node.getRight() , level-1);
		}
		levelList.clear();
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
public class BinaryTreeLevelOrder {
	public static void main(String[] args) {
		SimpleBinaryTree sbt = new SimpleBinaryTree();
		Scanner scan = new Scanner(System.in);
		String value = scan.nextLine();
		StringTokenizer st = new StringTokenizer(value, " ");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if(token.equals("#") ) {
				sbt.insert(null);
			}else {
				sbt.insert( token );
			}
		}
		sbt.getLevelOrder();
	}
}