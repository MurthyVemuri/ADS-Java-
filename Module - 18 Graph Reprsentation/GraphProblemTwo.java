import java.util.*;

class GraphDemo {
	
	private int graphVertices;
	private int[][] graphMatrix;
	private Map<Integer,List<Integer>> adjacency_List;	

	GraphDemo(int graphVertices) {
		this.graphVertices = graphVertices;
		graphMatrix = new int[graphVertices + 1][graphVertices + 1];

		adjacency_List = new HashMap<Integer, List<Integer>>();	
		for (int i = 1; i <= graphVertices;  i++) {
			adjacency_List.put(i, new LinkedList<Integer>());
		}
	}

	public void createEdge(int setTo , int setFrom , int edgeValue) {
		try{
			graphMatrix[setTo][setFrom] = edgeValue;
		}catch (Exception e) {}

		if (setTo > adjacency_List.size() || setFrom > adjacency_List.size()) {
			return;
		}
		List<Integer> setTolist = adjacency_List.get(setTo);
		setTolist.add(setFrom);
		/*List<Integer> setFromlist = Adjacency_List.get(setFrom);
		setFromlist.add(setTo);*/
		Collections.sort(setTolist);
	}

	public int getEdge(int setTo , int setFrom) {
		return graphMatrix[setTo][setFrom];
	}


	public List<Integer> getEdge(int source) {

		if (source > adjacency_List.size()) {
			return null;
		}
		return adjacency_List.get(source);
	}

}

public class GraphProblemTwo {
	public static void main(String[] args) {

		int toValue = 0;
		int fromValue = 0;
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		scan.nextLine();
		GraphDemo gd = new GraphDemo(size);

		String inputValue = scan.nextLine();
		String changedInput = inputValue.replace("(","").replace(")","");
		String perfectInput = changedInput.replace(","," ");
		String[] samples = perfectInput.split("  ");

		for(int i = 0; i < samples.length; i++) {
			char[] charArray = samples[i].toCharArray();
			toValue  = (int)charArray[0] - 96 ;
			fromValue = (int)charArray[2] - 96;
			gd.createEdge(toValue , fromValue , 1);
		}
		
		System.out.print("  ");
		for (int i = 1; i <= size; i++)
			System.out.print((char)(i + 96) + " ");
		System.out.println();


		for (int i = 1; i <= size; i++) {
			System.out.print((char)(i + 96) + " ");
			try {	
				for (int j = 1; j <= size; j++) {
					System.out.print(gd.getEdge(i, j) + " ");
				}
			}catch (Exception e) {}
			System.out.println();
		}


		for (int i = 1; i <= size; i++) {
			System.out.print((char)(i + 96) + "->" );
			List<Integer> edgeList = gd.getEdge(i);
			try {
				for (int j = 1; ; j++ ) {
					if(edgeList.size() == 0) {
						System.out.print("null");
						break;
					}
					if (j != edgeList.size()) {
						int value = edgeList.get(j-1);
						System.out.print((char)(value + 96) + "->");
					}else{
						int elseValue = edgeList.get(j - 1 );
						System.out.print((char)(elseValue + 96));
						System.out.print("->null");
						break;
					}
				}
			System.out.println();
			}catch (Exception e) {}
		}
	}
}


/*
import java.util.Scanner;

class GraphDemo {
	
	private int graphVertices;
	private int[][] graphMatrix;

	GraphDemo(int graphVertices) {
		this.graphVertices = graphVertices;
		graphMatrix = new int[graphVertices + 1][graphVertices + 1];
	}

	public void createEdge(int setTo , int setFrom , int edgeValue) {
		try{
			graphMatrix[setTo][setFrom] = edgeValue;
		}catch (Exception e) {}
	}

	public int getEdge(int setTo , int setFrom) {
		return graphMatrix[setTo][setFrom];
	}

}

public class GraphProblemTwo {
	public static void main(String[] args) {

		int toValue = 0;
		int fromValue = 0;
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		scan.nextLine();
		GraphDemo gd = new GraphDemo(size);

		String inputValue = scan.nextLine();
		String changedInput = inputValue.replace("(","").replace(")","");
		String perfectInput = changedInput.replace(","," ");
		String[] samples = perfectInput.split("  ");

		for(int i = 0; i < samples.length; i++) {
			char[] charArray = samples[i].toCharArray();
			toValue = (int)charArray[0];
			fromValue = (int)charArray[2];
			System.out.println( toValue + " " + fromValue);
			gd.createEdge(toValue , fromValue , 1);
		}
		
		System.out.print("  ");
		for (int i = 1; i <= size; i++)
			System.out.print((char)(i + 96) + " ");
		System.out.println();


		for (int i = 1; i <= size; i++) {
			System.out.print((char)(i + 96) + " ");
			try {	
				for (int j = 1; j <= size; j++) {
					System.out.print(gd.getEdge(i, j) + " ");
				}
			}catch (Exception e) {}
			System.out.println();
		}
	}
}


import java.util.Scanner;

class GraphDemo {
	
	private int graphVertices;
	private int[][] graphMatrix;

	GraphDemo(int graphVertices) {
		this.graphVertices = graphVertices;
		graphMatrix = new int[graphVertices + 1][graphVertices + 1];
	}

	public void createEdge(int setTo , int setFrom , int edgeValue) {
		try{
			graphMatrix[setTo][setFrom] = edgeValue;
		}catch (Exception e) {}
	}

	public int getEdge(int setTo , int setFrom) {
		return graphMatrix[setTo][setFrom];
	}

}

public class GraphProblemTwo {
	public static void main(String[] args) {

		int toValue = 0;
		int fromValue = 0;
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		scan.nextLine();
		GraphDemo gd = new GraphDemo(size);

		String inputValue = scan.nextLine();
		String changedInput = inputValue.replace("(","").replace(")","");
		String perfectInput = changedInput.replace(","," ");
		String[] samples = perfectInput.split("  ");
		for(int i = 0; i < samples.length; i++) {
			String[] convertValues = samples[i].split(" ");
			toValue = convertValues[0];
			fromValue = convertValues[1];
			gd.createEdge(toValue , fromValue , 1);
		}
		
		
		System.out.print("  ");
		for (int i = 1; i <= size; i++)
			System.out.print(i + " ");
		System.out.println();


		for (int i = 1; i <= size; i++) {
			System.out.print(i + " ");
			try {	
				for (int j = 1; j <= size; j++) {
					System.out.print(gd.getEdge(i, j) + " ");
				}
			}catch (Exception e) {}
			System.out.println();
		}
	}
}



/*
	for(int i = 1; i <= size; i++) {
		toValue = scan.nextInt();
		fromValue = scan.nextInt();
		gd.createEdge(toValue , fromValue , 1);
	}
*/
