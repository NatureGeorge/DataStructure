package lessons;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class SparseMatrix_UI extends JFrame {

	private JPanel contentPane;
	private JTextField rowField;
	private JTextField colField;
	private JTextField rowsField;
	private JTextField colsField;
	private JTextField valueField;
	private JTextField maxSizeField;
	private SparseMatrix sm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SparseMatrix_UI frame = new SparseMatrix_UI();
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
	public SparseMatrix_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rowField = new JTextField();
		rowField.setBounds(176, 154, 84, 33);
		contentPane.add(rowField);
		rowField.setColumns(10);
		
		JLabel lblRow = new JLabel("ROW");
		lblRow.setBounds(35, 154, 101, 33);
		contentPane.add(lblRow);
		
		JLabel lblColumn = new JLabel("COLUMN");
		lblColumn.setBounds(35, 197, 83, 33);
		contentPane.add(lblColumn);
		
		colField = new JTextField();
		colField.setColumns(10);
		colField.setBounds(176, 197, 84, 33);
		contentPane.add(colField);
		
		JLabel lblRows = new JLabel("ROWs");
		lblRows.setBounds(37, 10, 81, 33);
		contentPane.add(lblRows);
		
		JLabel lblColumns = new JLabel("COLUMNs");
		lblColumns.setBounds(35, 53, 101, 33);
		contentPane.add(lblColumns);
		
		rowsField = new JTextField();
		rowsField.setColumns(10);
		rowsField.setBounds(176, 10, 84, 33);
		contentPane.add(rowsField);
		
		colsField = new JTextField();
		colsField.setColumns(10);
		colsField.setBounds(176, 53, 84, 33);
		contentPane.add(colsField);
		
		valueField = new JTextField();
		valueField.setColumns(10);
		valueField.setBounds(176, 240, 84, 33);
		contentPane.add(valueField);
		
		JLabel lblValue = new JLabel("VALUE");
		lblValue.setBounds(35, 240, 73, 33);
		contentPane.add(lblValue);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(10, 284, 93, 23);
		contentPane.add(btnSubmit);
		
		JTextArea originalArea = new JTextArea();
		originalArea.setBounds(279, 36, 240, 131);
		contentPane.add(originalArea);
		
		JTextArea transposedArea = new JTextArea();
		transposedArea.setBounds(279, 196, 240, 131);
		contentPane.add(transposedArea);
		
		JLabel lblOriginalMatrix = new JLabel("Original Matrix");
		lblOriginalMatrix.setBounds(355, 10, 101, 33);
		contentPane.add(lblOriginalMatrix);
		
		JLabel lblTransposedMatrix = new JLabel("Transposed Matrix");
		lblTransposedMatrix.setBounds(346, 166, 110, 33);
		contentPane.add(lblTransposedMatrix);
		
		JButton btnTranspose = new JButton("Transpose");
		btnTranspose.setBounds(25, 367, 93, 23);
		contentPane.add(btnTranspose);
		
		JButton btnFastTranspose = new JButton("Fast Transpose");
		btnFastTranspose.setBounds(128, 367, 127, 23);
		contentPane.add(btnFastTranspose);
		
		JTextArea countArea = new JTextArea();
		countArea.setBounds(279, 337, 240, 53);
		contentPane.add(countArea);
		
		JLabel lblMaxsize = new JLabel("MAXSIZE");
		lblMaxsize.setBounds(35, 96, 106, 33);
		contentPane.add(lblMaxsize);
		
		maxSizeField = new JTextField();
		maxSizeField.setColumns(10);
		maxSizeField.setBounds(176, 96, 84, 33);
		contentPane.add(maxSizeField);
		
		JButton btnInitial = new JButton("Initial");
		btnInitial.setBounds(10, 133, 93, 23);
		contentPane.add(btnInitial);
		
		
		btnInitial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rows = Integer.parseInt(rowsField.getText());
				int cols = Integer.parseInt(colsField.getText());
				int maxSize = Integer.parseInt(maxSizeField.getText());
				sm = new SparseMatrix(rows, cols, maxSize);
				originalArea.setText(sm.stringMatrix());
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = Integer.parseInt(rowField.getText());
				int col = Integer.parseInt(colField.getText());
				float value = Float.parseFloat(valueField.getText());
				sm.receive(row, col, value);
				originalArea.setText(sm.stringMatrix());
			}
		});
		
		btnTranspose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SparseMatrix tm = sm.transpose();
					transposedArea.setText(tm.stringMatrix());
					countArea.setText(String.format("Loop Count: %s", sm.tCounter.getValue()));
				}
				catch (Exception e2){
					transposedArea.setText("Invalid Input!");
					e2.printStackTrace();
				}
			}
		});
		
		btnFastTranspose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SparseMatrix tm = sm.fastTranspose();
					transposedArea.setText(tm.stringMatrix());
					countArea.setText(String.format("Loop Count: %s", sm.ftCounter.getValue()));
				}
				catch (Exception e2){
					transposedArea.setText("Invalid Input!");
					e2.printStackTrace();
				}
			}
		});
	}
}
