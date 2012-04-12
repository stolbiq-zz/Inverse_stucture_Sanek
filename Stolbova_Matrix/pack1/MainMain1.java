package pack1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainMain1{

	private static Matrix1 scannerReadFile(String file) throws FileNotFoundException{
		/*Attention!
		* For the correct working of program it's essential to create such files like
		* textA.txt, textB.txt (for typing vector or matrix),
		* operation.txt (this one - for typing the operation Add, Multiple, Minus, Det, Trans, Number),
		* number.txt (to type a number you are going to multiple with matrix)
		* Moreover, the numbers in files must be typed using only 1 space after EACH number!!!
		* There mustn't be any other symbols in file!
		* Examples of typing ("_" - symbol of space):
		* 5_45_4_ or 45_
		* 7_78_12_ 8_
		* 45_
		*/
		int p;
		int m = 0;
		int n = 0;
		Scanner scanner = new Scanner(new FileInputStream(file));
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

		Matrix1 ob1 = new Matrix1(m, n);
		m = 0;
		Scanner scanner1 = new Scanner(new FileInputStream(file));
		while (scanner1.hasNextLine()) {
			n = 0;
			String line = scanner1.nextLine();
			p = line.indexOf(' ');
			while (p!=(-1)){
				String extraline = new String();
				extraline = line.substring(0, p);
				ob1.setElement(m, n, Integer.parseInt(extraline));
				line = line.substring(p+1);
				p = line.indexOf(' ');
				n++;
			}
		m++;
		}
		return ob1;
	}
		
		
	private static String scannerReadOperation() throws FileNotFoundException{
		String line = new String();
		Scanner scanner = new Scanner(new FileInputStream("operation.txt"));
		line = scanner.nextLine();
		return line;
	}
	
	
	private static int scannerReadNumber() throws FileNotFoundException{
		int a = 1;
		Scanner scanner = new Scanner(new FileInputStream("number.txt"));
		a = Integer.parseInt(scanner.nextLine());
		return a;
	}
	
	
	
	public static void main(String[] args){
		try{
			Matrix1 ob1 = scannerReadFile("textA.txt");
			Matrix1 ob2 = scannerReadFile("textB.txt");
			String signal1, signal2, oper;
			if ((ob1.getStr() == 1) || (ob1.getCol() == 1)){
				signal1 = "Vector";
				System.out.println("Vector has read from textA.txt");
			}
			else {
				signal1 = "Matrix";
				System.out.println("Matrix has read from textA.txt!");
			}
			
			if ((ob2.getStr() == 1) || (ob2.getCol() == 1)){
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
				System.out.println();
				ob2.intMult(scannerReadNumber()).printf();
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
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}