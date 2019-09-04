package lessons;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.NumberFormatException;
import javax.swing.JLabel;
import java.awt.Color;

public class IList_UI extends JFrame {

	private JPanel contentPane;
	private JTextField inputField;
	private JTextField index_get;
	private JTextField textField_index_add;
	private JTextField textField_index_del;
	private JTextField ele_find;
	private JTextField textField_value_add;
	private JTextField textField_value_del;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IList_UI frame = new IList_UI();
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
	public IList_UI() {
		IList_IO iList_IO = new IList_IO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea txtrThe = new JTextArea();
		txtrThe.setText("The average-time-complexity and steps of insertion is:");
		txtrThe.setBounds(10, 151, 358, 52);
		contentPane.add(txtrThe);
		
		JTextArea list_text = new JTextArea();
		list_text.setBounds(10, 81, 358, 59);
		contentPane.add(list_text);
		
		inputField = new JTextField();
		inputField.setBounds(409, 29, 244, 50);
		contentPane.add(inputField);
		inputField.setColumns(10);
		
		JTextArea description_text = new JTextArea();
		description_text.setText("You can input comma-separate data \nand the program will store it in a sequence list.");
		description_text.setBounds(10, 10, 358, 44);
		contentPane.add(description_text);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(409, 89, 115, 23);
		contentPane.add(btnSubmit);
		
		JButton btnClear = new JButton("Clear Input");
		btnClear.setBounds(530, 89, 123, 23);
		contentPane.add(btnClear);
		
		JTextPane ele_get = new JTextPane();
		ele_get.setBounds(46, 287, 322, 21);
		contentPane.add(ele_get);
		
		index_get = new JTextField();
		index_get.setBounds(46, 318, 322, 21);
		contentPane.add(index_get);
		index_get.setColumns(10);
		
		JButton btnIndex = new JButton("Get");
		btnIndex.setBounds(409, 287, 244, 50);
		contentPane.add(btnIndex);
		
		textField_index_add = new JTextField();
		textField_index_add.setColumns(10);
		textField_index_add.setBounds(410, 151, 39, 21);
		contentPane.add(textField_index_add);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(530, 150, 123, 23);
		contentPane.add(btnAdd);
		
		JTextPane index_find = new JTextPane();
		index_find.setBounds(46, 373, 322, 21);
		contentPane.add(index_find);
		
		textField_index_del = new JTextField();
		textField_index_del.setColumns(10);
		textField_index_del.setBounds(409, 182, 40, 21);
		contentPane.add(textField_index_del);
		
		ele_find = new JTextField();
		ele_find.setColumns(10);
		ele_find.setBounds(46, 404, 322, 21);
		contentPane.add(ele_find);
		
		JTextPane length_text = new JTextPane();
		length_text.setBounds(10, 225, 358, 21);
		contentPane.add(length_text);
		
		JTextPane empty_text = new JTextPane();
		empty_text.setBounds(10, 256, 358, 21);
		contentPane.add(empty_text);
		
		JButton btnDel = new JButton("Del");
		btnDel.setBounds(530, 183, 123, 23);
		contentPane.add(btnDel);
		
		JButton btnFind = new JButton("Find");
		btnFind.setBounds(409, 371, 244, 54);
		contentPane.add(btnFind);
		
		JButton btnClearList = new JButton("Clear List");
		
		JButton btnGetListLength = new JButton("Get List Length");
		btnGetListLength.setBounds(409, 224, 244, 23);
		contentPane.add(btnGetListLength);
		
		JButton btnIsListEmpty = new JButton("Is List Empty?");
		btnIsListEmpty.setBounds(409, 256, 244, 23);
		contentPane.add(btnIsListEmpty);
		
		textField_value_add = new JTextField();
		textField_value_add.setColumns(10);
		textField_value_add.setBounds(459, 151, 65, 21);
		contentPane.add(textField_value_add);
		
		textField_value_del = new JTextField();
		textField_value_del.setColumns(10);
		textField_value_del.setBounds(458, 182, 66, 21);
		contentPane.add(textField_value_del);
		
		JLabel lblIndex = new JLabel("Index");
		lblIndex.setForeground(Color.ORANGE);
		lblIndex.setBackground(Color.ORANGE);
		lblIndex.setBounds(408, 132, 54, 15);
		contentPane.add(lblIndex);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setForeground(Color.ORANGE);
		lblValue.setBounds(470, 132, 54, 15);
		contentPane.add(lblValue);
		
		JLabel label = new JLabel("Index");
		label.setForeground(Color.ORANGE);
		label.setBackground(Color.ORANGE);
		label.setBounds(10, 318, 58, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Index");
		label_1.setForeground(Color.ORANGE);
		label_1.setBackground(Color.ORANGE);
		label_1.setBounds(10, 379, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Value");
		label_2.setForeground(Color.ORANGE);
		label_2.setBounds(10, 407, 54, 15);
		contentPane.add(label_2);
		
		JLabel lblValue_1 = new JLabel("Value");
		lblValue_1.setForeground(Color.ORANGE);
		lblValue_1.setBackground(Color.ORANGE);
		lblValue_1.setBounds(10, 293, 54, 15);
		contentPane.add(lblValue_1);
		
		JLabel lblContentOfList = new JLabel("Content Of List");
		lblContentOfList.setForeground(Color.ORANGE);
		lblContentOfList.setBackground(Color.ORANGE);
		lblContentOfList.setBounds(10, 64, 123, 15);
		contentPane.add(lblContentOfList);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setForeground(Color.ORANGE);
		lblInput.setBackground(Color.ORANGE);
		lblInput.setBounds(409, 10, 54, 15);
		contentPane.add(lblInput);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					iList_IO.receive(inputField.getText().split(","));
					list_text.setText(iList_IO.showList());
					txtrThe.setText(iList_IO.check());
				}catch(Exception e1) {
					list_text.setText(String.format("[ INFO ] %s", e1));
				}
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					inputField.setText("");
				}catch(Exception e1) {
					inputField.setText("Error !");
				}
			}
		});
		
		btnIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ele_get.setText(""+iList_IO.getEleViaIndex(Integer.parseInt(index_get.getText())));
				}
				catch(Exception e1) {
					ele_get.setText("[ INFO ] Invalid Input !");
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int index = Integer.parseInt(textField_index_add.getText());
					String ele = textField_value_add.getText();
					iList_IO.addEleToIndex(index, ele);
					list_text.setText(iList_IO.showList());
					txtrThe.setText(iList_IO.check());
				}
				catch(NumberFormatException e1) {
					list_text.setText("[ INFO ] Invalid Input !");
				}
				catch(Exception e2) {
					list_text.setText(String.format("[ INFO ] %s",e2));
				}
			}
		});
		
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int index = Integer.parseInt(textField_index_del.getText());
					String stage = ""+iList_IO.getEleViaIndex(index);
					textField_value_del.setText(stage);
					iList_IO.delEleViaIndex(index);
					list_text.setText(iList_IO.showList());
					txtrThe.setText(iList_IO.check());
				}
				catch(NumberFormatException e1) {
					list_text.setText("[ INFO ] Invalid Input !");
				}
				catch(Exception e2) {
					list_text.setText(String.format("[ INFO ] %s",e2));
				}
			}
		});
		
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ele = ele_find.getText();
					index_find.setText(""+iList_IO.findEle(ele));
					
				}catch(Exception e1) {
					index_find.setText("[ INFO ] Invalid Input !");
				}
			}
		});
		
		btnClearList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					iList_IO.clearList();
					list_text.setText("[ INFO ] The list is clear !");
				}catch(Exception e1) {
					list_text.setText("[ INFO ] Invalid Input !");
				}
			}
		});
		btnClearList.setBounds(530, 117, 123, 23);
		contentPane.add(btnClearList);
		
		btnGetListLength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					length_text.setText(""+iList_IO.getListLength());
				}catch(Exception e1) {
					list_text.setText("[ INFO ] Error !");
				}
			}
		});
		
		btnIsListEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean result = iList_IO.isListEmpty();
					empty_text.setText(""+result);
				}catch(Exception e1) {
					list_text.setText("[ INFO ] Error !");
				}
			}
		});
	}
}
