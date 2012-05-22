package cardsPackage;

import grafica.*;

import java.util.ArrayList;

// public static void main
public class Start {
	private ArrayList<Cards> MainList;

	public static void printMainList(ArrayList<Cards> MainList, int number) {
		for (int i = 0; i < number; i++) {
			System.out.println("name " + MainList.get(i).name);
		}
	}

	public Start(OpenList arg, String[] elements, double waveLength2) {
		// список карточек
		MainList = new ArrayList<Cards>(100);
		double waveLength = waveLength2;
		// ChemComposition parameters = new ChemComposition ();



		final double fom3notLessThan = 7.5;
		final double fom8notLessThan = 7.5;
		String fileName = "quickstart.dat";
		PeaksReader readFile = new PeaksReader(fileName);
		/*
		 * System.out.println("Listing of " + fileName);
		 * System.out.println("---------------------------");
		 * readFile.printList();
		 * System.out.println("Total number of input peaks " +
		 * readFile.listOfPeaks.size()); System.out.println();
		 */
		readFile.sortMax();
		/*
		 * System.out.println("Listing of sorted list" + fileName);
		 * System.out.println("---------------------------");
		 * readFile.printList();
		 */

		// засунуть это в main
		DataReader t1 = new DataReader();
		DataReader t2 = new DataReader();
		t1.run("base1.txt", MainList, waveLength, elements);
		t2.run("base.txt", MainList, waveLength, elements);
		// System.out.println("size " + MainList.size());
		/*
		 * System.out.println(MainList.get(2).name);
		 * 
		 * System.out.println("-----------------------");
		 */

		// readFile.printList();
		final int NUMBER=8;
		StrongPeaks strongPeaksExp = new StrongPeaks();
		strongPeaksExp.FillList(readFile.listOfPeaks);
		
		for (int i = 0; i <NUMBER/* MainList.size()*/; i++) {
			try{
			MainList.get(i).sortIntensity();
			//System.out.println(MainList.get(i).peaksList.get(0).intensity);
			//StrongPeaks strongPeaksCard = new StrongPeaks(MainList.get(i).peaksList);
			//strongPeaksCard.FillList(MainList.get(i).peaksList);
			MainList.get(i).fom8Calc(strongPeaksExp);
		} catch (Exception e) {}
		}

 
		for (int j = 0; j < NUMBER; j++) {
			Cards max = new Cards();
			max = MainList.get(j);
			int maxIndex = j;
			for (int i = j; i < MainList.size(); i++) {
				if (MainList.get(i).fom8 >= max.fom8) {
					max = MainList.get(i);
					maxIndex = i;
				}
			}
			MainList.set(maxIndex, MainList.get(j));
			MainList.set(j, max);
		}
		new Window1(arg, this);
		System.out.println(getLength(0));
	}
	public String getName(int i){
		return MainList.get(i).name;
	}
	public String getLatticeType(int i){
		return MainList.get(i).latticeType;
	}
	public double getFom(int i){
		return MainList.get(i).fom8;
	}
	public double getXPeak(int i, int j){
		return MainList.get(i).peaksList.get(j).theta;
	}
	public double getYPeak(int i, int j){
		return MainList.get(i).peaksList.get(j).intensity;
	}
	public int getLength(int i){
		return MainList.get(i).peaksList.size();
	}
}
