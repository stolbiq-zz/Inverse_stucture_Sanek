package cardsPackage;

import java.io.*;
import java.security.Policy.Parameters;
import java.util.ArrayList;

public class DataReader extends Thread {
	public void run(String dataBaseName, ArrayList<Cards> MainList,
			double waveLength, String[] elements) {

		// ChemComposition parameters = new ChemComposition ();
		String stroka = "\n";
		try {
			OutputStreamWriter OSW = new OutputStreamWriter(System.out);
			PrintWriter PW = new PrintWriter(OSW, true);
			InputStreamReader ISR = new InputStreamReader(System.in, "Cp866");

			try {
				// Построчно читаем файл и печатаем его содержимое если такой
				// элемент встречается
				FileReader FR = new FileReader(dataBaseName);
				BufferedReader BRf = new BufferedReader(FR);
				int cardNumber = -1;
				do {

					stroka = BRf.readLine();
					String substance = "";
					String symmetryType = "";
					cardNumber++;

					if (stroka != null) {
						// System.out.println("Bla");
						if ((stroka.indexOf(elements[0].toUpperCase()) > 0)	&& (stroka.indexOf(elements[0].toUpperCase()) < stroka.indexOf("     "))) {
							int a = stroka.indexOf("   1");
							a = a + 4;
							int b = stroka.indexOf("     ");
							substance = stroka.substring(a, b);

							// получили название вещества

							int p = stroka.indexOf("     D");
							// System.out.println(p);
							Cards nextCard = new Cards();
							if (p == -1) {
								symmetryType = "NODATA";
								b = b + 27;
								int c = stroka.indexOf("  ", b);
								substance = substance.concat(stroka.substring(
										b, c));
								nextCard.name = substance;
								nextCard.latticeType = symmetryType;
								coordGetter(c, stroka, nextCard);
								nextCard.calcTheta(waveLength);
							} else {
								p = p + 6;//+5
								symmetryType = stroka.substring(p-1, p+1);
								//System.out.println(symmetryType);
								p = p + 6;
								int s = stroka.indexOf("  ", p);
								substance = substance.concat(stroka.substring(
										p, s));
								nextCard.name = substance;
								nextCard.latticeType = symmetryType;
								coordGetter(s, stroka, nextCard);
								nextCard.calcTheta(waveLength);
							}
							MainList.add(nextCard);
						}
						
						

					 }
					// MainList.get(cardNumber).calcTheta(waveLength);
				} while (stroka != null);

			}// try
			catch (FileNotFoundException e) {

			}// catch (FileNotFoundException e) //catch
		}// try
		catch (Exception e) {

		}// catch(Exception e)
			// main
			// testFile1
	}

	public void coordGetter(int start, String stroka, Cards nextCard) {
		int d = stroka.indexOf(".", start);
		String number = stroka.substring(1, 6);
		int last = stroka.indexOf(number, d);
		int ind = d - 1;
		int counter = 0;
		while (ind < last - 1) {
			String x = "";
			String y = "";
			int s = 0;
			while (s < 6) {
				x = x + stroka.charAt(ind);
				s++;
				ind++;
			}
			while (stroka.charAt(ind) == ' ') {
				ind++;
			}
			while (stroka.charAt(ind) != ' ') {
				y = y + stroka.charAt(ind);
				ind++;
			}
			while (stroka.charAt(ind) == ' ') {
				ind++;
			}
			// System.out.println(y);
			// System.out.println(x);
			double distance = Double.parseDouble(x);
			double intensity = Double.parseDouble(y);
			// System.out.println(intensity);
			// System.out.println(distance);
			Peaks nextPeak = new Peaks(0, intensity, distance);
			nextCard.peaksList.add(counter, nextPeak);
			counter++;
		}
	}
}
