import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	private Controller control = new Controller();
	
	public MainFrame() {
		
		setTitle("Backpack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
			
		//Question section
		JLabel lblQuestion = new JLabel("Escolha a opção");
		lblQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblQuestion);
			
		//separating label and first button
		contentPane.add(Box.createRigidArea(new Dimension(40,40)));
		
		//Button to generate objects
		JButton btnAdd = new JButton("Nós e frequências aleatórias");
		btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(btnAdd);
		
		//separating label and first table
		contentPane.add(Box.createRigidArea(new Dimension(40,40)));
		
		//Nodes label
		JLabel lblNodes = new JLabel("Nós");
		lblNodes.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNodes.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNodes);
		JLabel lblNumNodes = new JLabel("");
		lblNumNodes.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNumNodes.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNumNodes);
		
		//separating label and first table
		contentPane.add(Box.createRigidArea(new Dimension(40,40)));
		
		//Nodes label
		JLabel lblFreq = new JLabel("Freqûencias");
		lblFreq.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblFreq.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblFreq);
		JLabel lblNumFreq = new JLabel("");
		lblNumFreq.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNumFreq.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNumFreq);
		
		//separating label and first table
		contentPane.add(Box.createRigidArea(new Dimension(40,40)));		
		
		//Table1 title
		JLabel table1Title = new JLabel("Tabela de custos");
		table1Title.setAlignmentX(Component.CENTER_ALIGNMENT);
		table1Title.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(table1Title);		
		//Table 1
		JTable tableObjects = new JTable();
	    tableObjects.setMaximumSize(new Dimension(500, 150 ));
		contentPane.add(tableObjects);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//get values
				int nodes[] = control.getRandomNodes();
				int freq[] = control.getRandomFrequencies(nodes.length);
				
				//set values
				lblNumNodes.setText(control.getArrayString(nodes));
				lblNumFreq.setText(control.getArrayString(freq));
				
				//get result
//				int[][] results = control.generateResultsMatrix(max_weight);
				
				//show data
				tableObjects.setModel(getTableModelMatrix(nodes, 10));
			}
		});
		
	}
	
	private DefaultTableModel getTableModelMatrix( int[] weights, int max_weight) {
			
		Vector<String> COLUMN_NAME_VECTOR = new Vector<String>(
				Arrays.asList(new String[] {"A", "B","C"})
		);

		Vector<Vector<String>> matrix = new Vector<Vector<String>>();
		
		for(int i=0; i<weights.length + 2; i++) {
			Vector<String> row = new Vector<String>();
			
			for(int j=0; j<max_weight + 2; j++) {
				String rowText;
				
				if(i==0 && j==0)
					rowText = String.valueOf("");
				else if(i==0) 
					rowText = String.valueOf(j-1); 
				else if (j==0) 
					rowText = String.valueOf(i-1);
				else
					rowText = String.valueOf("a");
			
                row.add(rowText);
			}
			
            matrix.add(row);
      
		}
		
		return new DefaultTableModel( matrix, COLUMN_NAME_VECTOR);
	}
}
