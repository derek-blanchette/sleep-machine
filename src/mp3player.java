import java.io.*;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;


public class mp3player {

	public static void main(String[] args) throws JavaLayerException, IOException  {
		String path = null;
		
		//Choose sound file
		Object[] possibleValues = { "Train Ride", "Brown Noise", "Forest Sanctuary" };
		Object selectedValue = JOptionPane.showInputDialog(null,
		"Choose one", "Input",
		JOptionPane.INFORMATION_MESSAGE, null,
		possibleValues, possibleValues[0]);  
		  
		System.out.println("You selected " + selectedValue.toString());
		
		//Determine Minutes
		String inputTime = JOptionPane.showInputDialog("How many minutes would you like?");
		//Convert string to integer
		int mins = Integer.parseInt(inputTime);
		
		//Set file path
		if (selectedValue.toString().equals("Brown Noise")) {
			path = "src/brown_noise.mp3";
			
		}
		else if (selectedValue.toString().equals("Train Ride")) {
			path = "src/train.mp3";
		}
		else if (selectedValue.toString().equals("Forest Sanctuary")) {
			path = "src/park.mp3";
		}
			

		//Setup the stream

		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);

		//Setup the player
		Player player = new Player(bis);
		
		
		//Create a timer that will end at specified minutes
		new Reminder(mins);
		
		//Start music, ensured to play long enough
		for (int i = 1; i > 0; i = i + 1){
			player.play();
		}

	}
}
