/**
 * JavaBasic
 * Chapter 4 - Inheritance and Interfaces
 * 2014-04-28
 * 
 * Copyright Affix Byte Coders AB
 */

package shapes;


// --------- Define Base Class --------------------------
public abstract class Shape {

	enum ShapeType {RECTANGLE, TRIANGLE, CIRCLE, LINE};
	
    protected float profileLength;
    protected float area;
    
    
    
    private static int uniqueId = 1;
    private Coord location;
    private final ShapeType type;
    private final int elementId;

    protected Shape(ShapeType type, Coord c) {
    	checkCoord(c);
    	this.elementId = uniqueId++;
    	this.type = type;
    	this.location = c;
    }
    
    public abstract void calcProfileLength();
    public abstract void calcArea();
   	public abstract boolean checkMove(Coord theCoord);
    
    /**
	 * @return the uniqueId
	 */
	public static int getUniqueId() {
		return uniqueId;
	}

	/**
	 * @return the location
	 */
	public Coord getLocation() {
		return location;
	}

	/**
	 * @return the type
	 */
	public ShapeType getType() {
		return type;
	}

	/**
	 * @return the elementId
	 */
	public int getElementId() {
		return elementId;
	}

	// present profile length of object
	public float getProfileLength(){
		return profileLength;
	}

    // present area of object
	public float getArea(){
        return area;
	}
	
	
		public Coord getCoordinates() {
			return location;
		}
		public boolean Move(Coord theCoord) {
			int X = theCoord.getX();
			int Y = theCoord.getY();
			
			if(!this.checkMove(theCoord)) {
//				System.out.println("Could not move the shape the dimentions dont fit within limits");
			return false;
			}else {
				this.location = new Coord(X, Y);
//				System.out.println("shape moved successfully");
			return true;
			}
		}
		
	
	@Override
	public String toString() {
		return String.format("Shape [profileLength=%s, area=%s, coordinates = x:%s y:%s elementId= %d]", profileLength, area,getCoordinates().getX(), getCoordinates().getY(), elementId); 
	}
	
	protected static boolean checkCoord(Coord c) {
		int X = c.getX();
		int Y = c.getY();
		
		if(X < ShapeConfiguration.DRAWING_XMIN || X > ShapeConfiguration.DRAWING_XMAX ) {
			throw new IllegalArgumentException(String.format("coord X:%d, coord Y:%d out of limits %n Drawing limits is X:%d Y:%d", c.getX(), c.getY(), ShapeConfiguration.DRAWING_XMAX, ShapeConfiguration.DRAWING_YMAX));
		}
		if(Y < ShapeConfiguration.DRAWING_YMIN || Y > ShapeConfiguration.DRAWING_YMAX ) {
			throw new IllegalArgumentException(String.format("coord X:%d, coord Y:%d out of limits %n Drawing limits is X:%d Y:%d", c.getX(), c.getY(), ShapeConfiguration.DRAWING_XMAX, ShapeConfiguration.DRAWING_YMAX));
		}
		
		return true;
	}

}



