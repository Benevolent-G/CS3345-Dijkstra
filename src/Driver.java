/**
 * @author Greyson Paris
 *
 */
public class Driver {
	
	
	public static void main(String[] args){
		InputFromFile fred = new InputFromFile("edges.txt");
		
		Dijkstra dj = new Dijkstra( fred.getAllEdges() );
		
		dj.shortestPath(0);
		dj.am.printAdjacencyMatrix();
		
//		System.out.println(fred.getAllEdges());
//		System.out.println(fred.getAllEdges().size());
//		System.out.println(fred.getAllEdges().get(0));

	}
	
}
