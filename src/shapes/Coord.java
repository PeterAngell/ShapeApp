package shapes;

public class Coord {

	private final int x;
	private final int y;
	
	public Coord() {
		x=1;
		y=1;
	}
	
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
}
