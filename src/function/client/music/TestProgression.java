package function.client.music;
public class TestProgression {

	private JNote root;
	private char quality;
	private int numberOfChords;
	private Function[] progression;

	public TestProgression(JNote root, char quality, int numberOfChords) {
		this.root = root;
		this.quality = quality;
		this.numberOfChords = numberOfChords;
		progression = new Function[numberOfChords];

		setRegression();
	}

	public void setRegression() {
		if (quality == 'M') {
			progression[0] = Function.I;
			progression[0].setChord(root);
			progression[numberOfChords - 1] = Function.I;
			progression[numberOfChords - 1].setChord(root);

		} else {
			progression[0] = Function.i;
			progression[0].setChord(root);
			progression[numberOfChords - 1] = Function.i;
			progression[numberOfChords - 1].setChord(root);
		}

		for (int i = numberOfChords - 1; i > 1; i--) {
			TestChart previous = new TestChart(progression[i], 'b');
			progression[i - 1] = previous.getNext();
			progression[i - 1].setChord(root);
		}
	}

	public void setProgression() {
		if (quality == 'M') {
			progression[0] = Function.I;
			progression[0].setChord(root);
		} else {
			progression[0] = Function.i;
			progression[0].setChord(root);
		}

		for (int i = 1; i < progression.length; i++) {
			TestChart next = new TestChart(progression[i - 1], 'n');
			progression[i] = next.getNext();
			progression[i].setChord(root);
		}
	}

	public void displayProgression() {
		for (int i = 0; i < progression.length; i++) {
			System.out.println(progression[i].toString());
		}
	}
	
	public String toString() 
	{
		String msg = "";
		for (int i = 0; i < progression.length; i++)
			msg += (progression[i].toString() + "\n");
		return msg;
	}

	public Function[] getProgression() {
		return progression;
	}


}