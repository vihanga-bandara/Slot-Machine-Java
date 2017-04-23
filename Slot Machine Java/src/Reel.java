import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.glass.ui.Window;

public class Reel extends JFrame {
	public static ArrayList<Symbol> list = new ArrayList<Symbol>();
	static JButton addCoin = new JButton("Add Coin");
	static JLabel creditArea = new JLabel("Shows number of credit you have");
	static JLabel betArea = new JLabel("Shows the number of credits currently betting");
	static JButton betOne = new JButton("Bet One");
	static JButton betMax = new JButton("Bet Max");
	static JButton reset = new JButton("Reset");
	static JButton spin = new JButton("SPIN");
	static JButton reel_1 = new JButton("");
	static JButton reel_2 = new JButton("");
	static JButton reel_3 = new JButton("");
	static JButton statistics = new JButton("Statistics");

	private final static int initialCredit = 10;
	static int currentCredit = initialCredit;
	static int betAmount = 0;
	static int betCharge = 0;
	static int wins = 0;
	static int losses = 0;
	static int noOfGames = 0;

	static boolean isclick1;
	static boolean isclick2;
	static boolean isclick3;
	static int f = 0;

	String status;
	int creditsWon = 0;

	public static void CreateFrame() {
		JFrame frame = new JFrame("Slot Machine");
		JPanel Mainpanel = new JPanel(new BorderLayout());
		JPanel toppanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel botmpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel rsidepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel centerpanel = new JPanel(new GridLayout(1, 3));
		JPanel lsidepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		addCoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				spin.setEnabled(true);
				betOne.setEnabled(true);
				betMax.setEnabled(true);
				currentCredit++;
				creditArea.setText("Current Credit Amount : " + Integer.toString(currentCredit));
			}

		});

		betOne.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				betAmount++;
				currentCredit--;
				creditArea.setText("Current Credit Amount : " + Integer.toString(currentCredit));
				betArea.setText("Current Bet Amount : " + Integer.toString(betAmount));
				if (currentCredit <= 0) {
					betOne.setEnabled(false);
					betMax.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Sorry! You have insufficient credits. Please add more ",
							"Game Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					reset.setEnabled(true);
					betOne.setEnabled(true);
				}
			}

		});

		betMax.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				final int betMaxi = 3;
				if (currentCredit != 0 && currentCredit >= 3) {
					reset.setEnabled(true);
					betAmount += betMaxi;
					currentCredit -= betMaxi;
					creditArea.setText("Current Credit Amount : " + Integer.toString(currentCredit));
					betArea.setText("Current Bet Amount : " + Integer.toString(betAmount));
				} else {
					JOptionPane.showMessageDialog(null, "Sorry! You have insufficient credits. Please add more ",
							"Game Info", JOptionPane.INFORMATION_MESSAGE);
					betMax.setEnabled(false);
				}
			}

		});

		reset.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				betOne.setEnabled(true);
				betMax.setEnabled(true);
				currentCredit += betAmount;
				betAmount = 0;
				betArea.setText("You have not bet yet");
				creditArea.setText("Current Credit Amount : " + Integer.toString(currentCredit));
				reel_1.setIcon(null);
				reel_2.setIcon(null);
				reel_3.setIcon(null);
			}

		});

		spin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				reset.setEnabled(false);
				betMax.setEnabled(false);
				betOne.setEnabled(false);
				addCoin.setEnabled(false);
				spin.setEnabled(false);
				statistics.setEnabled(false);
				if (betAmount > 0) {
					f = 1;
					betCharge = 0;
					betCharge = betAmount;
					betAmount = 0;
					isclick1 = false;
					isclick2 = false;
					isclick3 = false;
					Thread t1 = new Thread(new Reel1());
					Thread t2 = new Thread(new Reel2());
					Thread t3 = new Thread(new Reel3());
					t1.start();
					t2.start();
					t3.start();

				} else {
					JOptionPane.showMessageDialog(null, "You have to bet first! ", "Game Info",
							JOptionPane.INFORMATION_MESSAGE);
					reset.setEnabled(true);
					betMax.setEnabled(true);
					betOne.setEnabled(true);
					addCoin.setEnabled(true);
					spin.setEnabled(true);
					statistics.setEnabled(true);
				}

			}

		}

		);

		reel_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				isclick1 = true;
			}

		});

		reel_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				isclick2 = true;
			}

		});

		reel_3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				isclick3 = true;
			}

		});

		statistics.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (noOfGames > 0) {
					Statistics stats = new Statistics();

				} else {
					JOptionPane.showMessageDialog(null, "No statistics to show");
				}
			}

		});
		botmpanel.add(addCoin);
		toppanel.add(creditArea);
		toppanel.add(betArea);
		botmpanel.add(betOne);
		botmpanel.add(betMax);
		botmpanel.add(statistics);
		rsidepanel.add(reset);
		rsidepanel.add(spin);
		centerpanel.add(reel_1);
		centerpanel.add(reel_2);
		centerpanel.add(reel_3);

		botmpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // create
		// border
		// for
		// bottom
		// panel
		creditArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		betArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		Mainpanel.add(toppanel, BorderLayout.NORTH);
		Mainpanel.add(botmpanel, BorderLayout.SOUTH);
		Mainpanel.add(rsidepanel, BorderLayout.EAST);
		Mainpanel.add(lsidepanel, BorderLayout.WEST);
		Mainpanel.add(centerpanel, BorderLayout.CENTER);

		frame.add(Mainpanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 400);
		frame.setVisible(true);
		frame.setIconImage(new ImageIcon("Images/frameIcon/shvibdy.jpg").getImage());

	}

	public static void check() {
		while ((Reel.isclick1 != false) && (Reel.isclick2 != false) && (Reel.isclick3 != false)) {
			Symbol go = new Symbol();
			go.Winnings();

			if (currentCredit > 0) {
				spin.setEnabled(true);
			} else if (currentCredit > 0 && betAmount > 0) {
				JOptionPane.showMessageDialog(null, "Your allocated Credit is over. Please add more", "Game Info",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public static void Symbols() {
		Symbol seven = new Symbol();
		seven.setImage("Images/redseven.png");
		seven.setValue(7);
		list.add(seven);
		Symbol bell = new Symbol();
		bell.setImage("Images/bell.png");
		bell.setValue(6);
		list.add(bell);
		Symbol watermelon = new Symbol();
		watermelon.setImage("Images/watermelon.png");
		watermelon.setValue(5);
		list.add(watermelon);
		Symbol plum = new Symbol();
		plum.setImage("Images/plum.png");
		plum.setValue(4);
		list.add(plum);
		Symbol lemon = new Symbol();
		lemon.setImage("Images/lemon.png");
		lemon.setValue(3);
		list.add(lemon);
		Symbol cherry = new Symbol();
		cherry.setImage("Images/cherry.png");
		cherry.setValue(2);
		list.add(cherry);
	}

	@Override
	public String toString() {
		return "Reel [status=" + status + ", creditsWon=" + creditsWon + "]";
	}

	public ArrayList<Symbol> spin() {
		Collections.shuffle(list);
		return list;
	}

	public Reel(String status, int creditsWon) {

		this.status = status;
		this.creditsWon = creditsWon;
	}

}
