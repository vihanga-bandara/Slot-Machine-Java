import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Statistics extends JFrame {

	static ArrayList<Reel> stats = new ArrayList<Reel>();
	JFrame frames = new JFrame("Statistics");
	JPanel mainspanel = new JPanel(new BorderLayout());
	JPanel centerspanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel topspanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel botmspanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	static JLabel wins = new JLabel();
	static JLabel losses = new JLabel();
	static JLabel avg = new JLabel();
	static JButton save = new JButton("Save statistics");
	static double average = 0;

	public Statistics() {
		buildFrame();
	}

	public void buildFrame() {
		frames.add(mainspanel);
		frames.setSize(800, 300);
		setLocation(600, 300);
		frames.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		centerspanel.add(wins);
		centerspanel.add(losses);
		centerspanel.add(avg);
		topspanel.add(save);
		wins.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		losses.setBorder(BorderFactory.createLineBorder(Color.RED));
		avg.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		mainspanel.add(centerspanel, BorderLayout.CENTER);
		mainspanel.add(topspanel, BorderLayout.NORTH);
		mainspanel.add(botmspanel, BorderLayout.EAST);
		createStats();
		createTable();
		save.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				save();
			}

		});

	}

	public void createTable() {
		JTable table = new JTable();
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < stats.size(); i++) {
			list.add(new Object[] { i + 1, stats.get(i).status, stats.get(i).creditsWon });

		}
		table.setModel(new DefaultTableModel(list.toArray(new Object[][] {}),
				new String[] { "Game Number", "Status", "Coins/Credit Won" }));
		JScrollPane tab = new JScrollPane(table);
		botmspanel.add(tab);
	}

	public static void createStats() {
		int total = 0;
		wins.setText("Number of Wins : " + Integer.toString(Reel.wins));
		losses.setText("Number of Losses : " + Integer.toString(Reel.losses));
		for (int i = 0; i < stats.size(); i++) {
			total += stats.get(i).creditsWon;
		}
		average = total / Reel.noOfGames;
		avg.setText("Average Number of Credits Netted Per Game : " + Double.toString(average));
	}

	public static void save()

	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = df.format(new Date());
		time = time + ".txt";
		String line = null;
		String line1 = null;
		try {
			File bit = new File(time);
			if (!bit.exists()) {
				bit.createNewFile();
			}
			FileWriter b = new FileWriter(bit);
			BufferedWriter lol = new BufferedWriter(b);
			for (int i = 0; i < stats.size(); i++) {
				line1 = ("Status of the game : " + stats.get(i).status + " Coins/Credit Won : "
						+ stats.get(i).creditsWon);
				lol.write(line1);
				lol.newLine();
			}
			line = "Number of Wins : " + Reel.wins + " Number of Losses :  " + Reel.losses
					+ " Number of Credits Netted Per Game :  " + (average);
			lol.write(line);
			lol.newLine();

			lol.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Statistics saved to a text file");
	}

}
