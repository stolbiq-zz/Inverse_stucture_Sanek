package pack1;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ScannerReadVector{
	public int strVectorA, strVectorB, colVectorA, colVectorB;
	public int[][] vectorA, vectorB;
	ScannerReadVector(){
		//Read Vector A
		try {
			FileInputStream fileStream = new FileInputStream("vectorA.txt");
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
			strVectorA = n; 
			colVectorA = m;
			//System.out.println(strVectorA);
			vectorA = new int[colVectorA+1][strVectorA+1];
			FileInputStream fileStream2 = new FileInputStream("vectorA.txt");
			Scanner scanner2 = new Scanner(fileStream2);
			m = 0;
			while (scanner2.hasNextLine()) {
				n = 0;
				String line = scanner2.nextLine();
				p = line.indexOf(' ');
				while (p!=(-1)){
					String extraline = new String();
					extraline = line.substring(0, p);
					vectorA[m][n] = Integer.parseInt(extraline);
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
		
		//Read Vector B;
		try {
			FileInputStream fileStream = new FileInputStream("vectorB.txt");
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
			strVectorB = n; 
			colVectorB = m;
			vectorB = new int[colVectorB+1][strVectorB+1];
			FileInputStream fileStream2 = new FileInputStream("vectorB.txt");
			Scanner scanner2 = new Scanner(fileStream2);
			m = 0;
			while (scanner2.hasNextLine()) {
				n = 0;
				String line = scanner2.nextLine();
				p = line.indexOf(' ');
				while (p!=(-1)){
					String extraline = new String();
					extraline = line.substring(0, p);
					vectorB[m][n] = Integer.parseInt(extraline);
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
