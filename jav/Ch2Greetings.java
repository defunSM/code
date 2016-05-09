import javax.swing.*;

class Ch2Greetings {
	
	public static void main( String[] args ) {
		
		String name;
		name = JOptionPane.showInputDialog(null, "What is your name?");          // Takes input
		
		JOptionPane.showMessageDialog(null, "Nice to meet you, " + name + ".");  // Displays the name
	}
}
