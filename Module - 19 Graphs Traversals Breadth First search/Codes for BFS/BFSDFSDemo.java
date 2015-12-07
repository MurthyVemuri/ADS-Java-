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


public class BFSDFSDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        BfsDfs bfsdfs = new BfsDfs(size);
        
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


        // for (int i = 0; i < adjacencyMatrix.length; i++) {
        //     System.out.println(Arrays.toString(adjacencyMatrix[i]));
        // }

        System.out.print("DFS :");
        bfsdfs.dfs(0);

        System.out.print("\nBFS :");
        bfsdfs.bfs(0);
    }
}

/*
import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {
  
  public void BFSTravese(int[][] matrix, int root){
    // Create a queue
    LinkedList<Integer> queue = new LinkedList<Integer>();
    // Create a visited list.
    ArrayList<Integer> visited = new ArrayList<Integer>();
    
    // Insert the start vertex into the queue.
    queue.offer(root);
    
    // While the queue is not empty
    while(!queue.isEmpty()){
      int node = queue.poll();
      visited.add(node);
      System.out.printf("%d ", node); // Print the node ID to console.
      
      for(int i = 0; i < matrix.length; i++){
        // If node not in queue or in visited add to queue.
        if(matrix[node][i] != 0){ // Make sure we are an edge
          if(!queue.contains(i) && !visited.contains(i)){
            queue.offer(i);
          }
        }
      }
    }
  }
  
}

*/



/*
import java.util.ArrayList;
import java.util.Stack;

public class DFS {
    
  public void DFSTravese(int[][] matrix, int root){
    // Create a queue
    Stack<Integer> stack = new Stack<Integer>();
    // Create a visited list.
    ArrayList<Integer> visited = new ArrayList<Integer>();
    
    // Insert the start vertex into the queue.
    stack.push(root);
    
    // While the queue is not empty
    while(!stack.isEmpty()){
      int node = stack.pop();
      visited.add(node);
      System.out.printf("%d ", node); // Print the node ID to console.
      
      for(int i = 0; i < matrix.length; i++){
        // If node not in queue or in visited add to queue.
        if(matrix[node][i] != 0){ // Make sure we are an edge
          if(!stack.contains(i) && !visited.contains(i)){
            stack.push(i);
          }
        }
      }
    }
  }
}

*/