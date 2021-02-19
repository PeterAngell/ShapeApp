package shapes;

public class Drawing {

	private Shape[] shapeArray = new Shape[ShapeConfiguration.MAX_OBJECTS];
	private int nextIndex = 0;
	
	public Drawing() {
		System.out.println("Drawing created");
	}
	
	boolean addShape(Shape s){
		
		
		if(nextIndex < ShapeConfiguration.MAX_OBJECTS) {
			shapeArray[nextIndex++] = s;
			return true;
		}else {
			for(int i = 0; i < shapeArray.length; i++) {
				if(shapeArray[i] == null) {
					shapeArray[i] = s;
					return true;
				}
				
			}
		}
		
		
		return false;
		
	}
	
	Shape[] getShapeArray() {
		return shapeArray;
	}
}
