import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class AdjacencyList {

	static ArrayList<ArrayList<edge>> adjacencyList;
	static ArrayList<HashSet<Integer>> adjacencyEdges;

	public static void main(String[] args) {
		new AdjacencyList().run();
	}


	public void run() {

		Scanner in = new Scanner(System.in);
		int caseCount = Integer.parseInt(in.nextLine());
		int loopCount = 0;
		while (caseCount - loopCount > 0) {
			String line = in.nextLine();
			Scanner sc = new Scanner(line);
			int vertexCount = sc.nextInt();
			int edgeCount = sc.nextInt();
			adjacencyList = new ArrayList<ArrayList<edge>>();
			adjacencyEdges = new ArrayList<HashSet<Integer>>();

			for (int n = 0; n < vertexCount; n++) {
				adjacencyList.add(new ArrayList<edge>());
				adjacencyEdges.add(new HashSet<Integer>());
			}

			while (edgeCount-- > 0) {
				line = in.nextLine();
				sc = new Scanner(line);
				int source = sc.nextInt();
				int dest = sc.nextInt();
				edge edge1 = new edge(dest, 0);
				edge edge2 = new edge(source, 0);
				if (!adjacencyEdges.get(source).contains(edge1.hashCode())) {
					adjacencyEdges.get(source).add(edge1.hashCode());
					adjacencyList.get(source).add(edge1);
				}
				if (!adjacencyEdges.get(dest).contains(edge2.hashCode())) {
					adjacencyEdges.get(dest).add(edge2.hashCode());
					adjacencyList.get(dest).add(edge2);
				}
			}

			System.out.printf("%d\n", ++loopCount);
			for (int i = 0; i < vertexCount; i++) {
				System.out.printf("%d: ", i);
				ArrayList<edge> edges = adjacencyList.get(i);
				Collections.sort(edges);
				for (int node = 0; node < edges.size(); node++) {
					if (node + 1 == edges.size()) {
						System.out.print(edges.get(node).vertex);
					} else {
						System.out.printf("%d, ", edges.get(node).vertex);
					}
				}
				System.out.println();
			}
		}
	}
}

class edge implements Comparable<edge> {

	public int vertex, weight;

	public edge(int v, int w) {
		vertex = v;
		weight = w;
	}


	public int compareTo(edge o) {
		if (this.vertex < o.vertex) {
			return -1;
		} else if (this.vertex > o.vertex) {
			return 1;
		} else {
			return 0;
		}
	}


	public int hashCode() {
		int hash = 1;
		hash = 100007 * hash + this.vertex;
		hash = 100007 * hash + this.weight;
		return hash;
	}
}