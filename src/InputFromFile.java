import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Greyson Paris
 *
 */
public class InputFromFile {

	ArrayList<int[]> edges;

	InputFromFile(String filename) {
		edges = new ArrayList<int[]>();
		try {
			readInputFile(filename);
		} catch (FileNotFoundException e) {
			System.out.println("file not found duder");
			e.printStackTrace();
		}
	}

	public ArrayList<int[]> getAllEdges() {
		return edges;
	}

	private void readInputFile(String inputFilePath) throws FileNotFoundException {
		File input = new File(inputFilePath);
		if (input.exists()) {
			Scanner in = new Scanner(input);

			int[] edgeParams;
			String[] temp;

			while (in.hasNextLine()) {
				edgeParams = new int[3];
				temp = in.nextLine().split(" ");
				for (int i = 0; i < 3; i++) {
					edgeParams[i] = Integer.parseInt(temp[i]);
				}
				edges.add(edgeParams);
			}
			in.close();
		}
	}

}
