/**
 * JavaBasic
 * Chapter 4 - Inheritance and Interfaces
 * 2014-04-28
 * 
 * Copyright Affix Byte Coders AB
 */

package shapes;


//--------------------- Define class Circle ------------
public class Circle extends Shape{

	private int radius;
	private int border;
	
	public Circle() {
		this(ShapeConfiguration.DEFAULT_DIMENSION);
	}

	// constructor
	public Circle(int r){
		this(r, new Coord());
		

	}
	public Circle(int r, Coord theCoord){
		super(ShapeType.CIRCLE,theCoord);
		// Border is an imaginary square around the circle to controll conflict with drawing dimentions
		
		if(r <= 0 ) {
			throw new IllegalArgumentException(
					String.format("Constructor arguments %d to Circle not accepted!", r));

		}
		// can only check if the length is going outside the parameters so height is 0 for now
				super.checkCoord(new Coord(theCoord.getX() + border, theCoord.getY() + border));
		radius = r;
		border = radius*2;
		calcProfileLength();
		calcArea();
		System.out.println("Circle created!");

	}

	// calculate profile length of Circle object
	public void calcProfileLength(){
		profileLength = (float) (2*Math.PI*radius);
	}

	// calculate area of Circle object
	public void calcArea(){
		area = (float) (Math.PI*radius*radius);
	}


	@Override
	public String toString() {
		return String.format("Circle [radius=%s, %s]", radius, super.toString());
	}

	

	@Override
	public boolean checkMove(Coord theCoord) {
		if(super.checkCoord(new Coord(theCoord.getX() , theCoord.getY()))) {
			if(theCoord.getX() + border < ShapeConfiguration.DRAWING_XMAX && theCoord.getY() + border < ShapeConfiguration.DRAWING_YMAX) {
				return true;
			}
		}
		return false;
		
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	



}