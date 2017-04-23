
import java.util.Random;

public class Reel3 implements Runnable {

	static int rand3;

	@Override
	public void run() {
		while (Reel.isclick3 != true) {
			int size = Reel.list.size();
			rand3 = new Random().nextInt(size);
			Reel.reel_3.setIcon(Reel.list.get(rand3).getImage());
			try {
				Thread.sleep(90);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		Reel.check();
	}

}
