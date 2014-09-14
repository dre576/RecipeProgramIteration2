package controller;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Recipe;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class WriteFile {
	public static void saveFile(List<Recipe> list) {
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("Recipes", List.class);
		String xml;
		FileOutputStream fos = null;
		try {
			xml = xstream.toXML(list);
			fos = new FileOutputStream("myFile.xml");
			fos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8"));
			byte[] bytes = xml.getBytes("UTF-8");
			fos.write(bytes);

		} catch (Exception e) {
			System.err.println("Error in XML Write: " + e.getMessage());
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
