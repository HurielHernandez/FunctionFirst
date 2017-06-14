package music;
public class Progression {

	private JNote root;
	private char quality;
	private int numberOfChords;
	private Chord[] progression;
	private MajorScale degree;

	public Progression(JNote root, char quality, int numberOfChords) {
		this.root = root;
		this.quality = quality;
		this.numberOfChords = numberOfChords;
		progression = new Chord[numberOfChords];
		degree = new MajorScale(root);

		setRegression();
	}

	public void setRegression() {
		progression[0] = new Chord(root, quality);
		progression[0].setDegree(1);
		progression[numberOfChords - 1] = new Chord(root, quality);
		progression[numberOfChords - 1].setDegree(1);

		for (int i = numberOfChords - 1; i > 1; i--) {
			Chart previous = new Chart(progression[i].getDegree(), 'b');
			int idegree = previous.getNext();
			char quality = degree.getQuality(idegree);
			Chord chord = new Chord(degree.getDegree(idegree), quality);
			chord.setDegree(previous.getNext());
			progression[i - 1] = chord;
		}
	}

	public void setProgression() {
		progression[0] = new Chord(root, quality);
		progression[0].setDegree(1);

		for (int i = 1; i < progression.length; i++) {
			Chart next = new Chart(progression[i - 1].getDegree(), 'n');
			char quality = degree.getQuality(next.getNext());
			Chord chord = new Chord(degree.getDegree(next.getNext()), quality);
			chord.setDegree(next.getNext());
			progression[i] = chord;
		}
	}

	public void displayProgression() {
		for (int i = 0; i < progression.length; i++) {
			System.out.println(progression[i].toString()
					+ (progression[i].getDegree())
					+ (progression[i].getQuality()));
		}
	}

	public Chord getChord(int chordNumber) {
		return progression[chordNumber];
	}

}
