/**
 * Node.java Creates a new node for the OcTree
 * 
 * 
 * @author Aayushi Khurana
 * @author Pranay Shashank Adavi
 * 
 * 
 */

public class Node {

	// public Node parent;

	Point[] child = new Point[8];// Array of Child Points

	Node[] childNodes;// Array of child nodes

	int noOfChildNodes = 0;// Count of child nodes

	public Point co_ordinates ; // Co_ordiantes of each node

	public int depth;// depth of each node
	public float dimension;// dimension of node
	static int dpt = 0;

	/**
	 * 
	 * @param id
	 * 
	 *            Constructor to initialize the value of a new node
	 */

	public Node(Point p, int d) {

		/* this.co_ordinates.x = p.x;
		this.co_ordinates.y = p.y;
		this.co_ordinates.z = p.z;*/
		
		this.co_ordinates=new Point(p.x,p.y,p.z);
		
       
		depth = d;
		dimension = (float) (2.0 / Math.pow(2, depth));

	}

	/**
	 * Creates new child Nodes for a node
	 * 
	 * @param newChild
	 *            Array of all points to be put
	 * 
	 * 
	 **/

	public void updateNode(Point[] newChild) {

		String binRep = "";
		Point temp = new Point();
		// Loop to compare the sign of each coordiantes and
		// create new mid points
		for (int i = 0; i < 8; i++) {
			String sign = "";
			binRep = Integer.toBinaryString(i);

			sign = Point.checkSign(binRep);

			if (sign.charAt(0) == 'a') {
				temp.z = co_ordinates.x - dimension / 2;

			} else {
				temp.z = co_ordinates.x + dimension / 2;
			}
			if (sign.charAt(1) == 'a') {

				temp.y = co_ordinates.y - dimension / 2;

			} else {
				temp.y = co_ordinates.y + dimension / 2;
			}
			if (sign.charAt(2) == 'a') {
				temp.x = co_ordinates.z - dimension / 2;

			} else {
				temp.x = co_ordinates.z + dimension / 2;
			}
			// Intializing child nodes
			childNodes[i] = new Node(temp, depth + 1);

		}

	}

	/**
	 * Check the sign of each co-ordinate of a point in child array
	 * 
	 * @param x
	 *            Co-Ordinate X of a 3-D Point
	 * @param y
	 *            Co-Ordinate Y of a 3-D Point
	 * @param z
	 *            Co-Ordinate Z of a 3-D Point
	 * 
	 * @return index This will return the octant no for a particular point
	 * 
	 **/

	public int checkChild(float x, float y, float z) {
		int index = -1;
		// If-else branch for each coordinate to get octant
		if (x > 0 && y > 0 && z > 0) {
			index = 0;
		} else if (x > 0 && y > 0 && z < 0) {
			index = 1;
		} else if (x > 0 && y < 0 && z > 0) {
			index = 2;
		} else if (x > 0 && y < 0 && z < 0) {
			index = 3;
		} else if (x < 0 && y > 0 && z > 0) {
			index = 4;
		} else if (x < 0 && y > 0 && z < 0) {
			index = 5;
		} else if (x < 0 && y < 0 && z > 0) {
			index = 6;
		} else {
			index = 7;
		}
		return index;

	}

	/**
	 * Check the sign of each co-ordinate of a point
	 * 
	 * @param p
	 *            add a point to the OcTree node
	 * 
	 * 
	 **/
	public void add(Point p) {

		if (noOfChildNodes < 8) {
			child[noOfChildNodes] = p;
			noOfChildNodes++;
			// return true;
		} else if (noOfChildNodes == 8) {

			childNodes = new Node[8];
			Point[] tempChild = new Point[9];
			depth = dpt;
			dpt++;
			// depth++;
			dimension = (float) (2 / Math.pow(2, depth));
			for (int i = 0; i < child.length; i++) {
				tempChild[i] = child[i];
			}
			tempChild[8] = p;
			noOfChildNodes = 9;
			child = null;

			updateNode(tempChild);
			// Find octants for each chid points and add them into the right
			// child node
			for (int i = 0; i < 9; i++) {
				int index = checkChild(tempChild[i].x - co_ordinates.x,
						tempChild[i].y - co_ordinates.y, tempChild[i].z
								- co_ordinates.z);
				childNodes[index].add(tempChild[i]);
			}
			// return true;

		} else {
			int index = checkChild(p.x - co_ordinates.x, p.y - co_ordinates.y,
					p.z - co_ordinates.z);
			childNodes[index].add(p);
		}

	}

	/**
	 * Prints the OcTree in Depth First Order
	 * 
	 **/
	public void print() {

		String stubString = "";
		for (int i = 0; i < this.depth; i++) {
			stubString += " ";
		}
		System.out.println(stubString + "(" + this.co_ordinates.x + ","
				+ this.co_ordinates.y + "," + this.co_ordinates.z + ") -- "
				+ dimension);
		// Prints the child points
		if (childNodes == null) {
			for (int i = 0; i < 8; i++)
				if (child[i] != null)
					System.out.println(stubString + "  * (" + child[i].x + ","
							+ child[i].y + "," + child[i].z + ")");

		} else {
			for (int i = 0; i < 8; i++) {
				childNodes[i].print();
			}
		}

	}
}
