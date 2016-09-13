package socialComputingHW1;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class findSentences {
	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();
		HashMap<String, String> final_result = new HashMap<String, String>();

		try {
			File inputFile = new File(
					"C:\\Users\\Smit\\Desktop\\2010_02_09_annotated.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Dialogue");

			NodeList nList1 = doc.getElementsByTagName("turn");

			System.out.println("----------------------------");
			String name = "null";

			for (int temp = 0; temp < nList1.getLength(); temp++) {
				Node nNode = nList.item(0);
				Node current_node = nList1.item(temp);
				Element current_element = (Element) current_node;
				name = current_element.getAttribute("speaker");
				Element eElement = (Element) nNode;
				StringBuilder sb = new StringBuilder();

				if (!names.contains(name)) {
					names.add(name);
					final_result.put(name, eElement
							.getElementsByTagName("turn").item(temp)
							.getTextContent());

				} else {
					sb = sb.append(final_result.get(name));
					sb = sb.append("\n");
					sb = sb.append(eElement.getElementsByTagName("turn")
							.item(temp).getTextContent());
					final_result.replace(name, sb.toString());
				}

			}

			for (int i = 0; i < names.size(); i++) {

				File file = new File("C:\\Users\\Smit\\Desktop\\"
						+ names.get(i) + ".txt");
				FileWriter fw = new FileWriter(file);
				fw.write(final_result.get(names.get(i)));
				fw.flush();
				fw.close();
				System.out
						.println(names.get(i)
								+ "\n =============================================== \n"
								+ final_result.get(names.get(i)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
