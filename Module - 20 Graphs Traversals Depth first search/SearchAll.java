import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class Node {

	public char label;
	public boolean visited=false;

	public Node(char l){
		this.label=l;
	}
}


class Graph {

	public Node rootNode;
	public ArrayList nodes=new ArrayList();
	public int[][] adjMatrix;
	int size;

	public void setRootNode(Node n) {
		this.rootNode=n;
	}
	
	public Node getRootNode() {
		return this.rootNode;
	}
	
	public void addNode(Node n) {
		nodes.add(n);
	}
	
	
	public void connectNode(Node start,Node end) {

		if(adjMatrix==null) {
			size=nodes.size();
			adjMatrix=new int[size][size];
		}

		int startIndex=nodes.indexOf(start);
		int endIndex=nodes.indexOf(end);
		adjMatrix[startIndex][endIndex]=1;
		adjMatrix[endIndex][startIndex]=1;
	}
	
	private Node getUnvisitedChildNode(Node n) {
		
		int index=nodes.indexOf(n);
		int j=0;
		
		while(j<size) {
			if(adjMatrix[index][j]==1 && ((Node)nodes.get(j)).visited==false) {
				return (Node)nodes.get(j);
			}
			j++;
		}
		return null;
	}
	

	public void bfs() {
		
		Queue q=new LinkedList();
		q.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited=true;

		while(!q.isEmpty()) {
			Node n=(Node)q.remove();
			Node child=null;
			
			while((child=getUnvisitedChildNode(n))!=null) {
				child.visited=true;
				printNode(child);
				q.add(child);
			}
		}
		clearNodes();
	}
	

	public void dfs() {

		Stack s=new Stack();
		s.push(this.rootNode);
		rootNode.visited=true;
		printNode(rootNode);
		while(!s.isEmpty()) {
			Node n=(Node)s.peek();
			Node child=getUnvisitedChildNode(n);
			if(child!=null) {
				child.visited=true;
				printNode(child);
				s.push(child);
			} else{
				s.pop();
			}
		}
		clearNodes();
	}
	

	private void clearNodes() {
		int i=0;
		while(i<size)
		{
			Node n=(Node)nodes.get(i);
			n.visited=false;
			i++;
		}
	}
	
	
	private void printNode(Node n) {
		System.out.print(n.label+" ");
	}
}



public class SearchAll {

	public static void main(String[] args)  {
		
		Node nA=new Node('A');
		Node nB=new Node('B');
		Node nC=new Node('C');
		Node nD=new Node('D');
		Node nE=new Node('E');
		Node nF=new Node('F');

		Graph g=new Graph();

		g.addNode(nA);
		g.addNode(nB);
		g.addNode(nC);
		g.addNode(nD);
		g.addNode(nE);
		g.addNode(nF);
		g.setRootNode(nA);
		
		g.connectNode(nA,nB);
		g.connectNode(nA,nC);
		g.connectNode(nA,nD);
		
		g.connectNode(nB,nE);
		g.connectNode(nB,nF);
		g.connectNode(nC,nF);
		
		System.out.println("DFS Traversal of a tree is ------------->");
		g.dfs();
		
		System.out.println("\nBFS Traversal of a tree is ------------->");
		g.bfs();
	}
}