package lessons;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class SubString_UI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField subTextField;
	private SubString ssr = new SubString();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubString_UI frame = new SubString_UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SubString_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(437, 155, 79, 75);
		contentPane.add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(17, 155, 409, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		subTextField = new JTextField();
		subTextField.setColumns(10);
		subTextField.setBounds(17, 209, 409, 21);
		contentPane.add(subTextField);
		
		JLabel lblText = new JLabel("Text");
		lblText.setBounds(17, 131, 54, 15);
		contentPane.add(lblText);
		
		JLabel lblNeedle = new JLabel("Needle/SubString");
		lblNeedle.setBounds(17, 186, 115, 15);
		contentPane.add(lblNeedle);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(17, 29, 499, 92);
		contentPane.add(textArea);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(25, 10, 54, 15);
		contentPane.add(lblResult);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ssr.setText(textField.getText());
				int[] result = ssr.KMP(subTextField.getText());
				
				String disaplay = "SubString starts at: ";
				
				int i = 0;
				while ( i < result.length){
					if (i > 0 && result[i]==0) {
						break;
					}
					disaplay += String.format("%s, ", result[i]);
					i += 1;
				}
				disaplay += String.format("\n\nTotal: %s", i);
				textArea.setText(disaplay);
				
			}
		});
	}
}
