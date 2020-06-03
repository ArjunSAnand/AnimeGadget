/* AnimeGadget
* P: to view the PDT time and have access to all other screens
* June 1st 2020
* Arjun Anand
* ComputerScienceISP.java
*/ 

package ISP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.Box;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Clock;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TimeZone;

import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JScrollPane;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ComputerScienceISP {
	static Document stuff2;
	static String datetoday;
	static String timetoday;
	private JFrame frame;
	static int fav = 0;
	static int s1 = 0;
	static int s2 = 0;
	static int s3 = 0;
	static int s4 = 0;
	static int s5 = 0;
	static int s6 = 0;
	static int s7 = 0;
	static int s8 = 0;
	static int s9 = 0;
	static int s10 = 0;
	static int s11 = 0;
	static int s12 = 0;
	static String data;

	public static void main(String[] args) throws IOException {

		String urldate = "https://www.calendardate.com/todays.htm";
		Document stuff = Jsoup.connect(urldate).timeout(6000).get();
		datetoday = StringUtils.substringBetween(stuff.toString(), "<p>Today's Date is ", "</p>");

		String urltime = "https://time.is/PDT";
		stuff2 = Jsoup.connect(urltime).timeout(6000).get();
		// System.out.println(stuff2.toString());
		timetoday = StringUtils.substringBetween(stuff2.toString(), "<time id=\"clock\">", "</time>");

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComputerScienceISP window = new ComputerScienceISP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ComputerScienceISP() throws IOException {
		initialize();
	}

	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 871, 634);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				ScreenOptions start = new ScreenOptions();
				ScreenOptions.main();

			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lblNewLabel_1.setIcon(new ImageIcon("pictures/58896f8198f84152b7fb8d57339495ef.jpg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(lblNewLabel);

		JLabel date = new JLabel("Date: " + datetoday);
		date.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(date);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("pictures/1459820607_fiwhrgr.png"));
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				ScreenLofi start = new ScreenLofi();
				ScreenLofi.main();

			}
		});

		JLabel timer = new JLabel("Time: " + timetoday);
		timer.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_1.add(timer);

		JButton btnNewButton = new JButton(" ADD");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setIcon(new ImageIcon("pictures/1.jpg"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		frame.getContentPane().add(btnNewButton, BorderLayout.WEST);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Screen2Add start = new Screen2Add();
				Screen2Add.main();
			}

		});

		JButton btnNewButton_1 = new JButton("  Watching");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setIcon(new ImageIcon("pictures/2.jpg"));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		frame.getContentPane().add(btnNewButton_1, BorderLayout.CENTER);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Screen3Watching start = new Screen3Watching();
				Screen3Watching.main();
			}

		});

		JButton btnNewButton_2 = new JButton("  UPCOMING");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setIcon(new ImageIcon("pictures/3.jpg"));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		frame.getContentPane().add(btnNewButton_2, BorderLayout.EAST);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Screen4Upcoming start = new Screen4Upcoming();
					Screen4Upcoming.main();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		String urldate = "https://www.calendardate.com/todays.htm";
		Document stuff = Jsoup.connect(urldate).timeout(6000).get();
		String datetoday = StringUtils.substringBetween(stuff.toString(), "<p>Today's Date is ", " ");
		System.out.println(datetoday);
		System.out.println("datetoday is + " + datetoday);
		// datetoday = "friday";
		if (datetoday.equalsIgnoreCase("monday")) {
			readdataM();
		}
		if (datetoday.equalsIgnoreCase("tuesday")) {
			readdataT();
			System.out.println("READING TUESDAY DATA");
		}
		if (datetoday.equalsIgnoreCase("wednesday")) {
			readdataW();
		}
		if (datetoday.equalsIgnoreCase("thursday")) {
			readdataTh();
		}
		if (datetoday.equalsIgnoreCase("friday")) {
			readdataF();
		}
		if (datetoday.equalsIgnoreCase("saturday")) {
			readdataS();
		}
		if (datetoday.equalsIgnoreCase("sunday")) {
			readdataSu();
		}
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String urltime = "https://time.is/PDT";
				try {
					stuff2 = Jsoup.connect(urltime).timeout(6000).get();
				} catch (IOException e) {
					e.printStackTrace();
				}
				timer.setText("Time: "
						+ StringUtils.substringBetween(stuff2.toString(), "<time id=\"clock\">", "</time>") + " PDT");

				fav = 0;
				fav = fav + Integer.parseInt(StringUtils.substringBetween(data.toString(), "1m", "2m"));
				fav = fav + Integer.parseInt(StringUtils.substringBetween(data.toString(), "2m", "3m"));
				fav = fav + Integer.parseInt(StringUtils.substringBetween(data.toString(), "3m", "4m"));
				fav = fav + Integer.parseInt(StringUtils.substringBetween(data.toString(), "4m", "5m"));
				fav = fav + Integer.parseInt(StringUtils.substringBetween(data.toString(), "5m", "6m"));
				fav = fav + Integer.parseInt(StringUtils.substringBetween(data.toString(), "6m", "7m"));
				fav = fav + Integer.parseInt(StringUtils.substringBetween(data.toString(), "7m", "8m"));
				fav = fav + Integer.parseInt(StringUtils.substringBetween(data.toString(), "8m", "9m"));
				fav = fav + Integer.parseInt(StringUtils.substringBetween(data.toString(), "9m", "10m"));
				fav = fav + Integer.parseInt(StringUtils.substringBetween(data.toString(), "10m", "11m"));
				fav = fav + Integer.parseInt(StringUtils.substringBetween(data.toString(), "11m", "12m"));
				// fav = fav + Integer.parseInt(StringUtils.substringBetween(data.toString(),
				// "12m", "13m"));
				lblNewLabel.setText("You have " + fav + " shows to watch today!");
			}
		};
		Timer t = new Timer(1000, taskPerformer);
		t.start();

	}

	public static void readdataM() throws FileNotFoundException {

		File myObj2 = new File("files/favM.txt");
		Scanner myReader = new Scanner(myObj2);
		while (myReader.hasNextLine()) {
			data = myReader.nextLine();
			System.out.println(data);
		}
		myReader.close();

	}

	public static void readdataT() throws FileNotFoundException {

		File myObj2 = new File("files/favT.txt");
		Scanner myReader = new Scanner(myObj2);
		while (myReader.hasNextLine()) {
			data = myReader.nextLine();
			System.out.println(data);
		}
		myReader.close();

	}

	public static void readdataW() throws FileNotFoundException {

		File myObj2 = new File("files/favW.txt");
		Scanner myReader = new Scanner(myObj2);
		while (myReader.hasNextLine()) {
			data = myReader.nextLine();
			System.out.println(data);
		}
		myReader.close();

	}

	public static void readdataTh() throws FileNotFoundException {

		File myObj2 = new File("files/favTh.txt");
		Scanner myReader = new Scanner(myObj2);
		while (myReader.hasNextLine()) {
			data = myReader.nextLine();
			System.out.println(data);
		}
		myReader.close();

	}

	public static void readdataF() throws FileNotFoundException {

		File myObj2 = new File("files/favF.txt");
		Scanner myReader = new Scanner(myObj2);
		while (myReader.hasNextLine()) {
			data = myReader.nextLine();
			System.out.println(data);
		}
		myReader.close();

	}

	public static void readdataS() throws FileNotFoundException {

		File myObj2 = new File("files/favS.txt");
		Scanner myReader = new Scanner(myObj2);
		while (myReader.hasNextLine()) {
			data = myReader.nextLine();
			System.out.println(data);
		}
		myReader.close();

	}

	public static void readdataSu() throws FileNotFoundException {

		File myObj2 = new File("files/favSu.txt");
		Scanner myReader = new Scanner(myObj2);
		while (myReader.hasNextLine()) {
			data = myReader.nextLine();
			System.out.println(data);
		}
		myReader.close();

	}

}
