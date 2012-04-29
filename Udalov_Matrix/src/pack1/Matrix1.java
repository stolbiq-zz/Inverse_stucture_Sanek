package pack1;

public class Matrix1 extends Vector1 {
	Matrix1(int n, int m){
		super(n, m);
	}
	
	public Matrix1 trans (){
		Matrix1 mtr = new Matrix1(this.str, this.col);
		for (int i=0; i<col; i++){
			for(int j=0; j<str; j++){
				mtr.setElement(j, i, this.getElement(i, j));
			}
		}
		return mtr;
	}
	
	private Matrix1 minor(int k, int q){
		Matrix1 minorMatrix = new Matrix1(col-1, str-1);
		int m = 0;
		int n = 0;
		int i = 0;
		int j = 0;
		for (i=0; i<col; i++){
			if (i!=k){
				for (j=0; j<str; j++){
					if (j!=q){
						minorMatrix.setElement(m,n,this.getElement(i, j));
						n++;
					}
				}
				m++;
			}
			n=0;
		}
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
				reint = this.getElement(0,0);
			}
			else{
				for (int i=0; i<str;i++)
				{
					reint = reint + this.getElement(0, i)*t*(minor(0,i).det());
					t=t*(-1);
				}
			}
		}
		return reint;
	}
}