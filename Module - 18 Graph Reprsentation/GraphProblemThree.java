import java.util.*;

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

	public void printEdges() {
		for(int i = 0; i < graphMatrix.length ; i++) {
			for(int j = 0; j < graphMatrix.length; j++) {
				int value = getEdge(i,j);
				if(value == 1){
					System.out.println( (i ) + "->" + (j) );
				}
			}
		}
	}
}


public class GraphProblemThree {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		GraphDemo gd = new GraphDemo(size);
		int[][] arrayInt = new int[size][size];

		int count = 0;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++) {
				arrayInt[i][j] = scan.nextInt();
				if(arrayInt[i][j] == 1)
					gd.createEdge(i , j ,1);
			}
		}
		
		for(int i = 0; i < size ; i++) {
			for(int j = 0; j <= i; j++) {
				int value = gd.getEdge(i,j);
				if(value == 1)
				count++;
			}
		}
		System.out.println(count);
		gd.printEdges();
	}
}



/*
import java.util.*;

class GraphDemo {
	
	private int graphVertices;
	private int[][] graphMatrix;
	Scanner scan = new Scanner(System.in);

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

	public void getInputFromAdjacentMatrix(int size) {
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++) {
				graphMatrix[i][j] = scan.nextInt();
				if(graphMatrix[i][j] == 1)
					createEdge(i , j ,1);
			}
		}
	}


	public int checkAdjacentMatrix(int size) {
		int count = 0;
		for(int i = 0; i < size ; i++) {
			for(int j = 0; j <= i; j++) {
				int value = getEdge(i,j);
				if(value == 1)
				count++;
			}
		}
		return count;
	}


}


public class GraphProblemThree {
	public static void main(String[] args) {
		Scanner scanmain = new Scanner(System.in);
		int size = Integer.parseInt(scanmain.nextLine());
		GraphDemo gd = new GraphDemo(size);
		gd.getInputFromAdjacentMatrix(size);
		System.out.println(gd.checkAdjacentMatrix(size));
	}
}

*/