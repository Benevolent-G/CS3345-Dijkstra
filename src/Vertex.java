/**
 * @author Greyson Paris
 *
 */
public class Vertex {
//DATA
	//public boolean known; // the known column
	public int distance; // the dv column
	public int parent; // the pv column
	public boolean known;
	
//CONSTRUCTORS
	Vertex(){
		known = false;
		distance = Integer.MAX_VALUE;
		parent = 0;
	}
	
//LOGIC
	
	
//ACCESS
	public void setSource(){
		distance = 0;
	}	
}

	