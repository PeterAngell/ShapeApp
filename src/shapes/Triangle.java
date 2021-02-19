package shapes;

public class Triangle extends Shape{

	private int base;
	private int height;
	
	
	Triangle(){
		this(ShapeConfiguration.DEFAULT_DIMENSION, ShapeConfiguration.DEFAULT_DIMENSION);
		
	}
	Triangle(int base, int height){
		this(base, height, new Coord());
		
	}
	Triangle(int base, int height, Coord theCoord){
		super(ShapeType.TRIANGLE, theCoord);
		
		if(base <= 0 || height <= 0 ) {
			throw new IllegalArgumentException(
					String.format("Constructor arguments %d, %d to Triangle not accepted! %n", base, height ));
		}
		
		// make shure that the entire Triangle fits into current Drawing limits
		super.checkCoord(new Coord(theCoord.getX() + (int)base, theCoord.getY() + (int)height));
		
		this.base = base;
		this.height = height;
		calcProfileLength();
		calcArea();
		System.out.println("Triangle created");
		
	}

	// calculate profile length of Triangle
		@Override
		public void calcProfileLength(){
			float side = (float)Math.sqrt(base*base + height*height);
			profileLength = base+height+side;
		}
		@Override
		public void calcArea() {
			area = ((base*height)/2F);
			
		}
		@Override
		public String toString() {
			return String.format("Triangle [base=%s, height=%s, %s]", base, height, super.toString());
		}
		
		
		@Override
		public boolean checkMove(Coord theCoord) {
			if(super.checkCoord(new Coord(theCoord.getX() , theCoord.getY()))) {
				if(theCoord.getX() + base < ShapeConfiguration.DRAWING_XMAX && theCoord.getY() + height < ShapeConfiguration.DRAWING_YMAX) {
					return true;
				}
			}
			return false;
			
		}
		/**
		 * @return the base
		 */
		public int getBase() {
			return base;
		}
		/**
		 * @return the height
		 */
		public int getHeight() {
			return height;
		}
		
		
		
}
