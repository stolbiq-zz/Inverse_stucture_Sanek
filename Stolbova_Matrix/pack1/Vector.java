package pack1;

public class Vector {
	int[][] vectorA, vectorB;
	int strVectorA, strVectorB, colVectorA, colVectorB;
	public void Sum(int[][] vectorA,int[][] vectorB,int strVectorA,int strVectorB,int colVectorA,int colVectorB){
		new SumVectorAVectorB(vectorA, vectorB, strVectorA, strVectorB, colVectorA, colVectorB);
	}
	public void Minus(int[][] vectorA,int[][] vectorB,int strVectorA,int strVectorB,int colVectorA,int colVectorB){			
		new MinusVectorAVectorB(vectorA, vectorB, strVectorA, strVectorB, colVectorA, colVectorB);
	}
	public void Multiple(int[][] vectorA,int[][] vectorB,int strVectorA,int strVectorB,int colVectorA,int colVectorB){
		new MultipleVectorAVectorB(vectorA, vectorB, strVectorA, strVectorB, colVectorA, colVectorB);
	}
	
	public Vector(){
		ScannerReadVector point = new ScannerReadVector();
		vectorA = point.vectorA;
		vectorB = point.vectorB;
		strVectorA = point.strVectorA;
		strVectorB = point.strVectorB;
		colVectorA = point.colVectorA;
		colVectorB = point.colVectorB;
		Sum(vectorA, vectorB, strVectorA, strVectorB, colVectorA, colVectorB);
		Minus(vectorA, vectorB, strVectorA, strVectorB, colVectorA, colVectorB);
		Multiple(vectorA, vectorB, strVectorA, strVectorB, colVectorA, colVectorB);
	}
}
