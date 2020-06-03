/* AnimeGadget
* P: to view the release schedule and favourite shows
* June 1st 2020
* Arjun Anand
* Screen4Upcoming.java
*/ 


package ISP;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.net.URL;
import org.xml.sax.SAXException;
import javax.swing.ImageIcon;

public class Screen4Upcoming {
	// static String v = "t";
	static String u;
	static ArrayList<String> xM = new ArrayList<String>();
	static ArrayList<String> xT = new ArrayList<String>();
	static ArrayList<String> xW = new ArrayList<String>();
	static ArrayList<String> xTh = new ArrayList<String>();
	static ArrayList<String> xF = new ArrayList<String>();
	static ArrayList<String> xS = new ArrayList<String>();
	static ArrayList<String> xSu = new ArrayList<String>();

	static ArrayList<String> xMt = new ArrayList<String>();
	static ArrayList<String> xTt = new ArrayList<String>();
	static ArrayList<String> xWt = new ArrayList<String>();
	static ArrayList<String> xTht = new ArrayList<String>();
	static ArrayList<String> xFt = new ArrayList<String>();
	static ArrayList<String> xSt = new ArrayList<String>();
	static ArrayList<String> xSut = new ArrayList<String>();

	static ArrayList<String> xMl = new ArrayList<String>();
	static ArrayList<String> xTl = new ArrayList<String>();
	static ArrayList<String> xWl = new ArrayList<String>();
	static ArrayList<String> xThl = new ArrayList<String>();
	static ArrayList<String> xFl = new ArrayList<String>();
	static ArrayList<String> xSl = new ArrayList<String>();
	static ArrayList<String> xSul = new ArrayList<String>();

	static ArrayList<String> xMi = new ArrayList<String>();
	static ArrayList<String> xTi = new ArrayList<String>();
	static ArrayList<String> xWi = new ArrayList<String>();
	static ArrayList<String> xThi = new ArrayList<String>();
	static ArrayList<String> xFi = new ArrayList<String>();
	static ArrayList<String> xSi = new ArrayList<String>();
	static ArrayList<String> xSui = new ArrayList<String>();
	static int counterx = 0;
	static JLabel[] arr = new JLabel[13];
	static JLabel[] arrfav = new JLabel[13];
	static int p;
	private JFrame frame;
	static int counter = 0;
	static int q = 0;
	static int custom1 = 0;
	static int custom2 = 0;
	static int custom3 = 0;
	static int counterclear = 0;
	static int x1 = 0;
	static int x2 = 0;
	static int x3 = 0;
	static int x4 = 0;
	static int x5 = 0;
	static int x6 = 0;
	static int x7 = 0;
	static int x8 = 0;
	static int x9 = 0;
	static int x10 = 0;
	static int x11 = 0;
	static int x12 = 0;
	static String data;
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

	static String m1 = "1m";
	static String m2 = "2m";
	static String m3 = "3m";
	static String m4 = "4m";
	static String m5 = "5m";
	static String m6 = "6m";
	static String m7 = "7m";
	static String m8 = "8m";
	static String m9 = "9m";
	static String m10 = "10m";
	static String m11 = "11m";
	static String m12 = "12m";
	static String m13 = "13m";

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen4Upcoming window = new Screen4Upcoming();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public Screen4Upcoming() throws IOException {
		xM.clear();
		xT.clear();
		xW.clear();
		xTh.clear();
		xF.clear();
		xS.clear();
		xSu.clear();
		analyze();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	public void initialize() throws IOException {

		System.out.println(s1);
		frame = new JFrame();
		frame.setBounds(100, 100, 777, 655);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		ScreenOptions start = new ScreenOptions();
		custom1 = ScreenOptions.sendcustom1(custom1);
		custom2 = ScreenOptions.sendcustom2(custom2);
		custom3 = ScreenOptions.sendcustom3(custom3);

		System.out.println("Custom1 is " + custom1);
		System.out.println("Custom2 is " + custom2);
		System.out.println("Custom3 is " + custom3);

		JLabel lblNewLabel = new JLabel("Currently Airing");
		lblNewLabel.setBounds(0, 0, 765, 30);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("DAY OF THE WEEK:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(61, 68, 266, 30);
		frame.getContentPane().add(lblNewLabel_1);
		String urldate = "https://www.calendardate.com/todays.htm";
		Document stuff = Jsoup.connect(urldate).timeout(6000).get();
		String datetoday = StringUtils.substringBetween(stuff.toString(), "<p>Today's Date is ", " ");
		System.out.println(datetoday);
//datetoday = "friday";
		if (datetoday.equalsIgnoreCase("monday")) {

			generatedataM();
			readdataM();
		}
		if (datetoday.equalsIgnoreCase("tuesday")) {
			System.out.println("x3 is: " + x3);

			readdataT();
			generatedataT();
			readdataT();
		}
		if (datetoday.equalsIgnoreCase("wednesday")) {
			generatedataW();
			readdataW();
		}
		if (datetoday.equalsIgnoreCase("thursday")) {
			generatedataTh();
			readdataTh();
		}
		if (datetoday.equalsIgnoreCase("friday")) {
			generatedataF();
			readdataF();
		}
		if (datetoday.equalsIgnoreCase("saturday")) {
			generatedataS();
			readdataS();
		}
		if (datetoday.equalsIgnoreCase("sunday")) {
			generatedataSu();
			readdataSu();
		}

		arr[1] = new JLabel("");
		arr[1].setForeground(Color.black);
		arr[1].setFont(new Font("Times New Roman", Font.BOLD, 20));
		arr[1].setBounds(61, 168, 183, 16);
		frame.getContentPane().add(arr[1]);
		System.out.println(data);
		if (Integer.parseInt(StringUtils.substringBetween(data.toString(), "1m", "2m")) == 0) {
			arrfav[1] = new JLabel("Favourite");
			arrfav[1].setForeground(Color.red);
			arrfav[1].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[1].setBounds(61, 223, 183, 14);
			frame.getContentPane().add(arrfav[1]);
		} else {
			arrfav[1] = new JLabel("Un-Favourite");
			arrfav[1].setForeground(Color.blue);
			arrfav[1].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[1].setBounds(61, 223, 183, 14);
			frame.getContentPane().add(arrfav[1]);
		}

		arr[2] = new JLabel("");
		arr[2].setFont(new Font("Times New Roman", Font.BOLD, 20));
		arr[2].setBounds(292, 168, 183, 16);
		frame.getContentPane().add(arr[2]);

		if (Integer.parseInt(StringUtils.substringBetween(data.toString(), "2m", "3m")) == 0) {
			arrfav[2] = new JLabel("Favourite");
			arrfav[2].setForeground(Color.red);
			arrfav[2].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[2].setBounds(292, 223, 183, 14);
			frame.getContentPane().add(arrfav[2]);
		} else {
			arrfav[2] = new JLabel("Un-Favourite");
			arrfav[2].setForeground(Color.blue);
			arrfav[2].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[2].setBounds(292, 223, 183, 14);
			frame.getContentPane().add(arrfav[2]);
		}
		arr[3] = new JLabel("");
		arr[3].setFont(new Font("Times New Roman", Font.BOLD, 20));
		arr[3].setBounds(542, 168, 183, 16);
		frame.getContentPane().add(arr[3]);
		if (Integer.parseInt(StringUtils.substringBetween(data.toString(), "3m", "4m")) == 0) {
			arrfav[3] = new JLabel("Favourite");
			arrfav[3].setForeground(Color.red);
			arrfav[3].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[3].setBounds(542, 223, 183, 14);
			frame.getContentPane().add(arrfav[3]);
		} else {
			arrfav[3] = new JLabel("Un-Favourite");
			arrfav[3].setForeground(Color.blue);
			arrfav[3].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[3].setBounds(542, 223, 183, 14);
			frame.getContentPane().add(arrfav[3]);
		}
		arr[4] = new JLabel("");
		arr[4].setFont(new Font("Times New Roman", Font.BOLD, 20));
		arr[4].setBounds(61, 279, 183, 16);
		frame.getContentPane().add(arr[4]);
		if (Integer.parseInt(StringUtils.substringBetween(data.toString(), "4m", "5m")) == 0) {
			arrfav[4] = new JLabel("Favourite");
			arrfav[4].setForeground(Color.red);
			arrfav[4].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[4].setBounds(61, 330, 183, 14);
			frame.getContentPane().add(arrfav[4]);
		} else {
			arrfav[4] = new JLabel("Un-Favourite");
			arrfav[4].setForeground(Color.blue);
			arrfav[4].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[4].setBounds(61, 330, 183, 14);
			frame.getContentPane().add(arrfav[4]);
		}
		arr[5] = new JLabel("");
		arr[5].setFont(new Font("Times New Roman", Font.BOLD, 20));
		arr[5].setBounds(292, 279, 183, 16);
		frame.getContentPane().add(arr[5]);
		if (Integer.parseInt(StringUtils.substringBetween(data.toString(), "5m", "6m")) == 0) {
			arrfav[5] = new JLabel("Favourite");
			arrfav[5].setForeground(Color.red);
			arrfav[5].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[5].setBounds(292, 330, 183, 14);
			frame.getContentPane().add(arrfav[5]);
		} else {
			arrfav[5] = new JLabel("Un-Favourite");
			arrfav[5].setForeground(Color.blue);
			arrfav[5].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[5].setBounds(292, 330, 183, 14);
			frame.getContentPane().add(arrfav[5]);
		}
		arr[6] = new JLabel("");
		arr[6].setFont(new Font("Times New Roman", Font.BOLD, 20));
		arr[6].setBounds(542, 279, 183, 16);
		frame.getContentPane().add(arr[6]);
		if (Integer.parseInt(StringUtils.substringBetween(data.toString(), "6m", "7m")) == 0) {
			arrfav[6] = new JLabel("Favourite");
			arrfav[6].setForeground(Color.red);
			arrfav[6].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[6].setBounds(542, 330, 183, 14);
			frame.getContentPane().add(arrfav[6]);
		} else {
			arrfav[6] = new JLabel("Un-Favourite");
			arrfav[6].setForeground(Color.blue);
			arrfav[6].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[6].setBounds(542, 330, 183, 14);
			frame.getContentPane().add(arrfav[6]);
		}
		arr[7] = new JLabel("");
		arr[7].setFont(new Font("Times New Roman", Font.BOLD, 20));
		arr[7].setBounds(61, 382, 183, 16);
		frame.getContentPane().add(arr[7]);
		if (Integer.parseInt(StringUtils.substringBetween(data.toString(), "7m", "8m")) == 0) {
			arrfav[7] = new JLabel("Favourite");
			arrfav[7].setForeground(Color.red);
			arrfav[7].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[7].setBounds(61, 438, 183, 14);
			frame.getContentPane().add(arrfav[7]);
		} else {
			arrfav[7] = new JLabel("Un-Favourite");
			arrfav[7].setForeground(Color.blue);
			arrfav[7].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[7].setBounds(61, 438, 183, 14);
			frame.getContentPane().add(arrfav[7]);
		}
		arr[8] = new JLabel("");
		arr[8].setFont(new Font("Times New Roman", Font.BOLD, 20));
		arr[8].setBounds(292, 382, 183, 16);
		frame.getContentPane().add(arr[8]);
		if (Integer.parseInt(StringUtils.substringBetween(data.toString(), "8m", "9m")) == 0) {
			arrfav[8] = new JLabel("Favourite");
			arrfav[8].setForeground(Color.red);
			arrfav[8].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[8].setBounds(292, 438, 183, 14);
			frame.getContentPane().add(arrfav[8]);
		} else {
			arrfav[8] = new JLabel("Un-Favourite");
			arrfav[8].setForeground(Color.blue);
			arrfav[8].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[8].setBounds(292, 438, 183, 14);
			frame.getContentPane().add(arrfav[8]);
		}
		arr[9] = new JLabel("");
		arr[9].setFont(new Font("Times New Roman", Font.BOLD, 20));
		arr[9].setBounds(542, 382, 183, 16);
		frame.getContentPane().add(arr[9]);
		if (Integer.parseInt(StringUtils.substringBetween(data.toString(), "9m", "10m")) == 0) {
			arrfav[9] = new JLabel("Favourite");
			arrfav[9].setForeground(Color.red);
			arrfav[9].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[9].setBounds(542, 438, 183, 14);
			frame.getContentPane().add(arrfav[9]);
		} else {
			arrfav[9] = new JLabel("Un-Favourite");
			arrfav[9].setForeground(Color.blue);
			arrfav[9].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[9].setBounds(542, 438, 183, 14);
			frame.getContentPane().add(arrfav[9]);
		}
		arr[10] = new JLabel("");
		arr[10].setFont(new Font("Times New Roman", Font.BOLD, 20));
		arr[10].setBounds(61, 495, 183, 16);
		frame.getContentPane().add(arr[10]);
		if (Integer.parseInt(StringUtils.substringBetween(data.toString(), "10m", "11m")) == 0) {
			arrfav[10] = new JLabel("Favourite");
			arrfav[10].setForeground(Color.red);
			arrfav[10].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[10].setBounds(61, 551, 183, 14);
			frame.getContentPane().add(arrfav[10]);
		} else {
			arrfav[10] = new JLabel("Un-Favourite");
			arrfav[10].setForeground(Color.blue);
			arrfav[10].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[10].setBounds(61, 551, 183, 14);
			frame.getContentPane().add(arrfav[10]);
		}
		arr[11] = new JLabel("");
		arr[11].setFont(new Font("Times New Roman", Font.BOLD, 20));
		arr[11].setBounds(292, 495, 183, 16);
		frame.getContentPane().add(arr[11]);
		if (Integer.parseInt(StringUtils.substringBetween(data.toString(), "11m", "12m")) == 0) {
			arrfav[11] = new JLabel("Favourite");
			arrfav[11].setForeground(Color.red);
			arrfav[11].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[11].setBounds(292, 551, 183, 14);
			frame.getContentPane().add(arrfav[11]);
		} else {
			arrfav[11] = new JLabel("Un-Favourite");
			arrfav[11].setForeground(Color.blue);
			arrfav[11].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[11].setBounds(292, 551, 183, 14);
			frame.getContentPane().add(arrfav[11]);
		}
		arr[12] = new JLabel("");
		arr[12].setFont(new Font("Times New Roman", Font.BOLD, 20));
		arr[12].setBounds(542, 495, 183, 16);
		frame.getContentPane().add(arr[12]);
		if (StringUtils.substringBetween(data.toString(), "12m", "13m") == "0") {
			arrfav[12] = new JLabel("Favourite");
			arrfav[12].setForeground(Color.red);
			arrfav[12].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[12].setBounds(542, 551, 183, 14);
			frame.getContentPane().add(arrfav[12]);
		} else {
			arrfav[12] = new JLabel("Un-Favourite");
			arrfav[12].setForeground(Color.blue);
			arrfav[12].setFont(new Font("Times New Roman", Font.BOLD, 20));
			arrfav[12].setBounds(542, 551, 183, 14);
			frame.getContentPane().add(arrfav[12]);
		}

		lblNewLabel_1.setText(datetoday);

		JLabel lblNewLabel_2 = new JLabel("");

		clear();

		if (custom1 == 1) {
			lblNewLabel_2.setIcon(new ImageIcon("pictures/upcoming backgroudn test.jpg"));
		}
		if (custom2 == 1) {
			lblNewLabel_2.setIcon(new ImageIcon("pictures/forest2.jpg"));
		}
		if (custom3 == 1) {
			lblNewLabel_2.setIcon(new ImageIcon("pictures/ocean.jpg"));
		}
		lblNewLabel_2.setBounds(0, 0, 765, 620);
		frame.getContentPane().add(lblNewLabel_2);

		if (datetoday.equalsIgnoreCase("Monday")) {
			Monday();
			int y = xM.size();
			for (int z = 1; z < y + 1; z++) {
				arr[z].setText(xM.get(p));
				// arr[z].setIcon(new ImageIcon(xMi.get(p)));
				arrfav[z].setVisible(true);
				p++;

			}
			p = 0;
		}
		if (datetoday.equalsIgnoreCase("Tuesday")) {
			Tuesday();
			int y = xT.size();
			for (int z = 1; z < y + 1; z++) {
				arr[z].setText(xT.get(p));
				arrfav[z].setVisible(true);
				p++;
			}
			p = 0;
		}
		if (datetoday.equalsIgnoreCase("Wednesday")) {
			Wednesday();
			int y = xW.size();
			for (int z = 1; z < y + 1; z++) {
				arr[z].setText(xW.get(p));
				arrfav[z].setVisible(true);
				p++;
			}
			p = 0;
		}
		if (datetoday.equalsIgnoreCase("Thursday")) {
			Thursday();
			int y = xTh.size();
			for (int z = 1; z < y + 1; z++) {
				arr[z].setText(xTh.get(p));
				arrfav[z].setVisible(true);
				p++;
			}
			p = 0;
		}
		if (datetoday.equalsIgnoreCase("Friday")) {
			Friday();
			int y = xF.size();
			for (int z = 1; z < y + 1; z++) {
				arr[z].setText(xF.get(p));
				arrfav[z].setVisible(true);
				p++;
			}
			p = 0;
		}
		if (datetoday.equalsIgnoreCase("Saturday")) {
			Saturday();
			int y = xS.size();
			for (int z = 1; z < y + 1; z++) {
				arr[z].setText(xS.get(p));
				arrfav[z].setVisible(true);
				p++;
			}
			p = 0;
		}
		if (datetoday.equalsIgnoreCase("Sunday")) {
			Sunday();
			int y = xSu.size();
			for (int z = 1; z < y + 1; z++) {
				arr[z].setText(xSu.get(p));
				arrfav[z].setVisible(true);
				p++;
			}
			p = 0;
		}
	}

	public static void analyze() throws IOException {
		String url = "https://www.kickassanime.rs/";

		Document stuff = Jsoup.connect(url).timeout(6000).get();
		String ele = stuff.toString();

		String[] split1 = ele.split("Monday", 2);

		String[] split2 = split1[1].split("animeList", 2);

		String info = split2[0];

		String Monday1[] = info.split("Tuesday", 2);

		String Monday = Monday1[0];

		String Tuesday1[] = Monday1[1].split("Wednesday", 2);

		String Tuesday = Tuesday1[0];

		String Wednesday1[] = Tuesday1[1].split("Thursday", 2);

		String Wednesday = Wednesday1[0];

		String Thursday1[] = Wednesday1[1].split("Friday", 2);

		String Thursday = Thursday1[0];

		String Friday1[] = Thursday1[1].split("Saturday", 2);

		String Friday = Friday1[0];

		String Saturday1[] = Friday1[1].split("Sunday", 2);

		String Saturday = Saturday1[0];

		String Sunday = Saturday1[1];

		String cT[] = Tuesday.split("jpg");

		String cW[] = Wednesday.split("jpg");

		String cTh[] = Thursday.split("jpg");

		String cF[] = Friday.split("jpg");

		String cS[] = Saturday.split("jpg");

		String cSu[] = Sunday.split("jpg");

		String cM[] = Monday.split("jpg");

		for (int y = 0; y < cM.length - 1; y++) {
			String x = StringUtils.substringBetween(cM[y], "\"title\":\"", "\",\"time\":\"");
			xM.add(x);

			String w = StringUtils.substringBetween(cM[y], "\"time\":\"", "\",\"slug\":\"");
			xMt.add(w);

			String z = StringUtils.substringBetween(cM[y], "\":\"\\/anime\\/", "\",\"image\":\"");
			xMl.add("https://www.kickassanime.rs/anime/" + z);

			String b = StringUtils.substringBetween(cM[y], "image\":\"", ".");
			xMi.add(b + ".jpg");
		}
		System.out.println(xM);
		System.out.println(xMt);
		System.out.println(xMl);
		System.out.println(xMi);

		for (int y = 0; y < cT.length - 1; y++) {
			String x = StringUtils.substringBetween(cT[y], "\"title\":\"", "\",\"time\":\"");
			xT.add(x);

			String w = StringUtils.substringBetween(cT[y], "\"time\":\"", "\",\"slug\":\"");
			xTt.add(w);

			String z = StringUtils.substringBetween(cT[y], "\":\"\\/anime\\/", "\",\"image\":\"");
			xTl.add("https://www.kickassanime.rs/anime/" + z);

			String b = StringUtils.substringBetween(cT[y], "image\":\"", ".");
			xTi.add(b + ".jpg");

		}
		System.out.println(xT);
		System.out.println(xTt);
		System.out.println(xTl);
		System.out.println(xTi);

		for (int y = 0; y < cW.length - 1; y++) {
			String x = StringUtils.substringBetween(cW[y], "\"title\":\"", "\",\"time\":\"");
			xW.add(x);

			String w = StringUtils.substringBetween(cW[y], "\"time\":\"", "\",\"slug\":\"");
			xWt.add(w);

			String z = StringUtils.substringBetween(cW[y], "\":\"\\/anime\\/", "\",\"image\":\"");
			xWl.add("https://www.kickassanime.rs/anime/" + z);

			String b = StringUtils.substringBetween(cW[y], "image\":\"", ".");
			xWi.add(b + ".jpg");
		}
		System.out.println(xW);
		System.out.println(xWt);
		System.out.println(xWl);
		System.out.println(xWi);

		for (int y = 0; y < cTh.length - 1; y++) {
			String x = StringUtils.substringBetween(cTh[y], "\"title\":\"", "\",\"time\":\"");
			xTh.add(x);

			String w = StringUtils.substringBetween(cTh[y], "\"time\":\"", "\",\"slug\":\"");
			xTht.add(w);

			String z = StringUtils.substringBetween(cTh[y], "\":\"\\/anime\\/", "\",\"image\":\"");
			xThl.add("https://www.kickassanime.rs/anime/" + z);

			String b = StringUtils.substringBetween(cTh[y], "image\":\"", ".");
			xThi.add(b + ".jpg");
		}
		System.out.println(xTh);
		System.out.println(xTht);
		System.out.println(xThl);
		System.out.println(xThi);

		for (int y = 0; y < cF.length - 1; y++) {
			String x = StringUtils.substringBetween(cF[y], "\"title\":\"", "\",\"time\":\"");
			xF.add(x);

			String w = StringUtils.substringBetween(cF[y], "\"time\":\"", "\",\"slug\":\"");
			xFt.add(w);

			String z = StringUtils.substringBetween(cF[y], "\":\"\\/anime\\/", "\",\"image\":\"");
			xFl.add("https://www.kickassanime.rs/anime/" + z);

			String b = StringUtils.substringBetween(cF[y], "image\":\"", ".");
			xFi.add(b + ".jpg");
		}
		System.out.println(xF);
		System.out.println(xFt);
		System.out.println(xFl);
		System.out.println(xFi);

		for (int y = 0; y < cS.length - 1; y++) {
			String x = StringUtils.substringBetween(cS[y], "\"title\":\"", "\",\"time\":\"");
			xS.add(x);

			String w = StringUtils.substringBetween(cS[y], "\"time\":\"", "\",\"slug\":\"");
			xSt.add(w);

			String z = StringUtils.substringBetween(cS[y], "\":\"\\/anime\\/", "\",\"image\":\"");
			xSl.add("https://www.kickassanime.rs/anime/" + z);

			String b = StringUtils.substringBetween(cS[y], "image\":\"", ".");
			xSi.add(b + ".jpg");
		}
		System.out.println(xS);
		System.out.println(xSt);
		System.out.println(xSl);
		System.out.println(xSi);

		for (int y = 0; y < cSu.length - 1; y++) {
			String x = StringUtils.substringBetween(cSu[y], "\"title\":\"", "\",\"time\":\"");
			xSu.add(x);

			String w = StringUtils.substringBetween(cSu[y], "\"time\":\"", "\",\"slug\":\"");
			xSut.add(w);

			String z = StringUtils.substringBetween(cSu[y], "\":\"\\/anime\\/", "\",\"image\":\"");
			xSul.add("https://www.kickassanime.rs/anime/" + z);

			String b = StringUtils.substringBetween(cSu[y], "image\":\"", ".");
			xSui.add(b + ".jpg");
		}
		System.out.println(xSu);
		System.out.println(xSut);
		System.out.println(xSul);
		System.out.println(xSui);
	}

	public static void Thursday() {
		arr[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xThl.get(0).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xThl.get(1).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xThl.get(2).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xThl.get(3).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xThl.get(4).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xThl.get(5).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xThl.get(6).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xThl.get(7).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xThl.get(8).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xThl.get(9).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xThl.get(10).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xThl.get(11).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		// fav button
		arrfav[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x1 % 2 == 0) {
					arrfav[1].setText("Un-Favourite");
					arrfav[1].setForeground(Color.blue);
					x1++;
					s1 = 1;
				} else {
					arrfav[1].setText("Favourite");
					arrfav[1].setForeground(Color.red);
					x1++;
					s1 = 0;
				}
				generatedataTh2();
			}
		});
		arrfav[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x2 % 2 == 0) {
					arrfav[2].setText("Un-Favourite");
					arrfav[2].setForeground(Color.blue);
					x2++;
					s2 = 1;
				} else {
					arrfav[2].setText("Favourite");
					arrfav[2].setForeground(Color.red);
					x2++;
					s2 = 0;
				}
				generatedataTh2();
			}
		});
		arrfav[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x3 % 2 == 0) {
					arrfav[3].setText("Un-Favourite");
					arrfav[3].setForeground(Color.blue);
					x3++;
					s3 = 1;
				} else {
					arrfav[3].setText("Favourite");
					arrfav[3].setForeground(Color.red);
					x3++;
					s3 = 0;
				}
				generatedataTh2();
			}
		});
		arrfav[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x4 % 2 == 0) {
					arrfav[4].setText("Un-Favourite");
					arrfav[4].setForeground(Color.blue);
					x4++;
					s4 = 1;
				} else {
					arrfav[4].setText("Favourite");
					arrfav[4].setForeground(Color.red);
					x4++;
					s4 = 0;
				}
				generatedataTh2();
			}
		});
		arrfav[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x5 % 2 == 0) {
					arrfav[5].setText("Un-Favourite");
					arrfav[5].setForeground(Color.blue);
					x5++;
					s5 = 1;
				} else {
					arrfav[5].setText("Favourite");
					arrfav[5].setForeground(Color.red);
					x5++;
					s5 = 0;
				}
				generatedataTh2();
			}
		});
		arrfav[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x6 % 2 == 0) {
					arrfav[6].setText("Un-Favourite");
					arrfav[6].setForeground(Color.blue);
					x6++;
					s6 = 1;
				} else {
					arrfav[6].setText("Favourite");
					arrfav[6].setForeground(Color.red);
					x6++;
					s6 = 0;
				}
				generatedataTh2();
			}
		});
		arrfav[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x7 % 2 == 0) {
					arrfav[7].setText("Un-Favourite");
					arrfav[7].setForeground(Color.blue);
					x7++;
					s7 = 1;
				} else {
					arrfav[7].setText("Favourite");
					arrfav[7].setForeground(Color.red);
					x7++;
					s7 = 0;
				}
				generatedataTh2();
			}
		});
		arrfav[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x8 % 2 == 0) {
					arrfav[8].setText("Un-Favourite");
					arrfav[8].setForeground(Color.blue);
					x8++;
					s8 = 1;
				} else {
					arrfav[8].setText("Favourite");
					arrfav[8].setForeground(Color.red);
					x8++;
					s8 = 0;
				}
				generatedataTh2();
			}
		});
		arrfav[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x9 % 2 == 0) {
					arrfav[9].setText("Un-Favourite");
					arrfav[9].setForeground(Color.blue);
					x9++;
					s9 = 1;
				} else {
					arrfav[9].setText("Favourite");
					arrfav[9].setForeground(Color.red);
					x9++;
					s9 = 0;
				}
				generatedataTh2();
			}
		});
		arrfav[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x10 % 2 == 0) {
					arrfav[10].setText("Un-Favourite");
					arrfav[10].setForeground(Color.blue);
					x10++;
					s10 = 1;
				} else {
					arrfav[10].setText("Favourite");
					arrfav[10].setForeground(Color.red);
					x10++;
					s10 = 0;
				}
				generatedataTh2();
			}
		});
		arrfav[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x11 % 2 == 0) {
					arrfav[11].setText("Un-Favourite");
					arrfav[11].setForeground(Color.blue);
					x11++;
					s11 = 1;
				} else {
					arrfav[11].setText("Favourite");
					arrfav[11].setForeground(Color.red);
					x11++;
					s11 = 0;
				}
				generatedataTh2();
			}
		});
		arrfav[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x12 % 2 == 0) {
					arrfav[12].setText("Un-Favourite");
					arrfav[12].setForeground(Color.blue);
					x12++;
					s12 = 1;
				} else {
					arrfav[12].setText("Favourite");
					arrfav[12].setForeground(Color.red);
					x12++;
					s12 = 0;
				}
				generatedataTh2();
			}
		});

	}

	public static void Monday() {
		arr[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xMl.get(0).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xMl.get(1).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xMl.get(2).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xMl.get(3).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xMl.get(4).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xMl.get(5).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xMl.get(6).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xMl.get(7).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xMl.get(8).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xMl.get(9).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xMl.get(10).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xMl.get(11).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}

			}
		});

		// fav button
		arrfav[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x1 % 2 == 0) {
					arrfav[1].setText("Un-Favourite");
					arrfav[1].setForeground(Color.blue);
					x1++;
					s1 = 1;
				} else {
					arrfav[1].setText("Favourite");
					arrfav[1].setForeground(Color.red);
					x1++;
					s1 = 0;
				}
				generatedataM2();

			}
		});
		arrfav[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x2 % 2 == 0) {
					arrfav[2].setText("Un-Favourite");
					arrfav[2].setForeground(Color.blue);
					x2++;
					s2 = 1;
				} else {
					arrfav[2].setText("Favourite");
					arrfav[2].setForeground(Color.red);
					x2++;
					s2 = 0;
				}
				generatedataM2();

			}
		});
		arrfav[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x3 % 2 == 0) {
					arrfav[3].setText("Un-Favourite");
					arrfav[3].setForeground(Color.blue);
					x3++;
					s3 = 1;
				} else {
					arrfav[3].setText("Favourite");
					arrfav[3].setForeground(Color.red);
					x3++;
					s3 = 0;
				}
				generatedataM2();

			}
		});
		arrfav[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x4 % 2 == 0) {
					arrfav[4].setText("Un-Favourite");
					arrfav[4].setForeground(Color.blue);
					x4++;
					s4 = 1;
				} else {
					arrfav[4].setText("Favourite");
					arrfav[4].setForeground(Color.red);
					x4++;
					s4 = 0;
				}
				generatedataM2();

			}
		});
		arrfav[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x5 % 2 == 0) {
					arrfav[5].setText("Un-Favourite");
					arrfav[5].setForeground(Color.blue);
					x5++;
					s5 = 1;
				} else {
					arrfav[5].setText("Favourite");
					arrfav[5].setForeground(Color.red);
					x5++;
					s5 = 0;
				}
				generatedataM2();

			}
		});
		arrfav[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x6 % 2 == 0) {
					arrfav[6].setText("Un-Favourite");
					arrfav[6].setForeground(Color.blue);
					x6++;
					s6 = 1;
				} else {
					arrfav[6].setText("Favourite");
					arrfav[6].setForeground(Color.red);
					x6++;
					s6 = 0;
				}
				generatedataM2();

			}
		});
		arrfav[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x7 % 2 == 0) {
					arrfav[7].setText("Un-Favourite");
					arrfav[7].setForeground(Color.blue);
					x7++;
					s7 = 1;
				} else {
					arrfav[7].setText("Favourite");
					arrfav[7].setForeground(Color.red);
					x7++;
					s7 = 0;
				}
				generatedataM2();

			}
		});
		arrfav[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x8 % 2 == 0) {
					arrfav[8].setText("Un-Favourite");
					arrfav[8].setForeground(Color.blue);
					x8++;
					s8 = 1;
				} else {
					arrfav[8].setText("Favourite");
					arrfav[8].setForeground(Color.red);
					x8++;
					s8 = 0;
				}
				generatedataM2();

			}
		});
		arrfav[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x9 % 2 == 0) {
					arrfav[9].setText("Un-Favourite");
					arrfav[9].setForeground(Color.blue);
					x9++;
					s9 = 1;
				} else {
					arrfav[9].setText("Favourite");
					arrfav[9].setForeground(Color.red);
					x9++;
					s9 = 0;
				}
				generatedataM2();

			}
		});
		arrfav[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x10 % 2 == 0) {
					arrfav[10].setText("Un-Favourite");
					arrfav[10].setForeground(Color.blue);
					x10++;
					s10 = 1;
				} else {
					arrfav[10].setText("Favourite");
					arrfav[10].setForeground(Color.red);
					x10++;
					s10 = 0;
				}
				generatedataM2();

			}
		});
		arrfav[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x11 % 2 == 0) {
					arrfav[11].setText("Un-Favourite");
					arrfav[11].setForeground(Color.blue);
					x11++;
					s11 = 1;
				} else {
					arrfav[11].setText("Favourite");
					arrfav[11].setForeground(Color.red);
					x11++;
					s11 = 0;
				}
				generatedataM2();

			}
		});
		arrfav[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x12 % 2 == 0) {
					arrfav[12].setText("Un-Favourite");
					arrfav[12].setForeground(Color.blue);
					x12++;
					s12 = 1;
				} else {
					arrfav[12].setText("Favourite");
					arrfav[12].setForeground(Color.red);
					x12++;
					s12 = 0;
				}
				generatedataM2();

			}
		});
	}

	public static void Tuesday() {
		arr[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xTl.get(0).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xTl.get(1).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xTl.get(2).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xTl.get(3).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xTl.get(4).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xTl.get(5).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xTl.get(6).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xTl.get(7).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xTl.get(8).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xTl.get(9).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xTl.get(10).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xTl.get(11).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});

		// fav button
		arrfav[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x1 % 2 == 0) {
					arrfav[1].setText("Un-Favourite");
					arrfav[1].setForeground(Color.blue);
					x1++;
					s1 = 1;

				} else {
					arrfav[1].setText("Favourite");
					arrfav[1].setForeground(Color.red);
					x1++;
					s1 = 0;
				}
				generatedataT2();

			}
		});
		arrfav[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x2 % 2 == 0) {
					arrfav[2].setText("Un-Favourite");
					arrfav[2].setForeground(Color.blue);
					x2++;
					s2 = 1;
				} else {
					arrfav[2].setText("Favourite");
					arrfav[2].setForeground(Color.red);
					x2++;
					s2 = 0;
				}
				generatedataT2();

			}
		});
		arrfav[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x3 % 2 == 0) {
					arrfav[3].setText("Un-Favourite");
					arrfav[3].setForeground(Color.blue);
					x3++;
					s3 = 1;
				} else {
					arrfav[3].setText("Favourite");
					arrfav[3].setForeground(Color.red);
					x3++;
					s3 = 0;
				}
				generatedataT2();

			}
		});
		arrfav[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x4 % 2 == 0) {
					arrfav[4].setText("Un-Favourite");
					arrfav[4].setForeground(Color.blue);
					x4++;
					s4 = 1;
				} else {
					arrfav[4].setText("Favourite");
					arrfav[4].setForeground(Color.red);
					x4++;
					s4 = 0;
				}
				generatedataT2();

			}
		});
		arrfav[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x5 % 2 == 0) {
					arrfav[5].setText("Un-Favourite");
					arrfav[5].setForeground(Color.blue);
					x5++;
					s5 = 1;
				} else {
					arrfav[5].setText("Favourite");
					arrfav[5].setForeground(Color.red);
					x5++;
					s5 = 0;
				}
				generatedataT2();

			}
		});
		arrfav[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x6 % 2 == 0) {
					arrfav[6].setText("Un-Favourite");
					arrfav[6].setForeground(Color.blue);
					x6++;
					s6 = 1;
				} else {
					arrfav[6].setText("Favourite");
					arrfav[6].setForeground(Color.red);
					x6++;
					s6 = 0;
				}
				generatedataT2();

			}
		});
		arrfav[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x7 % 2 == 0) {
					arrfav[7].setText("Un-Favourite");
					arrfav[7].setForeground(Color.blue);
					x7++;
					s7 = 1;
				} else {
					arrfav[7].setText("Favourite");
					arrfav[7].setForeground(Color.red);
					x7++;
					s7 = 0;
				}
				generatedataT2();

			}
		});
		arrfav[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x8 % 2 == 0) {
					arrfav[8].setText("Un-Favourite");
					arrfav[8].setForeground(Color.blue);
					x8++;
					s8 = 1;
				} else {
					arrfav[8].setText("Favourite");
					arrfav[8].setForeground(Color.red);
					x8++;
					s8 = 0;
				}
				generatedataT2();

			}
		});
		arrfav[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x9 % 2 == 0) {
					arrfav[9].setText("Un-Favourite");
					arrfav[9].setForeground(Color.blue);
					x9++;
					s9 = 1;
				} else {
					arrfav[9].setText("Favourite");
					arrfav[9].setForeground(Color.red);
					x9++;
					s9 = 0;
				}
				generatedataT2();

			}
		});
		arrfav[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x10 % 2 == 0) {
					arrfav[10].setText("Un-Favourite");
					arrfav[10].setForeground(Color.blue);
					x10++;
					s10 = 1;
				} else {
					arrfav[10].setText("Favourite");
					arrfav[10].setForeground(Color.red);
					x10++;
					s10 = 0;
				}
				generatedataT2();

			}
		});
		arrfav[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x11 % 2 == 0) {
					arrfav[11].setText("Un-Favourite");
					arrfav[11].setForeground(Color.blue);
					x11++;
					s11 = 1;
				} else {
					arrfav[11].setText("Favourite");
					arrfav[11].setForeground(Color.red);
					x11++;
					s11 = 0;
				}
				generatedataT2();

			}
		});
		arrfav[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x12 % 2 == 0) {
					arrfav[12].setText("Un-Favourite");
					arrfav[12].setForeground(Color.blue);
					x12++;
					s12 = 1;
				} else {
					arrfav[12].setText("Favourite");
					arrfav[12].setForeground(Color.red);
					x12++;
					s12 = 0;
				}
				generatedataT2();

			}
		});
	}

	public static void Wednesday() {
		arr[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xWl.get(0).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xWl.get(1).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xWl.get(2).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xWl.get(3).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xWl.get(4).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xWl.get(5).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xWl.get(6).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xWl.get(7).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xWl.get(8).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xWl.get(9).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xWl.get(10).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xWl.get(11).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});

		// fav button
		arrfav[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x1 % 2 == 0) {
					arrfav[1].setText("Un-Favourite");
					arrfav[1].setForeground(Color.blue);
					x1++;
					s1 = 1;
				} else {
					arrfav[1].setText("Favourite");
					arrfav[1].setForeground(Color.red);
					x1++;
					s1 = 0;
				}
				generatedataW2();

			}
		});
		arrfav[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x2 % 2 == 0) {
					arrfav[2].setText("Un-Favourite");
					arrfav[2].setForeground(Color.blue);
					x2++;
					s2 = 1;
				} else {
					arrfav[2].setText("Favourite");
					arrfav[2].setForeground(Color.red);
					x2++;
					s2 = 0;
				}
				generatedataW2();
			}
		});
		arrfav[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x3 % 2 == 0) {
					arrfav[3].setText("Un-Favourite");
					arrfav[3].setForeground(Color.blue);
					x3++;
					s3 = 1;
				} else {
					arrfav[3].setText("Favourite");
					arrfav[3].setForeground(Color.red);
					x3++;
					s3 = 0;
				}
				generatedataW2();
			}
		});
		arrfav[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x4 % 2 == 0) {
					arrfav[4].setText("Un-Favourite");
					arrfav[4].setForeground(Color.blue);
					x4++;
					s4 = 1;
				} else {
					arrfav[4].setText("Favourite");
					arrfav[4].setForeground(Color.red);
					x4++;
					s4 = 0;
				}
				generatedataW2();
			}
		});
		arrfav[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x5 % 2 == 0) {
					arrfav[5].setText("Un-Favourite");
					arrfav[5].setForeground(Color.blue);
					x5++;
					s5 = 1;
				} else {
					arrfav[5].setText("Favourite");
					arrfav[5].setForeground(Color.red);
					x5++;
					s5 = 0;
				}
				generatedataW2();
			}
		});
		arrfav[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x6 % 2 == 0) {
					arrfav[6].setText("Un-Favourite");
					arrfav[6].setForeground(Color.blue);
					x6++;
					s6 = 1;
				} else {
					arrfav[6].setText("Favourite");
					arrfav[6].setForeground(Color.red);
					x6++;
					s6 = 0;
				}
				generatedataW2();
			}
		});
		arrfav[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x7 % 2 == 0) {
					arrfav[7].setText("Un-Favourite");
					arrfav[7].setForeground(Color.blue);
					x7++;
					s7 = 1;
				} else {
					arrfav[7].setText("Favourite");
					arrfav[7].setForeground(Color.red);
					x7++;
					s7 = 0;
				}
				generatedataW2();
			}
		});
		arrfav[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x8 % 2 == 0) {
					arrfav[8].setText("Un-Favourite");
					arrfav[8].setForeground(Color.blue);
					x8++;
					s8 = 1;
				} else {
					arrfav[8].setText("Favourite");
					arrfav[8].setForeground(Color.red);
					x8++;
					s8 = 0;
				}
				generatedataW2();
			}
		});
		arrfav[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x9 % 2 == 0) {
					arrfav[9].setText("Un-Favourite");
					arrfav[9].setForeground(Color.blue);
					x9++;
					s9 = 1;
				} else {
					arrfav[9].setText("Favourite");
					arrfav[9].setForeground(Color.red);
					x9++;
					s9 = 0;
				}
				generatedataW2();
			}
		});
		arrfav[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x10 % 2 == 0) {
					arrfav[10].setText("Un-Favourite");
					arrfav[10].setForeground(Color.blue);
					x10++;
					s10 = 1;
				} else {
					arrfav[10].setText("Favourite");
					arrfav[10].setForeground(Color.red);
					x10++;
					s10 = 0;
				}
				generatedataW2();
			}
		});
		arrfav[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x11 % 2 == 0) {
					arrfav[11].setText("Un-Favourite");
					arrfav[11].setForeground(Color.blue);
					x11++;
					s11 = 1;
				} else {
					arrfav[11].setText("Favourite");
					arrfav[11].setForeground(Color.red);
					x11++;
					s11 = 0;
				}
				generatedataW2();
			}
		});
		arrfav[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x12 % 2 == 0) {
					arrfav[12].setText("Un-Favourite");
					arrfav[12].setForeground(Color.blue);
					x12++;
					s12 = 1;
				} else {
					arrfav[12].setText("Favourite");
					arrfav[12].setForeground(Color.red);
					x12++;
					s12 = 0;
				}
				generatedataW2();
			}
		});
	}

	public static void Friday() {
		arr[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xFl.get(0).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xFl.get(1).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xFl.get(2).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xFl.get(3).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xFl.get(4).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xFl.get(5).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xFl.get(6).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xFl.get(7).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xFl.get(8).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xFl.get(9).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xFl.get(10).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xFl.get(11).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		// fav button
		arrfav[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x1 % 2 == 0) {
					arrfav[1].setText("Un-Favourite");
					arrfav[1].setForeground(Color.blue);
					x1++;
					s1 = 1;
				} else {
					arrfav[1].setText("Favourite");
					arrfav[1].setForeground(Color.red);
					x1++;
					s1 = 0;
				}
				generatedataF2();
			}
		});
		arrfav[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x2 % 2 == 0) {
					arrfav[2].setText("Un-Favourite");
					arrfav[2].setForeground(Color.blue);
					x2++;
					s2 = 1;
				} else {
					arrfav[2].setText("Favourite");
					arrfav[2].setForeground(Color.red);
					x2++;
					s2 = 0;
				}
				generatedataF2();
			}
		});
		arrfav[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x3 % 2 == 0) {
					arrfav[3].setText("Un-Favourite");
					arrfav[3].setForeground(Color.blue);
					x3++;
					s3 = 1;
				} else {
					arrfav[3].setText("Favourite");
					arrfav[3].setForeground(Color.red);
					x3++;
					s3 = 0;
				}
				generatedataF2();
			}
		});
		arrfav[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x4 % 2 == 0) {
					arrfav[4].setText("Un-Favourite");
					arrfav[4].setForeground(Color.blue);
					x4++;
					s4 = 1;
				} else {
					arrfav[4].setText("Favourite");
					arrfav[4].setForeground(Color.red);
					x4++;
					s4 = 0;
				}
				generatedataF2();
			}
		});
		arrfav[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x5 % 2 == 0) {
					arrfav[5].setText("Un-Favourite");
					arrfav[5].setForeground(Color.blue);
					x5++;
					s5 = 1;
				} else {
					arrfav[5].setText("Favourite");
					arrfav[5].setForeground(Color.red);
					x5++;
					s5 = 0;
				}
				generatedataF2();
			}
		});
		arrfav[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x6 % 2 == 0) {
					arrfav[6].setText("Un-Favourite");
					arrfav[6].setForeground(Color.blue);
					x6++;
					s6 = 1;
				} else {
					arrfav[6].setText("Favourite");
					arrfav[6].setForeground(Color.red);
					x6++;
					s6 = 0;
				}
				generatedataF2();
			}
		});
		arrfav[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x7 % 2 == 0) {
					arrfav[7].setText("Un-Favourite");
					arrfav[7].setForeground(Color.blue);
					x7++;
					s7 = 1;
				} else {
					arrfav[7].setText("Favourite");
					arrfav[7].setForeground(Color.red);
					x7++;
					s7 = 0;
				}
				generatedataF2();
			}
		});
		arrfav[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x8 % 2 == 0) {
					arrfav[8].setText("Un-Favourite");
					arrfav[8].setForeground(Color.blue);
					x8++;
					s8 = 1;
				} else {
					arrfav[8].setText("Favourite");
					arrfav[8].setForeground(Color.red);
					x8++;
					s8 = 0;
				}
				generatedataF2();
			}
		});
		arrfav[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x9 % 2 == 0) {
					arrfav[9].setText("Un-Favourite");
					arrfav[9].setForeground(Color.blue);
					x9++;
					s9 = 1;
				} else {
					arrfav[9].setText("Favourite");
					arrfav[9].setForeground(Color.red);
					x9++;
					s9 = 0;
				}
				generatedataF2();
			}
		});
		arrfav[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x10 % 2 == 0) {
					arrfav[10].setText("Un-Favourite");
					arrfav[10].setForeground(Color.blue);
					x10++;
					s10 = 1;
				} else {
					arrfav[10].setText("Favourite");
					arrfav[10].setForeground(Color.red);
					x10++;
					s10 = 0;
				}
				generatedataF2();
			}
		});
		arrfav[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x11 % 2 == 0) {
					arrfav[11].setText("Un-Favourite");
					arrfav[11].setForeground(Color.blue);
					x11++;
					s11 = 1;
				} else {
					arrfav[11].setText("Favourite");
					arrfav[11].setForeground(Color.red);
					x11++;
					s11 = 0;
				}
				generatedataF2();
			}
		});
		arrfav[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x12 % 2 == 0) {
					arrfav[12].setText("Un-Favourite");
					arrfav[12].setForeground(Color.blue);
					x12++;
					s12 = 1;
				} else {
					arrfav[12].setText("Favourite");
					arrfav[12].setForeground(Color.red);
					x12++;
					s12 = 0;
				}
				generatedataF2();

			}
		});
	}

	public static void Saturday() {
		arr[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSl.get(0).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSl.get(1).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSl.get(2).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSl.get(3).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSl.get(4).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSl.get(5).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSl.get(6).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSl.get(7).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSl.get(8).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSl.get(9).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSl.get(10).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSl.get(11).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		// fav button
		arrfav[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x1 % 2 == 0) {
					arrfav[1].setText("Un-Favourite");
					arrfav[1].setForeground(Color.blue);
					x1++;
					s1 = 1;
				} else {
					arrfav[1].setText("Favourite");
					arrfav[1].setForeground(Color.red);
					x1++;
					s1 = 0;
				}
				generatedataS2();
			}
		});
		arrfav[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x2 % 2 == 0) {
					arrfav[2].setText("Un-Favourite");
					arrfav[2].setForeground(Color.blue);
					x2++;
					s2 = 1;
				} else {
					arrfav[2].setText("Favourite");
					arrfav[2].setForeground(Color.red);
					x2++;
					s2 = 0;
				}
				generatedataS2();
			}
		});
		arrfav[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x3 % 2 == 0) {
					arrfav[3].setText("Un-Favourite");
					arrfav[3].setForeground(Color.blue);
					x3++;
					s3 = 1;
				} else {
					arrfav[3].setText("Favourite");
					arrfav[3].setForeground(Color.red);
					x3++;
					s3 = 0;
				}
				generatedataS2();
			}
		});
		arrfav[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x4 % 2 == 0) {
					arrfav[4].setText("Un-Favourite");
					arrfav[4].setForeground(Color.blue);
					x4++;
					s4 = 1;
				} else {
					arrfav[4].setText("Favourite");
					arrfav[4].setForeground(Color.red);
					x4++;
					s4 = 0;
				}
				generatedataS2();

			}
		});
		arrfav[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x5 % 2 == 0) {
					arrfav[5].setText("Un-Favourite");
					arrfav[5].setForeground(Color.blue);
					x5++;
					s5 = 1;
				} else {
					arrfav[5].setText("Favourite");
					arrfav[5].setForeground(Color.red);
					x5++;
					s5 = 0;
				}
				generatedataS2();

			}
		});
		arrfav[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x6 % 2 == 0) {
					arrfav[6].setText("Un-Favourite");
					arrfav[6].setForeground(Color.blue);
					x6++;
					s6 = 1;
				} else {
					arrfav[6].setText("Favourite");
					arrfav[6].setForeground(Color.red);
					x6++;
					s6 = 0;
				}
				generatedataS2();

			}
		});
		arrfav[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x7 % 2 == 0) {
					arrfav[7].setText("Un-Favourite");
					arrfav[7].setForeground(Color.blue);
					x7++;
					s7 = 1;
				} else {
					arrfav[7].setText("Favourite");
					arrfav[7].setForeground(Color.red);
					x7++;
					s7 = 0;
				}
				generatedataS2();

			}
		});
		arrfav[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x8 % 2 == 0) {
					arrfav[8].setText("Un-Favourite");
					arrfav[8].setForeground(Color.blue);
					x8++;
					s8 = 1;
				} else {
					arrfav[8].setText("Favourite");
					arrfav[8].setForeground(Color.red);
					x8++;
					s8 = 0;
				}
				generatedataS2();

			}
		});
		arrfav[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x9 % 2 == 0) {
					arrfav[9].setText("Un-Favourite");
					arrfav[9].setForeground(Color.blue);
					x9++;
					s9 = 1;
				} else {
					arrfav[9].setText("Favourite");
					arrfav[9].setForeground(Color.red);
					x9++;
					s9 = 0;
				}
				generatedataS2();

			}
		});
		arrfav[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x10 % 2 == 0) {
					arrfav[10].setText("Un-Favourite");
					arrfav[10].setForeground(Color.blue);
					x10++;
					s10 = 1;
				} else {
					arrfav[10].setText("Favourite");
					arrfav[10].setForeground(Color.red);
					x10++;
					s10 = 0;
				}
				generatedataS2();

			}
		});
		arrfav[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x11 % 2 == 0) {
					arrfav[11].setText("Un-Favourite");
					arrfav[11].setForeground(Color.blue);
					x11++;
					s11 = 1;
				} else {
					arrfav[11].setText("Favourite");
					arrfav[11].setForeground(Color.red);
					x11++;
					s11 = 0;
				}
				generatedataS2();

			}
		});
		arrfav[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x12 % 2 == 0) {
					arrfav[12].setText("Un-Favourite");
					arrfav[12].setForeground(Color.blue);
					x12++;
					s12 = 1;
				} else {
					arrfav[12].setText("Favourite");
					arrfav[12].setForeground(Color.red);
					x12++;
					s12 = 0;
				}
				generatedataS2();

			}
		});
	}

	public static void Sunday() {
		arr[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSul.get(0).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSul.get(1).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSul.get(2).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSul.get(3).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSul.get(4).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSul.get(5).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSul.get(6).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSul.get(7).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSul.get(8).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSul.get(9).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSul.get(10).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		arr[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(xSul.get(11).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		// fav button
		arrfav[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x1 % 2 == 0) {
					arrfav[1].setText("Un-Favourite");
					arrfav[1].setForeground(Color.blue);
					x1++;
					s1 = 1;
				} else {
					arrfav[1].setText("Favourite");
					arrfav[1].setForeground(Color.red);
					x1++;
					s1 = 0;
				}
				generatedataSu2();

			}
		});
		arrfav[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x2 % 2 == 0) {
					arrfav[2].setText("Un-Favourite");
					arrfav[2].setForeground(Color.blue);
					x2++;
					s2 = 1;
				} else {
					arrfav[2].setText("Favourite");
					arrfav[2].setForeground(Color.red);
					x2++;
					s2 = 0;
				}
				generatedataSu2();

			}
		});
		arrfav[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x3 % 2 == 0) {
					arrfav[3].setText("Un-Favourite");
					arrfav[3].setForeground(Color.blue);
					x3++;
					s3 = 1;
				} else {
					arrfav[3].setText("Favourite");
					arrfav[3].setForeground(Color.red);
					x3++;
					s3 = 0;
				}
				generatedataSu2();

			}
		});
		arrfav[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x4 % 2 == 0) {
					arrfav[4].setText("Un-Favourite");
					arrfav[4].setForeground(Color.blue);
					x4++;
					s4 = 1;
				} else {
					arrfav[4].setText("Favourite");
					arrfav[4].setForeground(Color.red);
					x4++;
					s4 = 0;
				}
				generatedataSu2();

			}
		});
		arrfav[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x5 % 2 == 0) {
					arrfav[5].setText("Un-Favourite");
					arrfav[5].setForeground(Color.blue);
					x5++;
					s5 = 1;
				} else {
					arrfav[5].setText("Favourite");
					arrfav[5].setForeground(Color.red);
					x5++;
					s5 = 0;
				}
				generatedataSu2();

			}
		});
		arrfav[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x6 % 2 == 0) {
					arrfav[6].setText("Un-Favourite");
					arrfav[6].setForeground(Color.blue);
					x6++;
					s6 = 1;
				} else {
					arrfav[6].setText("Favourite");
					arrfav[6].setForeground(Color.red);
					x6++;
					s6 = 0;
				}
				generatedataSu2();

			}
		});
		arrfav[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x7 % 2 == 0) {
					arrfav[7].setText("Un-Favourite");
					arrfav[7].setForeground(Color.blue);
					x7++;
					s7 = 1;
				} else {
					arrfav[7].setText("Favourite");
					arrfav[7].setForeground(Color.red);
					x7++;
					s7 = 0;
				}
				generatedataSu2();

			}
		});
		arrfav[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x8 % 2 == 0) {
					arrfav[8].setText("Un-Favourite");
					arrfav[8].setForeground(Color.blue);
					x8++;
					s8 = 1;
				} else {
					arrfav[8].setText("Favourite");
					arrfav[8].setForeground(Color.red);
					x8++;
					s8 = 0;
				}
				generatedataSu2();

			}
		});
		arrfav[9].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x9 % 2 == 0) {
					arrfav[9].setText("Un-Favourite");
					arrfav[9].setForeground(Color.blue);
					x9++;
					s9 = 1;
				} else {
					arrfav[9].setText("Favourite");
					arrfav[9].setForeground(Color.red);
					x9++;
					s9 = 0;
				}
				generatedataSu2();

			}
		});
		arrfav[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x10 % 2 == 0) {
					arrfav[10].setText("Un-Favourite");
					arrfav[10].setForeground(Color.blue);
					x10++;
					s10 = 1;
				} else {
					arrfav[10].setText("Favourite");
					arrfav[10].setForeground(Color.red);
					x10++;
					s10 = 0;
				}
				generatedataSu2();

			}
		});
		arrfav[11].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x11 % 2 == 0) {
					arrfav[11].setText("Un-Favourite");
					arrfav[11].setForeground(Color.blue);
					x11++;
					s11 = 1;
				} else {
					arrfav[11].setText("Favourite");
					arrfav[11].setForeground(Color.red);
					x11++;
					s11 = 0;
				}
				generatedataSu2();

			}
		});
		arrfav[12].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x12 % 2 == 0) {
					arrfav[12].setText("Un-Favourite");
					arrfav[12].setForeground(Color.blue);
					x12++;
					s12 = 1;
				} else {
					arrfav[12].setText("Favourite");
					arrfav[12].setForeground(Color.red);
					x12++;
					s12 = 0;
				}
				generatedataSu2();

			}
		});

	}

	public static void clear() {
		arrfav[1].setVisible(false);
		arrfav[2].setVisible(false);
		arrfav[3].setVisible(false);
		arrfav[4].setVisible(false);
		arrfav[5].setVisible(false);
		arrfav[6].setVisible(false);
		arrfav[7].setVisible(false);
		arrfav[8].setVisible(false);
		arrfav[9].setVisible(false);
		arrfav[10].setVisible(false);
		arrfav[11].setVisible(false);
		arrfav[12].setVisible(false);
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

	public static void generatedataM() {
		try {
			getvariables();
			deletesaveM();
			FileWriter myWriter = new FileWriter("files/favM.txt");
			System.out.println("Creating File");
			myWriter.write(xM + "1m" + s1 + "2m" + s2 + "3m" + s3 + "4m" + s4 + "5m" + s5 + "6m" + s6 + "7m" + s7 + "8m"
					+ s8 + "9m" + s9 + "10m" + s10 + "11m" + s11 + "12m" + s12 + "13m");
			myWriter.close();
		} catch (Exception e) {
			System.out.println("Failing File");
			e.printStackTrace();
		}

	}

	public static void generatedataM2() {
		try {
			readdataM();
			// getvariables();
			deletesaveM();
			FileWriter myWriter = new FileWriter("files/favM.txt");
			System.out.println("Creating File");
			myWriter.write(xM + "1m" + s1 + "2m" + s2 + "3m" + s3 + "4m" + s4 + "5m" + s5 + "6m" + s6 + "7m" + s7 + "8m"
					+ s8 + "9m" + s9 + "10m" + s10 + "11m" + s11 + "12m" + s12 + "13m");
			myWriter.close();
			readdataM();

		} catch (Exception e) {
			System.out.println("Failing File");
			e.printStackTrace();
		}

	}

	public static void generatedataT() {
		try {
			readdataT();
			getvariables();
			deletesaveT();
			FileWriter myWriter = new FileWriter("files/favT.txt");
			System.out.println("Creating File");
			myWriter.write(xT + "1m" + s1 + "2m" + s2 + "3m" + s3 + "4m" + s4 + "5m" + s5 + "6m" + s6 + "7m" + s7 + "8m"
					+ s8 + "9m" + s9 + "10m" + s10 + "11m" + s11 + "12m" + s12 + "13m");
			myWriter.close();
			readdataT();

		} catch (Exception e) {
			System.out.println("Failing File");
			e.printStackTrace();
		}

	}

	public static void generatedataT2() {
		try {
			readdataT();
			// getvariables();
			deletesaveT();
			FileWriter myWriter = new FileWriter("files/favT.txt");
			System.out.println("Creating File");
			myWriter.write(xT + "1m" + s1 + "2m" + s2 + "3m" + s3 + "4m" + s4 + "5m" + s5 + "6m" + s6 + "7m" + s7 + "8m"
					+ s8 + "9m" + s9 + "10m" + s10 + "11m" + s11 + "12m" + s12 + "13m");
			myWriter.close();
			readdataT();

		} catch (Exception e) {
			System.out.println("Failing File");
			e.printStackTrace();
		}

	}

	public static void generatedataW() {
		try {
			getvariables();
			deletesaveW();
			FileWriter myWriter = new FileWriter("files/favW.txt");
			System.out.println("Creating File");
			myWriter.write(xW + "1m" + s1 + "2m" + s2 + "3m" + s3 + "4m" + s4 + "5m" + s5 + "6m" + s6 + "7m" + s7 + "8m"
					+ s8 + "9m" + s9 + "10m" + s10 + "11m" + s11 + "12m" + s12 + "13m");
			myWriter.close();
		} catch (Exception e) {
			System.out.println("Failing File");
			e.printStackTrace();
		}

	}

	public static void generatedataW2() {
		try {
			readdataW();
			// getvariables();
			deletesaveW();
			FileWriter myWriter = new FileWriter("files/favW.txt");
			System.out.println("Creating File");
			myWriter.write(xW + "1m" + s1 + "2m" + s2 + "3m" + s3 + "4m" + s4 + "5m" + s5 + "6m" + s6 + "7m" + s7 + "8m"
					+ s8 + "9m" + s9 + "10m" + s10 + "11m" + s11 + "12m" + s12 + "13m");
			myWriter.close();
			readdataW();

		} catch (Exception e) {
			System.out.println("Failing File");
			e.printStackTrace();
		}

	}

	public static void generatedataTh() {
		try {
			getvariables();
			deletesaveTh();
			FileWriter myWriter = new FileWriter("files/favTh.txt");
			System.out.println("Creating File");
			myWriter.write(xTh + "1m" + s1 + "2m" + s2 + "3m" + s3 + "4m" + s4 + "5m" + s5 + "6m" + s6 + "7m" + s7
					+ "8m" + s8 + "9m" + s9 + "10m" + s10 + "11m" + s11 + "12m" + s12 + "13m");
			myWriter.close();
		} catch (Exception e) {
			System.out.println("Failing File");
			e.printStackTrace();
		}

	}

	public static void generatedataTh2() {
		try {
			readdataTh();
			// getvariables();
			deletesaveTh();
			FileWriter myWriter = new FileWriter("files/favTh.txt");
			System.out.println("Creating File");
			myWriter.write(xTh + "1m" + s1 + "2m" + s2 + "3m" + s3 + "4m" + s4 + "5m" + s5 + "6m" + s6 + "7m" + s7
					+ "8m" + s8 + "9m" + s9 + "10m" + s10 + "11m" + s11 + "12m" + s12 + "13m");
			myWriter.close();
			readdataTh();

		} catch (Exception e) {
			System.out.println("Failing File");
			e.printStackTrace();
		}

	}

	public static void generatedataF() {
		try {
			getvariables();
			deletesaveF();
			FileWriter myWriter = new FileWriter("files/favF.txt");
			System.out.println("Creating File");
			myWriter.write(xF + "1m" + s1 + "2m" + s2 + "3m" + s3 + "4m" + s4 + "5m" + s5 + "6m" + s6 + "7m" + s7 + "8m"
					+ s8 + "9m" + s9 + "10m" + s10 + "11m" + s11 + "12m" + s12 + "13m");
			myWriter.close();
		} catch (Exception e) {
			System.out.println("Failing File");
			e.printStackTrace();
		}

	}

	public static void generatedataF2() {
		try {
			readdataF();
			// getvariables();
			deletesaveF();
			FileWriter myWriter = new FileWriter("files/favF.txt");
			System.out.println("Creating File");
			myWriter.write(xF + "1m" + s1 + "2m" + s2 + "3m" + s3 + "4m" + s4 + "5m" + s5 + "6m" + s6 + "7m" + s7 + "8m"
					+ s8 + "9m" + s9 + "10m" + s10 + "11m" + s11 + "12m" + s12 + "13m");
			myWriter.close();
			readdataF();

		} catch (Exception e) {
			System.out.println("Failing File");
			e.printStackTrace();
		}

	}

	public static void generatedataS() {
		try {
			getvariables();
			deletesaveS();
			FileWriter myWriter = new FileWriter("files/favS.txt");
			System.out.println("Creating File");
			myWriter.write(xS + "1m" + s1 + "2m" + s2 + "3m" + s3 + "4m" + s4 + "5m" + s5 + "6m" + s6 + "7m" + s7 + "8m"
					+ s8 + "9m" + s9 + "10m" + s10 + "11m" + s11 + "12m" + s12 + "13m");
			myWriter.close();
		} catch (Exception e) {
			System.out.println("Failing File");
			e.printStackTrace();
		}

	}

	public static void generatedataS2() {
		try {
			readdataS();
			// getvariables();
			deletesaveS();
			FileWriter myWriter = new FileWriter("files/favS.txt");
			System.out.println("Creating File");
			myWriter.write(xS + "1m" + s1 + "2m" + s2 + "3m" + s3 + "4m" + s4 + "5m" + s5 + "6m" + s6 + "7m" + s7 + "8m"
					+ s8 + "9m" + s9 + "10m" + s10 + "11m" + s11 + "12m" + s12 + "13m");
			myWriter.close();
			readdataS();

		} catch (Exception e) {
			System.out.println("Failing File");
			e.printStackTrace();
		}

	}

	public static void generatedataSu() {
		try {
			getvariables();
			deletesaveSu();
			FileWriter myWriter = new FileWriter("files/favSu.txt");
			System.out.println("Creating File");
			myWriter.write(xSu + "1m" + s1 + "2m" + s2 + "3m" + s3 + "4m" + s4 + "5m" + s5 + "6m" + s6 + "7m" + s7
					+ "8m" + s8 + "9m" + s9 + "10m" + s10 + "11m" + s11 + "12m" + s12 + "13m");
			myWriter.close();
		} catch (Exception e) {
			System.out.println("Failing File");
			e.printStackTrace();
		}

	}

	public static void generatedataSu2() {
		try {
			readdataSu();
			// getvariables();
			deletesaveSu();
			FileWriter myWriter = new FileWriter("files/favSu.txt");
			System.out.println("Creating File");
			myWriter.write(xSu + "1m" + s1 + "2m" + s2 + "3m" + s3 + "4m" + s4 + "5m" + s5 + "6m" + s6 + "7m" + s7
					+ "8m" + s8 + "9m" + s9 + "10m" + s10 + "11m" + s11 + "12m" + s12 + "13m");
			myWriter.close();
			readdataSu();

		} catch (Exception e) {
			System.out.println("Failing File");
			e.printStackTrace();
		}

	}

	public static void getvariables() {

		s1 = Integer.parseInt(StringUtils.substringBetween(data.toString(), "1m", "2m"));
		s2 = Integer.parseInt(StringUtils.substringBetween(data.toString(), "2m", "3m"));
		s3 = Integer.parseInt(StringUtils.substringBetween(data.toString(), "3m", "4m"));
		s4 = Integer.parseInt(StringUtils.substringBetween(data.toString(), "4m", "5m"));
		s5 = Integer.parseInt(StringUtils.substringBetween(data.toString(), "5m", "6m"));
		s6 = Integer.parseInt(StringUtils.substringBetween(data.toString(), "6m", "7m"));
		s7 = Integer.parseInt(StringUtils.substringBetween(data.toString(), "7m", "8m"));
		s8 = Integer.parseInt(StringUtils.substringBetween(data.toString(), "8m", "9m"));
		s9 = Integer.parseInt(StringUtils.substringBetween(data.toString(), "9m", "10m"));
		s10 = Integer.parseInt(StringUtils.substringBetween(data.toString(), "10m", "11m"));
		s11 = Integer.parseInt(StringUtils.substringBetween(data.toString(), "11m", "12m"));
		// s12 = Integer.parseInt(StringUtils.substringBetween(data.toString(), "12m",
		// "13m"));
		System.out.println(s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12);
	}

	public static void deletesaveM() {
		File f = new File("files/favM.txt"); // file to be delete
		if (f.delete()) // returns Boolean value
		{
			System.out.println(f.getName() + " deleted"); // getting and printing the file name
		} else {
			System.out.println("failed");
		}
	}

	public static void deletesaveT() {
		File f = new File("files/favT.txt"); // file to be delete
		if (f.delete()) // returns Boolean value
		{
			System.out.println(f.getName() + " deleted"); // getting and printing the file name
		} else {
			System.out.println("failed");
		}
	}

	public static void deletesaveW() {
		File f = new File("files/favW.txt"); // file to be delete
		if (f.delete()) // returns Boolean value
		{
			System.out.println(f.getName() + " deleted"); // getting and printing the file name
		} else {
			System.out.println("failed");
		}
	}

	public static void deletesaveTh() {
		File f = new File("files/favTh.txt"); // file to be delete
		if (f.delete()) // returns Boolean value
		{
			System.out.println(f.getName() + " deleted"); // getting and printing the file name
		} else {
			System.out.println("failed");
		}
	}

	public static void deletesaveF() {
		File f = new File("files/favF.txt"); // file to be delete
		if (f.delete()) // returns Boolean value
		{
			System.out.println(f.getName() + " deleted"); // getting and printing the file name
		} else {
			System.out.println("failed");
		}
	}

	public static void deletesaveS() {
		File f = new File("files/favS.txt"); // file to be delete
		if (f.delete()) // returns Boolean value
		{
			System.out.println(f.getName() + " deleted"); // getting and printing the file name
		} else {
			System.out.println("failed");
		}
	}

	public static void deletesaveSu() {
		File f = new File("files/favSu.txt"); // file to be delete
		if (f.delete()) // returns Boolean value
		{
			System.out.println(f.getName() + " deleted"); // getting and printing the file name
		} else {
			System.out.println("failed");
		}
	}
}
