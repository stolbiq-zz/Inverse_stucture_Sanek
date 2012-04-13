package pack1;

public class Vector1 {
	
	protected int col, str;
	protected int[][] arr;
	
	Vector1(int m, int n){
		int[][] array = new int[m][n];
		for (int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				array[i][j] = 0;
			}
		}
		arr = array;
		col = m;
		str = n;
	}
	
	public void setElement(int i, int j, int p){
		arr[i][j] = p;
	}
	
	public int getElement(int i, int j){
		return arr[i][j];
	}
	
	public int getStr(){
		return str;
	}
	
	public int getCol(){
		return col;
	}
	
	public void printf(){
		for (int i=0; i<col; i++){
			for (int j=0; j<str; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void sumVectorAVectorB(Vector1 v){
		System.out.println("Addition");
		if ((this.col != v.col) || (this.str != v.str)){
			System.out.println("Impossible to sum");
		}
		else{
			Vector1 sumAB = new Vector1(this.col, this.str);
			for (int i=0; i<this.col; i++){
				for (int j=0; j<this.str; j++){
					sumAB.arr[i][j] = this.arr[i][j] + v.arr[i][j];
				}
			}
			sumAB.printf();
		}
	}
	
	public void minusVectorAVectorB(Vector1 v){
		System.out.println("Minus");
		if ((this.col != v.col) || (this.str != v.str)){
			System.out.println("Impossible to sum");
		}
		else{
			Vector1 minAB = new Vector1(this.col, this.str);
			for (int i=0; i<this.col; i++){
				for (int j=0; j<this.str; j++){
					minAB.arr[i][j] = this.arr[i][j] - v.arr[i][j];
				}
			}
			minAB.printf();
		}
	}
	
	public void multipleVectorAVectorB(Vector1 v){
		System.out.println("Multiplication");
		if (this.str != v.col){
			System.out.println("Impossible to mult");
		}
	
		else{
			Vector1 multAB = new Vector1(this.col, v.str);
			for (int i=0; i<this.col; i++){
				for (int j=0; j<v.str; j++){
					for(int t=0; t<this.str; t++){
						multAB.arr[i][j] = multAB.arr[i][j] + this.arr[i][t] * v.arr[t][j];
					}
				}
			}
			multAB.printf();
		}
	}
	
	public Vector1 intMult(int a){
		Vector1 iMult = new Vector1(this.col, this.str);;
		for (int i=0; i<this.col; i++){
			for(int j=0; j<this.str; j++){
				iMult.arr[i][j] = a*this.arr[i][j];
			}
		}
		return (iMult);
	}
}