package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import model.Category;
import model.Recipe;
import model.dao.CategoryDAO;
import model.dao.RecipeDAO;
import model.util.MyTableModel;
import controller.RecipeController;

import java.awt.Toolkit;
import model.util.searchSort;

public class mainFrame extends JFrame {
	private JTable table;
	private JTextField textField;
	DefaultTableModel tableModel;
	private JComboBox comboBox;
	Recipe currentRecipe;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error loading program.  Check that MySQL is running.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(mainFrame.class.getResource("/img/cook.png")));
		Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
		setTitle("Recipes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 507);
		setLocationRelativeTo(null);
		try {
			String nomeSO = System.getProperty("os.name");
			if (nomeSO.contains("Linux")) {
				UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			} else {
				UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerLocation(0.5);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		getContentPane().add(splitPane, gbc_splitPane);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 381, 0 };
		gbl_panel.rowHeights = new int[] { 0, 35, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 72, 221, 0 };
		gbl_panel_5.rowHeights = new int[] { 37, 101, 0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		JLabel labelCategory = new JLabel("Category:");
		GridBagConstraints gbc_labelCategory = new GridBagConstraints();
		gbc_labelCategory.anchor = GridBagConstraints.WEST;
		gbc_labelCategory.insets = new Insets(0, 0, 5, 5);
		gbc_labelCategory.gridx = 0;
		gbc_labelCategory.gridy = 0;
		panel_5.add(labelCategory, gbc_labelCategory);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fillTable();
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panel_5.add(comboBox, gbc_comboBox);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_5.add(scrollPane, gbc_scrollPane);

		Vector<String> columns = new Vector<String>();
		columns.add("Recipes");
		tableModel = MyTableModel.modelRecipe(columns, null);
		table = new JTable();
		 table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jTableMouseClicked(arg0);
			}
		});
		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 95, 91, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 23, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);
						
								JButton btnNewButton = new JButton("Add");
								GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
								gbc_btnNewButton.fill = GridBagConstraints.BOTH;
								gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
								gbc_btnNewButton.gridx = 0;
								gbc_btnNewButton.gridy = 0;
								panel_2.add(btnNewButton, gbc_btnNewButton);
								btnNewButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										addRecipe();
									}
								});
								btnNewButton.setIcon(new ImageIcon(mainFrame.class.getResource("/img/save.png")));
				
						JButton btnNewButton_1 = new JButton("Edit");
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								jButtonEdit(arg0);
							}
						});
						GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
						gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
						gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
						gbc_btnNewButton_1.gridx = 1;
						gbc_btnNewButton_1.gridy = 0;
						panel_2.add(btnNewButton_1, gbc_btnNewButton_1);
						btnNewButton_1.setIcon(new ImageIcon(mainFrame.class.getResource("/img/edit_table.png")));
		
				JButton btnNewButton_2 = new JButton("Delete");
				GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
				gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
				gbc_btnNewButton_2.gridx = 2;
				gbc_btnNewButton_2.gridy = 0;
				panel_2.add(btnNewButton_2, gbc_btnNewButton_2);
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						buttonDelete(arg0);
					}
				});
				btnNewButton_2.setIcon(new ImageIcon(mainFrame.class.getResource("/img/remove.png")));

		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 458, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 19, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_1.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 96, 0 };
		gbl_panel_3.rowHeights = new int[] { 323, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_3.add(scrollPane_1, gbc_scrollPane_1);

		textPane = new JTextPane();
		scrollPane_1.setViewportView(textPane);
		textPane.setContentType("text/html");
		textPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		panel_1.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 33, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(mainFrame.class.getResource("/img/search_icon.png")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search();
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBorder(null);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_4.add(textField, gbc_textField);
		textField.setColumns(10);

		fillComboBox();
		fillTable();
	}

	protected void jButtonEdit(ActionEvent arg0) {
		try {
		Recipe recipe = (Recipe) table.getValueAt(table.getSelectedRow(), 0);
		editRecipeDialog dialog = new editRecipeDialog(recipe);
		dialog.setVisible(true);
		fillComboBox();
		}
		
		catch (ArrayIndexOutOfBoundsException OutOfBounds)
		{
			JOptionPane.showMessageDialog(null, "You must select a recipe for editing.", "Select Recipe", JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception exception)
		{
			JOptionPane.showMessageDialog(null, "General Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void buttonDelete(ActionEvent arg0) {
		try {
		Recipe recipe = (Recipe) table.getValueAt(table.getSelectedRow(), 0);
		RecipeController.removeRecipe(recipe);
		textPane.setText("");
		fillComboBox();
		fillTable();
		}
		catch (ArrayIndexOutOfBoundsException OutOfBounds)
		{
			
			JOptionPane.showMessageDialog(null, "You must select a recipe for deletion.", "Select Recipe", JOptionPane.ERROR_MESSAGE);
			
		}
		
		catch(Exception exception)
		{
			JOptionPane.showMessageDialog(null, "General Error", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	}

	private void fillComboBox() {
		comboBox.removeAllItems();		
		comboBox.addItem("All");
		for(Category category: CategoryDAO.findAll()){
			if (category.getRecipes() != null){
				comboBox.addItem(category);
			}
		}		
	}

	protected void addRecipe() {
		createRecipeDialog dialog = new createRecipeDialog();
		dialog.setVisible(true);
		fillComboBox();
	}

	protected void jTableMouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount() == 1){
			currentRecipe = (Recipe) table.getValueAt(table.getSelectedRow(), 0);
			textPane.setText(currentRecipe.getVisualText());
		}
	}

	private void fillTable() {		
		tableModel.setRowCount(0);
		if(comboBox.getSelectedItem() != null){
		if (comboBox.getSelectedItem().equals("All")) {
			ArrayList<Recipe> recipes;
			recipes = RecipeController.getRecipes();
			for (Recipe recipe : recipes) {
				tableModel.addRow(new Object[] { recipe });
			}
		} else {
			Category category = (Category)comboBox.getSelectedItem();
			for (Recipe recipe : category.getRecipes()) {
				tableModel.addRow(new Object[] { recipe });
			}
		} }
		repaint();
	}
	
	protected void search(){
		//if user wants to get back to the rest of the recipes just select all in combo box
		
		ArrayList<Recipe> recipes = RecipeController.getRecipes();
		ArrayList<Recipe> allFoundRecipes;
		String textEntered = textField.getText();
		if (textEntered.equals("") ||textEntered.equals(" "))
		{
			fillTable();
		}
		else{
		allFoundRecipes = searchSort.searchByName(textEntered,recipes);
		allFoundRecipes.addAll(searchSort.searchByCategory(textEntered, recipes));
		allFoundRecipes.addAll(searchSort.searchByIngredient(textEntered, recipes));
		tableModel.setRowCount(0);
		if(comboBox.getSelectedItem() != null){
			if (comboBox.getSelectedItem().equals("All")) {
				for (Recipe recipe : allFoundRecipes) {
					tableModel.addRow(new Object[] { recipe });
				}
			} else {
				Category category = (Category)comboBox.getSelectedItem();
				for (Recipe recipe : category.getRecipes()) {
					tableModel.addRow(new Object[] { recipe });
				}
			} }
			repaint();
		}
		
	}
}
