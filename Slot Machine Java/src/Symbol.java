import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Symbol implements ISymbol {
	private ImageIcon ii = null;
	private int Value = 0;

	public Symbol() {

	}

	// setters and getters
	@Override
	public void setImage(String image) {
		this.ii = new ImageIcon(image);

	}

	@Override
	public ImageIcon getImage() {

		return ii;
	}

	@Override
	public String toString() {
		return "ImageIcon =" + ii + ", Value= " + Value + ", getImage()=" + getImage() + ", getValue()=" + getValue()
				+ ", getClass()=" + getClass();
	}

	@Override
	public void setValue(int Value) {

		this.Value = Value;

	}

	@Override
	public int getValue() {

		return Value;
	}

	public void Winnings() {
		String Status = "";
		int creditsWon = 0;
		Reel.spin.setEnabled(false);
		if ((Reel.list.get(Reel1.rand1)).equals(Reel.list.get(Reel2.rand2))
				&& (Reel.list.get(Reel1.rand1)).equals(Reel.list.get(Reel3.rand3))) {
			JOptionPane.showMessageDialog(null, "You Win!", "Game Result", JOptionPane.INFORMATION_MESSAGE);
			Reel.wins++; // ask
			Reel.noOfGames++;
			Reel.currentCredit += (Reel.betCharge) * (Reel.list.get(Reel1.rand1).getValue());
			Reel.creditArea.setText("Current Credit Amount : " + Integer.toString(Reel.currentCredit));
			Status = "Won";
			creditsWon = (Reel.betCharge) * (Reel.list.get(Reel1.rand1).getValue());

			Reel.spin.setEnabled(false);
			Reel.betArea.setText("Current Bet Amount : 0");

		} else if ((Reel.list.get(Reel1.rand1)).equals(Reel.list.get(Reel2.rand2))) {

			JOptionPane.showMessageDialog(null, "You Win! Free Spin Chance", "Game Result",
					JOptionPane.INFORMATION_MESSAGE);
			Reel.wins++;
			Reel.noOfGames++;
			Reel.betAmount = Reel.betCharge;
			Reel.creditArea.setText("Current Credit Amount : " + Integer.toString(Reel.currentCredit));
			Status = "Won - Free Spin Given";
			creditsWon = 0;
			Reel.spin.setEnabled(true);
		} else if ((Reel.list.get(Reel1.rand1)).equals(Reel.list.get(Reel3.rand3))) {
			JOptionPane.showMessageDialog(null, "You Win! Free Spin Chance", "Game Result",
					JOptionPane.INFORMATION_MESSAGE);
			Reel.wins++;
			Reel.noOfGames++;
			Reel.betAmount = Reel.betCharge;
			Reel.creditArea.setText("Current Credit Amount : " + Integer.toString(Reel.currentCredit));
			Status = "Won - Free Spin Given";
			creditsWon = 0;
			Reel.spin.setEnabled(true);
		} else if ((Reel.list.get(Reel2.rand2)).equals(Reel.list.get(Reel3.rand3))) {
			JOptionPane.showMessageDialog(null, "You Win! Free Spin Chance", "Game Result",
					JOptionPane.INFORMATION_MESSAGE);
			Reel.wins++;
			Reel.noOfGames++;
			Reel.betAmount = Reel.betCharge;
			Reel.creditArea.setText("Current Credit Amount : " + Integer.toString(Reel.currentCredit));
			Status = "Won - Free Spin Given";
			creditsWon = 0;
			Reel.spin.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(null, "You lose", "Game Result", JOptionPane.INFORMATION_MESSAGE);
			Reel.losses++;
			Reel.noOfGames++;
			Status = "Lost";
			creditsWon = 0;
			Reel.betArea.setText("Current Bet Amount : 0");

		}
		Reel t = new Reel(Status, creditsWon);
		Statistics.stats.add(t);

		Reel.isclick1 = false;
		Reel.isclick2 = false;
		Reel.isclick3 = false;
		Reel.f = 0;
		Reel.reset.setEnabled(true);
		Reel.betMax.setEnabled(true);
		Reel.betOne.setEnabled(true);
		Reel.addCoin.setEnabled(true);
		Reel.statistics.setEnabled(true);
	}

}
