package pack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	private static Matrix scannerReadFile(String file)
			throws FileNotFoundException {
		int p;
		int m = 0;
		int n = 0;
		Scanner scanner = new Scanner(new FileInputStream(file));
		while (scanner.hasNextLine()) {
			n = 0;
			String line = scanner.nextLine();
			p = line.indexOf(' ');
			while (p != (-1)) {
				line = line.substring(p + 1);
				p = line.indexOf(' ');
				n++;
			}
			m++;
		}

		Matrix ob1 = new Matrix(m, n);
		m = 0;
		Scanner scanner1 = new Scanner(new FileInputStream(file));
		while (scanner1.hasNextLine()) {
			n = 0;
			String line = scanner1.nextLine();
			p = line.indexOf(' ');
			while (p != (-1)) {
				String extraline = new String();
				extraline = line.substring(0, p);
				ob1.arr[m][n] = Integer.parseInt(extraline);
				line = line.substring(p + 1);
				p = line.indexOf(' ');
				n++;
			}
			m++;
		}
		return ob1;
	}

	/*
	 * private static Matrix scanMatrix(String file) throws
	 * FileNotFoundException{ FileReader fin = new FileReader(file); Scanner src
	 * = new Scanner(fin); int i=0, k=0, col, str; while (src.hasNext()) { if
	 * (src.hasNextDouble()) { k++; } else{break;} }
	 * while(src.hasNextLine()){i++;} k=k/i; col=k; str=i; double M[][]=new
	 * double[i][k];
	 * 
	 * i=0; k=0; while (src.hasNext()) { if (src.hasNextInt()) {
	 * M[i][k]=src.nextInt(); k++; if(k>=col) { k=0; i++; }
	 * 
	 * }else{ break; } }
	 * 
	 * Matrix A=new Matrix(str, col); A.arr=M; return A; }
	 */
	public static void main(String[] args) throws MistakeNullDet, MistakeImpossibleToCalculate {
		try {
			Matrix A = scannerReadFile("A.txt");
			Matrix B = scannerReadFile("B.txt");
			Scanner operation = new Scanner(System.in);
			String s;
			while(true){
				s = operation.nextLine();
			if(s.equals("Sum")){
				A.sumAB(B).printMatrix();
				}else{
			if(s.equals("Minus")){
					A.minusAB(B).printMatrix();
				}else{
					if (s.equals("Multiply")){
						A.multAB(B).printMatrix();	
					}else{
					if(s.equals("Det")){
						double det = A.detMatrixA();
						System.out.print("Det=");
						System.out.println(det);
							
					}else{
					if(s.equals("Inverse")){
						System.out.println("Inverse");
						A.inverse().printMatrix();	
					}else{
						if(s.equals("Exit")){
						break;	
						}
					}	
					}	
					
					}
					
				}
				
				}
			
			
			}	
			} catch (MistakeNullDet err2) {
				err2.print();
			}
			catch (MistakeImpossibleToCalculate err1) {
				err1.print();
			}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		}

}
