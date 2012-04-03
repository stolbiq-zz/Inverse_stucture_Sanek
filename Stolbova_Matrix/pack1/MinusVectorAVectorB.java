package pack1;

public class MinusVectorAVectorB extends ScannerReadVector {
	private int minAB[][];
	public MinusVectorAVectorB(int arrA[][], int arrB[][], int strA, int strB, int colA, int colB){
		minAB = new int[colA][strA];
		System.out.println("Minus");
		if ((colA != colB) || (strA != strB)){
			System.out.println("Impossible to minus");
		}
		else{
			for (int i=0; i<colB; i++){
				for (int j=0; j<strB; j++){
					minAB[i][j] = arrA[i][j] - arrB[i][j];
					System.out.print(minAB[i][j] + " ");
				}
				System.out.println();
			}
		}
		System.out.println("_________________");
	}
}
