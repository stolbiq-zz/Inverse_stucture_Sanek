/*package pack1;

public class DetMatrixA extends ScannerReadMatrix {
	private int max=colMatrixA;
	private int n;
	private int p[] = new int[max];
	private boolean used[] = new boolean[max];
	private int det=0;
	private int buf;
	private int sign;
	
	public final void finish(int[][] matrixA,int str){
		sign=0;
		buf=1; 
		for (int i=0; i<str; i++){
			//System.out.println(p[i]);
			buf=buf*matrixA[i][p[i]];
			//System.out.println(buf);
			for(int k=i; k<str; k++){
				if(p[i]>p[k]){
					sign++;
				}
			}
		}
		buf=buf*(int)Math.pow(-1, sign); 
		det=det+buf;
	}

	public final void step(int k){
		if (k==n) finish(matrixA, n);
		else{
			for (int i=0;i<n;i++) 
				if (!used[i]) {
					used[i] = true;
					p[k] = i;
					step(k+1);
					used[i] = false;
				}
		}	
	}
	public DetMatrixA(int[][] matrixA, int n){
		this.finish(matrixA, n);
		System.out.println("Determinante");
		//n=colMatrixA;
		for (int i=0;i<n;i++) used[i] = false;
		step (0);
		System.out.println("detA="+det);
		System.out.println("_________________");
	}
} */           	     	
