package pack1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
		
	private static Scanner scan(String file) throws FileNotFoundException {
		FileInputStream fileStream = new FileInputStream(file);
		Scanner scanner = new Scanner(fileStream);
		return scanner;
	}
	private static Matrix scannerReadFile(String file){
		/*Attention!
		 * For the correct working of program it's essential to create such files like
		 * textA.txt, textB.txt (for typing vector or matrix), 
		 * operation.txt (this one - for typing the operation Add, Multiple, Minus, Det, Trans, Number),
		 * number.txt (to type a number you are going to multiple with matrix) 
		 * Moreover, the numbers in files must be typed using only 1 space after EACH number!!! 
		 * There mustn't be any other symbols in file!
		 * Examples of typing ("_" - symbol of space):
		 * 5_45_4_		or		45_
		 * 7_78_12_				8_
		 *						45_
		*/
			Matrix ob1 = new Matrix();
			int p;
			int m = 0;
			int n = 0;
			try{
				Scanner scanner = scan(file);
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
				m = 0;
				Scanner scanner1 = scan(file);
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
	

	private static String scannerReadOperation(){
		String line = new String();;
			try{
				Scanner scanner = scan("operation.txt");
				while (scanner.hasNextLine()) {
					line = scanner.nextLine();
				}
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return line;
		} 
		
	
	private static int scannerReadNumber(){
		int a = 1;
			try{
				Scanner scanner = scan("number.txt");
				a = Integer.parseInt(scanner.nextLine());
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return a;
		}

	

	public static void main(String[] args){
		Matrix ob1 = scannerReadFile("textA.txt");
		Matrix ob2 = scannerReadFile("textB.txt");
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
			System.out.println("Matrix has read from textB.txt!");
		}
		
		oper = scannerReadOperation();
		
		if (oper.equals("Add")){
			ob1.sumVectorAVectorB(ob2);
		}
		if (oper.equals("Multiple")){
			ob1.multipleVectorAVectorB(ob2);
		}
		if (oper.equals("Minus")){
			ob1.minusVectorAVectorB(ob2);
		}
		
		if (oper.equals("Number")){
			ob1.intMult(scannerReadNumber()).printf();
		}
		
		if ((signal1.equals("Matrix")) && (signal2.equals("Matrix"))){
			if (oper.equals("Trans")){
				ob1.trans().printf();
				System.out.println();
				ob2.trans().printf();
			}
			if (oper.equals("Det")){
				try{
					System.out.println(ob1.det());
					System.out.println();
					System.out.println(ob2.det());
				}
				catch(DetMistake e){
					e.print();
				}
			}
		}
	}
}	
