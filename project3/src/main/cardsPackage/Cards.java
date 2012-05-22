package cardsPackage;

import java.util.*;

// собственно, класс карточек веществ
public class Cards {
	protected String name;
	// элементный состав
	// protected int[] composotion = new int[118];
	// если что, lattice - крист решетка по англицки
	// содержать будет что-то в духе D, H, D3 и т.п.
	protected String latticeType;
	ArrayList<Peaks> peaksList = new ArrayList<Peaks>(20);
	protected double fom3, fom8;
	final double thetaError = 0.5;
	final double intensityError = 10;
	public final int NUMBEROFPEAKS = 8;

	
	public Cards (){
	}
	
	public Cards (String name, String latticeType){
		this.name = name;
		this.latticeType = latticeType;
	}
	
	public void calcTheta (double waveLength) {
		for (int i = 0; i < this.peaksList.size(); i++) {
			this.peaksList.get(i).theta = 2 * Math.asin(Math.pow(10, -3)*(waveLength)
					/ (2 * this.peaksList.get(i).distance)) * 180/Math.PI;
		}
	}
	
	public void sortIntensity () {
		for (int j = 0; j < this.peaksList.size(); j++) {
			Peaks max = new Peaks(this.peaksList.get(j).theta, this.peaksList.get(j).intensity, this.peaksList.get(j).distance);
			int maxIndex = j;
			for (int i = j; i < this.peaksList.size(); i++) {
				if (this.peaksList.get(i).intensity >= max.intensity) {
					max = this.peaksList.get(i);
					maxIndex = i;
				}
			}
			this.peaksList.set(maxIndex, this.peaksList.get(j));
			this.peaksList.set(j, max);
		}
	}
		
	// подсчет параметра грубого отбора (по малому числу сильнейших пиков)	
	public void fom3Calc (StrongPeaks strongPeaksExp) {
		double thetaDiffSum = 0, intensityDiffSum = 0;
		for (int i = 0; i < 3; i++) {
			thetaDiffSum = thetaDiffSum
					+ Math.abs(this.peaksList.get(i).theta - strongPeaksExp.list[i].theta);
			intensityDiffSum = intensityDiffSum
					+ Math.abs(this.peaksList.get(i).intensity - strongPeaksExp.list[i].intensity);
		}
		this.fom3 = 0.375 * (1 - thetaDiffSum / (8 * thetaError))
				* (1 - intensityDiffSum / (8 * intensityError));
		//System.out.println(this.fom3);
	}
	
	// подсчет параметра точного отбора (большее число пиков)
	// на момент коммита параметр заносится в поле fom класса Cards
	public void fom8Calc (StrongPeaks strongPeaksExp) {
		double thetaDiffSum = 0, intensityDiffSum = 0;
		for (int i = 0; i < 8; i++) {
			thetaDiffSum = thetaDiffSum
					+ Math.abs(this.peaksList.get(i).theta - strongPeaksExp.list[i].theta);
			intensityDiffSum = intensityDiffSum
					+ Math.abs(this.peaksList.get(i).intensity - strongPeaksExp.list[i].intensity);
		//System.out.println(thetaDiffSum);
		}
		this.fom8 = 0.375 * (1 - thetaDiffSum / (8 * thetaError))
				* (1 - intensityDiffSum / (8 * intensityError));
	}
}
