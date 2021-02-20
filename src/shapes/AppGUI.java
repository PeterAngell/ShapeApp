package shapes;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;



@SuppressWarnings("unused")
public class AppGUI {

	private JFrame frame;
	private JTextField tfElementId;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					AppGUI window = new AppGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Drawing D1 = new Drawing();
		StringBuilder sb = new StringBuilder();
		frame = new JFrame();
		frame.setBounds(100, 100, 1013, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(650, 25, 282, 391);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JInternalFrame createNewShapeWindow = new JInternalFrame("New JInternalFrame");
		createNewShapeWindow.setEnabled(false);
		createNewShapeWindow.setBounds(161, 96, 358, 296);
		frame.getContentPane().add(createNewShapeWindow);
		createNewShapeWindow.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 25, 630, 422);
		textPane.setEditable(false);
		frame.getContentPane().add(textPane);
		
		JLabel lblNewShapeCoords = new JLabel("Coordinates:");
		lblNewShapeCoords.setBounds(10, 11, 153, 14);
		createNewShapeWindow.getContentPane().add(lblNewShapeCoords);
		
		JButton btnCreateShape = new JButton("Create shape");
		btnCreateShape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreateShape.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = 0;
				int y = 0;
				int r = 0;
				int h = 0;
				int b = 0;
				int id = 0;
				try {
					if(createNewShapeWindow.getTitle().equals("Create new circle:")) {
					x= Integer.parseInt(textField.getText());
					y = Integer.parseInt(textField_1.getText());
					r = Integer.parseInt(textField_2.getText());
					D1.addShape(new Circle(r, new Coord(x,y)));
					sb.append("Circle created");
					sb.append(System.lineSeparator());
					}
					else if(createNewShapeWindow.getTitle().equals("Create new line:")) {
						x= Integer.parseInt(textField.getText());
						y = Integer.parseInt(textField_1.getText());
						r = Integer.parseInt(textField_2.getText());
						D1.addShape(new Line(r, new Coord(x,y)));
						sb.append("Line created");
						sb.append(System.lineSeparator());
					}
					else if(createNewShapeWindow.getTitle().equals("Create new rectangle:")) {
						x= Integer.parseInt(textField.getText());
						y = Integer.parseInt(textField_1.getText());
						b = Integer.parseInt(textField_3.getText());
						h = Integer.parseInt(textField_4.getText());
						D1.addShape(new Rectangle(b,h, new Coord(x,y)));
						sb.append("Rectangle created");
						sb.append(System.lineSeparator());
					}
					else if(createNewShapeWindow.getTitle().equals("Create new triangle:")) {
						x= Integer.parseInt(textField.getText());
						y = Integer.parseInt(textField_1.getText());
						b = Integer.parseInt(textField_3.getText());
						h = Integer.parseInt(textField_4.getText());
						D1.addShape(new Triangle(b,h, new Coord(x,y)));
						sb.append("Triangle created");
						sb.append(System.lineSeparator());
					}
					else if(createNewShapeWindow.getTitle().equals("Move a shape:")) {
						x= Integer.parseInt(textField.getText());
						y = Integer.parseInt(textField_1.getText());
						id = Integer.parseInt(tfElementId.getText());
						
						for(int i = 0; i < D1.getShapeArray().length; i++) {

							if(D1.getShapeArray()[i]!= null) {
								if(D1.getShapeArray()[i].getElementId() == id) {

									D1.getShapeArray()[i].Move(new Coord(x,y));
									sb.append("Shape with id:");
									sb.append(id);
									sb.append(" was moved");
									sb.append(System.lineSeparator());

								}
							}
						}
					}
					else if (createNewShapeWindow.getTitle().equals("Remove a Shape:")) {
						
						id = Integer.parseInt(tfElementId.getText());
						for(int i = 0; i < D1.getShapeArray().length; i++) {

							if(D1.getShapeArray()[i]!= null) {
								if(D1.getShapeArray()[i].getElementId() == id) {
									D1.getShapeArray()[i]=null;
									sb.append("Shape with id:");
									sb.append(id);
									sb.append(" was removed");
									sb.append(System.lineSeparator());
								}
							}
						}
					}
				}
				catch (NumberFormatException e1) {
					System.out.println("error");
					sb.append("error");
				}
				finally{
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					createNewShapeWindow.setEnabled(false);
					createNewShapeWindow.setVisible(false);
					textPane.setText(sb.toString());
					
				}
			}
		});
		btnCreateShape.setBounds(10, 212, 170, 32);
		
		createNewShapeWindow.getContentPane().add(btnCreateShape);
		
		JButton btnCancelShape = new JButton("Cancel");
		btnCancelShape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelShape.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createNewShapeWindow.setEnabled(false);
				createNewShapeWindow.setVisible(false);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnCancelShape.setBounds(190, 212, 142, 32);
		createNewShapeWindow.getContentPane().add(btnCancelShape);
		
		
		JLabel lblX = new JLabel("X:");
		lblX.setBounds(10, 36, 46, 14);
		createNewShapeWindow.getContentPane().add(lblX);
		
		textField = new JTextField();
		textField.setBounds(38, 36, 86, 20);
		createNewShapeWindow.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setBounds(134, 36, 46, 14);
		createNewShapeWindow.getContentPane().add(lblY);
		
		textField_1 = new JTextField();
		textField_1.setBounds(185, 33, 86, 20);
		createNewShapeWindow.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 76, 46, 14);
		createNewShapeWindow.getContentPane().add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(138, 73, 86, 20);
		createNewShapeWindow.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 115, 46, 14);
		createNewShapeWindow.getContentPane().add(lblName);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(142, 115, 46, 14);
		createNewShapeWindow.getContentPane().add(lblName_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(48, 112, 86, 20);
		createNewShapeWindow.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(185, 112, 86, 20);
		createNewShapeWindow.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_1 = new JLabel("Removing  object");
		lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(10, 0, 322, 201);
		createNewShapeWindow.getContentPane().add(lblNewLabel_1);
		createNewShapeWindow.setVisible(false);
		
		JButton btnNewLine = new JButton("Line");
		btnNewLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewLine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createNewShapeWindow.setEnabled(true);
				createNewShapeWindow.setVisible(true);
				lblName.setEnabled(false);
				lblName.setVisible(false);
				lblName_1.setEnabled(false);
				lblName_1.setVisible(false);
				textField_3.setEnabled(false);
				textField_3.setVisible(false);
				textField_4.setEnabled(false);
				textField_4.setVisible(false);
				lblNewLabel_1.setVisible(false);
				lblNewLabel_1.setEnabled(false);
				lblNewLabel.setText("Length");
				lblNewLabel.setVisible(true);
				textField_2.setVisible(true);
				textField_2.setEnabled(true);
				lblX.setVisible(true);
				lblY.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(true);
				textField.setEnabled(true);
				textField_1.setEnabled(true);
				createNewShapeWindow.setTitle("Create new line:");
				lblNewShapeCoords.setText("Coordinates:");
				btnCreateShape.setText("Create Line");
			}
		});
		btnNewLine.setBounds(141, 45, 121, 49);
		panel.add(btnNewLine);
		
		JButton btnNewTriangle = new JButton("Triangle");
		btnNewTriangle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createNewShapeWindow.setEnabled(true);
				createNewShapeWindow.setVisible(true);
				lblName.setEnabled(true);
				lblName.setVisible(true);
				lblName.setText("Base");
				lblName_1.setEnabled(true);
				lblName_1.setVisible(true);
				lblName_1.setText("Height");
				textField_3.setEnabled(true);
				textField_3.setVisible(true);
				textField_4.setEnabled(true);
				textField_4.setVisible(true);
				lblNewLabel.setEnabled(false);
				lblNewLabel.setVisible(false);
				textField_2.setEnabled(false);
				textField_2.setVisible(false);
				lblNewLabel_1.setVisible(false);
				lblNewLabel_1.setEnabled(false);
				lblX.setVisible(true);
				lblY.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(true);
				textField.setEnabled(true);
				textField_1.setEnabled(true);
				createNewShapeWindow.setTitle("Create new triangle:");
				lblNewShapeCoords.setText("Coordinates:");
				btnCreateShape.setText("Create Triangle");
			}
		});
		btnNewTriangle.setBounds(141, 105, 121, 49);
		panel.add(btnNewTriangle);
		
		JButton btnNewRectangle = new JButton("Rectangle");
		btnNewRectangle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createNewShapeWindow.setEnabled(true);
				createNewShapeWindow.setVisible(true);
				lblName.setEnabled(true);
				lblName.setVisible(true);
				lblName_1.setEnabled(true);
				lblName_1.setVisible(true);
				textField_3.setEnabled(true);
				textField_3.setVisible(true);
				textField_4.setEnabled(true);
				textField_4.setVisible(true);
				lblNewLabel.setEnabled(false);
				lblNewLabel.setVisible(false);
				textField_2.setEnabled(false);
				textField_2.setVisible(false);
				lblNewLabel_1.setVisible(false);
				lblNewLabel_1.setEnabled(false);
				lblNewLabel_1.setEnabled(false);
				lblX.setVisible(true);
				lblY.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(true);
				textField.setEnabled(true);
				textField_1.setEnabled(true);
				lblName.setText("Base");
				lblName_1.setText("Height");
				createNewShapeWindow.setTitle("Create new rectangle:");
				lblNewShapeCoords.setText("Coordinates:");
				btnCreateShape.setText("Create Rectangle");
			}
		});
		btnNewRectangle.setBounds(10, 105, 121, 49);
		panel.add(btnNewRectangle);
		
		JButton btnNewCircle = new JButton("Circle");
		btnNewCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewCircle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createNewShapeWindow.setEnabled(true);
				createNewShapeWindow.setVisible(true);
				lblName.setEnabled(false);
				lblName.setVisible(false);
				lblName_1.setEnabled(false);
				lblName_1.setVisible(false);
				textField_3.setEnabled(false);
				textField_3.setVisible(false);
				textField_4.setEnabled(false);
				textField_4.setVisible(false);
				lblNewLabel.setText("Radius");
				lblNewLabel.setVisible(true);
				textField_2.setVisible(true);
				textField_2.setEnabled(true);
				lblX.setVisible(true);
				lblY.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(true);
				textField.setEnabled(true);
				textField_1.setEnabled(true);
				lblNewLabel_1.setVisible(false);
				lblNewLabel_1.setEnabled(false);
				createNewShapeWindow.setTitle("Create new circle:");
				lblNewShapeCoords.setText("Coordinates:");
				btnCreateShape.setText("Create Circle");
				
			}
		});
		btnNewCircle.setBounds(10, 45, 121, 49);
		panel.add(btnNewCircle);
		
		JLabel lblCreateNewShape = new JLabel("Create new shape:");
		lblCreateNewShape.setBounds(10, 11, 108, 23);
		panel.add(lblCreateNewShape);
		
		JLabel lblOperations = new JLabel("Shape operations:");
		lblOperations.setBounds(10, 182, 108, 23);
		panel.add(lblOperations);
		
		JLabel lblElementId = new JLabel("Select element id:");
		lblElementId.setBounds(10, 216, 108, 23);
		panel.add(lblElementId);
		
		tfElementId = new JTextField();
		tfElementId.setBounds(144, 217, 86, 20);
		panel.add(tfElementId);
		tfElementId.setColumns(10);
		
		JButton btnMoveShape = new JButton("Move");
		btnMoveShape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNewShapeWindow.setEnabled(true);
				createNewShapeWindow.setVisible(true);
				lblName.setEnabled(false);
				lblName.setVisible(false);
				lblName_1.setEnabled(false);
				lblName_1.setVisible(false);
				textField_2.setEnabled(false);
				textField_2.setVisible(false);
				textField_3.setEnabled(false);
				textField_3.setVisible(false);
				textField_4.setEnabled(false);
				textField_4.setVisible(false);
				lblNewLabel.setEnabled(false);
				lblNewLabel.setVisible(false);
				lblNewLabel_1.setVisible(false);
				lblNewLabel_1.setEnabled(false);
				lblX.setVisible(true);
				lblY.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(true);
				textField.setEnabled(true);
				textField_1.setEnabled(true);
				lblNewShapeCoords.setText("New Coordinates");
				createNewShapeWindow.setTitle("Move a shape:");
				btnCreateShape.setText("Move shape");
				
			}
		});
		btnMoveShape.setBounds(10, 250, 121, 49);
		panel.add(btnMoveShape);
		
		JButton btnRemoveShape = new JButton("Remove");
		btnRemoveShape.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createNewShapeWindow.setEnabled(true);
				createNewShapeWindow.setVisible(true);
				lblName.setEnabled(false);
				lblName.setVisible(false);
				lblName_1.setEnabled(false);
				lblName_1.setVisible(false);
				textField_2.setEnabled(false);
				textField_2.setVisible(false);
				textField_3.setEnabled(false);
				textField_3.setVisible(false);
				textField_4.setEnabled(false);
				textField_4.setVisible(false);
				lblNewLabel.setEnabled(false);
				lblNewLabel.setVisible(false);
				lblX.setVisible(false);
				lblX.setEnabled(false);
				lblY.setVisible(false);
				lblY.setEnabled(false);
				textField_1.setVisible(false);
				textField_1.setEnabled(false);
				textField.setVisible(false);
				textField.setEnabled(false);
				lblNewLabel_1.setVisible(true);
				lblNewLabel_1.setEnabled(true);
				createNewShapeWindow.setTitle("Remove a Shape:");
				lblNewShapeCoords.setText("");
				btnCreateShape.setText("Yes remove shape");
			}
		});
		btnRemoveShape.setBounds(141, 248, 121, 49);
		panel.add(btnRemoveShape);
		
		JButton btnPrintShapes = new JButton("Print all shapes");
		btnPrintShapes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText(ShapeApp.printGeometryData(D1.getShapeArray()).toString());
			}
		});
		btnPrintShapes.setBounds(10, 338, 252, 41);
		panel.add(btnPrintShapes);
		
		JLabel lblConsole = new JLabel("Console output:");
		lblConsole.setBounds(10, 11, 149, 14);
		frame.getContentPane().add(lblConsole);
		
		
	}

}
