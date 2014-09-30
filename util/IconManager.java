package model.util;

import javax.swing.ImageIcon;

public class IconManager {

	private static ImageIcon edit = new ImageIcon(IconManager.class.getResource("/img/edit_table.png"));
	
	private static ImageIcon remove = new ImageIcon(IconManager.class.getResource("/img/remove.png"));

	public static ImageIcon getEdit() {
		return edit;
	}

	public void setEdit(ImageIcon edit) {
		this.edit = edit;
	}

	public static ImageIcon getRemove() {
		return remove;
	}

	public void setRemove(ImageIcon remove) {
		this.remove = remove;
	}

}
