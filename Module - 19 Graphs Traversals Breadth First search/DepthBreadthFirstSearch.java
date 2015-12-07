import java.util.*;


class Node {
	
	int dataValue;
	Node next;

	public Node(int d) {
		dataValue = d;
		next = null;
	}
}

class adjList {
	Node head;
}

class Graph {
	int size_Graph;
	adjList[] array;

	public Graph(int size_Graph) {
		this.size_Graph = size_Graph;
		array = new adjList[size_Graph];

		for (int i = 0; i < size_Graph; i++) {
			array[i] = new adjList();
			array[i].head = null;
		}
	}

	public void addEdge(int src, int dest) {
		Node n = new Node(dest);
		n.next = array[src].head;
		array[src].head = n;
	}

	public void startBFS(int startVertex) {
		boolean[] visited = new boolean[size_Graph];
		Queue<Integer> queueList = new LinkedList<Integer>();

		queueList.add(startVertex);
		while (queueList.isEmpty() == false) {
			int n = queueList.poll();
			System.out.print(" " + n);
			visited[n] = true;
			Node head = array[n].head;
			while (head != null) {
				if (visited[head.dataValue] == false) {
					queueList.add(head.dataValue);
					visited[head.dataValue] = true;
				}
				head = head.next;
			}
		}
	}
}

class GraphDemo {
	
	private int graphVertices;
	private int[][] graphMatrix;

	GraphDemo(int graphVertices) {
		this.graphVertices = graphVertices;
		graphMatrix = new int[graphVertices][graphVertices];
	}

	public void createEdge(int setTo , int setFrom , int edgeValue) {
			graphMatrix[setTo][setFrom] = edgeValue;
	}

	public int getEdge(int setTo , int setFrom) {
		return graphMatrix[setTo][setFrom];
	}

}




public class DepthBreadthFirstSearch {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int verticesNumber = scan.nextInt();
		GraphDemo gd = new GraphDemo(verticesNumber);
		Graph g = new Graph(verticesNumber);
		int choice = scan.nextInt();
		List<Integer> arrayNumbers = new ArrayList<Integer>();


		if(choice == 0){
			String outputValue;
			for(int i = 0; i < verticesNumber; i++) {
				outputValue= scan.next();
				String[] eachValue = outputValue.split("->");
				for(int j = 0; j < eachValue.length; j++) {
					arrayNumbers.add(Integer.parseInt(eachValue[j]));
				}
			}
			for(int i = 0; i < arrayNumbers.size() ; i++){ 
				boolean checking = false; 
				for(int j = 0 ; j < i ; j++){ 
					if(arrayNumbers.get(i) == arrayNumbers.get(j)){ 
						checking = true; 
						break; 
					} 
				} 
				if(!checking){ 
				Collections.sort(arrayNumbers);
				System.out.print(arrayNumbers.get(i) + " "); 
				} 
			}
		}


		if(choice == 1) {
			int[][] arrayInt = new int[verticesNumber][verticesNumber];
			int count = 0;
			for(int i = 0; i < verticesNumber; i++){
				for(int j = 0; j < verticesNumber; j++) {
					arrayInt[i][j] = scan.nextInt();
					if(arrayInt[i][j] == 1)
						g.addEdge(i , j);
				}
			}

			for(int i = 0; i < verticesNumber; i++){
				for(int j = 0; j < verticesNumber; j++) {
					if(arrayInt[i][j] == 1){
						g.startBFS(i);
						break;
					}
				}
			}
		}
	}
}

