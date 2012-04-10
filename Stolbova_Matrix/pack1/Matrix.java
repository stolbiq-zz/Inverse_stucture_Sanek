package pack1;

public class Matrix extends Vector {
	
	public Matrix trans (){
		Matrix mtr = new Matrix();
		mtr.arr = new int[str+1][col+1];
		mtr.col = str;
		mtr.str = col;
		for (int i=0; i<col; i++){
			for(int j=0; j<str; j++){
				mtr.arr[j][i] = arr[i][j];
			}
		}
		return mtr;
	}
	
	private Matrix minor(int k, int q){
		Matrix minorMatrix = new Matrix();
		int m = 0;
		int n = 0;
		minorMatrix.arr = new int[col][str];
		for (int i=0; i<col; i++){
			if (i!=k){
				for (int j=0; j<str; j++){
					if (j!=q){
						minorMatrix.arr[m][n] = arr[i][j];
						n++;
					}
				}
				m++;
			}
			n=0;
		}
		minorMatrix.col = col-1;
		minorMatrix.str = str-1;
		return minorMatrix;
	}
	public int det() throws DetMistake{
		if (col != str){
			throw new DetMistake();
		}
		int t = 1;
		int reint = 0;
		if (col == str){
			if (str == 1){
				reint = arr[0][0];
			}
			else{
				for (int i=0; i<str;i++)
				{
					reint = reint + arr[0][i]*t*(minor(0,i).det());
					t=t*(-1);
				}
			}
		}
		return reint;
	}
}
