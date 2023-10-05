public class Humain extends Personnage {

	public Humain(String nom) {
		super(nom);
	}

	public void afficher() {

		if (super.getHP()==0) {
			System.out.println("	       -----\r\n"
					+ "	      ( x.x )\r\n"
					+ "	       -----\r\n"
					+ "	         |\r\n"
					+ "	      <--|-->\r\n"
					+ "	        / \\\r\n"
					+ "	       /   \\");
		} else {
			System.out.println("       -----\r\n"
					+ "      ( o.o )\r\n"
					+ "       -----\r\n"
					+ "         |\r\n"
					+ "      <--|-->\r\n"
					+ "        / \\\r\n"
					+ "       /   \\");
		}
	}

}
