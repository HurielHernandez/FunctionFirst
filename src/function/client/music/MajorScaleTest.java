package music;
public class MajorScaleTest {
	public static void main(String[] args) {
		MajorScale scale = new MajorScale(JNote.A);
		JNote[] test = scale.getScale();

		for (int i = 1; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
	}
}
