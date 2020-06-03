/* AnimeGadget
* P: to customize the user interface
* June 1st 2020
* Arjun Anand
* ScreenOptions.java
*/ 

package ISP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.event.ItemEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScreenOptions {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	static int custom1 = 0;
	static int custom2 = 0;
	static int custom3 = 0;

	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenOptions window = new ScreenOptions();
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
	public ScreenOptions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 809, 623);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

		frame.getContentPane().setLayout(null);

		JLabel Customization = new JLabel("Customization");
		Customization.setFont(new Font("Times New Roman", Font.BOLD, 26));
		Customization.setBounds(307, 11, 171, 90);
		frame.getContentPane().add(Customization);

		JLabel lblNewLabel = new JLabel("City");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(73, 116, 42, 23);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Forest");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(367, 116, 64, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Ocean");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(650, 116, 78, 23);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("pictures/upcoming backgroudn test.jpg"));
		lblNewLabel_3.setBounds(28, 171, 171, 254);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("pictures/forest.jpg"));
		lblNewLabel_4.setBounds(307, 171, 171, 254);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("pictures/ocean2.jpg"));
		lblNewLabel_5.setBounds(595, 171, 171, 244);
		frame.getContentPane().add(lblNewLabel_5);

		JButton btnNewButton = new JButton("Select");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(28, 462, 171, 80);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Select");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(307, 462, 178, 80);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Select");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(595, 462, 171, 80);
		frame.getContentPane().add(btnNewButton_2);

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				btnNewButton.setText("Selected");
				btnNewButton_1.setText("Not Selected");
				btnNewButton_2.setText("Not Selected");
				resetcustom();
				custom1 = 1;
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				btnNewButton.setText("Not Selected");
				btnNewButton_1.setText("Selected");
				btnNewButton_2.setText("Not Selected");
				resetcustom();
				custom2 = 1;
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				btnNewButton.setText("Not Selected");
				btnNewButton_1.setText("Not Selected");
				btnNewButton_2.setText("Selected");
				resetcustom();
				custom3 = 1;
			}
		});
	}

	public static void resetcustom() {
		custom1 = 0;
		custom2 = 0;
		custom3 = 0;
	}

	public static int sendcustom1(int y) {
		return custom1;
	}

	public static int sendcustom2(int y) {
		return custom2;
	}

	public static int sendcustom3(int y) {
		return custom3;
	}
}
