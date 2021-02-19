/**
 * JavaBasic
 * Chapter 4 - Inheritance and Interfaces
 * 2014-04-28
 * 
 * Copyright Affix Byte Coders AB
 */

package shapes;

import java.util.InputMismatchException;
import java.util.Scanner;

import affix.java.basic.exceptions.Shape.ShapeType;
/*FOR TESTING COMMENT THIS CLASS*/
public class ShapeApp {

	static Scanner input = new Scanner(System.in);

	private static void addShapes(Drawing theDrawing) { 
		input.useDelimiter(System.lineSeparator());

		@SuppressWarnings("unused")
		ShapeType type;
		@SuppressWarnings("unused")
		Shape temp = null;
		boolean more = true;
		boolean again = true;
		while(again) {
			System.out.println("Choose a Shape:");
			for(int i = 0; i < Shape.ShapeType.values().length; i++) {
				System.out.format("%d ", i+1);
				System.out.println(Shape.ShapeType.values()[i]);
			}
			
			System.out.println("5: Go back");

			try {
				int choise = input.nextInt();
				
				switch(choise) {
				case 1:
					type = ShapeType.RECTANGLE;

					System.out.println("Rectangle choosen; enter (height, width)");
					String userRectangle = input.next();
				String[] rectangleParts = userRectangle.split(",");
					int h = Integer.parseInt(rectangleParts[0].trim());
					int w = Integer.parseInt(rectangleParts[1].trim());
					more = theDrawing.addShape(new Rectangle(h, w, userCoord())); 
					break;
				case 2:
					type = ShapeType.TRIANGLE;
					System.out.println("Triangle choosen; enter (base, height)");
					String userTriangle = input.next();
					String[] triangleParts = userTriangle.split(",");
					int base = Integer.parseInt(triangleParts[0].trim());
					int height = Integer.parseInt(triangleParts[1].trim());							
					more = theDrawing.addShape(new Triangle(base, height,userCoord()));
					break;
				case 3:
					type = ShapeType.CIRCLE;
					System.out.println("Circle choosen; enter (radius)");
					int r = Integer.parseInt(input.next());						
					more = theDrawing.addShape(new Circle(r, userCoord()));
					break;
				case 4:
					type = ShapeType.LINE;
					System.out.println("Line choosen; enter (Length)");
					int length = Integer.parseInt(input.next());
					more = theDrawing.addShape(new Line(length, userCoord()));
					break;
				case 5:
					System.out.println("ok going back");
					again = false;

				}


			}




			catch (NumberFormatException e) {
				System.out.format("Input error, try again!%n");

			}
			catch (IllegalArgumentException e) {
				System.out.println("Input problem" + e.toString() + "Try again!%n");

			}
			catch (InputMismatchException e) {
				System.out.format("Input not recognized try again%n", e.toString());

			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Input error" + e.toString()+ "%n");

			}

			if(!more) {
				System.out.println("Array full can´t store more shapes remove shapes to make space!");
			}




		}
	}

	private static void removeShapes(Drawing theDrawing) { 
		input.useDelimiter(System.lineSeparator());
		printGeometryData(theDrawing.getShapeArray());
	try {
			System.out.println("Choose the elementId of the shape to remove:");
			int elementId = input.nextInt();

			for(int i = 0; i < theDrawing.getShapeArray().length; i++) {

				if(theDrawing.getShapeArray()[i]!= null) {
					if(theDrawing.getShapeArray()[i].getElementId() == elementId) {
						theDrawing.getShapeArray()[i]=null;
						System.out.format("removed Shape with id :%d %n", elementId);
					}
				}
			}
		}
		catch (InputMismatchException e) {
			System.out.println("Input error");

		}

	}
	public static void moveShape(Drawing theDrawing) { 
		input.useDelimiter(System.lineSeparator());
		boolean move = false;
		printGeometryData(theDrawing.getShapeArray());
		try {
			System.out.println("Choose the elementId of the shape to move:");
			int elementId =  input.nextInt();

			System.out.println("choose new coords");
		Coord aCoord =   userCoord();

			for(int i = 0; i < theDrawing.getShapeArray().length; i++) {

				if(theDrawing.getShapeArray()[i]!= null) {
					if(theDrawing.getShapeArray()[i].getElementId() == elementId) {

						move = theDrawing.getShapeArray()[i].Move(aCoord);

					}
				}
			}
		}
		catch (InputMismatchException e) {
			System.out.println("Input error");

		}
		catch (IllegalArgumentException e) {
			System.out.format("Input error", e.toString());

		}
		if(!move) {
			System.out.println("Could not move the shape the dimentions dont fit within limits");
		}else {
			System.out.println("shape moved successfully");
		}

	}

	private static Coord userCoord() throws NumberFormatException {

		System.out.println("Enter Coordinate value (x, y) for possition in Drawing");

		String userCoords = input.next();
		String[] parts =  userCoords.split(",");
		int x = Integer.parseInt(parts[0].trim());
		int y = Integer.parseInt(parts[1].trim());


		return new Coord(x, y);
	}

	public static StringBuilder printGeometryData(Shape[] shapeArray){

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<shapeArray.length; i++){
			if(shapeArray[i]!= null) {
				sb.append(shapeArray[i]);
				sb.append(System.lineSeparator());
			}
		}
		return sb;
	}


				public static void main(String[] args) {
	
					Drawing theDrawing = new Drawing();
					boolean more = true;
			
					input.useDelimiter(System.lineSeparator());
	
					while(more) {
						System.out.println("make a choice:");
						System.out.println("1: Create shape");
						System.out.println("2: Remove shape");
						System.out.println("3: Move shape");
						System.out.println("4: Print Shapes");
						System.out.println("5: Quit");
	
						try {
							int choise = Integer.parseInt(input.next());
	
							switch(choise) {
	
							case 1:
								addShapes(theDrawing);
								break;
							case 2:
								removeShapes(theDrawing);
								break;
							case 3:
								moveShape(theDrawing);
								break;
							case 4:
								printGeometryData(theDrawing.getShapeArray());
								break;
							case 5:
								System.out.println("quitting");
								more=false;
								break;
							}
	
						}
						catch (NumberFormatException e) {
							System.out.format("Input error, try again!");
							more = true;
						}
						catch (IllegalArgumentException e) {
							System.out.println("Input problem" + e.toString() + "Try again!");
							more = true;
						}
						catch (InputMismatchException e) {
							System.out.format("Input not recognized try again", e.toString());
							more = true;
						}
					}
				}
}

