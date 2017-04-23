
import java.util.Random;

public class Reel2 implements Runnable {

	static int rand2;

	@Override
	public void run() {
		while (Reel.isclick2 != true) {
			int size = Reel.list.size();

			rand2 = new Random().nextInt(size);
			Reel.reel_2.setIcon(Reel.list.get(rand2).getImage());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		Reel.check();
	}

}
