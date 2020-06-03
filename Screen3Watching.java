/* AnimeGadget
* P: to view & play shows you are currently watching
* June 1st 2020
* Arjun Anand
* Screen3Watching.java
*/ 


package ISP;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import org.apache.commons.lang3.StringUtils;

import java.awt.BorderLayout;
import java.awt.Desktop;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.lang.*;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;
import javax.swing.SwingConstants;
import java.awt.Color; // Import the Scanner class to read text files

public class Screen3Watching {

	static int z = 0;
	static ArrayList<String> ShowName = new ArrayList<String>(100);
	static ArrayList<String> ShowEpisode = new ArrayList<String>(100);
	static ArrayList<String> ShowLink = new ArrayList<String>(100);
	static ArrayList<String> ShowNamewriter = new ArrayList<String>(100);
	static ArrayList<String> ShowEpisodewriter = new ArrayList<String>(100);
	static ArrayList<String> ShowLinkwriter = new ArrayList<String>(100);
	static int custom1 = 0;
	static int custom2 = 0;
	static int custom3 = 0;
	static String data;
	static int save = 0;
	static boolean exists;
	static int added;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Screen3Watching window = new Screen3Watching();
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
	public Screen3Watching() {
		ShowName.clear();
		ShowEpisode.clear();
		ShowLink.clear();
		ShowNamewriter.clear();
		ShowLinkwriter.clear();
		ShowEpisodewriter.clear();
		testsave();
		System.out.println("save is: " + exists);
		if (exists) {
			try {
				readdata();
			} catch (Exception e) {
				e.printStackTrace();
			}
			convertvariables();

		}
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 663, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ScreenOptions start = new ScreenOptions();
		custom1 = ScreenOptions.sendcustom1(custom1);
		custom2 = ScreenOptions.sendcustom2(custom2);
		custom3 = ScreenOptions.sendcustom3(custom3);

		System.out.println("Custom1 is " + custom1);
		System.out.println("Custom2 is " + custom2);
		System.out.println("Custom3 is " + custom3);

		frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(496, 11, 129, 49);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				deletesave(); // check
				newvariables(); // check
				createsave();

			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

		lblNewLabel.setBounds(10, 101, 129, 34);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 164, 128, 34);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 243, 128, 34);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 312, 128, 34);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 383, 128, 34);
		frame.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(332, 101, 129, 34);
		frame.getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(332, 164, 239, 34);
		frame.getContentPane().add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(332, 243, 239, 34);
		frame.getContentPane().add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(332, 312, 239, 34);
		frame.getContentPane().add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 20));

		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(ShowLink.get(0).toString()).toURI());
					System.out.print(ShowLink.get(0));
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(ShowLink.get(1).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(ShowLink.get(2).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(ShowLink.get(3).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(ShowLink.get(4).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(ShowLink.get(5).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(ShowLink.get(6).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(ShowLink.get(7).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL(ShowLink.get(8).toString()).toURI());
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});

		JButton btnNewButton1 = new JButton("+");
		btnNewButton1.setBounds(135, 101, 63, 34);
		frame.getContentPane().add(btnNewButton1);

		JButton btnNewButton11 = new JButton("del");
		btnNewButton11.setBounds(197, 101, 63, 34);
		frame.getContentPane().add(btnNewButton11);

		JButton btnNewButton111 = new JButton("-");
		btnNewButton111.setBounds(259, 101, 63, 34);
		frame.getContentPane().add(btnNewButton111);

		JButton btnNewButton2 = new JButton("+");
		btnNewButton2.setBounds(135, 164, 63, 34);
		frame.getContentPane().add(btnNewButton2);

		JButton btnNewButton22 = new JButton("del");
		btnNewButton22.setBounds(197, 164, 63, 34);
		frame.getContentPane().add(btnNewButton22);

		JButton btnNewButton222 = new JButton("-");
		btnNewButton222.setBounds(259, 164, 63, 34);
		frame.getContentPane().add(btnNewButton222);

		JButton btnNewButton3 = new JButton("+");
		btnNewButton3.setBounds(135, 243, 63, 34);
		frame.getContentPane().add(btnNewButton3);

		JButton btnNewButton33 = new JButton("del");
		btnNewButton33.setBounds(197, 243, 63, 34);
		frame.getContentPane().add(btnNewButton33);

		JButton btnNewButton333 = new JButton("-");
		btnNewButton333.setBounds(259, 243, 63, 34);
		frame.getContentPane().add(btnNewButton333);

		JButton btnNewButton4 = new JButton("+");
		btnNewButton4.setBounds(135, 312, 63, 34);
		frame.getContentPane().add(btnNewButton4);

		JButton btnNewButton44 = new JButton("del");
		btnNewButton44.setBounds(197, 312, 63, 34);
		frame.getContentPane().add(btnNewButton44);

		JButton btnNewButton444 = new JButton("-");
		btnNewButton444.setBounds(259, 312, 63, 34);
		frame.getContentPane().add(btnNewButton444);

		JButton btnNewButton5 = new JButton("+");
		btnNewButton5.setBounds(135, 383, 63, 34);
		frame.getContentPane().add(btnNewButton5);

		JButton btnNewButton55 = new JButton("del");
		btnNewButton55.setBounds(197, 383, 63, 34);
		frame.getContentPane().add(btnNewButton55);

		JButton btnNewButton555 = new JButton("-");
		btnNewButton555.setBounds(259, 383, 63, 34);
		frame.getContentPane().add(btnNewButton555);

		JButton btnNewButton6 = new JButton("+");
		btnNewButton6.setBounds(458, 101, 63, 34);
		frame.getContentPane().add(btnNewButton6);

		JButton btnNewButton66 = new JButton("del");
		btnNewButton66.setBounds(518, 101, 63, 34);
		frame.getContentPane().add(btnNewButton66);

		JButton btnNewButton666 = new JButton("-");
		btnNewButton666.setBounds(578, 101, 63, 34);
		frame.getContentPane().add(btnNewButton666);

		JButton btnNewButton7 = new JButton("+");
		btnNewButton7.setBounds(458, 170, 63, 34);
		frame.getContentPane().add(btnNewButton7);

		JButton btnNewButton77 = new JButton("del");
		btnNewButton77.setBounds(518, 170, 63, 34);
		frame.getContentPane().add(btnNewButton77);

		JButton btnNewButton777 = new JButton("-");
		btnNewButton777.setBounds(578, 170, 63, 34);
		frame.getContentPane().add(btnNewButton777);

		JButton btnNewButton8 = new JButton("+");
		btnNewButton8.setBounds(458, 249, 63, 34);
		frame.getContentPane().add(btnNewButton8);

		JButton btnNewButton88 = new JButton("del");
		btnNewButton88.setBounds(518, 249, 63, 34);
		frame.getContentPane().add(btnNewButton88);

		JButton btnNewButton888 = new JButton("-");
		btnNewButton888.setBounds(578, 249, 63, 34);
		frame.getContentPane().add(btnNewButton888);

		JButton btnNewButton9 = new JButton("+");
		btnNewButton9.setBounds(458, 318, 63, 34);
		frame.getContentPane().add(btnNewButton9);

		JButton btnNewButton99 = new JButton("del");
		btnNewButton99.setBounds(518, 318, 63, 34);
		frame.getContentPane().add(btnNewButton99);

		JButton btnNewButton999 = new JButton("-");
		btnNewButton999.setBounds(578, 318, 63, 34);
		frame.getContentPane().add(btnNewButton999);

		JLabel lblNewLabelwatching = new JLabel("Watching:");
		lblNewLabelwatching.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabelwatching.setBounds(34, 29, 285, 49);
		frame.getContentPane().add(lblNewLabelwatching);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(197, 76, 63, 14);
		frame.getContentPane().add(lblNewLabel_11);

		JLabel lblNewLabel_11_1 = new JLabel("");
		lblNewLabel_11_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_1.setBounds(197, 135, 63, 24);
		frame.getContentPane().add(lblNewLabel_11_1);

		JLabel lblNewLabel_11_2 = new JLabel("");
		lblNewLabel_11_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_2.setBounds(197, 209, 63, 24);
		frame.getContentPane().add(lblNewLabel_11_2);

		JLabel lblNewLabel_11_3 = new JLabel("");
		lblNewLabel_11_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_3.setBounds(197, 288, 63, 24);
		frame.getContentPane().add(lblNewLabel_11_3);

		JLabel lblNewLabel_11_4 = new JLabel("");
		lblNewLabel_11_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_4.setBounds(197, 357, 63, 24);
		frame.getContentPane().add(lblNewLabel_11_4);

		JLabel lblNewLabel_11_5 = new JLabel("");
		lblNewLabel_11_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_5.setBounds(529, 76, 63, 24);
		frame.getContentPane().add(lblNewLabel_11_5);

		JLabel lblNewLabel_11_6 = new JLabel("");
		lblNewLabel_11_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_6.setBounds(529, 146, 63, 24);
		frame.getContentPane().add(lblNewLabel_11_6);

		JLabel lblNewLabel_11_7 = new JLabel("");
		lblNewLabel_11_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_7.setBounds(529, 215, 63, 24);
		frame.getContentPane().add(lblNewLabel_11_7);

		JLabel lblNewLabel_11_8 = new JLabel("");
		lblNewLabel_11_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_8.setBounds(529, 293, 63, 24);
		frame.getContentPane().add(lblNewLabel_11_8);

		JLabel lblNewLabel_10 = new JLabel("");

		if (custom1 == 1) {
			lblNewLabel_10.setIcon(new ImageIcon("pictures/city watching.jpg"));
		}
		if (custom2 == 1) {
			lblNewLabel_10.setIcon(new ImageIcon("pictures/forest.jpg"));
		}
		if (custom3 == 1) {
			lblNewLabel_10.setIcon(new ImageIcon("pictures/ocean2.jpg"));
		}
		lblNewLabel_10.setBounds(0, 0, 651, 452);
		frame.getContentPane().add(lblNewLabel_10);
		// test links
		// https://www.kickassanime.rs/anime/kami-no-tou-346996
		// https://www.kickassanime.rs/anime/plunderer-675339

		// ShowName.clear();
		// ShowEpisode.clear();

		System.out.println("Show Name is " + ShowName);
		System.out.println("Show Episode is " + ShowEpisode);
		System.out.println("Show Link is " + ShowLink);
		z++;

		try {
			lblNewLabel.setText(ShowName.get(0));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_1.setText(ShowName.get(1));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_2.setText(ShowName.get(2));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_3.setText(ShowName.get(3));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_4.setText(ShowName.get(4));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_5.setText(ShowName.get(5));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_6.setText(ShowName.get(6));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_7.setText(ShowName.get(7));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_8.setText(ShowName.get(8));
		} catch (Exception E) {
		}

		try {
			lblNewLabel_11.setText(ShowEpisode.get(0));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_11_1.setText(ShowEpisode.get(1));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_11_2.setText(ShowEpisode.get(2));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_11_3.setText(ShowEpisode.get(3));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_11_4.setText(ShowEpisode.get(4));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_11_5.setText(ShowEpisode.get(5));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_11_6.setText(ShowEpisode.get(6));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_11_7.setText(ShowEpisode.get(7));
		} catch (Exception E) {
		}
		try {
			lblNewLabel_11_8.setText(ShowEpisode.get(8));

		} catch (Exception E) {
		}

		btnNewButton1.setVisible(false);
		btnNewButton11.setVisible(false);
		btnNewButton111.setVisible(false);
		btnNewButton2.setVisible(false);
		btnNewButton22.setVisible(false);
		btnNewButton222.setVisible(false);
		btnNewButton3.setVisible(false);
		btnNewButton33.setVisible(false);
		btnNewButton333.setVisible(false);
		btnNewButton4.setVisible(false);
		btnNewButton44.setVisible(false);
		btnNewButton444.setVisible(false);
		btnNewButton5.setVisible(false);
		btnNewButton55.setVisible(false);
		btnNewButton555.setVisible(false);
		btnNewButton6.setVisible(false);
		btnNewButton66.setVisible(false);
		btnNewButton666.setVisible(false);
		btnNewButton7.setVisible(false);
		btnNewButton77.setVisible(false);
		btnNewButton777.setVisible(false);
		btnNewButton8.setVisible(false);
		btnNewButton88.setVisible(false);
		btnNewButton888.setVisible(false);
		btnNewButton9.setVisible(false);
		btnNewButton99.setVisible(false);
		btnNewButton999.setVisible(false);

		// show 1
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(0).toString());
				x++;
				ShowEpisode.set(0, Integer.toString(x));
				lblNewLabel_11.setText(ShowEpisode.get(0));

			}

		});
		btnNewButton11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNewButton1.setVisible(false);
				btnNewButton11.setVisible(false);
				btnNewButton111.setVisible(false);
				ShowEpisode.remove(0);
				ShowName.remove(0);
				lblNewLabel.setText("");
				lblNewLabel_11.setText("");

			}

		});

		btnNewButton111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(0).toString());
				x--;
				if (x < 0) {
					x = 0;
				}
				ShowEpisode.set(0, Integer.toString(x));
				lblNewLabel_11.setText(ShowEpisode.get(0));

			}

		});

//show 2		
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(1).toString());
				x++;
				ShowEpisode.set(1, Integer.toString(x));
				lblNewLabel_11_1.setText(ShowEpisode.get(1));

			}

		});
		btnNewButton22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNewButton2.setVisible(false);
				btnNewButton22.setVisible(false);
				btnNewButton222.setVisible(false);
				ShowEpisode.remove(1);
				ShowName.remove(1);
				lblNewLabel_1.setText("");
				lblNewLabel_11_1.setText("");

			}

		});

		btnNewButton222.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(1).toString());
				x--;
				if (x < 0) {
					x = 0;
				}
				ShowEpisode.set(1, Integer.toString(x));
				lblNewLabel_11_1.setText(ShowEpisode.get(1));

			}

		});

		// show 3

		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(2).toString());
				x++;
				ShowEpisode.set(2, Integer.toString(x));
				lblNewLabel_11_2.setText(ShowEpisode.get(2));

			}

		});
		btnNewButton33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNewButton3.setVisible(false);
				btnNewButton33.setVisible(false);
				btnNewButton333.setVisible(false);
				ShowEpisode.remove(2);
				ShowName.remove(2);
				lblNewLabel_2.setText("");
				lblNewLabel_11_2.setText("");

			}

		});

		btnNewButton333.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(2).toString());
				x--;
				if (x < 0) {
					x = 0;
				}
				ShowEpisode.set(2, Integer.toString(x));
				lblNewLabel_11_2.setText(ShowEpisode.get(2));

			}

		});

		// show 4

		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(3).toString());
				x++;
				ShowEpisode.set(3, Integer.toString(x));
				lblNewLabel_11_3.setText(ShowEpisode.get(3));

			}

		});
		btnNewButton44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNewButton4.setVisible(false);
				btnNewButton44.setVisible(false);
				btnNewButton444.setVisible(false);
				ShowEpisode.remove(3);
				ShowName.remove(3);
				lblNewLabel_3.setText("");
				lblNewLabel_11_3.setText("");

			}

		});

		btnNewButton444.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(3).toString());
				x--;
				if (x < 0) {
					x = 0;
				}
				ShowEpisode.set(3, Integer.toString(x));
				lblNewLabel_11_3.setText(ShowEpisode.get(3));

			}

		});

		// show 5

		btnNewButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(4).toString());
				x++;
				ShowEpisode.set(4, Integer.toString(x));
				lblNewLabel_11_4.setText(ShowEpisode.get(4));

			}

		});
		btnNewButton55.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNewButton5.setVisible(false);
				btnNewButton55.setVisible(false);
				btnNewButton555.setVisible(false);
				ShowEpisode.remove(4);
				ShowName.remove(4);
				lblNewLabel_4.setText("");
				lblNewLabel_11_4.setText("");

			}

		});

		btnNewButton555.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(4).toString());
				x--;
				if (x < 0) {
					x = 0;
				}
				ShowEpisode.set(4, Integer.toString(x));
				lblNewLabel_11_4.setText(ShowEpisode.get(4));

			}

		});

		// show 6

		btnNewButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(5).toString());
				x++;
				ShowEpisode.set(5, Integer.toString(x));
				lblNewLabel_11_5.setText(ShowEpisode.get(5));

			}

		});
		btnNewButton66.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNewButton6.setVisible(false);
				btnNewButton66.setVisible(false);
				btnNewButton666.setVisible(false);
				ShowEpisode.remove(5);
				ShowName.remove(5);
				lblNewLabel_5.setText("");
				lblNewLabel_11_5.setText("");

			}

		});

		btnNewButton666.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(5).toString());
				x--;
				if (x < 0) {
					x = 0;
				}
				ShowEpisode.set(5, Integer.toString(x));
				lblNewLabel_11_5.setText(ShowEpisode.get(5));

			}

		});

		// show 7

		btnNewButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(6).toString());
				x++;
				ShowEpisode.set(6, Integer.toString(x));
				lblNewLabel_11_6.setText(ShowEpisode.get(6));

			}

		});
		btnNewButton77.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNewButton7.setVisible(false);
				btnNewButton77.setVisible(false);
				btnNewButton777.setVisible(false);
				ShowEpisode.remove(6);
				ShowName.remove(6);
				lblNewLabel_6.setText("");
				lblNewLabel_11_6.setText("");

			}

		});

		btnNewButton777.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(6).toString());
				x--;
				if (x < 0) {
					x = 0;
				}
				ShowEpisode.set(6, Integer.toString(x));
				lblNewLabel_11_6.setText(ShowEpisode.get(6));

			}

		});

		// show 8
		btnNewButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(7).toString());
				x++;
				ShowEpisode.set(7, Integer.toString(x));
				lblNewLabel_11_7.setText(ShowEpisode.get(7));

			}

		});
		btnNewButton88.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNewButton8.setVisible(false);
				btnNewButton88.setVisible(false);
				btnNewButton888.setVisible(false);
				ShowEpisode.remove(7);
				ShowName.remove(7);
				lblNewLabel_7.setText("");
				lblNewLabel_11_7.setText("");

			}

		});

		btnNewButton888.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(7).toString());
				x--;
				if (x < 0) {
					x = 0;
				}
				ShowEpisode.set(7, Integer.toString(x));
				lblNewLabel_11_7.setText(ShowEpisode.get(7));

			}

		});

		// show 9
		btnNewButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(8).toString());
				x++;
				ShowEpisode.set(8, Integer.toString(x));
				lblNewLabel_11_8.setText(ShowEpisode.get(8));

			}

		});
		btnNewButton99.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnNewButton9.setVisible(false);
				btnNewButton99.setVisible(false);
				btnNewButton999.setVisible(false);
				ShowEpisode.remove(8);
				ShowName.remove(8);
				lblNewLabel_8.setText("");
				lblNewLabel_11_8.setText("");

			}

		});

		btnNewButton999.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = Integer.parseInt(ShowEpisode.get(8).toString());
				x--;
				if (x < 0) {
					x = 0;
				}
				ShowEpisode.set(8, Integer.toString(x));
				lblNewLabel_11_8.setText(ShowEpisode.get(8));

			}

		});

		try {
			if (!(ShowName.get(0).equalsIgnoreCase(""))) {
				btnNewButton1.setVisible(true);
				btnNewButton11.setVisible(true);
				btnNewButton111.setVisible(true);

			}
		} catch (Exception E) {

		}

		try {
			if (!(ShowName.get(1).equalsIgnoreCase(""))) {
				btnNewButton2.setVisible(true);
				btnNewButton22.setVisible(true);
				btnNewButton222.setVisible(true);
			}
		} catch (Exception E) {

		}

		try {
			if (!(ShowName.get(2).equalsIgnoreCase(""))) {
				btnNewButton3.setVisible(true);
				btnNewButton33.setVisible(true);
				btnNewButton333.setVisible(true);
			}
		} catch (Exception E) {

		}

		try {
			if (!(ShowName.get(3).equalsIgnoreCase(""))) {
				btnNewButton4.setVisible(true);
				btnNewButton44.setVisible(true);
				btnNewButton444.setVisible(true);
			}
		} catch (Exception E) {

		}

		try {
			if (!(ShowName.get(4).equalsIgnoreCase(""))) {
				btnNewButton5.setVisible(true);
				btnNewButton55.setVisible(true);
				btnNewButton555.setVisible(true);
			}
		} catch (Exception E) {

		}

		try {
			if (!(ShowName.get(5).equalsIgnoreCase(""))) {
				btnNewButton6.setVisible(true);
				btnNewButton66.setVisible(true);
				btnNewButton666.setVisible(true);
			}
		} catch (Exception E) {

		}

		try {
			if (!(ShowName.get(6).equalsIgnoreCase(""))) {
				btnNewButton7.setVisible(true);
				btnNewButton77.setVisible(true);
				btnNewButton777.setVisible(true);
			}
		} catch (Exception E) {

		}

		try {
			if (!(ShowName.get(7).equalsIgnoreCase(""))) {
				btnNewButton8.setVisible(true);
				btnNewButton88.setVisible(true);
				btnNewButton888.setVisible(true);
			}
		} catch (Exception E) {

		}

		try {
			if (!(ShowName.get(8).equalsIgnoreCase(""))) {
				btnNewButton9.setVisible(true);
				btnNewButton99.setVisible(true);
				btnNewButton999.setVisible(true);
			}
		} catch (Exception E) {

		}

	}
	/*
	 * public void writesave() throws IOException { FileWriter myWriter = new
	 * FileWriter("save.txt"); myWriter.write("1" + ShowName.get(0) + "2" +
	 * ShowName.get(1) + "3" + ShowName.get(2) + "4" + ShowName.get(3) + "5" +
	 * ShowName.get(4) + "6" + ShowName.get(5) + "7" + ShowName.get(6) + "8" +
	 * ShowName.get(7) + "9" + ShowName.get(8) + "11" + ShowEpisode.get(0) + "22" +
	 * ShowEpisode.get(1) + "33" + ShowEpisode.get(2) + "44" + ShowEpisode.get(3) +
	 * "55" + ShowEpisode.get(4) + "66" + ShowEpisode.get(5) + "77" +
	 * ShowEpisode.get(6) + "88" + ShowEpisode.get(7) + "99" + ShowEpisode.get(8) +
	 * "111" + ShowLink.get(0) + "222" + ShowLink.get(1) + "333" + ShowLink.get(2) +
	 * "444" + ShowLink.get(3) + "555" + ShowLink.get(4) + "666" + ShowLink.get(5) +
	 * "777" + ShowLink.get(6) + "888" + ShowLink.get(7) + "999" + ShowLink.get(8) +
	 * "101010"); myWriter.close(); }
	 * 
	 */
	/*
	 * File myObj2 = new File("save.txt"); Scanner myReader = new Scanner(myObj2);
	 * while (myReader.hasNextLine()) { data = myReader.nextLine();
	 * System.out.println("SUS" + data);
	 * 
	 * ShowName.set(0, StringUtils.substringBetween(data.toString(), "1", "2"));
	 * ShowName.set(1, StringUtils.substringBetween(data.toString(), "2", "3"));
	 * ShowName.set(2, StringUtils.substringBetween(data.toString(), "3", "4"));
	 * ShowName.set(3, StringUtils.substringBetween(data.toString(), "4", "5"));
	 * ShowName.set(4, StringUtils.substringBetween(data.toString(), "5", "6"));
	 * ShowName.set(5, StringUtils.substringBetween(data.toString(), "6", "7"));
	 * ShowName.set(6, StringUtils.substringBetween(data.toString(), "7", "8"));
	 * ShowName.set(7, StringUtils.substringBetween(data.toString(), "8", "9"));
	 * ShowName.set(8, StringUtils.substringBetween(data.toString(), "8", "11"));
	 * ShowEpisode.set(0, StringUtils.substringBetween(data.toString(), "11",
	 * "22")); ShowEpisode.set(1, StringUtils.substringBetween(data.toString(),
	 * "22", "33")); ShowEpisode.set(2,
	 * StringUtils.substringBetween(data.toString(), "33", "44"));
	 * ShowEpisode.set(3, StringUtils.substringBetween(data.toString(), "44",
	 * "55")); ShowEpisode.set(4, StringUtils.substringBetween(data.toString(),
	 * "55", "66")); ShowEpisode.set(5,
	 * StringUtils.substringBetween(data.toString(), "66", "77"));
	 * ShowEpisode.set(6, StringUtils.substringBetween(data.toString(), "77",
	 * "88")); ShowEpisode.set(7, StringUtils.substringBetween(data.toString(),
	 * "88", "99")); ShowEpisode.set(8,
	 * StringUtils.substringBetween(data.toString(), "99", "111")); ShowLink.set(0,
	 * StringUtils.substringBetween(data.toString(), "111", "222")); ShowLink.set(1,
	 * StringUtils.substringBetween(data.toString(), "222", "333")); ShowLink.set(2,
	 * StringUtils.substringBetween(data.toString(), "333", "444")); ShowLink.set(3,
	 * StringUtils.substringBetween(data.toString(), "444", "555")); ShowLink.set(4,
	 * StringUtils.substringBetween(data.toString(), "555", "666")); ShowLink.set(5,
	 * StringUtils.substringBetween(data.toString(), "666", "777")); ShowLink.set(6,
	 * StringUtils.substringBetween(data.toString(), "777", "888")); ShowLink.set(7,
	 * StringUtils.substringBetween(data.toString(), "888", "999")); ShowLink.set(8,
	 * StringUtils.substringBetween(data.toString(), "999", "101010")); * File
	 * myObj2 = new File("save.txt"); Scanner myReader = new Scanner(myObj2); while
	 * (myReader.hasNextLine()) { data = myReader.nextLine();
	 * System.out.println("SUS" + data); myReader.close();
	 */

	public static void setvariables() throws FileNotFoundException {
		File myObj2 = new File("files/save.txt");
		Scanner myReader = new Scanner(myObj2);
		while (myReader.hasNextLine()) {
			data = myReader.nextLine();
			System.out.println("SUS" + data);

			ShowName.add(0, StringUtils.substringBetween(data.toString(), ".1.", ".2."));
			ShowName.add(1, StringUtils.substringBetween(data.toString(), ".2.", ".3."));
			ShowName.add(2, StringUtils.substringBetween(data.toString(), ".3.", ".4."));
			ShowName.add(3, StringUtils.substringBetween(data.toString(), ".4.", ".5."));
			ShowName.add(4, StringUtils.substringBetween(data.toString(), ".5.", ".6."));
			ShowName.add(5, StringUtils.substringBetween(data.toString(), ".6.", ".7."));
			ShowName.add(6, StringUtils.substringBetween(data.toString(), ".7.", ".8."));
			ShowName.add(7, StringUtils.substringBetween(data.toString(), ".8.", ".9."));
			ShowName.add(8, StringUtils.substringBetween(data.toString(), ".9.", ".11."));
			ShowEpisode.add(0, StringUtils.substringBetween(data.toString(), ".11.", ".22."));
			ShowEpisode.add(1, StringUtils.substringBetween(data.toString(), ".22.", ".33."));
			ShowEpisode.add(2, StringUtils.substringBetween(data.toString(), ".33.", ".44."));
			ShowEpisode.add(3, StringUtils.substringBetween(data.toString(), ".44.", ".55."));
			ShowEpisode.add(4, StringUtils.substringBetween(data.toString(), ".55.", ".66."));
			ShowEpisode.add(5, StringUtils.substringBetween(data.toString(), ".66.", ".77."));
			ShowEpisode.add(6, StringUtils.substringBetween(data.toString(), ".77.", ".88."));
			ShowEpisode.add(7, StringUtils.substringBetween(data.toString(), ".88.", ".99."));
			ShowEpisode.add(8, StringUtils.substringBetween(data.toString(), ".99.", ".111."));
			ShowLink.add(0, StringUtils.substringBetween(data.toString(), ".111.", ".222."));
			ShowLink.add(1, StringUtils.substringBetween(data.toString(), ".222.", ".333."));
			ShowLink.add(2, StringUtils.substringBetween(data.toString(), ".333.", ".444."));
			ShowLink.add(3, StringUtils.substringBetween(data.toString(), ".444.", ".555."));
			ShowLink.add(4, StringUtils.substringBetween(data.toString(), ".555.", ".666."));
			ShowLink.add(5, StringUtils.substringBetween(data.toString(), ".666.", ".777."));
			ShowLink.add(6, StringUtils.substringBetween(data.toString(), ".777.", ".888."));
			ShowLink.add(7, StringUtils.substringBetween(data.toString(), ".888.", ".999."));
			ShowLink.add(8, StringUtils.substringBetween(data.toString(), ".999.", ".101010."));

			System.out.println("FINAL NAMES ARE: " + ShowName);
		}
		myReader.close();

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

	public static void testsave() {
		try {
			File tempFile = new File("files/save.txt");
			exists = tempFile.exists();

		} catch (Exception e) {

		}
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

	public static void readdata() throws FileNotFoundException {

		File myObj2 = new File("files/save.txt");
		Scanner myReader = new Scanner(myObj2);
		while (myReader.hasNextLine()) {
			data = myReader.nextLine();
			System.out.println(data);
		}
		myReader.close();

	}

}
