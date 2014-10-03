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
import model.util.searchSort;
import controller.RecipeController;

import java.awt.Toolkit;

public class mainFrame extends JFrame {
	private JTable tableRecipes;
	private JTextField textFieldSearch;
	DefaultTableModel tableModel;
	private JComboBox comboBoxCategory;
	Recipe currentRecipe;
	private JTextPane textPaneRecipe;

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

		JPanel panelWest = new JPanel();
		splitPane.setLeftComponent(panelWest);
		GridBagLayout gbl_panelWest = new GridBagLayout();
		gbl_panelWest.columnWidths = new int[] { 381, 0 };
		gbl_panelWest.rowHeights = new int[] { 0, 35, 0 };
		gbl_panelWest.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelWest.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panelWest.setLayout(gbl_panelWest);

		JPanel panelRecipes = new JPanel();
		panelRecipes.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panelRecipes = new GridBagConstraints();
		gbc_panelRecipes.fill = GridBagConstraints.BOTH;
		gbc_panelRecipes.insets = new Insets(0, 0, 5, 0);
		gbc_panelRecipes.gridx = 0;
		gbc_panelRecipes.gridy = 0;
		panelWest.add(panelRecipes, gbc_panelRecipes);
		GridBagLayout gbl_panelRecipes = new GridBagLayout();
		gbl_panelRecipes.columnWidths = new int[] { 72, 221, 0 };
		gbl_panelRecipes.rowHeights = new int[] { 37, 101, 0 };
		gbl_panelRecipes.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelRecipes.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panelRecipes.setLayout(gbl_panelRecipes);

		JLabel labelCategory = new JLabel("Category:");
		GridBagConstraints gbc_labelCategory = new GridBagConstraints();
		gbc_labelCategory.anchor = GridBagConstraints.WEST;
		gbc_labelCategory.insets = new Insets(0, 0, 5, 5);
		gbc_labelCategory.gridx = 0;
		gbc_labelCategory.gridy = 0;
		panelRecipes.add(labelCategory, gbc_labelCategory);

		comboBoxCategory = new JComboBox();
		comboBoxCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fillTable();
			}
		});
		GridBagConstraints gbc_comboBoxCategory = new GridBagConstraints();
		gbc_comboBoxCategory.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCategory.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxCategory.gridx = 1;
		gbc_comboBoxCategory.gridy = 0;
		panelRecipes.add(comboBoxCategory, gbc_comboBoxCategory);

		JScrollPane scrollPaneTableRecipes = new JScrollPane();
		GridBagConstraints gbc_scrollPaneTableRecipes = new GridBagConstraints();
		gbc_scrollPaneTableRecipes.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTableRecipes.gridwidth = 2;
		gbc_scrollPaneTableRecipes.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneTableRecipes.gridx = 0;
		gbc_scrollPaneTableRecipes.gridy = 1;
		panelRecipes.add(scrollPaneTableRecipes, gbc_scrollPaneTableRecipes);

		Vector<String> columns = new Vector<String>();
		columns.add("Recipes");
		tableModel = MyTableModel.modelRecipe(columns, null);
		tableRecipes = new JTable();
		 tableRecipes.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
		tableRecipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jTableMouseClicked(arg0);
			}
		});
		tableRecipes.setModel(tableModel);
		scrollPaneTableRecipes.setViewportView(tableRecipes);

		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panelButtons = new GridBagConstraints();
		gbc_panelButtons.fill = GridBagConstraints.BOTH;
		gbc_panelButtons.gridx = 0;
		gbc_panelButtons.gridy = 1;
		panelWest.add(panelButtons, gbc_panelButtons);
		GridBagLayout gbl_panelButtons = new GridBagLayout();
		gbl_panelButtons.columnWidths = new int[] { 95, 91, 0, 0 };
		gbl_panelButtons.rowHeights = new int[] { 23, 0 };
		gbl_panelButtons.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelButtons.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panelButtons.setLayout(gbl_panelButtons);
						
								JButton buttonAdd = new JButton("Add");
								GridBagConstraints gbc_buttonAdd = new GridBagConstraints();
								gbc_buttonAdd.fill = GridBagConstraints.BOTH;
								gbc_buttonAdd.insets = new Insets(0, 0, 0, 5);
								gbc_buttonAdd.gridx = 0;
								gbc_buttonAdd.gridy = 0;
								panelButtons.add(buttonAdd, gbc_buttonAdd);
								buttonAdd.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										addRecipe();
									}
								});
								buttonAdd.setIcon(new ImageIcon(mainFrame.class.getResource("/img/save.png")));
				
						JButton buttonEdit = new JButton("Edit");
						buttonEdit.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								jButtonEdit(arg0);
							}
						});
						GridBagConstraints gbc_buttonEdit = new GridBagConstraints();
						gbc_buttonEdit.fill = GridBagConstraints.BOTH;
						gbc_buttonEdit.insets = new Insets(0, 0, 0, 5);
						gbc_buttonEdit.gridx = 1;
						gbc_buttonEdit.gridy = 0;
						panelButtons.add(buttonEdit, gbc_buttonEdit);
						buttonEdit.setIcon(new ImageIcon(mainFrame.class.getResource("/img/edit_table.png")));
		
				JButton buttonRemove = new JButton("Delete");
				GridBagConstraints gbc_buttonRemove = new GridBagConstraints();
				gbc_buttonRemove.fill = GridBagConstraints.BOTH;
				gbc_buttonRemove.gridx = 2;
				gbc_buttonRemove.gridy = 0;
				panelButtons.add(buttonRemove, gbc_buttonRemove);
				buttonRemove.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						buttonDelete(arg0);
					}
				});
				buttonRemove.setIcon(new ImageIcon(mainFrame.class.getResource("/img/remove.png")));

		JPanel panelEast = new JPanel();
		splitPane.setRightComponent(panelEast);
		GridBagLayout gbl_panelEast = new GridBagLayout();
		gbl_panelEast.columnWidths = new int[] { 458, 0 };
		gbl_panelEast.rowHeights = new int[] { 0, 19, 0 };
		gbl_panelEast.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelEast.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panelEast.setLayout(gbl_panelEast);

		JPanel panelText = new JPanel();
		GridBagConstraints gbc_panelText = new GridBagConstraints();
		gbc_panelText.insets = new Insets(0, 0, 5, 0);
		gbc_panelText.fill = GridBagConstraints.BOTH;
		gbc_panelText.gridx = 0;
		gbc_panelText.gridy = 0;
		panelEast.add(panelText, gbc_panelText);
		GridBagLayout gbl_panelText = new GridBagLayout();
		gbl_panelText.columnWidths = new int[] { 96, 0 };
		gbl_panelText.rowHeights = new int[] { 323, 0 };
		gbl_panelText.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelText.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panelText.setLayout(gbl_panelText);

		JScrollPane scrollPaneTextPane = new JScrollPane();
		scrollPaneTextPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPaneTextPane = new GridBagConstraints();
		gbc_scrollPaneTextPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTextPane.gridx = 0;
		gbc_scrollPaneTextPane.gridy = 0;
		panelText.add(scrollPaneTextPane, gbc_scrollPaneTextPane);

		textPaneRecipe = new JTextPane();
		scrollPaneTextPane.setViewportView(textPaneRecipe);
		textPaneRecipe.setContentType("text/html");
		textPaneRecipe.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel panelSearch = new JPanel();
		panelSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSearch.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelSearch = new GridBagConstraints();
		gbc_panelSearch.fill = GridBagConstraints.BOTH;
		gbc_panelSearch.gridx = 0;
		gbc_panelSearch.gridy = 1;
		panelEast.add(panelSearch, gbc_panelSearch);
		GridBagLayout gbl_panelSearch = new GridBagLayout();
		gbl_panelSearch.columnWidths = new int[] { 0, 0, 0 };
		gbl_panelSearch.rowHeights = new int[] { 33, 0 };
		gbl_panelSearch.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelSearch.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelSearch.setLayout(gbl_panelSearch);
		
		JLabel labelSearch = new JLabel("");
		labelSearch.setIcon(new ImageIcon(mainFrame.class.getResource("/img/search_icon.png")));
		GridBagConstraints gbc_labelSearch = new GridBagConstraints();
		gbc_labelSearch.insets = new Insets(0, 0, 0, 5);
		gbc_labelSearch.anchor = GridBagConstraints.EAST;
		gbc_labelSearch.gridx = 0;
		gbc_labelSearch.gridy = 0;
		panelSearch.add(labelSearch, gbc_labelSearch);

		textFieldSearch = new JTextField();
		textFieldSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search();
			}
		});
		textFieldSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldSearch.setBorder(null);
		GridBagConstraints gbc_textFieldSearch = new GridBagConstraints();
		gbc_textFieldSearch.fill = GridBagConstraints.BOTH;
		gbc_textFieldSearch.gridx = 1;
		gbc_textFieldSearch.gridy = 0;
		panelSearch.add(textFieldSearch, gbc_textFieldSearch);
		textFieldSearch.setColumns(10);

		fillComboBox();
		fillTable();
	}

	protected void jButtonEdit(ActionEvent arg0) {
		Recipe recipe = (Recipe) tableRecipes.getValueAt(tableRecipes.getSelectedRow(), 0);
		editRecipeDialog dialog = new editRecipeDialog(recipe);
		dialog.setVisible(true);
		textPaneRecipe.setText("");
		fillComboBox();
	}

	protected void buttonDelete(ActionEvent arg0) {		
		Recipe recipe = (Recipe) tableRecipes.getValueAt(tableRecipes.getSelectedRow(), 0);
		int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove the recipe " + recipe.getTitle() + "?");
		if (option == JOptionPane.YES_OPTION){
			RecipeController.removeRecipe(recipe);
			textPaneRecipe.setText("");
			fillComboBox();
			fillTable();
		}
	}

	private void fillComboBox() {
		comboBoxCategory.removeAllItems();		
		comboBoxCategory.addItem("All");
		for(Category category: CategoryDAO.findAll()){
			if (category.getRecipes() != null){
				comboBoxCategory.addItem(category);
			}
		}		
	}

	protected void addRecipe() {
		createRecipeDialog dialog = new createRecipeDialog();
		dialog.setVisible(true);
		textPaneRecipe.setText("");
		fillComboBox();
	}

	protected void jTableMouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount() == 1){
			currentRecipe = (Recipe) tableRecipes.getValueAt(tableRecipes.getSelectedRow(), 0);
			textPaneRecipe.setText(currentRecipe.getVisualText());
		}
	}

	private void fillTable() {		
		tableModel.setRowCount(0);
		if(comboBoxCategory.getSelectedItem() != null){
		if (comboBoxCategory.getSelectedItem().equals("All")) {
			ArrayList<Recipe> recipes;
			recipes = RecipeController.getRecipes();
			for (Recipe recipe : recipes) {
				tableModel.addRow(new Object[] { recipe });
			}
		} else {
			Category category = (Category)comboBoxCategory.getSelectedItem();
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
		String textEntered = textFieldSearch.getText();
		if (textEntered.equals("") ||textEntered.equals(" "))
		{
			fillTable();
		}
		else{
		allFoundRecipes = searchSort.searchByName(textEntered,recipes);
		allFoundRecipes.addAll(searchSort.searchByCategory(textEntered, recipes));
		allFoundRecipes.addAll(searchSort.searchByIngredient(textEntered, recipes));
		tableModel.setRowCount(0);
		if(comboBoxCategory.getSelectedItem() != null){
			if (comboBoxCategory.getSelectedItem().equals("All")) {
				for (Recipe recipe : allFoundRecipes) {
					tableModel.addRow(new Object[] { recipe });
				}
			} else {
				Category category = (Category)comboBoxCategory.getSelectedItem();
				for (Recipe recipe : category.getRecipes()) {
					tableModel.addRow(new Object[] { recipe });
				}
			} }
			repaint();
		}
		
	}
}
