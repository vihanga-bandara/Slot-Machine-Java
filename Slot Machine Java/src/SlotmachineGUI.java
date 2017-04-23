import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlotmachineGUI {
	static JButton addCoin = new JButton("Add Coin");
	static JLabel creditArea = new JLabel("shows number of credit you have");
	static JLabel betArea = new JLabel("shows the number of credits currently betting");
	static JButton betOne = new JButton("Bet One");
	static JButton betMax = new JButton("Bet Max");
	static JButton reset = new JButton("Reset");
	static JButton spin = new JButton("SPIN");
	static JLabel reel1 = new JLabel("HI");
	static JLabel reel2 = new JLabel("HI");
	static JLabel reel3 = new JLabel("HI");

	public static void CreateFrame() {
		JFrame frame = new JFrame("Slot Machine");
		JPanel Mainpanel = new JPanel(new BorderLayout());
		JPanel toppanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel botmpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel rsidepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel centerpanel = new JPanel(new GridLayout(1, 3));
		JPanel lsidepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		botmpanel.add(addCoin);
		toppanel.add(creditArea);
		toppanel.add(betArea);
		botmpanel.add(betOne);
		botmpanel.add(betMax);
		rsidepanel.add(reset);
		rsidepanel.add(spin);
		centerpanel.add(reel1);
		centerpanel.add(reel2);
		centerpanel.add(reel3);

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

		JLabel label = new JLabel("Top Panel");
		toppanel.add(label);

		frame.add(Mainpanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
		frame.setIconImage(new ImageIcon("Images/frameIcon/shvibdy.jpg").getImage());

	}

	public static void main(String[] args) {
		CreateFrame();
	}

}
