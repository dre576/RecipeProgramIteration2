package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Category;
import model.Recipe;
import model.RecipeManager;
import model.util.IconManager;
import model.util.MyTableModel;
import controller.RecipeManagerController;

public class editRecipeDialog extends JDialog {


	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldTitle;
	private JTable tableIngredient;
	private JTable tableCategory;
	DefaultTableModel tableModelIngredient;
	DefaultTableModel tableModelCategory;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	
	
	Recipe recipe;
	HashMap<String, String> ingredients = new HashMap<String, String>();
	ArrayList<String> categories = new ArrayList<String>();
	private JTextArea textAreaDescription;

	
	public editRecipeDialog(Recipe recipe) {
		this.recipe = recipe;
		setTitle("Creating Recipe");
		setBounds(100, 100, 611, 429);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 69, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		setLocationRelativeTo(null);
		{
			JLabel lblTitle = new JLabel("Title:");
			GridBagConstraints gbc_lblTitle = new GridBagConstraints();
			gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
			gbc_lblTitle.anchor = GridBagConstraints.WEST;
			gbc_lblTitle.gridx = 0;
			gbc_lblTitle.gridy = 0;
			contentPanel.add(lblTitle, gbc_lblTitle);
		}
		{
			textFieldTitle = new JTextField();
			GridBagConstraints gbc_textFieldTitle = new GridBagConstraints();
			gbc_textFieldTitle.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldTitle.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldTitle.gridx = 1;
			gbc_textFieldTitle.gridy = 0;
			contentPanel.add(textFieldTitle, gbc_textFieldTitle);
			textFieldTitle.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridwidth = 2;
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 1;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 68, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.insets = new Insets(0, 0, 0, 5);
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = 0;
				panel.add(panel_1, gbc_panel_1);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[] { 0, 0 };
				gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
				gbl_panel_1.columnWeights = new double[] { 0.0,
						Double.MIN_VALUE };
				gbl_panel_1.rowWeights = new double[] { 0.0, 0.0,
						Double.MIN_VALUE };
				panel_1.setLayout(gbl_panel_1);
				{
					JLabel lblIngredients = new JLabel("Ingredients:");
					GridBagConstraints gbc_lblIngredients = new GridBagConstraints();
					gbc_lblIngredients.insets = new Insets(0, 0, 5, 0);
					gbc_lblIngredients.anchor = GridBagConstraints.WEST;
					gbc_lblIngredients.gridx = 0;
					gbc_lblIngredients.gridy = 0;
					panel_1.add(lblIngredients, gbc_lblIngredients);
				}
				{
					JButton buttonIngredient = new JButton("+");
					buttonIngredient.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							addIngredient();
						}
					});
					GridBagConstraints gbc_buttonIngredient = new GridBagConstraints();
					gbc_buttonIngredient.fill = GridBagConstraints.HORIZONTAL;
					gbc_buttonIngredient.gridx = 0;
					gbc_buttonIngredient.gridy = 1;
					panel_1.add(buttonIngredient, gbc_buttonIngredient);
				}
			}
			{
				scrollPane_2 = new JScrollPane();
				GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
				gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
				gbc_scrollPane_2.gridx = 1;
				gbc_scrollPane_2.gridy = 0;
				panel.add(scrollPane_2, gbc_scrollPane_2);
				{
					Vector columns = new Vector();
					columns.add("Ingredient");
					columns.add("Amount");
					columns.add("Edit");
					columns.add("Remove");
					tableModelIngredient = MyTableModel.modelIngredient(
							columns, null);

					tableIngredient = new JTable(tableModelIngredient);
					tableIngredient.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							mouseClickedTableIngredient(arg0);
						}
					});
					tableIngredient.getColumnModel().getColumn(0)
							.setPreferredWidth(200);
					tableIngredient.getColumnModel().getColumn(1)
							.setPreferredWidth(100);
					tableIngredient.getColumnModel().getColumn(2)
							.setPreferredWidth(30);
					tableIngredient.getColumnModel().getColumn(3)
							.setPreferredWidth(30);
					scrollPane_2.setViewportView(tableIngredient);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridwidth = 2;
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 2;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 63, 479, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.insets = new Insets(0, 0, 0, 5);
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = 0;
				panel.add(panel_1, gbc_panel_1);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[] { 63, 0 };
				gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
				gbl_panel_1.columnWeights = new double[] { 0.0,
						Double.MIN_VALUE };
				gbl_panel_1.rowWeights = new double[] { 0.0, 0.0,
						Double.MIN_VALUE };
				panel_1.setLayout(gbl_panel_1);
				{
					JLabel lblCategories = new JLabel("Categories:");
					GridBagConstraints gbc_lblCategories = new GridBagConstraints();
					gbc_lblCategories.insets = new Insets(0, 0, 5, 0);
					gbc_lblCategories.anchor = GridBagConstraints.NORTHWEST;
					gbc_lblCategories.gridx = 0;
					gbc_lblCategories.gridy = 0;
					panel_1.add(lblCategories, gbc_lblCategories);
				}
				{
					JButton buttonCategory = new JButton("+");
					buttonCategory.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							addCategory();
						}
					});
					GridBagConstraints gbc_buttonCategory = new GridBagConstraints();
					gbc_buttonCategory.fill = GridBagConstraints.HORIZONTAL;
					gbc_buttonCategory.gridx = 0;
					gbc_buttonCategory.gridy = 1;
					panel_1.add(buttonCategory, gbc_buttonCategory);
				}
			}
			{
				scrollPane_1 = new JScrollPane();
				GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
				gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
				gbc_scrollPane_1.gridx = 1;
				gbc_scrollPane_1.gridy = 0;
				panel.add(scrollPane_1, gbc_scrollPane_1);
				{
					Vector columns = new Vector();
					columns.add("Category");
					columns.add("Edit");
					columns.add("Remove");
					tableModelCategory = MyTableModel.modelCategory(columns,
							null);
					tableCategory = new JTable(tableModelCategory);
					tableCategory.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							mouseClickedTableCategory(e);
						}
					});
					tableCategory.getColumnModel().getColumn(0)
							.setPreferredWidth(330);
					tableCategory.getColumnModel().getColumn(1)
							.setPreferredWidth(30);
					tableCategory.getColumnModel().getColumn(2)
							.setPreferredWidth(30);
					scrollPane_1.setViewportView(tableCategory);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridwidth = 2;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 3;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 68, 490, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JLabel lblDescription = new JLabel("Description:");
				GridBagConstraints gbc_lblDescription = new GridBagConstraints();
				gbc_lblDescription.anchor = GridBagConstraints.NORTH;
				gbc_lblDescription.insets = new Insets(0, 0, 0, 5);
				gbc_lblDescription.gridx = 0;
				gbc_lblDescription.gridy = 0;
				panel.add(lblDescription, gbc_lblDescription);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 0;
				panel.add(scrollPane, gbc_scrollPane);
				{
					textAreaDescription = new JTextArea();
					scrollPane.setViewportView(textAreaDescription);
					textAreaDescription.setLineWrap(true);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						saveRecipe();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		fillFields();
		fillTable();
	}

	private void fillFields() {
		for (Category category : recipe.getCategories()) {
			categories.add(category.getName());
		}
		ingredients = recipe.getIngredients();
		textAreaDescription.setText(recipe.getDirections());
		textFieldTitle.setText(recipe.getTitle());
	}

	protected void saveRecipe() {
		String title = textFieldTitle.getText();
		String directions = textAreaDescription.getText();
		RecipeManagerController.editRecipe(directions, title, ingredients, categories, recipe);
		setVisible(false);
	}

	protected void mouseClickedTableCategory(MouseEvent e) {
		if (e.getClickCount() == 2) {
			/*remove*/
			if(tableCategory.getSelectedColumn() == 2){
				String category = (String) tableCategory.getValueAt(tableCategory.getSelectedRow(), 0);
				categories.remove(category);
			} /*edit*/ else if (tableCategory.getSelectedColumn() == 1){
				String category = (String) tableCategory.getValueAt(tableCategory.getSelectedRow(), 0);
				saveCategoryDialog dialog = new saveCategoryDialog(category);
				dialog.setVisible(true);
				
				String newCategory = dialog.getCategory();
				categories.remove(category);
				categories.add(newCategory);
			}
		}
		
		fillTable();

	}

	protected void mouseClickedTableIngredient(MouseEvent arg0) {
		if (arg0.getClickCount() == 2) {
			/*remove*/
			if(tableIngredient.getSelectedColumn() == 3){
				String key = (String) tableIngredient.getValueAt(tableIngredient.getSelectedRow(), 0);
				ingredients.remove(key);
			} /*edit*/ else if (tableIngredient.getSelectedColumn() == 2){
				String ingredient = (String) tableIngredient.getValueAt(tableIngredient.getSelectedRow(), 0);
				String amount = (String) tableIngredient.getValueAt(tableIngredient.getSelectedRow(), 1);
				saveIngredientDialog dialog = new saveIngredientDialog(amount, ingredient);
				dialog.setVisible(true);
				
				String newIngredient = dialog.getIngredient();
				String newAmount = dialog.getAmount();
				
				ingredients.remove(ingredient);
				ingredients.put(newIngredient, newAmount);
			}
		}
		fillTable();
	}

	protected void addCategory() {
		saveCategoryDialog dialog = new saveCategoryDialog("");
		dialog.setVisible(true);
		
		String newCategory = dialog.getCategory();
		categories.add(newCategory);
		fillTable();
	}

	private void fillTable() {
		tableModelCategory.setRowCount(0);
		tableModelIngredient.setRowCount(0);

		for (String s : categories) {
			tableModelCategory.addRow(new Object[] { s, IconManager.getEdit(),
					IconManager.getRemove() });
		}

		Iterator it = ingredients.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			String nameIngredient = (String) pairs.getKey();
			String amountIngredient = (String) pairs.getValue();
			tableModelIngredient.addRow(new Object[] { nameIngredient,
					amountIngredient, IconManager.getEdit(),
					IconManager.getRemove() });
			// it.remove();
		}
	}

	protected void addIngredient() {
		saveIngredientDialog dialog = new saveIngredientDialog("", "");
		dialog.setVisible(true);
		
		String newIngredient = dialog.getIngredient();
		String newAmount = dialog.getAmount();
		ingredients.put(newIngredient, newAmount);
		fillTable();
	}

}
