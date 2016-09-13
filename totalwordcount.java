package socialComputingHW1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class totalwordcount {

	public static void main(String[] args) throws Exception {

		ArrayList<String> names = new ArrayList<String>();
		HashMap<String, Integer> final_result = new HashMap<String, Integer>();

		File file = new File(
				"C:\\Users\\Smit\\Desktop\\SUNY\\Social Computing\\HW3\\dia.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while ((line = br.readLine()) != null) {
			String array[] = line.split(" ");

			for (int j = 0; j < array.length; j++) {

				if (!names.contains(array[j])) {
					names.add(array[j]);
					final_result.put(array[j], 1);

				} else {
					int temp = final_result.get(array[j]);
					temp++;
					final_result.replace(array[j], temp);
				}
			}
		}
		br.close();
		File f = new File(
				"C:\\Users\\Smit\\Desktop\\SUNY\\Social Computing\\HW3\\totalwordcount.txt");
		FileWriter fr1 = new FileWriter(f);

		for (int i = 0; i < names.size(); i++) {
			fr1.write(names.get(i) + "   " + final_result.get(names.get(i))
					+ "\n");
			fr1.flush();
			System.out.println(names.get(i) + "   "
					+ final_result.get(names.get(i)));
		}
		fr1.close();

	}

}
