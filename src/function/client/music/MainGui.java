package music;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jm.music.data.CPhrase;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.util.Play;

public class MainGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String[] KEY = { "C", "D", "E", "F", "G", "A", "B" };
	private static final String[] ACCIDENTALS = { "", "#", "b" };
	private static final String[] MODE = { "M", "m" };
	private JComboBox<String> keyComboBox = new JComboBox<String>(KEY);
	private JComboBox<String> accidentalComboBox = new JComboBox<String>(
			ACCIDENTALS);
	private JComboBox<String> modeComobBox = new JComboBox<String>(MODE);
	private JTextField numberOfChordsTextField = new JTextField(2);
	private JButton EnterButton = new JButton("Enter");
	private JButton PlayButton = new JButton("Play");
	private Part p = new Part();
	private static int numberOfThreads = 0;

	public MainGui() {
		JPanel p1 = new JPanel(new FlowLayout());
		p1.add(keyComboBox);
		p1.add(accidentalComboBox);
		p1.add(modeComobBox);
		numberOfChordsTextField.setText("1");
		p1.add(numberOfChordsTextField);
		p1.add(EnterButton);

		add(p1);
		EnterButton.addActionListener(new ButtonListener());

	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String key = keyComboBox.getSelectedItem().toString();
			String accidental = accidentalComboBox.getSelectedItem().toString();
			char mode = modeComobBox.getSelectedItem().toString().charAt(0);
			JNote selected = JNote.getNote(key + accidental);
			if (selected == JNote.D_SHARP) // Temporary Patch to solve D#
											// problem
											// returning CDoubleFlat
				selected = JNote.E_FLAT;

			int numberChords = Integer.parseInt(numberOfChordsTextField
					.getText());
			TestProgression progression = new TestProgression(selected, mode,
					numberChords);

			JFrame frame1 = new JFrame();
			frame1.setLayout(new FlowLayout());

			ChordPanel[] chordPanel = new ChordPanel[numberChords];
			for (int i = 0; i < numberChords; i++) {
				chordPanel[i] = new ChordPanel(
						progression.getProgression()[i].getChord(),
						progression.getProgression()[i].getName());
				frame1.add(chordPanel[i]);
			}
			frame1.add(PlayButton);
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.pack();
			frame1.setLocationRelativeTo(null);
			frame1.setVisible(true);

			play(progression, numberChords);

			PlayButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {

					if (numberOfThreads < 1) {
						Thread PlayMidi = new Thread(new Runnable() {
							@Override
							public void run() {
								Play.midi(p);
							}
						});
						numberOfThreads += 1;
						PlayMidi.start();
					}

				}
			});

		}
	}

	public void play(TestProgression progression, int numberOfChords) {
		CPhrase phrase = new CPhrase();
		for (int i = 0; i < numberOfChords; i++) {
			Chord chord = progression.getProgression()[i].getChord();
			Note[] chords = { chord.getChord()[0].getNote(),
					chord.getChord()[1].getNote(),
					chord.getChord()[2].getNote() };
			phrase.addChord(chords);
		}
		p.addCPhrase(phrase);
	}

	public static void main(String[] args) {
		MainGui frame = new MainGui();
		frame.pack();
		frame.setTitle("Chord Generator");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
