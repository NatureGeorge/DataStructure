package lessons;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class SepDec_UI extends JFrame {

	private JPanel contentPane;
	private JTextField inputField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SepDec_UI frame = new SepDec_UI();
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
	public SepDec_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputField = new JTextField();
		inputField.setBounds(10, 150, 576, 52);
		contentPane.add(inputField);
		inputField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(10, 212, 271, 66);
		contentPane.add(btnSubmit);
		
		JTextArea resultArea = new JTextArea();
		resultArea.setText("result");
		resultArea.setBounds(10, 10, 286, 118);
		contentPane.add(resultArea);
		
		JButton btnClearInput = new JButton("Clear Input");
		btnClearInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField.setText("");
			}
		});
		btnClearInput.setBounds(315, 212, 271, 66);
		contentPane.add(btnClearInput);
		
		JTextArea stackArea = new JTextArea();
		stackArea.setText("Content of Stack");
		stackArea.setBounds(306, 10, 286, 118);
		contentPane.add(stackArea);
		
		JLabel lblInputfield = new JLabel("InputField");
		lblInputfield.setBounds(10, 138, 100, 15);
		contentPane.add(lblInputfield);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SeparatorDetector sepDec = new SeparatorDetector();
					boolean result = sepDec.isLegal(inputField.getText());
					if (result) {
						resultArea.setText("The formula is correct !");
					}
					else {
						resultArea.setText("The formula is wrong !");
					}
					
					stackArea.setText("The Content of Current Stack Is\n" + sepDec.show);
					
					
				}catch(Exception e1) {
					resultArea.setText(String.format("[ INFO ] %s", e1));
				}
			}
		});
	}
}
