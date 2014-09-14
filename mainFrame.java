package Iota;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.JList;

import java.awt.GridLayout;

import javax.swing.JEditorPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class mainFrame extends JFrame
{
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					mainFrame frame = new mainFrame();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainFrame()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 575);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 844, 546);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Recipes");
		lblNewLabel.setBounds(10, 11, 241, 54);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		panel.add(lblNewLabel);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(10, 76, 57, 14);
		panel.add(lblCategory);
		
		JLabel lblTags = new JLabel("Tags");
		lblTags.setBounds(10, 101, 46, 14);
		panel.add(lblTags);
		
		textField = new JTextField();
		textField.setBounds(69, 98, 171, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(69, 73, 171, 20);
		panel.add(comboBox);
		
		String[] columnName = {"Title"};
		Object[][] data = {{"Pancakes"},{"Eggs and Bacon"},{"Banana Bread"} };
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 512, 70, 23);
		panel.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(90, 512, 70, 23);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(170, 512, 70, 23);
		panel.add(btnDelete);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(250, 11, 584, 490);
		panel.add(editorPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 230, 375);
		panel.add(scrollPane);
		
		table = new JTable(data, columnName);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(250, 512, 70, 23);
		panel.add(btnSearch);
		
		textField_1 = new JTextField();
		textField_1.setBounds(330, 513, 504, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
	}
}
