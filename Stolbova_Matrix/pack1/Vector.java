package pack1;

public class Vector {
	public int col, str;
	public int[][] arr;
	public void sumVectorAVectorB(Vector v){
		System.out.println("Summary");
		if ((this.col != v.col) || (this.str != v.str)){   //this - к этому объекту обращаемся!!! v - параметр
			System.out.println("Impossible to sum");
		}
		else{
			for (int i=0; i<this.col; i++){
				for (int j=0; j<this.str; j++){
					System.out.print((this.arr[i][j] + v.arr[i][j]) + " ");
				}
				System.out.println();
			}
		}
	}
	
	public void minusVectorAVectorB(Vector v){
		System.out.println("Minus");
		if ((this.col != v.col) || (this.str != v.str)){
			System.out.println("Impossible to minus");
		}
		else{
			for (int i=0; i<this.col; i++){
				for (int j=0; j<this.str; j++){
					System.out.println((this.arr[i][j] - v.arr[i][j]) + " ");
				}
				System.out.println();
			}
		}
		System.out.println("_________________");
	}
	
	public void multipleVectorAVectorB(Vector v){
		System.out.println("Multiplication");
		if (this.str != v.col){
			System.out.println("Impossible to mult");
		}
		
		else{
			int[][] multAB = new int[this.col+1][v.str+1];
			for (int i=0; i<this.col; i++){
				for (int j=0; j<v.str; j++){
					for(int t=0; t<this.str; t++){
						multAB[i][j] = multAB[i][j] + this.arr[i][t] * v.arr[t][j];
					}
			}
		}
			for (int i=0; i<this.col; i++){
				for (int j=0; j<v.str; j++){
					System.out.print(multAB[i][j] + " ");
				}
				System.out.println();
			}
		}
		System.out.println("_________________");
	}
}
