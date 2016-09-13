package socialComputingHW1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class vectorCalculator {

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
							+ speakernames[i] + "wordcount.txt");

			File file1 = new File(
					"C:\\Users\\Smit\\Desktop\\SUNY\\Social Computing\\HW3\\totalwordcounts.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			BufferedReader br1 = new BufferedReader(new FileReader(file1));
			double final_answer = 0;
			String line = "";
			String line1 = "";
			while ((line = br.readLine()) != null
					&& (line1 = br1.readLine()) != null) {

				String temp[] = line.split(" - ");
				String temp1[] = line1.split("   ");
				Double te = (Double.parseDouble(temp[1]) - Double
						.parseDouble(temp1[1]));
				Double answer = te * te;
				final_answer = answer + final_answer;
			}

			Double d = (double) final_answer;
			System.out.println(speakernames[i] + " " + Math.sqrt(d));

			br.close();
			br1.close();

		}

	}
}
