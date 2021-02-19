package shapes;

import java.util.Locale;

public class Line extends Shape {
	
	private int length;
	
	public Line(){
		this(ShapeConfiguration.DEFAULT_DIMENSION);
	}
	
	public Line(int length){
		this(length, new Coord());
	}
	public Line(int length, Coord theCoord) {
		super(ShapeType.LINE, theCoord);
		if(length <=0 ) {
			throw new IllegalArgumentException(
					String.format("Constructor arguments %d to Line not accepted!", length));
		}
		// can only check if the length is going outside the parameters so height is 0 for now
		super.checkCoord(new Coord(theCoord.getX() + length, theCoord.getY() + 0));
		this.length = length;
		calcProfileLength();
		System.out.println("Line created");
	}
	@Override
	public void calcProfileLength() {
		profileLength = length;
	}
	
	
	@Override
	public void calcArea() {
		area = 0;
		
	}

		
	@Override
	public String toString() {
		return String.format(Locale.US,"Line [Length = %d, %s]", length, super.toString());
	}
	@Override
	public boolean checkMove(Coord theCoord) {
		if(super.checkCoord(new Coord(theCoord.getX() , theCoord.getY()))) {
			if(theCoord.getX() + length < ShapeConfiguration.DRAWING_XMAX && theCoord.getY() + 0 < ShapeConfiguration.DRAWING_YMAX) {
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	

}
