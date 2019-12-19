package lessons;

import java.awt.BorderLayout;
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

public class HuffmanTree_UI extends JFrame {

	private JPanel contentPane;
	private JTextField weightField;
	private JTextField dataField;
	private String note = "Please input comma-separated data";
	private HuffmanTree tree;
	private int[] weights;
	private Object[] data;
	private int[][] HN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HuffmanTree_UI frame = new HuffmanTree_UI();
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
	public HuffmanTree_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		weightField = new JTextField();
		weightField.setBounds(10, 158, 244, 38);
		contentPane.add(weightField);
		weightField.setColumns(10);
		weightField.setText(note);
		
		dataField = new JTextField();
		dataField.setColumns(10);
		dataField.setBounds(10, 231, 244, 38);
		contentPane.add(dataField);
		dataField.setText(note);
		
		JLabel lblWeights = new JLabel("Weights");
		lblWeights.setBounds(10, 133, 54, 15);
		contentPane.add(lblWeights);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(10, 206, 54, 15);
		contentPane.add(lblData);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(10, 279, 243, 23);
		contentPane.add(btnSubmit);
		
		JTextArea preRootArea = new JTextArea();
		preRootArea.setBounds(296, 35, 270, 88);
		contentPane.add(preRootArea);
		preRootArea.setLineWrap(true); 
		
		JTextArea huffmanCodeArea = new JTextArea();
		huffmanCodeArea.setBounds(10, 35, 244, 88);
		contentPane.add(huffmanCodeArea);
		huffmanCodeArea.setLineWrap(true); 
		
		JLabel lblHuffmancode = new JLabel("HuffmanCode");
		lblHuffmancode.setBounds(10, 10, 120, 15);
		contentPane.add(lblHuffmancode);
		
		JTextArea inRootArea = new JTextArea();
		inRootArea.setBounds(296, 173, 270, 81);
		contentPane.add(inRootArea);
		inRootArea.setLineWrap(true); 
		
		JLabel lblPretransverse = new JLabel("PreRootTraverse");
		lblPretransverse.setBounds(298, 10, 120, 15);
		contentPane.add(lblPretransverse);
		
		JLabel lblIntransverse = new JLabel("InRootTraverse");
		lblIntransverse.setBounds(296, 148, 120, 15);
		contentPane.add(lblIntransverse);
		
		JButton btnTraverse = new JButton("Traverse");
		btnTraverse.setBounds(296, 279, 270, 23);
		contentPane.add(btnTraverse);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					huffmanCodeArea.setText("");
					String[] ws = weightField.getText().split(",");
					weights = new int[ws.length];
					for (int i = 0; i<ws.length;i++) {
						weights[i] = Integer.parseInt(ws[i]);
					}
					data = dataField.getText().split(",");
					tree = new HuffmanTree();
					HN = tree.huffmanCoding(weights, data);
					if (HN == null) {
						huffmanCodeArea.setText("Invalid Input ! Please ensure that data share a same length.");
					}
					for (int i=0; i<HN.length; i++) {
						huffmanCodeArea.append(weights[i]+": ");
						for (int j=0; j<HN[i].length; j++) {
							if(HN[i][j] == -1) {
								for (int k= j + 1; k<HN[i].length; k++) {
									huffmanCodeArea.append(" "+HN[i][k]);
								}
								break;
							}
						}
						huffmanCodeArea.append(", ");
					}
				}catch (Exception e2) {
					huffmanCodeArea.setText("Invalid Input !");
					//e2.printStackTrace();
				}
			}
		});
	
		btnTraverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tree != null) {
					try {
						tree.preRootTraverse();
						preRootArea.setText(tree.display);
						tree.cleandisplay();
						tree.inRootTraverse();
						inRootArea.setText(tree.display);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}else {
					preRootArea.setText("Please submit data!");
					inRootArea.setText("Please submit data!");
				}
			}
		});
	}
}
