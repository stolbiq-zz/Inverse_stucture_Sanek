package grafica;

import java.util.ArrayList;

public class MatterList {
	private ArrayList<String> matter;
	public MatterList(){
		matter = new ArrayList<String>();
		matter.add("H");
		matter.add("Li");
		matter.add("B");
		matter.add("C");
		matter.add("N");
		matter.add("O");
		matter.add("F");
		matter.add("Na");
		matter.add("Mg");
		matter.add("Al");
		matter.add("Si");
		matter.add("P");
		matter.add("S");
		matter.add("Cl");
		matter.add("K");
		matter.add("Ca");
		matter.add("Cr");
		matter.add("Mn");
		matter.add("Fe");
		matter.add("Co");
		matter.add("Ni");
		matter.add("Cu");
		matter.add("Zn");
		matter.add("As");
		matter.add("Br");
		matter.add("Sr");
		matter.add("Mo");
		matter.add("Ag");
		matter.add("Cd");
		matter.add("Sn");
		matter.add("Sb");
		matter.add("Te");
		matter.add("I");
		matter.add("Cs");
		matter.add("Ba");
		matter.add("La");
		matter.add("Ce");
		matter.add("W");
		matter.add("Hg");
		matter.add("Pb");

	}
	public boolean correctMatter(String name){
		return matter.contains(name.trim());
	}
}