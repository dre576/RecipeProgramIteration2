package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class saveIngredientDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldIngredient;
	private JTextField textFieldAmount;
	String amount = "";
	String ingredient = "";
	private JButton okButton;
	
	public saveIngredientDialog(String amount, String ingredient) {
		setTitle("Ingredient");
		setModal(true);
		this.amount = amount;
		this.ingredient = ingredient;
		setBounds(100, 100, 328, 126);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblIngredient = new JLabel("Ingredient:");
			GridBagConstraints gbc_lblIngredient = new GridBagConstraints();
			gbc_lblIngredient.anchor = GridBagConstraints.EAST;
			gbc_lblIngredient.insets = new Insets(0, 0, 5, 5);
			gbc_lblIngredient.gridx = 0;
			gbc_lblIngredient.gridy = 0;
			contentPanel.add(lblIngredient, gbc_lblIngredient);
		}
		{
			textFieldIngredient = new JTextField();
			GridBagConstraints gbc_textFieldIngredient = new GridBagConstraints();
			gbc_textFieldIngredient.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldIngredient.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldIngredient.gridx = 1;
			gbc_textFieldIngredient.gridy = 0;
			contentPanel.add(textFieldIngredient, gbc_textFieldIngredient);
			textFieldIngredient.setColumns(10);
		}
		{
			JLabel lblAmount = new JLabel("Amount:");
			GridBagConstraints gbc_lblAmount = new GridBagConstraints();
			gbc_lblAmount.anchor = GridBagConstraints.WEST;
			gbc_lblAmount.insets = new Insets(0, 0, 0, 5);
			gbc_lblAmount.gridx = 0;
			gbc_lblAmount.gridy = 1;
			contentPanel.add(lblAmount, gbc_lblAmount);
		}
		{
			textFieldAmount = new JTextField();
			GridBagConstraints gbc_textFieldAmount = new GridBagConstraints();
			gbc_textFieldAmount.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldAmount.gridx = 1;
			gbc_textFieldAmount.gridy = 1;
			contentPanel.add(textFieldAmount, gbc_textFieldAmount);
			textFieldAmount.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buttonOK(e);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						textFieldAmount.setText("");
						textFieldIngredient.setText("");
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		textFieldAmount.setText(amount);
		textFieldIngredient.setText(ingredient);
	}

	protected void buttonOK(ActionEvent e) {
		amount = textFieldAmount.getText();
		ingredient = textFieldIngredient.getText();
		setVisible(false);
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

}
