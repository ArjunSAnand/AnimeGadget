package ISP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;

public class Screen2Add {

	static ArrayList<String> Add = new ArrayList<String>(100);
	static ArrayList<String> AddEpisode = new ArrayList<String>(100);

	static ArrayList<String> ShowName = new ArrayList<String>(100);
	static ArrayList<String> ShowEpisode = new ArrayList<String>(100);
	static ArrayList<String> ShowLink = new ArrayList<String>(100);

	static ArrayList<String> ShowNamewriter = new ArrayList<String>(100);
	static ArrayList<String> ShowEpisodewriter = new ArrayList<String>(100);
	static ArrayList<String> ShowLinkwriter = new ArrayList<String>(100);
	static String data;

	private JFrame frame;
	private JTextField textField;
	private JTextField txtEnterEpisode;

	/**
	 * Launch the application.
	 * 
	 * @return
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Screen2Add window = new Screen2Add();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Screen2Add() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 764, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(136, 5, 210, 200);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon("pictures/17e70358cb55f6c7812f9573c531ab84_pin-on-anime-manga_500-474.jpeg"));
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(364, 92, 203, 25);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		// textField.setText("Enter Kickassanime Url Here");
		textField.setText("https://www.kickassanime.rs/anime/kami-no-tou-346996");
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("ADD URL");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(577, 88, 165, 33);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(btnNewButton);

		JLabel Show = new JLabel("-----");
		Show.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Show.setBounds(20, 366, 236, 33);
		frame.getContentPane().add(Show);

		JLabel ShowPicture = new JLabel("");
		ShowPicture.setBounds(390, 249, 48, 14);
		frame.getContentPane().add(ShowPicture);

		JLabel showAdded = new JLabel("Show Added:");
		showAdded.setFont(new Font("Times New Roman", Font.BOLD, 25));
		showAdded.setBounds(20, 265, 166, 33);
		frame.getContentPane().add(showAdded);

		txtEnterEpisode = new JTextField();
		txtEnterEpisode.setText("Enter Episode Number Here");
		txtEnterEpisode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnterEpisode.setColumns(10);
		txtEnterEpisode.setBounds(364, 151, 203, 25);
		frame.getContentPane().add(txtEnterEpisode);

		JButton btnAddEpisode = new JButton("ADD EP");
		btnAddEpisode.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAddEpisode.setBackground(Color.LIGHT_GRAY);
		btnAddEpisode.setBounds(577, 147, 165, 33);
		frame.getContentPane().add(btnAddEpisode);

		JLabel episodeAdded = new JLabel("Episode Added:");
		episodeAdded.setFont(new Font("Times New Roman", Font.BOLD, 25));
		episodeAdded.setBounds(272, 265, 197, 33);
		frame.getContentPane().add(episodeAdded);

		JLabel episodeText = new JLabel("-----");
		episodeText.setFont(new Font("Times New Roman", Font.BOLD, 15));
		episodeText.setBounds(272, 366, 197, 33);
		frame.getContentPane().add(episodeText);

		JButton Confirm = new JButton("Confirm");
		Confirm.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Confirm.setBackground(Color.LIGHT_GRAY);
		Confirm.setBounds(525, 337, 165, 33);
		frame.getContentPane().add(Confirm);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(562, 381, 128, 33);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(562, 422, 128, 33);
		frame.getContentPane().add(lblNewLabel_1_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String test = textField.getText();
					Document stuff = Jsoup.connect(test).timeout(6000).get();
					String x = stuff.toString();
					x = StringUtils.substringBetween(x, "{\"name\":", ",");
					// System.out.println(x);
					Show.setText(x);
					lblNewLabel_1.setText("confirmed!");

				}

				catch (Exception E) {
					// TODO Auto-generated catch block
					E.printStackTrace();
					lblNewLabel_1.setText("failed!");
				}
			}
		});
		btnAddEpisode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String test2 = txtEnterEpisode.getText();
				episodeText.setText(test2);
			}
		});
		Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String test1 = Show.getText();

				if (ShowName.contains(test1)) {
					Show.setText("Show Already Added");
					episodeText.setText("");
				} else {
					if (StringUtils.isNumeric(episodeText.getText())) {

						try {
							readdata();
							convertvariables();
						} catch (Exception e1) {
							e1.printStackTrace();
						}

						ShowName.add(test1);
						String test2 = episodeText.getText();
						Add.add(test1); 
						Add.add(test2);
						ShowEpisode.add(test2);

						deletesave(); // check
						newvariables(); // check
						createsave();

						lblNewLabel_1_1.setText("Added");
					} else {
						episodeText.setText("Enter a number");
					}

					if (textField.getText().equalsIgnoreCase("confirmed!")) {
						ShowLink.add(textField.getText());
					}

				}
			}
		});
		frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

	}

	public static void readdata() throws FileNotFoundException {

		File myObj2 = new File("files/save.txt");
		Scanner myReader = new Scanner(myObj2);
		while (myReader.hasNextLine()) {
			data = myReader.nextLine();
			System.out.println(data);
		}
		myReader.close();

	}

	public static void convertvariables() {

		if ((StringUtils.substringBetween(data.toString(), ".1.", ".2.")).equalsIgnoreCase("")) {

		} else {
			ShowName.add(0, StringUtils.substringBetween(data.toString(), ".1.", ".2."));
			ShowEpisode.add(0, StringUtils.substringBetween(data.toString(), ".11.", ".22."));
		}

		if ((StringUtils.substringBetween(data.toString(), ".2.", ".3.")).equalsIgnoreCase("")) {

		} else {
			ShowName.add(1, StringUtils.substringBetween(data.toString(), ".2.", ".3."));
			ShowEpisode.add(0, StringUtils.substringBetween(data.toString(), ".22.", ".33."));
		}

		if ((StringUtils.substringBetween(data.toString(), ".3.", ".4.")).equalsIgnoreCase("")) {

		} else {
			ShowName.add(2, StringUtils.substringBetween(data.toString(), ".3.", ".4."));
			ShowEpisode.add(0, StringUtils.substringBetween(data.toString(), ".33.", ".44."));
		}

		if ((StringUtils.substringBetween(data.toString(), ".4.", ".5.")).equalsIgnoreCase("")) {

		} else {
			ShowName.add(3, StringUtils.substringBetween(data.toString(), ".4.", ".5."));
			ShowEpisode.add(0, StringUtils.substringBetween(data.toString(), ".44.", ".55."));
		}

		if ((StringUtils.substringBetween(data.toString(), ".5.", ".6.")).equalsIgnoreCase("")) {

		} else {
			ShowName.add(4, StringUtils.substringBetween(data.toString(), ".5.", ".6."));
			ShowEpisode.add(0, StringUtils.substringBetween(data.toString(), ".55.", ".66."));
		}

		if ((StringUtils.substringBetween(data.toString(), ".6.", ".7.")).equalsIgnoreCase("")) {

		} else {
			ShowName.add(5, StringUtils.substringBetween(data.toString(), ".6.", ".7."));
			ShowEpisode.add(0, StringUtils.substringBetween(data.toString(), ".66.", ".77."));
		}

		if ((StringUtils.substringBetween(data.toString(), ".7.", ".8.")).equalsIgnoreCase("")) {

		} else {
			ShowName.add(6, StringUtils.substringBetween(data.toString(), ".7.", ".8."));
			ShowEpisode.add(0, StringUtils.substringBetween(data.toString(), ".77.", ".88."));
		}

		if ((StringUtils.substringBetween(data.toString(), ".8.", ".9.")).equalsIgnoreCase("")) {

		} else {
			ShowName.add(7, StringUtils.substringBetween(data.toString(), ".8.", ".9."));
			ShowEpisode.add(0, StringUtils.substringBetween(data.toString(), ".88.", ".99."));
		}

		if ((StringUtils.substringBetween(data.toString(), ".9.", ".11.")).equalsIgnoreCase("")) {

		} else {
			ShowName.add(8, StringUtils.substringBetween(data.toString(), ".9.", ".11."));
			ShowEpisode.add(0, StringUtils.substringBetween(data.toString(), ".99.", ".111."));
		}

	}

	public static void deletesave() {
		File f = new File("files/save.txt"); // file to be delete
		if (f.delete()) // returns Boolean value
		{
			System.out.println(f.getName() + " deleted"); // getting and printing the file name
		} else {
			System.out.println("failed");
		}
	}

	public static void newvariables() {

		ShowEpisodewriter.clear();
		ShowNamewriter.clear();

		ShowEpisodewriter.addAll(ShowEpisode);
		ShowNamewriter.addAll(ShowName);
		ShowLinkwriter.addAll(ShowLink);
		System.out.println("EP # " + ShowEpisodewriter);
		System.out.println("EP link " + ShowLinkwriter);
		System.out.println("EP name " + ShowNamewriter);

		System.out.println("EP # size " + ShowEpisodewriter.size());
		System.out.println("EP link size " + ShowLinkwriter.size());
		System.out.println("EP name size " + ShowNamewriter.size());

		for (int x = ShowEpisodewriter.size(); x < (17 - ShowEpisodewriter.size()); x++) {
			ShowEpisodewriter.add(x, "");
			ShowNamewriter.add(x, "");
		}
		System.out.println("EP # " + ShowEpisodewriter);
		System.out.println("EP link " + ShowLinkwriter);
		System.out.println("EP name " + ShowNamewriter);
		System.out.println("EP # size " + ShowEpisodewriter.size());
		System.out.println("EP link size " + ShowLinkwriter.size());
		System.out.println("EP name size " + ShowNamewriter.size());

	}

	public static void createsave() {
		try {
			deletesave();
			FileWriter myWriter = new FileWriter("files/save.txt");
			System.out.println("Creating File");
			myWriter.write(".1." + ShowNamewriter.get(0) + ".2." + ShowNamewriter.get(1) + ".3." + ShowNamewriter.get(2)
					+ ".4." + ShowNamewriter.get(3) + ".5." + ShowNamewriter.get(4) + ".6." + ShowNamewriter.get(5)
					+ ".7." + ShowNamewriter.get(6) + ".8." + ShowNamewriter.get(7) + ".9." + ShowNamewriter.get(8)
					+ ".11." + ShowEpisodewriter.get(0) + ".22." + ShowEpisodewriter.get(1) + ".33."
					+ ShowEpisodewriter.get(2) + ".44." + ShowEpisodewriter.get(3) + ".55." + ShowEpisodewriter.get(4)
					+ ".66." + ShowEpisodewriter.get(5) + ".77." + ShowEpisodewriter.get(6) + ".88."
					+ ShowEpisodewriter.get(7) + ".99." + ShowEpisodewriter.get(8) + ".111.");
			myWriter.close();
		} catch (Exception e) {
			System.out.println("Failing File");
			e.printStackTrace();
		}
	}
}
