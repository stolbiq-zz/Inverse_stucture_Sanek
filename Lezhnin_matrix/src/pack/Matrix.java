package pack;

public class Matrix extends Vector {
	public Matrix(int col, int str) {
		super(col, str);
	}

	protected int max = this.strnum;
	protected int n;
	protected int transpositions[] = new int[max];
	protected boolean used[] = new boolean[max];
	protected double det = 0;
	protected double buf;
	protected int sign;

	// determinant
	private final void finish() {
		sign = 0;
		buf = 1;
		for (int i = 0; i < n; i++) {
			// System.out.println(p[i]);
			buf = buf * this.arr[i][transpositions[i]];
			// System.out.println(buf);
			for (int k = i; k < n; k++) {
				if (transpositions[i] > transpositions[k]) {
					sign++;
				}

			}
		}
		// System.out.println(buf);
		buf = buf * (int) Math.pow(-1, sign);
		det = det + buf;
		// System.out.println(det);
	}

	private final void step(int k) {
		if (k == n)
			finish();
		else {
			for (int i = 0; i < n; i++)
				if (!used[i]) {
					used[i] = true;
					transpositions[k] = i;
					step(k + 1);
					used[i] = false;
				}
		}

	}

	public double detMatrixA() throws  MistakeImpossibleToCalculate{
		det = 0;
		if (this.strnum != this.colnum){
			throw new MistakeImpossibleToCalculate();
			//return 0;
		} else {
			n = this.strnum;
			for (int i = 0; i < n; i++)
				used[i] = false;
			step(0);
			// System.out.println("detA=" + det);

			return det;
		}
	}

	// end of determinant calculation

	public Matrix inverse() throws MistakeNullDet, MistakeImpossibleToCalculate{
		int flag_str = 0;
		int flag_col = 0;
		Matrix invMat = new Matrix(this.colnum, this.strnum);
		Matrix minor = new Matrix(this.colnum - 1, this.strnum - 1);
		if (this.detMatrixA() < 0.0000001 && this.detMatrixA() > -0.0000001) {
			throw new MistakeNullDet();
		} else {
			double det = this.detMatrixA();
			for (int i = 0; i < this.strnum; i++) {
				for (int k = 0; k < this.strnum; k++) {
					flag_str = 0;
					for (int j = 0; j < minor.strnum; j++) {
						if (i == j) {
							flag_str = 1;
						}
						flag_col = 0;
						for (int t = 0; t < minor.strnum; t++) {
							if (k == t) {
								flag_col = 1;
							}
							minor.arr[j][t] = this.arr[j + flag_str][t
									+ flag_col];
						}
					}
					// minor.print_matrix();
					invMat.arr[k][i] = Math.pow(-1, i + k)
							* (minor.detMatrixA()) / det;
				}
			}
		return invMat;	
		}
	}
}