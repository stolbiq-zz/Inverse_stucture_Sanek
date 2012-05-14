package grafica;

import java.util.Vector;

public class MatterList {
	private static Vector<String> matter;
	public MatterList(){
		matter = new Vector<String>();
		matter.add("Mg");
		matter.add("Ba");
		matter.add("Mn");
		matter.add("Be");
		matter.add("St");
	}
	public boolean correctMatter(String name){
		return matter.contains(name);
	}
}