package cardsPackage;

import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

// чтение набора пиков из экспериментальной дифрактограммы
public class PeaksReader {
	public ArrayList<Peaks> listOfPeaks = new ArrayList<Peaks>(50);

	public PeaksReader(String fileName) {
		try {
			// открываем входной поток для чтения из файла
			FileInputStream fileStream = new FileInputStream(fileName);
			// заводим новый объект типа Scanner для возможности посимвольного
			// считывания
			Scanner scanner = new Scanner(fileStream);
			int spacePointer1 = 0, spacePointer2;

			// начинаем построчно читать файл
			// считаем, что значения угла и интенсивности разделены пробелом
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String readTheta = new String();
				String readIntensity = new String();
				try {
					readTheta = line.substring(0, line.indexOf(' ', 1));
					readIntensity = line.substring(line.lastIndexOf(' '));
					Peaks peak = new Peaks(Double.parseDouble(readTheta),
							Double.parseDouble(readIntensity), 0);
					listOfPeaks.add(peak);
				} catch (StringIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected Peaks get(int index) {
		return this.listOfPeaks.get(index);
	}

	protected void markMax() {
		for (int i = 1; i < this.listOfPeaks.size() - 1; i++) {
			if ((get(i - 1).intensity < get(i).intensity)
					&& (get(i).intensity > get(i + 1).intensity)) {
				get(i).maximum = true;
			}
		}
	}

	private void reserveMax() {
		this.markMax();
		int i = 0;
		while (i < this.listOfPeaks.size()) {
			if (!(get(i).maximum)) {
				this.listOfPeaks.remove(get(i));
			} else {
				i++;
			}
		}
	}

	public void sortMax() {
		this.reserveMax();
		for (int j = 0; j < this.listOfPeaks.size(); j++) {
			Peaks max = new Peaks(get(j).theta, get(j).intensity, get(j).distance);
			int maxIndex = j;
			for (int i = j; i < this.listOfPeaks.size(); i++) {
				if (get(i).intensity >= max.intensity) {
					max = get(i);
					maxIndex = i;
				}
			}
			this.listOfPeaks.set(maxIndex, get(j));
			this.listOfPeaks.set(j, max);
		}
	}

	public void printList() {
		for (int i = 0; i < this.listOfPeaks.size(); i++) {
			System.out.println(get(i).theta + "  " + get(i).intensity);
		}
		System.out.println("---------------------------");
		System.out.println();
	}

}