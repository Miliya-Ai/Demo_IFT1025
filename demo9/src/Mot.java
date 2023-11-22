import java.io.Serializable;

public class Mot implements Serializable{

	private String leMot;

	public Mot(String mot) {
		this.leMot = mot;
	}

	public String toString() {
		return this.leMot;
	}


}
