package music;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jm.music.data.CPhrase;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.util.Play;

public class GameGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String[] KEY = { "C", "D", "E", "F", "G", "A", "B" };
	private static final String[] ACCIDENTALS = { "", "#", "b" };
	private static final String[] MODE = { "M", "m" };
	private JComboBox<String> modeComobBox = new JComboBox<String>(MODE);
	private JTextField numberOfChordsTextField = new JTextField(2);
	private JButton EnterButton = new JButton("Enter");
	private JButton PlayButton = new JButton("Play");
	private JButton DisplayButton = new JButton("Display");
	private JButton SubmitButton = new JButton("Submit");
	private Part p = new Part();
	private static int numberOfThreads = 0;

	public GameGui() {
		JPanel p1 = new JPanel(new FlowLayout());

		p1.add(modeComobBox);
		numberOfChordsTextField.setText("1");
		p1.add(numberOfChordsTextField);
		p1.add(EnterButton);

		add(p1);
		dispose();
		EnterButton.addActionListener(new ButtonListener1());

	}

	private class ButtonListener1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			String key = KEY[(int) (Math.random() * 7 - 1)];
			String accidental = ACCIDENTALS[((int) (Math.random() * 3))];
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

			GamePanel[] gamePanel = new GamePanel[numberChords];
			for (int i = 0; i < numberChords; i++) {
				gamePanel[i] = new GamePanel();
				frame1.add(gamePanel[i]);
			}
			frame1.add(new JLabel(key + accidental + mode));
			frame1.add(PlayButton);
			frame1.add(SubmitButton);
			frame1.add(DisplayButton);

			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.pack();
			frame1.setLocationRelativeTo(null);
			frame1.setVisible(true);
			frame1.setResizable(false);
			frame1.setBackground(Color.WHITE);

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

						PlayMidi.start();
					}

				}
			});

			DisplayButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					ChordPanel[] chordPanel = new ChordPanel[numberChords];
					for (int i = 0; i < numberChords; i++) {
						chordPanel[i] = new ChordPanel(progression
								.getProgression()[i].getChord(), progression
								.getProgression()[i].getName());
						frame1.add(chordPanel[i]);
					}
					frame1.pack();

				}
			});

			SubmitButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					double correct = 0;
					double total = 0;
					for (int i = 0; i < numberChords; i++) {
						if (progression.getProgression()[i].getName().equals(
								gamePanel[i].getFunctionComboBox()
										.getSelectedItem().toString())) {
							gamePanel[i].setColor(true);
							correct++;
							total++;
						} else {
							gamePanel[i].setColor(false);
							total++;
						}
					}
					JOptionPane.showMessageDialog(null, String.format(
							"%.0f out of %.0f chords correct.", correct, total));
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
		GameGui frame = new GameGui();
		frame.pack();
		frame.setTitle("Game Gui");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
