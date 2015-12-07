import java.util.*;

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
				System.out.print(graphMatrix[i][j]);
			}
			System.out.println();
		}
	}
}


public class LtoGraph {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		GraphDemo gd = new GraphDemo(size);

		for(int j = 1; j <= size;j++) {
			String data =  scan.nextLine();
			String[] splitData = data.split("->");
			for(int i = 1; i < splitData.length; i++) {
				int x = Integer.parseInt(splitData[0]);
				int y = Integer.parseInt(splitData[i]);
				gd.createEdge(x - 1,y - 1,1);
			}
		}
			gd.printEdges();
	}
}