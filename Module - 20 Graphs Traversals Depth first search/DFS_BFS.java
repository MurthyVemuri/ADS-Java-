import java.util.LinkedList;
import java.util.Queue;
	

public class DFS_BFS
{

	public static void main(String[] args){
		new DFS_BFS();
	}
	
	int N;
	boolean[][] G; 
	
	
	DFS_BFS(){
		setupGraph();
		DFS();
		BFS();
	}
	
	void setupGraph()
	{		
		N=8;
		G=new boolean[N][N];
		
		G[0][1]=G[1][0]=true;
		G[0][2]=G[2][0]=true;	
		G[0][3]=G[3][0]=true;
		G[1][4]=G[4][1]=true;
		G[3][4]=G[4][3]=true;
		G[5][6]=G[6][5]=true;
		G[5][7]=G[7][5]=true;
		G[6][7]=G[7][6]=true;
	}
	
	// perform a DFS on the graph G
	void DFS()
	{
		boolean[] V=new boolean[N]; // a visited array to mark which vertices have been visited while doing the DFS
		
		int numComponets=0; // the number of components in the graph
		
		// do the DFS from each node not already visited
		for (int i=0; i<N; ++i)
			if (!V[i])
			{
				++numComponets;
				System.out.printf("Starting a DFS for component %d starting at node %d%n",numComponets,i);
				
				DFS(i,V);
			}
		
		System.out.println();
		System.out.printf("Finished with DFS - found %d components.%n", numComponets);
	}
	
	// perform a DFS starting at node at (works recursively)
	void DFS(int at, boolean[] V)
	{
		System.out.printf("At node %d in the DFS%n",at);
		
		// mark that we are visiting this node
		V[at]=true;
		
		// recursively visit every node connected to this that we have not already visited
		for (int i=0; i<N; ++i)
			if (G[at][i] && !V[i])
			{
				System.out.printf("Going to node %d...",i);
				DFS(i,V);
			}
		
		System.out.printf("Done processing node %d%n", at);
	}
	
	// perform a BFS on the graph G 
	void BFS()
	{
		boolean[] V=new boolean[N]; // a visited array to mark which vertices have been visited while doing the BFS
		
		int numComponets=0; // the number of components in the graph
		
		// do the BFS from each node not already visited
		for (int i=0; i<N; ++i)
			if (!V[i])
			{
				++numComponets;
				System.out.printf("Starting a BFS for component %d starting at node %d%n",numComponets,i);
				
				BFS(i,V);
			}
		
		System.out.println();
		System.out.printf("Finished with BFS - found %d components.%n", numComponets);
	}
	
	// perform a BFS starting at node start
	void BFS(int start, boolean[] V)
	{
		Queue<Integer> Q=new LinkedList<Integer>(); // A queue to process nodes
		
		// start with only the start node in the queue and mark it as visited
		Q.offer(start);
		V[start]=true;
				
		// continue searching the graph while still nodes in the queue
		while (!Q.isEmpty())
		{
			int at=Q.poll(); // get the head of the queue
			System.out.printf("At node %d in the BFS%n",at);
			
			// add any unseen nodes to the queue to process, then mark them as visited so they don't get re-added
			for (int i=0; i<N; ++i)
				if (G[at][i] && !V[i])
				{
					Q.offer(i);
					V[i]=true;
					
					System.out.printf("Adding node %d to the queue in the BFS%n", i);
				}
			
			System.out.printf("Done processing node %d%n", at);
		}
		
		System.out.printf("Finished with the BFS from start node %d%n", start);
	}

}