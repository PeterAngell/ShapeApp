/**
 * JavaBasic
 * Chapter 4 - Inheritance and Interfaces
 * 2014-04-28
 * 
 * Copyright Affix Byte Coders AB
 */

package shapes;



//--------------------- Define class Rectangle ------------
public class Rectangle extends Shape{

	private int height;
	private int width;

	// default constructor
	public Rectangle() {
		this(ShapeConfiguration.DEFAULT_DIMENSION, ShapeConfiguration.DEFAULT_DIMENSION);
		
	}
	//overloaded constructor
	public Rectangle(int h, int w) {
		this(h, w, new Coord());
	}
	
	// overloaded constructor
	public Rectangle(int height, int width, Coord theCoord) {
		super(ShapeType.RECTANGLE, theCoord);
		
		if(width <= 0 || height <= 0) {
			throw new IllegalArgumentException(
					String.format("Constructor arguments %d, %d to Rectangle not accepted! %n", height, width));
		}
		
		// make shure that the entire Rectangle fits into current Drawing limits
		super.checkCoord(new Coord(theCoord.getX() + width, theCoord.getY() + height));
		
		this.height = height;
		this.width = width;
		
		calcProfileLength();
		calcArea();
		System.out.println("Rectangle created!");
	}

	// calculate profile length of Rectangle
	public void calcProfileLength(){
		profileLength = 2*(height+width);
	}

	// calculate Area of Rectangle
	public void calcArea(){
		area = height*width;
	}

	@Override
	public String toString() {
		return String.format("Rectangle [height=%s, width=%s, %s]", height, width, super.toString());
	}

	
	@Override
	public boolean checkMove(Coord theCoord) {
		if(super.checkCoord(new Coord(theCoord.getX() , theCoord.getY()))) {
			if(theCoord.getX() + height < ShapeConfiguration.DRAWING_XMAX && theCoord.getY() + width < ShapeConfiguration.DRAWING_YMAX) {
				return true;
			}
		}
		return false;
		
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	
	
	

}

