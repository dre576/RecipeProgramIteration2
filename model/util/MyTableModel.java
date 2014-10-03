package model.util;

import java.util.Vector;

import javax.swing.Icon;
import javax.swing.table.DefaultTableModel;

import model.Category;
import model.Recipe;
import model.RecipeManager;

public class MyTableModel {
	public static DefaultTableModel modelRecipe(Vector columns, Vector data) {
        DefaultTableModel model = new DefaultTableModel(data, columns) {

            Class[] types = new Class[]{
            		Recipe.class
            };
            boolean[] canEdit = new boolean[]{
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        return model;
    }
	
	public static DefaultTableModel modelIngredient(Vector columns, Vector data) {
        DefaultTableModel model = new DefaultTableModel(data, columns) {

            Class[] types = new Class[]{
            		String.class, String.class, Icon.class, Icon.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        return model;
    }
	
	public static DefaultTableModel modelCategory(Vector columns, Vector data) {
        DefaultTableModel model = new DefaultTableModel(data, columns) {

            Class[] types = new Class[]{
            		String.class, Icon.class, Icon.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        return model;
    }
	
	public static DefaultTableModel modelIngredientEdit(Vector columns, Vector data) {
        DefaultTableModel model = new DefaultTableModel(data, columns) {

            Class[] types = new Class[]{
            		RecipeManager.class, String.class, Icon.class, Icon.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        return model;
    }
	
	public static DefaultTableModel modelCategoryEdit(Vector columns, Vector data) {
        DefaultTableModel model = new DefaultTableModel(data, columns) {

            Class[] types = new Class[]{
            		Category.class, Icon.class, Icon.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        return model;
    }
}
