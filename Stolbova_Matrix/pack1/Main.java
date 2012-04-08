package pack1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
public static Matrix ScannerReadFile(String file){
		/*Attention!
		 * For the correct working of program it's essential to create such files like
		 * textA.txt, textB.txt (for typing vector or matrix), operation.txt (this one - for typing the operation Add, Multiple or Minus) 
		 * Moreover, the numbers in files must be typed using only 1 space after EACH number!!! 
		 * There mustn't be any other symbols in file!
		 * Examples of typing ("_" - symbol of space):
		 * 5_45_4_		or		45_
		 * 7_78_12_				8_
		 *						45_
		*/
			Matrix ob1 = new Matrix();
			try {
			FileInputStream fileStream = new FileInputStream(file);
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
			ob1.str = n; 
			ob1.col = m;
			ob1.arr = new int[ob1.col+1][ob1.str+1];
			FileInputStream fileStream1 = new FileInputStream(file);
			Scanner scanner1 = new Scanner(fileStream1);
			m = 0;
			while (scanner1.hasNextLine()) {
				n = 0;
				String line = scanner1.nextLine();
				p = line.indexOf(' ');
				while (p!=(-1)){
					String extraline = new String();
					extraline = line.substring(0, p);
					ob1.arr[m][n] = Integer.parseInt(extraline);
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
		return ob1;
	}

	public static String ScannerReadOperation(){
		String line = new String();;
		try {
			FileInputStream fileStream = new FileInputStream("operation.txt");
			Scanner scanner = new Scanner(fileStream);
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return line;
	}

	public static void main(String[] args){ 
		Matrix ob1 = ScannerReadFile("textA.txt");
		Matrix ob2 = ScannerReadFile("textB.txt");
		String signal1, signal2, oper;
		if ((ob1.str == 1) || (ob1.col == 1)){
			signal1 = "Vector";
			System.out.println("Vector has read from textA.txt");
		}
		else {
			signal1 = "Matrix";
			System.out.println("Matrix has read from textA.txt!");
		}
		
		if ((ob2.str == 1) || (ob2.col == 1)){
			signal2 = "Vector";
			System.out.println("Vector has read from textB.txt");
		}
		else {
			signal2 = "Matrix";
			System.out.println("Matrix has read from tetB.txt!");
		}
		
		oper = ScannerReadOperation();
		
		if ((signal1 == "Matrix") && (signal2 == "Matrix")){
			if (oper.equals("Add")){
				ob1.sumMatrixAMatrixB(ob2);
			}
			if (oper.equals("Multiple")){
				ob1.multipleMatrixAMatrixB(ob2);
			}
			if (oper.equals("Minus")){
				ob1.minusMatrixAMatrixB(ob2);
			}
		}
		if ((signal1 == "Vector") && (signal2 == "Vector")){
			if (oper.equals("Add")){
				ob1.sumVectorAVectorB(ob2);
			}
			if (oper.equals("Multiple")){
				ob1.multipleVectorAVectorB(ob2);
			}
			if (oper.equals("Minus")){
				ob1.minusVectorAVectorB(ob2);
			}
		}
	}
}
