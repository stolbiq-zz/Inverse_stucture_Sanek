package pack1;

public class Matrix extends Vector {
	int[][] matrixA;
	int[][] matrixB;
	int strMatrixA, strMatrixB, colMatrixA, colMatrixB;
	public Matrix(){
		ScannerReadMatrix scanner = new ScannerReadMatrix();
		matrixA = scanner.matrixA;
		matrixB = scanner.matrixB;
		strMatrixA = scanner.strMatrixA;
		strMatrixB = scanner.strMatrixB;
		colMatrixA = scanner.colMatrixB;
		colMatrixB = scanner.colMatrixB;
		super.Sum(matrixA, matrixB, strMatrixA, strMatrixB, colMatrixA, colMatrixB);
		super.Minus(matrixA, matrixB, strMatrixA, strMatrixB, colMatrixA, colMatrixB);
		super.Multiple(matrixA, matrixB, strMatrixA, strMatrixB, colMatrixA, colMatrixB);
	}
}