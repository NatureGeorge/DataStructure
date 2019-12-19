package lessons;

import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.Random;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Sort_UI extends JFrame {

	private JPanel contentPane;
	private JTextField lengthField;
	private final String insertS = "InsertSort"; 
	private final String shellS = "ShellSort"; 
	private final String bubbleS = "Bubble Sort";
	private final String quickS = "Quick Sort";
	private final String seqSearch = "Seq Search";
	private final String bstSearch = "Binary Sort Tree: Search";
	private final String hashSearch = "Hash Search";
	private long startTime;
	private long endTime;
	private int len;
	private String selectedS = insertS;
	private String selectedSearch = seqSearch;
	private Random rand = new Random();
	private JTextField maxField;
	private JTextField minField;
	private int[] array;
	private JTextField textField;
	private BSTree bstree;
	private RecordNode[] seqList;
	private HashTable<Integer> ht;
	//private RecordNode[] result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sort_UI frame = new Sort_UI();
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
	public Sort_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1017, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 539, 128);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 152, 229, 23);
		comboBox.addItem(insertS);
		comboBox.addItem(shellS);
		comboBox.addItem(bubbleS);
		comboBox.addItem(quickS);
		comboBox.setSelectedIndex(0);
		contentPane.add(comboBox);
		
		lengthField = new JTextField();
		lengthField.setBounds(483, 152, 66, 23);
		contentPane.add(lengthField);
		lengthField.setColumns(10);
		
		JButton btnNewButton = new JButton("Generate SeqNums");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					len = Integer.parseInt(lengthField.getText());
					int min = Integer.parseInt(minField.getText());
					int max = Integer.parseInt(maxField.getText());
					String display = "";
					array = new int[len];
					for (int i=0; i<len;i++) {
						array[i] = rand.nextInt((max - min) + 1) + min;
						display = display + array[i] + ", ";
					}
					
					textPane.setText("Random array is:" + display);
					
					// SEQ Search
					seqList = new RecordNode[array.length];
					for (int i = 0; i < array.length; i++) {
						seqList[i] = new RecordNode(array[i]);
					}	
					// BSTree Search
					bstree = new BSTree();
					KeyType[] key = new KeyType[array.length];
					ElementType[] elem = new ElementType[array.length];
					for (int i = 0; i < array.length; i++) {
						key[i] = new KeyType(array[i]);
						elem[i] = new ElementType("0");
						if (bstree.insertBST(key[i], elem[i])) {
							//textField.setText(""+key[i]);
							//break;
						} 
					}
					//Hash Search
			    	ht = new HashTable<Integer>(array.length);
		        	for (int i = 0; i < array.length; i++) {
		            	ht.insert(array[i]);
		        	}
			    }catch (Exception e2) {
					textPane.setText("Invalid Input");
				}
			}
		});
		btnNewButton.setBounds(271, 185, 278, 23);
		contentPane.add(btnNewButton);
		
		JButton sortBtn = new JButton("Sort");
		sortBtn.setBounds(10, 185, 229, 23);
		contentPane.add(sortBtn);
		
		maxField = new JTextField();
		maxField.setColumns(10);
		maxField.setBounds(371, 152, 66, 23);
		contentPane.add(maxField);
		
		minField = new JTextField();
		minField.setColumns(10);
		minField.setBounds(271, 152, 66, 23);
		contentPane.add(minField);
		
		JLabel lblLen = new JLabel("len");
		lblLen.setBounds(447, 156, 25, 15);
		contentPane.add(lblLen);
		
		JLabel lblMax = new JLabel("max");
		lblMax.setBounds(347, 156, 25, 15);
		contentPane.add(lblMax);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setBounds(249, 156, 25, 15);
		contentPane.add(lblMin);
		
		JScrollPane infoScrollPane = new JScrollPane();
		infoScrollPane.setBounds(559, 10, 280, 284);
		contentPane.add(infoScrollPane);
		
		JTextArea infoArea = new JTextArea();
		infoScrollPane.setViewportView(infoArea);
		
		JScrollPane content_scrollPane = new JScrollPane();
		content_scrollPane.setBounds(849, 10, 147, 284);
		contentPane.add(content_scrollPane);
		
		JTextArea contentArea = new JTextArea();
		content_scrollPane.setViewportView(contentArea);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int target = Integer.parseInt(textField.getText());
					if (selectedSearch.equals(seqSearch)) {
						startTime=System.nanoTime();
						int index = Search.seqSearchWithGuard(target, seqList);
						endTime=System.nanoTime();
						if (index == -1) {
							infoArea.append("查找关键码：" + target + " 失败! " + (endTime - startTime) + "(ns)\n");
						}else {
							infoArea.append("查找关键码：" + target + " 成功! (index: " + index + ") " +(endTime - startTime) + "(ns)\n");
						}
					}else if (selectedSearch.equals(bstSearch)) {
						KeyType keyvalue = new KeyType();
			        	keyvalue.key=target;
			        	startTime=System.nanoTime();
			        	RecordNode found = (RecordNode) bstree.searchBST(keyvalue);
			        	endTime=System.nanoTime();
			            if (found != null) {
			            	infoArea.append("查找关键码：" + keyvalue + " 成功! " + (endTime - startTime) + "(ns)\n");
			            } else {
			            	infoArea.append("查找关键码：" + keyvalue + " 失败! " + (endTime - startTime) + "(ns)\n");
			            }
					}else if (selectedSearch.equals(hashSearch)) {
						startTime=System.nanoTime();
						boolean hashSearch = ht.contain(target);
						endTime=System.nanoTime();
						if (hashSearch) {
							infoArea.append("查找关键码：" + target + " 成功! " + (endTime - startTime) + "(ns)\n");
						}else {
							infoArea.append("查找关键码：" + target + " 失败! " + (endTime - startTime) + "(ns)\n");
						}
						contentArea.setText(ht.printHashTable());
					}
				}catch (Exception ee) {
					textField.setText("Invalid input !");
				}
			}
		});
		btnSearch.setBounds(271, 271, 278, 23);
		contentPane.add(btnSearch);
		
		textField = new JTextField();
		textField.setBounds(10, 228, 539, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox<String> searchCombo = new JComboBox<String>();
		searchCombo.setBounds(10, 271, 229, 23);
		searchCombo.addItem(seqSearch);
		searchCombo.addItem(bstSearch);
		searchCombo.addItem(hashSearch);
		searchCombo.setSelectedIndex(0);
		contentPane.add(searchCombo);
		
		ItemListener itemListener_search = new ItemListener() {
			public void itemStateChanged(ItemEvent e){
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                	selectedSearch =(String) searchCombo.getSelectedItem();
                }
            }
		};
		searchCombo.addItemListener(itemListener_search);
		
		ItemListener itemListener_sort = new ItemListener() {
			public void itemStateChanged(ItemEvent e){
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                	selectedS =(String) comboBox.getSelectedItem();
                }
            }
		};
		comboBox.addItemListener(itemListener_sort);
		
		sortBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sort sortOb = new Sort(len);
				for (int i=0;i<len;i++) {
					RecordNode rNode = new RecordNode(array[i]);
					try {
						sortOb.insert(i, rNode);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						textPane.setText("Error" + e1);
					}
				}
				switch (selectedS) {
				case insertS:
					startTime=System.nanoTime();
					sortOb.insertSort();
					endTime=System.nanoTime();
					break;
				case shellS:
					startTime=System.nanoTime();
					sortOb.shellSort(Sort.hibbard(len));
					endTime=System.nanoTime();
					break;
				case bubbleS:
					startTime=System.nanoTime();
					sortOb.bubbleSort();
					endTime=System.nanoTime();
					break;
				case quickS:
					startTime=System.nanoTime();
					sortOb.quickSort();
					endTime=System.nanoTime();
					break;
				}
				String result = sortOb.display();
				textPane.setText("Sorted Result: \n"+result);
				infoArea.append(selectedS + " Time Cost:" + (endTime - startTime) + "(ns)\n");
				
			}
		});
	}
}
