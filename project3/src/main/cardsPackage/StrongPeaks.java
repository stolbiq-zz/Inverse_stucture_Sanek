package cardsPackage;

import java.util.ArrayList;

// получение из экспериментальной дифрактограммы списка "главных" максимумов, 
// вычисление параметра fom (figure of merit), сортировка списка по этому параметру
public class StrongPeaks {

	public final int NUMBEROFPEAKS = 8;
	public Peaks[] list = new Peaks[NUMBEROFPEAKS];

	public StrongPeaks() {
	}
	
	public StrongPeaks(ArrayList <Peaks> peaksList) {
		for (int i = 0; i < NUMBEROFPEAKS; i++) {
			list[i] = peaksList.get(i);
		}
	}
	
	
	// заводится список самых сильных пиков
	public void FillList (ArrayList <Peaks> peaksList) {
		for (int i = 0; i < NUMBEROFPEAKS; i++) {
			list[i] = peaksList.get(i);
		}
	}
	
	// распечатка списка
	public void print() {
		for (int i = 0; i < NUMBEROFPEAKS; i++) {
			System.out.println(this.list[i].theta + " "
					+ this.list[i].intensity);
		}
	}
}
