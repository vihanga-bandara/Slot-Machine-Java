
import java.util.Random;

public class Reel1 implements Runnable {

	static int rand1;

	@Override
	public void run() {
		while (Reel.isclick1 != true) {
			int size = Reel.list.size();
			rand1 = new Random().nextInt(size);
			Reel.reel_1.setIcon(Reel.list.get(rand1).getImage());
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		Reel.check();

	}

}