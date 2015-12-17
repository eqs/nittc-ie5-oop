import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ex7{
	
	private JFrame frame;
	private JTextArea textArea;
	
	private ImagePanel imagePanel;
	
	// グレースケール画像を突っ込んでおく変数
	private GrayImage img;
	
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
		westPanel.setPreferredSize(new Dimension(228, 64));
		westPanel.setLayout(new FlowLayout());
		frame.getContentPane().add(westPanel, BorderLayout.WEST);
		
		JLabel label1 = new JLabel("File Name");
		westPanel.add(label1);
		
		JTextField textField = new JTextField("./lena.png");
		textField.setPreferredSize(new Dimension(192, 24));
		westPanel.add(textField);

		JButton btnLoad = new JButton("Load");
		btnLoad.setPreferredSize(new Dimension(160, 24));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				textArea.append(String.format("Load '%s'\n", textField.getText()));
				try{
					BufferedImage bimg = ImageIO.read(new File(textField.getText()));
					img = new GrayImage(bimg);
					imagePanel.setImage(img);
					imagePanel.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
				}catch(IOException e1){
					textArea.append(String.format("Can't find or load '%s'\n", textField.getText()));
				}
			}
		});
		westPanel.add(btnLoad);
	
		JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setPreferredSize(new Dimension(160, 8));
		westPanel.add(separator);

		JButton btnBinary = new JButton("Binary");
		btnBinary.setPreferredSize(new Dimension(160, 24));
		btnBinary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				// 2値化フィルタを画像に適用する
				BinaryImageFilter f = new BinaryImageFilter();
				img.applyFilter(f);
				imagePanel.setImage(img);
				imagePanel.repaint();
				textArea.append(String.format("apply binary filter\n"));
			}
		});
		westPanel.add(btnBinary);
		
		JButton btnNegative = new JButton("Negative");
		btnNegative.setPreferredSize(new Dimension(160, 24));
		btnNegative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				// ネガ・ポジ変換フィルタを画像に適用する
				NegativeImageFilter f = new NegativeImageFilter();
				img.applyFilter(f);
				imagePanel.setImage(img);
				imagePanel.repaint();
				textArea.append(String.format("apply negative filter\n"));
			}
		});
		westPanel.add(btnNegative);
		
		textArea = new JTextArea(5, 128);
		//textArea.setPreferredSize(new Dimension(160, 64));
	
		JScrollPane scroll1 = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.getContentPane().add(scroll1, BorderLayout.SOUTH);
		
		imagePanel = new ImagePanel();
		
		JScrollPane scroll2 = new JScrollPane(imagePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scroll2, BorderLayout.CENTER);

	}
}
