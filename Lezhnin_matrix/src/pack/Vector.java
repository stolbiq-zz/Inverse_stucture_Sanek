package pack;

public class Vector {
	protected int colnum, strnum;
	protected double[][] arr;

	public Vector(int col, int str) {
		double[][] array = new double[col][str];
		for (int i = 0; i < str; i++) {
			for (int j = 0; j < col; j++) {
				array[i][j] = 0;
			}
		}
		arr = array;
		colnum = col;
		strnum = str;

	}

	protected void printMatrix() {
		for (int i = 0; i < this.strnum; i++) {
			for (int j = 0; j < colnum; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public Vector sumAB(Vector v) {
		System.out.println("Sum");
		Vector sumAB = new Vector(this.colnum, this.strnum);
		if ((this.colnum != v.colnum) || (this.strnum != v.strnum)) {
			System.out.println("Incorrect operation");
			return sumAB;
		} else {
			for (int i = 0; i < this.colnum; i++) {
				for (int k = 0; k < this.strnum; k++) {
					sumAB.arr[i][k] = this.arr[i][k] + v.arr[i][k];
				}
			}
		return sumAB;			
		}
	}

	public Vector minusAB(Vector v) {
		System.out.println("Minus");
		Vector minusAB = new Vector(this.colnum, this.strnum);
		if ((this.colnum != v.colnum) || (this.strnum != v.strnum)) {
			System.out.println("Incorrect operation");
		return minusAB;
		} else {
			for (int i = 0; i < this.colnum; i++) {
				for (int k = 0; k < this.strnum; k++) {
					minusAB.arr[i][k] = this.arr[i][k] - v.arr[i][k];
				}
			}
		return minusAB;
		}
	}

	public Vector multAB(Vector v) {
		System.out.println("Multiplication");
		Vector multAB = new Vector(this.colnum, v.strnum);
		if (this.strnum != v.colnum) {
			System.out.println("Impossible to multiply");
			return multAB;
		} else {
			for (int i = 0; i < this.colnum; i++) {
				for (int k = 0; k < v.strnum; k++) {
					for (int t = 0; t < this.strnum; t++) {
						multAB.arr[i][k] = multAB.arr[i][k] + this.arr[i][t]
								* v.arr[t][k];
					}
				}
			}
			return multAB;
		}
		
	}

	public Vector trans() {
		System.out.println("Transposition");
		Vector trans = new Vector(this.strnum, this.colnum);
		for (int i = 0; i < this.colnum; i++) {
			for (int k = 0; k < this.strnum; k++) {
				trans.arr[i][k] = this.arr[k][i];
			}
		}
		
		return trans;
	}

	public Vector multnum(double num) {
		System.out.println("Multiply with number");
		Vector multnum = new Vector(this.colnum, this.strnum);
		for (int i = 0; i < this.colnum; i++) {
			for (int k = 0; k < this.strnum; k++) {
				multnum.arr[i][k] = num * this.arr[i][k];
			}
		}
	return multnum;	
	}
}