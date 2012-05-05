package pack;

public class MistakeNullDet extends Exception {
	static final long serialVersionUID = 1;

	public void print() {
			System.out.println("Det=0, inverse matrix doesn't exist");
	}
}
