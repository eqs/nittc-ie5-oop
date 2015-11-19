import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ex7{
	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run(){
				try{
					Ex7 window  =new Ex7();
					window.frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ex7(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelWest = new JPanel();
		panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
		frame.getContentPane().add(panelWest, BorderLayout.WEST);
		
		JLabel label1 = new JLabel("File Name");
		panelWest.add(label1);
		
		JTextField textField = new JTextField("./aaa.png");
		panelWest.add(textField);
		
		JTextArea textArea = new JTextArea("aaa");

		JScrollPane scroll1 = new JScrollPane(textArea);
		frame.getContentPane().add(scroll1, BorderLayout.SOUTH);

	}
}
