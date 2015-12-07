import java.util.*;

class BfsDfs {
    int numNodes;
    private  int[][] adjacencyMatrix;
    private  int[] visited;

    BfsDfs(int numNodes) {
        this.numNodes = numNodes;
        adjacencyMatrix = new int[numNodes][numNodes];
        visited = new int[numNodes];
    }

    public void setMatrix(int i, int j, int weight) {
        adjacencyMatrix[i][j] = weight;
    }


    public int getMatrix(int i, int j) {
        return adjacencyMatrix[i][j];
    }

    public String toString(){
        return adjacencyMatrix.toString();
    }

    public void dfs(int rootNode) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(rootNode);
        visited[rootNode] = 1;
        printNode(rootNode);
        while (!s.isEmpty()) {
            int n = s.peek();
            int child = getUnvisitedChildNode(n);
            if (child != -1) {
                visited[child] = 1;
                printNode(child);
                s.push(child);
            } else {
                s.pop();
            }
        }
        clearAllVisited();
    }

    public void bfs(int rootNode) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(rootNode);
        printNode(rootNode);
        visited[rootNode] = 1;
        while (!q.isEmpty()) {
            int n = q.remove();
            int child = -1;
            while ((child = getUnvisitedChildNode(n)) != -1) {
                visited[child] = 1;
                printNode(child);
                q.add(child);
            }
        }
        clearAllVisited();
    }

    private void clearAllVisited() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
    }

    private int getUnvisitedChildNode(int n) {
        for (int i = 0; i < adjacencyMatrix[n].length; i++) {
            if (adjacencyMatrix[n][i] == 1 && visited[i] != 1 ) {
                return i;
            }
        }
        return -1;
    }

    private void printNode(int node) {
        //System.out.println("visited node: " + (char) (node + 'A'));
         System.out.print((node + 1) + " ");
    }
}

public class DepthSearchDemos {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
 		BfsDfs bfsdfs = new BfsDfs(size);
		int choice = scan.nextInt();

        if(choice == 0){
            for(int j = 1; j <= size;j++) {
                String data =  scan.nextLine();
                String[] splitData = data.split("->");
                for(int i = 1; i < splitData.length; i++) {
                    int x = Integer.parseInt(splitData[0]);
                    int y = Integer.parseInt(splitData[i]);
                    bfsdfs.setMatrix(x - 1,y - 1,1);
                }
            }
            System.out.println();
            bfsdfs.dfs(0);
        }

		if(choice == 1) {      
			int[][] adjacencyMatrix = new int[size][size];
			int count = 0;
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++) {
					adjacencyMatrix[i][j] = scan.nextInt();
						if(adjacencyMatrix[i][j] == 1)
							bfsdfs.setMatrix(i , j ,1);
				}
			}

			for(int i = 0; i < size ; i++) {
				for(int j = 0; j <= i; j++) {
					int value = bfsdfs.getMatrix(i,j);
					if(value == 1)
						count++;
				}
			}
			bfsdfs.dfs(0);
    	}
	}
}


/*if(choice == 0){
            String outputValue;
            for(int i = 0; i < size; i++) {
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
        }*/