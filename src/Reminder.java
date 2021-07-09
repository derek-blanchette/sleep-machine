import java.util.Timer;
import java.util.TimerTask;
import java.io.*;

public class Reminder {
	Timer timer;

	public Reminder(int seconds) {
		timer = new Timer();
		timer.schedule(new RemindTask(), seconds * 1000 * 60);
	}

	class RemindTask extends TimerTask {
		public void run() throws RuntimeException {
			try {
				if ("Mac OS X".equals(System.getProperty("os.name"))) {
					Runtime.getRuntime().exec("shutdown -h now");
				}
			} catch (IOException e) {
			}
			System.exit(0);
			timer.cancel(); //Terminate the timer thread
		}
	}

	public static void main(String args[]) {

	}
}