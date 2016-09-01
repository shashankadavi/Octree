/**
 * Point.java Calculates a point in 3D Space
 * 
 * 
 * @author Aayushi Khurana
 * @author Pranay Shashank Adavi
 * 
 * 
 */

public class Point {
	// Co_ordiantes in a 3D Space
	float x;
	float y;
	float z;

	/**
	 * 
	 * Constructor to initialize with default values
	 */

	public Point() {
		this.x=0;
		this.y=0;
		this.z=0;

	}

	/**
	 * 
	 * @param x
	 *            Co-ordinate X of a point
	 * @param y
	 *            Co-ordinate Y of a point
	 * @param z
	 *            Co-ordinate Z of a point
	 * 
	 *            Constructor to initialize the coordinates of a point
	 */
	public Point(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * 
	 * @param s
	 *            String CoOrdiantes
	 * 
	 *            Constructor to initialize the coordinates of a point
	 */

	public Point(String s) {
		if (s.length() == 1) {
			this.x = s.charAt(0)-'0' ;
			this.y = 0;
			this.z = 0;

		} else if (s.length() == 2) {
			this.x = s.charAt(1)-'0' ;
			this.y = s.charAt(0)-'0';
			this.z = 0;

		} else {
			this.x = s.charAt(2)-'0';
			this.y = s.charAt(1)-'0';
			this.z = s.charAt(0)-'0';
		}
	}

	/**
	 * Check the sign of each co-ordinate of a point
	 * 
	 * @param s
	 *            String containing the binary representation
	 * 
	 * @return String which will help in deciding the octant of a point
	 * 
	 **/

	public static String checkSign(String s) {
		Point p = new Point(s);

		String sign = "";
		if (p.x > 0) {
			sign += "a";
		} else {
			sign += "b";
		}
		if (p.y >0) {
			sign += "a";
		} else {
			sign += "b";
		}
		if (p.z >0) {
			sign += "a";
		} else {
			sign += "b";
		}

		return sign;

	}
}
