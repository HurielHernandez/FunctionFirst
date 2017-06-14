package com.client.music;

import jm.music.data.CPhrase;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.util.Play;
import jm.util.Write;

public class ProgressionTest
{
	public static void main(String[] args)
	{
		// Progression testProgression = new Progression(Note.C, 'M', 10);

		// testProgression.displayProgression();
		int numberOfChords = 8;
		TestProgression progression = new TestProgression(JNote.A, 'M',
				numberOfChords);

		CPhrase phrase = new CPhrase();

		for (int i = 0; i < numberOfChords; i++)
		{
			Chord chord = progression.getProgression()[i].getChord();
			Note[] chords = new Note[4];

			chords[0] = new Note(10, 2);
			chords[1] = new Note(10, 2);
			chords[2] = new Note(10, 2);
			chords[3] = new Note(10, 2);

			if (progression.getProgression()[i].isEqual(Function.viio))
				chords[0]
						.setPitch((chord.getChord()[1].getNote().getPitch()) - 12);
			else
				chords[0]
						.setPitch((chord.getChord()[0].getNote().getPitch()) - 12);

			int numbers[] =
			{ chord.getChord()[0].getNote().getPitch(),
					chord.getChord()[1].getNote().getPitch(),
					chord.getChord()[2].getNote().getPitch() };
			java.util.Arrays.sort(numbers);

			chords[1].setPitch(numbers[0] + 12);
			chords[2].setPitch(numbers[1] + 0);
			chords[3].setPitch(numbers[2] + 12);

			phrase.addChord(chords);
		}
		// System.out.println(chords[0].getPitch());

		Part p = new Part();
		p.addCPhrase(phrase);
		Write.midi(p, "ProgressionTest1.midi");
		progression.displayProgression();
		Play.midi(p);
	}
}
