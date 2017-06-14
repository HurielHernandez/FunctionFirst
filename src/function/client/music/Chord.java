package function.client.music;


public class Chord {
	private JNote[] chord;
	private char quality;
	private int degree;

	public Chord(JNote root, char quality) {
		chord = new JNote[3];
		this.quality = quality;

		switch (quality) 
		{
		case 'M':
			major(root);
			break;
		case 'm':
			minor(root);
			break;
		case 'd':
			diminished(root);
			break;
		case 'a':
			augmented(root);
			break;
		}
	}

	public void major(JNote root) {
		chord[0] = root;
		chord[1] = root.getMajorThird();
		chord[2] = root.getPerfectFifth();
	}

	public void minor(JNote root) {
		chord[0] = root;
		chord[1] = root.getMinorThird();
		chord[2] = root.getPerfectFifth();
	}

	public void diminished(JNote root) {
		chord[0] = root;
		chord[1] = root.getMinorThird();
		chord[2] = chord[1].getMinorThird();
	}

	public void augmented(JNote root) {
		chord[0] = root;
		chord[1] = root.getMajorThird();
		chord[2] = root.getAugmentedFifth();
	}

	public JNote[] getChord() {
		return chord;
	}

	public char getQuality() {
		return quality;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public String toString() {
		String msg = "";
		for (int i = 0; i < chord.length; i++)
			msg += (chord[i] + " ");
		return msg;
	}

}
