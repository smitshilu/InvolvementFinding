package socialComputingHW1;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class findPOS {

	public static void main(String args[]) {

		ArrayList<String> names = new ArrayList<String>();
		HashMap<String, Integer> final_result = new HashMap<String, Integer>();

		try {

			/*
			 * Change File name for 2nd dataset
			 */

			File inputFile = new File(
					"C:\\Users\\Smit\\Desktop\\2010_02_09_annotated.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("turn");

			String name = "null";
			System.out.println(nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node current_node = nList.item(temp);
				Element current_element = (Element) current_node;
				int a = 0;

				name = current_element.getAttribute("speaker");
				String pos = current_element.getAttribute("pos");
				
				int n = pos.split(";").length;

				if (!names.contains(name)) {
					names.add(name);
					final_result.put(name, 0);
				}

				a = final_result.get(name);
				a = a+(n-1);
				final_result.replace(name, a);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i) + " = "
					+ final_result.get(names.get(i)));
		}
	}
}