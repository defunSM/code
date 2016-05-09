import javax.swing.*;

class Ch2Sample1 {
	
	public static void main( String[] args ) {
		
		JFrame myWindow;                                   		        // Creates a object of type JFrame
		myWindow = new JFrame();                           		        // Initalizes the object with the JFrame type

		myWindow.setSize(300, 200);                               	        // Sets the size of the window to 300 by 200
		myWindow.setTitle("My first Java Program");             	        // Sets the title of the window
		myWindow.setVisible(true);                                	        // Determines if you can see the window or not
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	        // Allows the window to be closed if ran by and IDLE (Eclipse)
		
	}
}
