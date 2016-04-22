import java.util.Arrays;
import java.util.List;
/**
 * @author Greyson Paris
 *
 */
public class AdjacencyMatrix {
//DATA	
	
	List<int[]> edges;
	int[][] adjacencyMatrix;
	
//CONSTRUCTORS	
	
	AdjacencyMatrix(){
		//throw new Exception("NoInputException");
	}
	
	AdjacencyMatrix(List<int[]> inputEdges){
		edges = inputEdges;
		matrixFromEdges(48, 48);
	}
	
	AdjacencyMatrix(List<int[]> inputEdges, int row, int col){ 
		edges = inputEdges;
		matrixFromEdges(row, col);
	}
	
//LOGIC
	
	private void matrixFromEdges( int row, int col){
		adjacencyMatrix = new int[row][col];
		
		for (int[] x : edges){
			setElement(x[0], x[1], x[2]);//create the edge out
			setElement(x[1], x[0], x[2]);//create also the return
		}
		
	}
	
//ACCESS
	
	private void setElement(int row, int col, int val){
		adjacencyMatrix[row][col] = val;
	}
	
	public int getElement(int row, int col){
		return adjacencyMatrix[row][col];
	}
	
	public int[] getRow(int row){
		return adjacencyMatrix[row];
	}
	
	public void setEdges(List<int[]> inputEdges){
		edges = inputEdges;
	}
	
	public void printAdjacencyMatrix(){
		for (int x = 0; x < adjacencyMatrix.length; x++)
		{
			System.out.println( Arrays.toString(adjacencyMatrix[x]) );
		}
	}
}
