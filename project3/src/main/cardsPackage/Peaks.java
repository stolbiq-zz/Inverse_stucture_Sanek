package cardsPackage;

// здесь информация по каждому пику
public class Peaks {
	protected double theta;
	protected double intensity;
	protected double distance;
	protected boolean maximum = false;

	public Peaks() {
	}

	public Peaks(double t, double i, double d) {
		this.theta = t;
		this.intensity = i;
		this.distance = d;
	}
	
}
