public class Pokemon extends Personnage {

	public Pokemon(String nom) {
		super(nom);
	}

	public void afficher(){
		if (super.getHP()!=0) {

			System.out.println(
					"   ___\r\n"
							+ "  (ô.ô)\r\n"
							+ "   -v-\r\n"
							+ " <(   )>\r\n"
							+ "  (___)\r\n"
							+ "   m m");
		} else {
			System.out.println(
					"    -------\r\n"
							+ "  -/       \\-\r\n"
							+ " /           \\\r\n"
							+ " +-----O-----+\r\n"
							+ " \\.........../\r\n"
							+ "  -\\......./-\r\n"
							+ "    -------");
		}
	}

	public String toString() {
		String toReturn = super.toString();
		if(super.getHP()== 0) {
			toReturn+=" (capturé)";
		}
		return toReturn;
	}
	
	public void attaquer(Pokemon autre){
		System.out.println("Pika pika pika pika !!");
	}
}
