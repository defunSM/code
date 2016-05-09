import javax.swing.*;

class Ch2ShowMessageDialog {
	
	public static void main( String[] args ) {
		
		JFrame jFrame;								// Creates object of type JFrame
				
		jFrame = new JFrame();							// Initalizes the object with type JFrame
		jFrame.setSize(400,300);						// Sets the size to 400 by 300 for the window
		jFrame.setVisible(true);						// Sets the visibility to true to be able to see the window
		
		String text;
		text = new String("Expresso");

		JOptionPane.showMessageDialog(jFrame, "How are you?");			// Pops up a message box which contains "How are you?" In the center of jFrame
		JOptionPane.showMessageDialog(null, text.indexOf("press"));			// Pops up a message box which contains "Good Bye" In the middle of the screen which is what null does
	}
}
