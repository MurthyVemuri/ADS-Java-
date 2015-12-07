
class AdjacencyMatrix<E> {

	private E[][] matrix;
	private boolean directedGraph = false;

	AdjacencyMatrix<E>(int numberOfVertex) {
		matrix = (E[][]) new Object[numberOfVertex][numberOfVertex];

	}

	public void AdjacencyMatrix(int numberOfVertex, boolean directedGraph) {
		for (int i = 0; i < numberOfVertex; i++) {
			for (int j = 0; j < numberOfVertex; j++) {
				setEdge(i, j, null);
			}
		}
		this.directedGraph = directedGraph;
	}

	public boolean isEdge(int i, int j) {
		return (matrix[i][j] != null);
	}

	public void setEdge(int i, int j, E weight) {
		matrix[i][j] = weight;
		if (!directedGraph) {
			matrix[j][i] = weight;
		}
	}


	public E getEdge(int i, int j) {
		return matrix[i][j];
	}

	public String toString(){
		return matrix.toString();
	}
}

public class AdjacentMatrixDemo {
	public static void main(String[] args) {
		
	}
}