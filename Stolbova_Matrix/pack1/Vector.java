package pack1;

public class Vector {
	public int col, str;
	public int[][] arr;
	public void printf(){
		for (int i=0; i<col; i++){
			for (int j=0; j<str; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}	
	public void sumVectorAVectorB(Vector v){
		System.out.println("Addition");
		if ((this.col != v.col) || (this.str != v.str)){ 
			System.out.println("Impossible to sum");
		}
		else{
			Vector sumAB = new Vector();
			sumAB.arr = new int[this.col][this.str];
			for (int i=0; i<this.col; i++){
				for (int j=0; j<this.str; j++){
					sumAB.arr[i][j] = this.arr[i][j] + v.arr[i][j];
				}
				sumAB.col = this.col;
				sumAB.str = this.str;
			}
			sumAB.printf();
		}
	}
	
	public void minusVectorAVectorB(Vector v){
		System.out.println("Minus");
		if ((this.col != v.col) || (this.str != v.str)){
			System.out.println("Impossible to sum");
		}
		else{
			Vector minAB = new Vector();
			minAB.arr = new int[this.col][this.str];
			for (int i=0; i<this.col; i++){
				for (int j=0; j<this.str; j++){
					minAB.arr[i][j] = this.arr[i][j] - v.arr[i][j];
				}
				minAB.col = this.col;
				minAB.str = this.str;
			}
			minAB.printf();
		}
	}
	
	public void multipleVectorAVectorB(Vector v){
		System.out.println("Multiplication");
		if (this.str != v.col){
			System.out.println("Impossible to mult");
		}

		else{
			Vector multAB = new Vector();
			multAB.arr = new int[this.col+1][v.str+1];
			for (int i=0; i<this.col; i++){
				for (int j=0; j<v.str; j++){
					for(int t=0; t<this.str; t++){
						multAB.arr[i][j] = multAB.arr[i][j] + this.arr[i][t] * v.arr[t][j];
					}
				}
			}
			multAB.col = this.col;
			multAB.str = v.str;
			multAB.printf();
		}
	}
	
	public Vector intMult(int a){
		Vector iMult = new Vector();
		iMult.arr = new int[this.col+1][this.str+1];
		for (int i=0; i<this.col; i++){
			for(int j=0; j<this.str; j++){
				iMult.arr[i][j] = a*this.arr[i][j];
			}
		}
		iMult.col = this.col;
		iMult.str = this.str;
		return (iMult);
	}
}