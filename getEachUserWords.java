package socialComputingHW1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class getEachUserWords {

	public static void main(String args[]) throws Exception {

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

			File file = new File(
					"C:\\Users\\Smit\\Desktop\\SUNY\\Social Computing\\HW3\\"
							+ speakernames[i] + ".txt");
			File file1 = new File(
					"C:\\Users\\Smit\\Desktop\\SUNY\\Social Computing\\HW3\\"
							+ speakernames[i] + "eachword.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			FileWriter fw = new FileWriter(file1);
			String line = "null";
			while ((line = br.readLine()) != null) {
				String temp[] = line.split(" ");
				for (int j = 0; j < temp.length; j++) {
					if (!temp[j].isEmpty())
						fw.write(temp[j] + "\n");
					fw.flush();
				}
			}
			fw.close();
			br.close();

		}

	}

}
