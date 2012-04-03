package pack1;

public class SumVectorAVectorB extends ScannerReadVector {
	private int sumAB[][];
	public SumVectorAVectorB(int arrA[][], int arrB[][], int strA, int strB, int colA, int colB){
		sumAB = new int[colA+1][strA+1];
		System.out.println("Summary");
		if ((colA != colB) || (strA != strB)){
			System.out.println("Impossible to sum");
		}
		else{
			for (int i=0; i<colB; i++){
				for (int j=0; j<strB; j++){
					sumAB[i][j] = arrA[i][j] + arrB[i][j];
					System.out.print(sumAB[i][j] + " ");
				}
				System.out.println();
			}
		}
		System.out.println("_________________");
	}
}	
