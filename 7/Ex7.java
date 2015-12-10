import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
	private JTextArea textArea;
	
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

		JPanel westPanel = new JPanel();
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		frame.getContentPane().add(westPanel, BorderLayout.WEST);
		
		JLabel label1 = new JLabel("File Name");
		westPanel.add(label1);
		
		JTextField textField = new JTextField("./aaa.png");
		westPanel.add(textField);

		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("ファイルを読み込む！！！");
				textArea.append(String.format("Load '%s'\n", textField.getText()));
			}
		});
		westPanel.add(btnLoad);

		JButton btnBinary = new JButton("Binary");
		btnBinary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("2値化！！！");
			}
		});
		westPanel.add(btnBinary);
		
		JButton btnNegative = new JButton("Negative");
		btnNegative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("ネガ・ポジ！！！");
			}
		});
		westPanel.add(btnNegative);
		
		textArea = new JTextArea("");
		textArea.setPreferredSize(new Dimension());
	
		JScrollPane scroll1 = new JScrollPane(textArea);
		frame.getContentPane().add(scroll1, BorderLayout.SOUTH);

	}
}
