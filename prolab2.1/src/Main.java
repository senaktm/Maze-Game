import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;



public class Main {
Timer t;
JLabel mantar;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Main();
	}
	public Main() {
		JFrame f = new JFrame();
		f.setTitle("SMURF GAME");
		f.add(new Board1());
		f.setSize(500,400);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		
	}


		
		
	

}
