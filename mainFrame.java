
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

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import controller.searchSort;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import model.Recipe;

public class mainFrame extends JFrame
{
	private JTextField tagsField;
	private JTable recipeTable;
	private JTextField searchBar;
	JComboBox categoryDropdown;
	String current = "";
	ArrayList<String> categoryList = new ArrayList<String>();
	ArrayList<Recipe> recipeArray = new ArrayList<Recipe>();
	//How do I bring in the recipes from the database? - Andrea

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
		
		JLabel lblRecipes = new JLabel("Recipes");
		lblRecipes.setBounds(10, 11, 241, 54);
		lblRecipes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipes.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		panel.add(lblRecipes);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(10, 76, 57, 14);
		panel.add(lblCategory);
		
		JLabel lblTags = new JLabel("Tags");
		lblTags.setBounds(10, 101, 46, 14);
		panel.add(lblTags);
		
		tagsField = new JTextField();
		tagsField.setBounds(69, 98, 171, 20);
		panel.add(tagsField);
		tagsField.setColumns(10);
		
		//added stuff here so we can fill out the category list - Andrea
		categoryList.add("Choose a category");  
		categoryList.addAll(searchSort.findCategories(recipeArray));  
		categoryDropdown = new JComboBox();
		for (int i=0;i<categoryList.size();i++)
		{
			categoryDropdown.addItem(categoryList.get(i));
		}
		categoryDropdown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		categoryDropdown.addActionListener(new ComboListener());
		categoryDropdown.setBounds(69, 73, 171, 20);
		panel.add(categoryDropdown);
		
		String[] columnName = {"Title"};
		Object[][] data = {{"Pancakes"},{"Eggs and Bacon"},{"Banana Bread"} };
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnAdd.setBounds(10, 512, 70, 23);
		panel.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnEdit.setBounds(90, 512, 70, 23);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnDelete.setBounds(170, 512, 70, 23);
		panel.add(btnDelete);
		
		JEditorPane textArea = new JEditorPane();
		textArea.setBounds(250, 11, 584, 490);
		panel.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 230, 375);
		panel.add(scrollPane);
		
		recipeTable = new JTable(data, columnName);
		recipeTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(recipeTable);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnSearch.setBounds(250, 512, 70, 23);
		panel.add(btnSearch);
		
		searchBar = new JTextField();
		searchBar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
		searchBar.setBounds(330, 513, 504, 20);
		panel.add(searchBar);
		searchBar.setColumns(10);
	}
	//also added this so we can break the code apart a bit and make it easier to read and understand -Andrea
	private class ComboListener implements ActionListener
	{

		public void actionPerformed(ActionEvent event) {
			if (!current.equals(""))
			{
				//need to call sort by recipe so it can display properly
				//the alphabetical recipes again
			}
			current = categoryList.get((categoryDropdown.getSelectedIndex()));
			//need to call search by category once category is chosen
			//to display recipes titles with selected category
		}
		
	}
}
