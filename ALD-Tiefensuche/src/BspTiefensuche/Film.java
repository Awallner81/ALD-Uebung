package BspTiefensuche;

public class Film implements Comparable<Film> {

	private final String titel;
	
	private final double l�nge;

	public Film(String titel, double l�nge) {
		this.titel = titel;
		this.l�nge = l�nge;
	}

	public String getTitel() {
		return titel;
	}

	public double getL�nge() {
		return l�nge;
	}

	@Override
	public String toString() {
		return titel + " (L�nge: " + l�nge + ")";
	}

	@Override
	public int compareTo(Film arg0) {

		if (this.l�nge > arg0.getL�nge())
			return 1;
		else if (this.l�nge < arg0.getL�nge())
			return -1;
		return 0;

	}

}
