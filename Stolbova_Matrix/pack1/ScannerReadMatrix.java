package pack1;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ScannerReadMatrix{
	public int strMatrixA, strMatrixB, colMatrixA, colMatrixB;
	public int[][] matrixA, matrixB;
	public ScannerReadMatrix(){
		
		/*Attention!
		 * For the correct working of program it's essential to create such files like
		 * textA.txt, textB.txt, vectorA.txt, vectorB.txt
		 * Moreover, the numbers in files must be typed using only 1 space after EACH number!!! 
		 * There mustn't be any other symbols in file!
		 * Examples of typing ("_" - symbol of space):
		 * 5_45_4_		or		45_
		 * 7_78_12_				8_
		 *						45_
		*/
		
		//Read Matrix A;
		try {
			FileInputStream fileStream = new FileInputStream("textA.txt");
			Scanner scanner = new Scanner(fileStream);
			int p;
			int m = 0;
			int n = 0;
			while (scanner.hasNextLine()) {
				n = 0;
				String line = scanner.nextLine();
				p = line.indexOf(' ');
				while (p!=(-1)){
					line = line.substring(p+1);
					p = line.indexOf(' ');
					n++;
				}
				m++;
			}
			strMatrixA = n; 
			colMatrixA = m;
			matrixA = new int[colMatrixA+1][strMatrixA+1];
			FileInputStream fileStream1 = new FileInputStream("textA.txt");
			Scanner scanner1 = new Scanner(fileStream1);
			m = 0;
			while (scanner1.hasNextLine()) {
				n = 0;
				String line = scanner1.nextLine();
				p = line.indexOf(' ');
				while (p!=(-1)){
					String extraline = new String();
					extraline = line.substring(0, p);
					matrixA[m][n] = Integer.parseInt(extraline);
					line = line.substring(p+1);
					p = line.indexOf(' ');
					n++;
				}
				m++;
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Read Matrix B;
		try {
			FileInputStream fileStream = new FileInputStream("textB.txt");
			Scanner scanner = new Scanner(fileStream);
			int p;
			int m = 0;
			int n = 0;
			while (scanner.hasNextLine()) {
				n = 0;
				String line = scanner.nextLine();
				p = line.indexOf(' ');
				while (p!=(-1)){
					line = line.substring(p+1);
					p = line.indexOf(' ');
					n++;
				}
				m++;
			}
			strMatrixB = n; 
			colMatrixB = m;
			matrixB = new int[colMatrixB+1][strMatrixB+1];
			FileInputStream fileStream1 = new FileInputStream("textB.txt");
			Scanner scanner1 = new Scanner(fileStream1);
			m = 0;
			while (scanner1.hasNextLine()) {
				n = 0;
				String line = scanner1.nextLine();
				p = line.indexOf(' ');
				while (p!=(-1)){
					String extraline = new String();
					extraline = line.substring(0, p);
					matrixB[m][n] = Integer.parseInt(extraline);
					line = line.substring(p+1);
					p = line.indexOf(' ');
					n++;
				}
				m++;
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}	
