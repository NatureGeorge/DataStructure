package lessons;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;


public class BiTree_UI extends JFrame {
	final String PreIn = "preRoot + inRoot";
	final String PostIn = "postRoot + inRoot";
	final String PreOnly = "preRoot";
	final String tree1 = "Tree 1";
	final String tree2 = "Tree 2";
	final String order1 = "LR";
	final String order2 = "RL";
	final String LevelT = "Level Traverse";
	final String PreT = "preRootTraverse";
	final String rPreT = "preRootTraverse [Recursion]";
	final String InT = "inRootTraverse";
	final String rInT = "inRootTraverse [Recursion]";
	final String PostT = "postRootTraverse";
	final String rPostT = "postRootTraverse [Recursion]";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputField1;
	private JTextField inputField2;
	private String selected_tree = tree1;
	private String selected_createTreeMethod = PreIn;
	private String selected_order_1 = order1;
	private String selected_order_2 = order1;
	private String selected_traverseMethod = LevelT;
	private JTextPane selectedTextPane;
	private BiTree selected_biTree;
	private BiTree biTree1;
	private BiTree biTree2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BiTree_UI frame = new BiTree_UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean checkSeq(String seqa, String seqb) {
		if (seqa.length() != seqb.length()) {
			return false;
		}
		char [] seqaChar = seqa.toCharArray();
		char [] seqbChar = seqb.toCharArray();
		Arrays.sort(seqaChar);
		Arrays.sort(seqbChar);
		String sortedSeqa = String.copyValueOf(seqaChar);
		String sortedSeqb = String.copyValueOf(seqbChar);
		if (sortedSeqa.equals(sortedSeqb)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Create the frame.
	 */
	public BiTree_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputField1 = new JTextField();
		inputField1.setBounds(28, 142, 279, 35);
		contentPane.add(inputField1);
		inputField1.setColumns(10);
		
		JButton btnCreateTree = new JButton("Create");
		btnCreateTree.setBounds(482, 224, 125, 23);
		contentPane.add(btnCreateTree);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(30, 27, 248, 86);
		contentPane.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(359, 27, 248, 86);
		contentPane.add(textPane_2);
		
		JTextPane equalPlane = new JTextPane();
		equalPlane.setBounds(295, 27, 47, 47);
		contentPane.add(equalPlane);
		
		JComboBox<String> create_comboBox = new JComboBox<String>();
		create_comboBox.setBounds(28, 224, 216, 23);
		create_comboBox.addItem(PreIn);
		create_comboBox.addItem(PostIn);
		create_comboBox.addItem(PreOnly);
		create_comboBox.setSelectedIndex(0);
		contentPane.add(create_comboBox);
		
		JButton btnTraverse = new JButton("Traverse");
		btnTraverse.setBounds(482, 261, 125, 23);
		contentPane.add(btnTraverse);
		
		JComboBox<String> traversal_comboBox = new JComboBox<String>();
		traversal_comboBox.setBounds(28, 261, 216, 23);
		traversal_comboBox.addItem(LevelT);
		traversal_comboBox.addItem(PreT);
		traversal_comboBox.addItem(InT);
		traversal_comboBox.addItem(PostT);
		traversal_comboBox.addItem(rPreT);
		traversal_comboBox.addItem(rInT);
		traversal_comboBox.addItem(rPostT);
		traversal_comboBox.setSelectedIndex(0);
		contentPane.add(traversal_comboBox);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setBounds(482, 191, 125, 23);
		contentPane.add(btnSelect);
		
		JComboBox<String> select_comboBox = new JComboBox<String>();
		select_comboBox.setBounds(28, 191, 444, 23);
		select_comboBox.addItem(tree1);
		select_comboBox.addItem(tree2);
		select_comboBox.setSelectedIndex(0);
		contentPane.add(select_comboBox);
		
		JLabel lblTree1 = new JLabel(tree1);
		lblTree1.setBounds(28, 10, 54, 15);
		contentPane.add(lblTree1);
		
		JLabel lblTree2 = new JLabel(tree2);
		lblTree2.setBounds(566, 10, 54, 15);
		contentPane.add(lblTree2);
		
		JLabel lblIsequal = new JLabel("IsEqual");
		lblIsequal.setBounds(295, 10, 54, 15);
		contentPane.add(lblIsequal);
		
		JLabel lblInput_1 = new JLabel("Input: preRoot/postRoot Seq");
		lblInput_1.setBounds(28, 123, 257, 15);
		contentPane.add(lblInput_1);
		
		JComboBox<String> mode_comboBox = new JComboBox<String>();
		mode_comboBox.setBounds(256, 261, 216, 23);
		mode_comboBox.addItem(order1);
		mode_comboBox.addItem(order2);
		mode_comboBox.setSelectedIndex(0);
		contentPane.add(mode_comboBox);
		
		JComboBox<String> createMode_comboBox = new JComboBox<String>();
		createMode_comboBox.setBounds(256, 224, 216, 23);
		createMode_comboBox.addItem(order1);
		createMode_comboBox.addItem(order2);
		createMode_comboBox.setSelectedIndex(0);
		contentPane.add(createMode_comboBox);
		
		inputField2 = new JTextField();
		inputField2.setColumns(10);
		inputField2.setBounds(328, 142, 279, 35);
		contentPane.add(inputField2);
		
		JLabel inRoot_label = new JLabel("Input: inRoot Seq");
		inRoot_label.setBounds(328, 123, 144, 15);
		contentPane.add(inRoot_label);
		
		JButton btnCompare = new JButton("test");
		btnCompare.setBounds(283, 84, 73, 23);
		contentPane.add(btnCompare);
		
		ItemListener itemListener_1 = new ItemListener() {
			public void itemStateChanged(ItemEvent e){
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                	selected_tree =(String) select_comboBox.getSelectedItem();
                }
            }
		};
		select_comboBox.addItemListener(itemListener_1);
		
		ItemListener itemListener_2 = new ItemListener() {
			public void itemStateChanged(ItemEvent e){
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                	selected_createTreeMethod =(String) create_comboBox.getSelectedItem();
                }
            }
		};
		create_comboBox.addItemListener(itemListener_2);
		
		ItemListener itemListener_3 = new ItemListener() {
			public void itemStateChanged(ItemEvent e){
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                	selected_order_1 =(String) createMode_comboBox.getSelectedItem();
                }
            }
		};
		createMode_comboBox.addItemListener(itemListener_3);
		
		
		ItemListener itemListener_4 = new ItemListener() {
			public void itemStateChanged(ItemEvent e){
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                	selected_order_2 =(String) mode_comboBox.getSelectedItem();
                }
            }
		};
		mode_comboBox.addItemListener(itemListener_4);
		
		
		ItemListener itemListener_5 = new ItemListener() {
			public void itemStateChanged(ItemEvent e){
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                	selected_traverseMethod =(String) traversal_comboBox.getSelectedItem();
                }
            }
		};
		traversal_comboBox.addItemListener(itemListener_5);
		
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selected_tree.equals(tree1)) {
					//biTree1 = selected_biTree;
					selectedTextPane = textPane_1;
					textPane_1.setText("You have select Tree 1, the following operation will be done in Tree 1");
				}else {
					//biTree2 = selected_biTree;
					selectedTextPane = textPane_2;
					textPane_2.setText("You have select Tree 2, the following operation will be done in Tree 2");
				}
				
			}
		});
		
		btnCreateTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstSeq = inputField1.getText();
				String inSeq = inputField2.getText();
				try {
				if (selected_createTreeMethod.equals(PreIn)) {
					if (checkSeq(firstSeq, inSeq)) {
						if (selected_tree.equals(tree1)) {
							biTree1 = new BiTree(firstSeq, inSeq, 0, 0, firstSeq.length(), selected_order_1);
							selected_biTree = biTree1;
						}else {
							biTree2 = new BiTree(firstSeq, inSeq, 0, 0, firstSeq.length(), selected_order_1);
							selected_biTree = biTree2;
						}
						
						selectedTextPane.setText("Tree has been built");
					}else {
						selectedTextPane.setText("Invalid Input: preSeq and inSeq share no equal length or elements !");
					}
				}else if(selected_createTreeMethod.equals(PostIn)) {
					if (checkSeq(firstSeq,  inSeq)) {
						if (selected_tree.equals(tree1)) {
							biTree1 = new BiTree(firstSeq, inSeq, firstSeq.length()-1, firstSeq.length()-1, firstSeq.length(), true, selected_order_1);
							selected_biTree = biTree1;
						}else {
							biTree2 = new BiTree(firstSeq, inSeq, firstSeq.length()-1, firstSeq.length()-1, firstSeq.length(), true, selected_order_1);
							selected_biTree = biTree2;
						}
						
						selectedTextPane.setText("Tree has been built");
					}else {
						selectedTextPane.setText("Invalid Input: postSeq and inSeq share no equal length or elements !");
					}
				}else {
					if (selected_biTree != null) {
						selected_biTree.resetIndex();
					}
					try {
						if (selected_tree.equals(tree1)) {
							biTree1 = new BiTree(firstSeq, selected_order_1);
							selected_biTree = biTree1;
						}else {
							biTree2 = new BiTree(firstSeq, selected_order_1);
							selected_biTree = biTree2;
						}
						
						selectedTextPane.setText("Tree has been built");
					}catch (Exception e2) {
						selectedTextPane.setText("Invalid Input ! Please use # to represent null children");
					}	
				}
				}catch (Exception e3) {
					selectedTextPane.setText("Invalid Input! Can't build with input seqs");
				}
			}
		});
		
		btnTraverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selected_biTree == null) {
					selectedTextPane.setText("Please create this tree!");
				}else {
					selected_biTree.cleandisplay();
					try {
						if (selected_traverseMethod.equals(LevelT)) {
							selected_biTree.levelTraverse(selected_order_2);
						}else if (selected_traverseMethod.equals(PreT)) {
							selected_biTree.preRootTraverse(selected_order_2);
						}else if (selected_traverseMethod.equals(InT)) {
							selected_biTree.inRootTraverse(selected_order_2);
						}else if (selected_traverseMethod.equals(PostT)){
							selected_biTree.postRootTraverse(selected_order_2);
						}else if (selected_traverseMethod.equals(rPreT)) {
							selected_biTree.preRootTraverse(selected_biTree.getRoot(), selected_order_2);
						}else if (selected_traverseMethod.equals(rInT)) {
							selected_biTree.inRootTraverse(selected_biTree.getRoot(), selected_order_2);
						}else {
							selected_biTree.postRootTraverse(selected_biTree.getRoot(), selected_order_2);
						}
						selectedTextPane.setText(selected_biTree.getdisplay());
					}catch (Exception e2){
						e2.printStackTrace();
					}
				}
				
			}
		});
		
		btnCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (biTree1 != null && biTree2 != null) {
					if (BiTree.isEqual(biTree1.getRoot(), biTree2.getRoot())) {
						equalPlane.setText("True");
					}else {
						equalPlane.setText("False");
					}
				}else {
					selectedTextPane.setText("Please Build 2 Tree !");
				}
			}
		});
	}
}
