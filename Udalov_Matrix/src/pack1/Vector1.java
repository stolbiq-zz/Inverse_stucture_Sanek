package pack1;
import java.util.*;

public class Vector1 {
	//col - length of column;
	//str - length of string;
	protected int col, str;
	protected ArrayList<Integer> arr;
	
	Vector1(int m, int n){
		ArrayList <Integer> array = new ArrayList<Integer>();
		for (int i=0; i<m*n; i++){
			array.add(new Integer(0));
		}
		arr = array;
		col = m;
		str = n;
	}
	
	public void setElement(int i, int j, int p){
		this.arr.set(str*i+j, p);
	}
	
	public Integer getElement(int i, int j){
		return (Integer) arr.get(str*i+j);
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
				System.out.print(arr.get(str*i+j) + " ");
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
					sumAB.setElement(i, j, this.getElement(i, j)+v.getElement(i, j));
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
					minAB.setElement(i, j, this.getElement(i, j)-v.getElement(i, j));
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
						multAB.setElement(i, j, multAB.getElement(i,j) + this.getElement(i,t) * v.getElement(t,j));
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
				iMult.setElement(i, j, this.getElement(i,j)*a);
			}
		}
		return (iMult);
	}
}