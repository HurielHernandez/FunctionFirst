package music;
public class MajorScale {
	private JNote root;
	private JNote[] degree;
	private char[] quality;
	private char key;

	public MajorScale(JNote root) {
		this.root = root;
		degree = new JNote[8];
		quality = new char[8];
		key = root.getKeyScale();

		degree[1] = root;
		quality[1] = 'M';
		degree[2] = root.getMajorSecond();
		quality[2] = 'm';
		degree[3] = degree[2].getMajorSecond();
		quality[3] = 'm';
		degree[4] = degree[3].getMinorSecond();
		quality[4] = 'M';
		degree[5] = degree[4].getMajorSecond();
		quality[5] = 'M';
		degree[6] = degree[5].getMajorSecond();
		quality[6] = 'm';
		degree[7] = degree[6].getMajorSecond();
		quality[7] = 'd';

	}

	public JNote[] getScale() {
		return degree;
	}

	public JNote getDegree(int degreeNumber) {
		return degree[degreeNumber];
	}

	public char getQuality(int degreeNumber) {
		return quality[degreeNumber];
	}
}
