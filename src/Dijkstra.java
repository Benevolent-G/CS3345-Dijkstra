
import java.util.List;
/**
 * @author Greyson Paris
 *
 */
public class Dijkstra {
//DATA
	AdjacencyMatrix am;
	Vertex[] vertex;
	
//CONSTRUCTORS
	Dijkstra(List<int[]> inputEdges){
		am = new AdjacencyMatrix(inputEdges);  
		vertex = generateVertexSet(am.adjacencyMatrix.length);
	}

//LOGIC
	
	/**
		Intent: The driving method. Give it a starting point, and everything else happens automagically
		
	*/
	public void shortestPath(int start){
		vertex[start].setSource();
		int index = start;
		
		while (hasUnknown()){
		getNeighbors(index);
		index = getNextIndex();
		}
		printDistanceRelation(start);
	}
	
	public void printDistanceRelation(int src){
		for (int i=0; i < vertex.length; i++){
			System.out.println("The shortest distance between State["+src+"] and State["+i+"]is: "+ vertex[i].distance);
			}
	}
	
	/**
		Intent: finds the next node to pursue and returns it. It does this by pursing the shortest unknown lead. 
	 */
	private int getNextIndex(){
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i< vertex.length; i++){
			if(!vertex[i].known){
				if( vertex[i].distance < min){
					min = vertex[i].distance;
					minIndex = i;
				}
			}
		}
		
		return minIndex;
	}
	
	/**
		Intent: check to see if vertex src has a shorter connection to any of its neighbors.
		after investigating all neighbors, mark node true.

	*/
	private void getNeighbors(int src){
		int[] row = am.getRow(src);

		for ( int i = 0; i < row.length; i++){
			if (row[i] > 0){
				if ( (vertex[src].distance + row[i]) < vertex[i].distance ){
					vertex[i].distance = vertex[src].distance + row[i];
					vertex[i].parent = src;
				}
			} 
		}
		vertex[src].known=true;
	}
	
	private Vertex[] generateVertexSet(int setSize){
		Vertex[] set = new Vertex[setSize];
		for (int i = 0; i < set.length; i++) {
			set[i] = new Vertex();
		}

		return set;
	}	
	
	private boolean hasUnknown(){
		for(Vertex v : vertex){
			if (!v.known) return true;
		}
		return false;
	}


//ACCESS
	
	
}
