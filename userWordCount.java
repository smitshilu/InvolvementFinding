package socialComputingHW1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class userWordCount {

	public static void main(String args[]) throws Exception {
		ArrayList<String> names = new ArrayList<>();

		String speakernames[] = new String[8];
		speakernames[0] = "jeremy";
		speakernames[1] = "rebecca";
		speakernames[2] = "caroline";
		speakernames[3] = "meg";
		speakernames[4] = "david";
		speakernames[5] = "barney";
		speakernames[6] = "vicky";
		speakernames[7] = "thomas";
		
		for (int i = 0; i < 8; i++) {

			HashMap<String, Integer> final_result = new HashMap<String, Integer>();

			File file = new File(
					"C:\\Users\\Smit\\Desktop\\SUNY\\Social Computing\\HW3\\"
							+ speakernames[i] + "eachword.txt");
			File file1 = new File(
					"C:\\Users\\Smit\\Desktop\\SUNY\\Social Computing\\HW3\\totalword.txt");

			BufferedReader br = new BufferedReader(new FileReader(file1));
			String line = "null";
			while ((line = br.readLine()) != null) {
				names.add(line);
				final_result.put(line, 0);
			}

			br.close();

			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				int temp = final_result.get(line);
				temp++;
				final_result.replace(line, temp);
			}

			File file3 = new File(
					"C:\\Users\\Smit\\Desktop\\SUNY\\Social Computing\\HW3\\"
							+ speakernames[i] + "wordcount.txt");
			FileWriter fw = new FileWriter(file3);

			for (int k = 0; k < names.size(); k++) {
				fw.write(names.get(k) + " - " + final_result.get(names.get(k))
						+ "\n");
				fw.flush();
			}
			fw.close();

		}
	}
}
