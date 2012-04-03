package pack1;

public class MultipleVectorAVectorB{
	private int[][] multAB;
	public MultipleVectorAVectorB(int arrA[][], int arrB[][], int strA, int strB, int colA, int colB){
		System.out.println("Multiplication");
		if (strA != colB){
			System.out.println("Impossible to mult");
		}
		
		else{
			multAB = new int[colA+1][strB+1];
			for (int i=0; i<colA; i++){
				for (int j=0; j<strB; j++){
					for(int t=0; t<strA; t++){
						multAB[i][j] = multAB[i][j] + arrA[i][t] * arrB[t][j];
					}
			}
		}
			for (int i=0; i<colA; i++){
				for (int j=0; j<strB; j++){
					System.out.print(multAB[i][j] + " ");
				}
				System.out.println();
			}
		}
		System.out.println("_________________");
	}
}
