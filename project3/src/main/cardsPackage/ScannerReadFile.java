package cardsPackage;

import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ScannerReadFile {
	public int[][] auxiliaryMatrix;

	public ScannerReadFile(String fileName) {
		try {
			// открываем входной поток для чтения из файла
			FileInputStream fileStream = new FileInputStream(fileName);
			// заводим новый объект типа Scanner для возможности посимвольного
			// считывания
			Scanner scanner = new Scanner(fileStream);
			int spacePointer;
			int linesRead = 0;
			int columnsRead = 0;

			// производится построчное считывание для определения размеров
			// вводимой матрицы
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				spacePointer = line.indexOf(' ');
				columnsRead = 0;
				while (spacePointer != (int) (-1)) {
					line = line.substring(spacePointer + 1);
					// заметим, что в конце каждой строки вводимой матрицы
					// должен стоять пробел, иначе последний элемент не будет
					// считан
					spacePointer = line.indexOf(' ');
					columnsRead++;
				}
				linesRead++;
			}

			int numberOfLines = linesRead;
			int numberOfColumns = columnsRead;
			// заводим вспомогательный массив, размерами совпадающий с введенной
			// из файла матрицей
			this.auxiliaryMatrix = new int[numberOfLines][numberOfColumns];
			int linesCounter = 0;
			int columnsCounter = 0;
			FileInputStream fileStream1 = new FileInputStream(fileName);
			Scanner scanner1 = new Scanner(fileStream1);
			linesRead = 0;
			columnsRead = 0;

			// поэлементно заполняем весь массив
			while (linesCounter < numberOfLines) {
				// считывается очередная строка
				String line = scanner1.nextLine();
				spacePointer = line.indexOf(' ');
				columnsCounter = 0;
				while (spacePointer != (int) (-1)) {
					// используем вспомогательную строку для "вырезания" из
					// входной строки элементов матрицы
					String tempLine = new String();
					tempLine = line.substring(0, spacePointer);
					this.auxiliaryMatrix[linesCounter][columnsCounter] = Integer
							.parseInt(tempLine);
					// "отрезав" один элемент, продолжаем движение по строке
					line = line.substring(spacePointer + 1);
					spacePointer = line.indexOf(' ');
					columnsCounter++;
				}
				linesCounter++;
			}

			// распечатываем для наглядности заполненный вспомогательный массив
			for (linesCounter = 0; linesCounter < numberOfLines; linesCounter++) {
				for (columnsCounter = 0; columnsCounter < numberOfColumns; columnsCounter++) {
					System.out
							.print(this.auxiliaryMatrix[linesCounter][columnsCounter]
									+ " ");
				}
				System.out.println();
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}