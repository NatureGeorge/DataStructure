package practice;

import lessons.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Container;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class IGraph_UI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField txtPleaseInputA;
	private int vexNum;
	private String[] vexNames;
	private JTextField txtVexName;
	private GraphKind kind;
	private IGraph graph;
	
	private JTextField kPathField;
	private JTextField vField;
	private JTextField uField;
	private final String adjM = "Adjacency Matrix";
	private final String adjL = "Adjacency List";
	private String selected_ds = adjM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IGraph_UI frame = new IGraph_UI();
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
	public IGraph_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 10, 373, 204);
		contentPane.add(scrollPane);
		
		tableModel = new DefaultTableModel();//rowData, columnNames
		table = new JTable(tableModel);
		//table = new JTable(rowData, columnNames);
		scrollPane.setViewportView(table);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(66, 337, 117, 23);
		contentPane.add(btnCreate);
		
		txtPleaseInputA = new JTextField();
		txtPleaseInputA.setText("Please input a number");
		txtPleaseInputA.setToolTipText("");
		txtPleaseInputA.setBounds(66, 234, 373, 21);
		contentPane.add(txtPleaseInputA);
		txtPleaseInputA.setColumns(10);
		
		JLabel lblVexNum = new JLabel("VexNum");
		lblVexNum.setBounds(2, 237, 54, 15);
		contentPane.add(lblVexNum);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(303, 337, 136, 23);
		contentPane.add(btnSubmit);
		
		txtVexName = new JTextField();
		txtVexName.setToolTipText("");
		txtVexName.setText("Please input comma-separate VexNames");
		txtVexName.setColumns(10);
		txtVexName.setBounds(66, 265, 373, 21);
		contentPane.add(txtVexName);
		
		JLabel lblVexName = new JLabel("VexName");
		lblVexName.setBounds(2, 268, 64, 15);
		contentPane.add(lblVexName);
		
		JComboBox<GraphKind> comboBox = new JComboBox<GraphKind>();
		comboBox.setBounds(66, 296, 117, 23);
		contentPane.add(comboBox);
		comboBox.addItem(GraphKind.UDG);
		comboBox.addItem(GraphKind.DG);
		comboBox.addItem(GraphKind.UDN);
		comboBox.addItem(GraphKind.DN);
		comboBox.setSelectedIndex(0);
		
		JLabel lblgraphKind = new JLabel("GraphKind");
		lblgraphKind.setBounds(2, 300, 64, 15);
		contentPane.add(lblgraphKind);
		
		kPathField = new JTextField();
		kPathField.setBounds(66, 378, 151, 21);
		contentPane.add(kPathField);
		kPathField.setColumns(10);
		
		JLabel lblKpath = new JLabel("K-Path");
		lblKpath.setBounds(2, 381, 64, 15);
		contentPane.add(lblKpath);
		
		JButton btnNewButton = new JButton("Seek");
		btnNewButton.setBounds(66, 444, 373, 23);
		contentPane.add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(66, 413, 151, 21);
		contentPane.add(textPane);
		
		JLabel statuslabel = new JLabel("Status");
		statuslabel.setBounds(2, 419, 64, 15);
		contentPane.add(statuslabel);
		
		vField = new JTextField();
		vField.setColumns(10);
		vField.setBounds(360, 413, 79, 21);
		contentPane.add(vField);
		
		uField = new JTextField();
		uField.setColumns(10);
		uField.setBounds(360, 378, 79, 21);
		contentPane.add(uField);
		
		JLabel lblNewLabel = new JLabel("Node U");
		lblNewLabel.setBounds(303, 381, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNodeV = new JLabel("Node V");
		lblNodeV.setBounds(303, 413, 54, 15);
		contentPane.add(lblNodeV);
		
		JLabel lblDatastructures = new JLabel("DataStructures");
		lblDatastructures.setBounds(193, 300, 90, 15);
		contentPane.add(lblDatastructures);
		
		JComboBox<String> dsboBox = new JComboBox<String>();
		dsboBox.setBounds(303, 296, 136, 23);
		dsboBox.addItem(adjM);
		dsboBox.addItem(adjL);
		dsboBox.setSelectedIndex(0);
		contentPane.add(dsboBox);
		
		JScrollPane display_scroll = new JScrollPane();
		display_scroll.setBounds(449, 10, 266, 205);
		contentPane.add(display_scroll);
		
		JTextPane displayField = new JTextPane();
		display_scroll.setViewportView(displayField);
		
		JButton btnGetTopologicalOrder = new JButton("Get Topological Order");
		btnGetTopologicalOrder.setBounds(449, 233, 266, 23);
		contentPane.add(btnGetTopologicalOrder);
		
		JButton btnFillZero = new JButton("FillZero");
		btnFillZero.setBounds(193, 337, 101, 23);
		contentPane.add(btnFillZero);
		
		ItemListener ds_itemListener = new ItemListener() {
			public void itemStateChanged(ItemEvent e){
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                	selected_ds = (String) dsboBox.getSelectedItem();
                }
            }
		};
		dsboBox.addItemListener(ds_itemListener);
		
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Set Data
				try {
					vexNum = Integer.parseInt(txtPleaseInputA.getText());
					tableModel = new DefaultTableModel(vexNum, vexNum);
					table.setModel(tableModel);
				}
				catch (Exception e2){
					txtPleaseInputA.setText("Invalid Input !");
				}
				//Set Column Name
				try {
					vexNames = txtVexName.getText().split(",");
					tableModel.setColumnIdentifiers(vexNames);
					if (vexNames.length != vexNum) {
						txtVexName.setText("Warning: vexNames do not have equal length to vexNum !");
					}
				}
				catch (Exception e2){
					txtVexName.setText("Invalid Input !");
				}
				
			}
		});
		
		btnFillZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0;i<vexNum;i++) {
					for (int j=0;j<vexNum;j++) {
						Object value = tableModel.getValueAt(i, j);
						if (value == null || value == "") {
							tableModel.setValueAt("0", i, j);
						}
					}
				}
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[][] arcs = new int[vexNum][vexNum];
				
				for (int i=0;i<vexNum;i++) {
					for (int j=0;j<vexNum;j++) {
						Object value = tableModel.getValueAt(i, j);
						if (value == null) {
							arcs[i][j] = MGraph.INFINITY;
						}else {
							arcs[i][j] = Integer.parseInt((String) value);
						}
						
					}
				}
				
				switch (selected_ds) {
				case adjM:
					graph = new MGraph(kind, vexNum, vexNames, arcs);
					break;
				case adjL:
					VNode[] vexs =  new VNode[vexNum];
					for (int i=0; i<vexNum; i++) {
						vexs[i] = new VNode(vexNames[i]);
					}
					
					graph = new ALGraph(kind, vexNum, vexs);
					
					for (int i=0;i<vexNum;i++) {
						for (int j=0;j<vexNum;j++) {
							int weight = arcs[i][j];
							if (weight != 0 && weight != MGraph.INFINITY) {
								graph.addArc(i, j, weight);
							}
						}
					}
					
				}
				
			}
		});
		
		ItemListener itemListener = new ItemListener() {
			public void itemStateChanged(ItemEvent e){
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                	kind =(GraphKind) comboBox.getSelectedItem();
                }
            }
		};
		comboBox.addItemListener(itemListener);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int k = Integer.parseInt(kPathField.getText());
					/*
					int u = Integer.parseInt(uField.getText());
					int v = Integer.parseInt(vField.getText());
					*/
					int u = graph.locateVex(uField.getText());
					int v = graph.locateVex(vField.getText());
					FindPath findPath = new FindPath();
					textPane.setText(findPath.findPath(graph, u, v, k));
				}catch (Exception e2) {
					kPathField.setText("Invalid Input!");
					System.out.println(e2);
				}
				
			}
		});
		
		btnGetTopologicalOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 1. Check Directed Acyclic Graph
				// 2. Get Topological Order
				if (graph.getKind() != GraphKind.UDG && graph.getKind() != GraphKind.UDN) {
					TopologicalSort.resetDisplay();
					try {
						if (TopologicalSort.auto(graph)){
							displayField.setText(TopologicalSort.getDisplay());
						}else {
							displayField.setText("There exists a circle in your graph");
						}
					}
					catch (Exception e2) {
						displayField.setText(e2.getMessage());
					}
				}else {
					displayField.setText("This is an undirected graph");
				}
				
				
				
			}
		});
	}
}
