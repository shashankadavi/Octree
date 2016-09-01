/**
 * OcTree.java
 * Creates an OcTree
 * 
 * 
 * @author Aayushi Khurana
 * @author Pranay Shashank Adavi
 * 
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OcTree {
	// Root node of OcTree
	Point p;
	Node rootTree;

	/**
	 * 
	 * @param id
	 * 
	 *            Constructor to initialize the root node
	 */

	OcTree() {
		p = new Point(0, 0, 0);
		rootTree = new Node(p, 0);
	}

	/**
	 * Add a point to the OcTree
	 * 
	 * @param p
	 *            Point in 3D Space
	 * 
	 * 
	 **/

	public void add(Point p) {

		rootTree.add(p);

	}

	/**
	 * The main program.
	 * 
	 * @param name
	 *            .file Input Text File
	 */

	public static void main(String[] args) {

		OcTree newTree = new OcTree();
		float no1;
		float no2;
		float no3;

		Scanner sc = null;
		try {
			sc = new Scanner(new File(args[0]));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Taking input from file
		while (sc.hasNextLine()) {

			no1 = Float.parseFloat(sc.next());// Converting to float from string
			no2 = Float.parseFloat(sc.next());
			no3 = Float.parseFloat(sc.next());
			Point aPoint = new Point(no1, no2, no3);
			newTree.rootTree.add(aPoint);

		}
		newTree.rootTree.print();// Printing the OcTree
		sc.close();

	}
}
