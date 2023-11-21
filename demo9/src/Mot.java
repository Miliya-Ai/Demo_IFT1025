import java.io.Serializable;

public class Mot implements Serializable, Parlable {

	private String leMot;

	public Mot(String mot) {
		this.leMot = mot;
	}

	public void parle() {
		System.out.println(this.leMot);
	}

	public String toString() {
		return this.leMot;
	}

	public void traduire(String n) {
		this.leMot = n;
	}

}
