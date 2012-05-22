package cardsPackage;

import grafica.OpenList;

public class ChemComposition extends OpenList{
	
	double waveLength;
	String[] elements;
	String fileName;
	public ChemComposition(OpenList arg){
		waveLength = WAVE;
		elements = ELEMENTS;
		fileName = FILENAME;
		System.out.println(waveLength);
		new Start(arg, elements, waveLength);
	}

}
