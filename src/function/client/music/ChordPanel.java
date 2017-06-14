package music;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChordPanel extends JPanel {
	private JLabel fifthTextField;
	private JLabel thirdTextField;
	private JLabel rootTextField;
	private JLabel quality;
	private JLabel degreeTextField;

	public ChordPanel(Chord chord, String name) {
		JPanel p1 = new JPanel(new GridLayout(5, 4));

		fifthTextField = new JLabel(chord.getChord()[0].getName());
		thirdTextField = new JLabel(chord.getChord()[1].getName());
		rootTextField = new JLabel(chord.getChord()[2].getName());
		quality = new JLabel(chord.getQuality() + "");
		degreeTextField = new JLabel(name);

		p1.add(rootTextField);
		p1.add(thirdTextField);
		p1.add(fifthTextField);
		p1.add(quality);
		p1.add(degreeTextField);

		setBorder(BorderFactory.createBevelBorder(1));
		add(p1);

	}

}
