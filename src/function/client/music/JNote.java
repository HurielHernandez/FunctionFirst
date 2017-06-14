package function.client.music;

public class JNote {
	private final int id; // degree number, corresponds with key position on a
							// piano starting with C as 0;
	private final String noteName; // String version of the note for display
	private final char key; // denotes if key uses # or b or None.
	private final char keyScale; // used for scale to determine consequent notes
									// uses # or b
	private final char[] noteAlphabet = {'c', 'd', 'e', 'f', 'g', 'a', 'b',  }; // used
																				// //
	private final int note;


	public JNote(String noteName, int id, char key, char keyScale) {
		this.id = id;
		this.noteName = noteName;
		this.key = key;
		this.keyScale = keyScale;
		this.note = (id + 48);
		
	}

	public static final JNote C_DOUBLE_FLAT = new JNote("Cbb", 10, 'c', 'b');
	public static final JNote C_FLAT = new JNote("Cb", 11, 'c', 'b');
	public static final JNote C = new JNote("C", 0, 'c', 'N');
	public static final JNote C_SHARP = new JNote("C#", 1, 'c', '#');
	public static final JNote C_DOUBLE_SHARP = new JNote("C##", 2, 'c', '#');

	public static final JNote D_DOUBLE_FLAT = new JNote("Dbb", 0, 'd', 'b');
	public static final JNote D_FLAT = new JNote("Db", 1, 'd', 'b');
	public static final JNote D = new JNote("D", 2, 'd', '#');
	public static final JNote D_SHARP = new JNote("D#", 3, 'd', '#');
	public static final JNote D_DOUBLE_SHARP = new JNote("D##", 4, 'd', '#');

	public static final JNote E_DOUBLE_FLAT = new JNote("Ebb", 2, 'e', 'b');
	public static final JNote E_FLAT = new JNote("Eb", 3, 'e', 'b');
	public static final JNote E = new JNote("E", 4, 'e', '#');
	public static final JNote E_SHARP = new JNote("E#", 5, 'e', '#');
	public static final JNote E_DOUBLE_SHARP = new JNote("E##", 6, 'e', '#');

	public static final JNote F_DOUBLE_FLAT = new JNote("Fbb", 3, 'f', 'b');
	public static final JNote F_FLAT = new JNote("Fb", 4, 'f', 'b');
	public static final JNote F = new JNote("F", 5, 'f', 'b');
	public static final JNote F_SHARP = new JNote("F#", 6, 'f', '#');
	public static final JNote F_DOUBLE_SHARP = new JNote("F##", 7, 'f', '#');

	public static final JNote G_DOUBLE_FLAT = new JNote("Gbb", 5, 'g', 'b');
	public static final JNote G_FLAT = new JNote("Gb", 6, 'g', 'b');
	public static final JNote G = new JNote("G", 7, 'g', '#');
	public static final JNote G_SHARP = new JNote("G#", 8, 'g', '#');
	public static final JNote G_DOUBLE_SHARP = new JNote("G##", 9, 'g', '#');

	public static final JNote A_DOUBLE_FLAT = new JNote("Abb", 7, 'a', 'b');
	public static final JNote A_FLAT = new JNote("Ab", 8, 'a', 'b');
	public static final JNote A = new JNote("A", 9, 'a', '#');
	public static final JNote A_SHARP = new JNote("A#", 10, 'a', '#');
	public static final JNote A_DOUBLE_SHARP = new JNote("A##", 11, 'a', '#');

	public static final JNote B_DOUBLE_FLAT = new JNote("Bbb", 9, 'b', 'b');
	public static final JNote B_FLAT = new JNote("Bb", 10, 'b', 'b');
	public static final JNote B = new JNote("B", 11, 'b', '#');
	public static final JNote B_SHARP = new JNote("B#", 0, 'b', '#');
	public static final JNote B_DOUBLE_SHARP = new JNote("B##", 1, 'b', '#');
	


	public int getId() {
		return id;
	}
	

	public int getNote()
	{
		return note;
	}

	public String getName() {
		return noteName;
	}

	public char getKey() {
		return key;
	}

	public char getKeyScale() {
		return keyScale;
	}

	public static JNote getNote(int Id, char note) // returns the right note
													// name
													// to make a triad eg. ACE,
													// or GBD
	{
		switch (Id) {
		case 0:
			switch (note) {
			case 'b':
				return B_SHARP;
			case 'c':
				return C;
			case 'd':
				return D_DOUBLE_FLAT;
			}
		case 1:
			switch (note) {
			case 'b':
				return B_DOUBLE_SHARP;
			case 'c':
				return C_SHARP;
			case 'd':
				return D_FLAT;
			}
		case 2:
			switch (note) {
			case 'c':
				return C_DOUBLE_SHARP;
			case 'd':
				return D;
			case 'e':
				return E_DOUBLE_FLAT;
			}
		case 3:
			switch (note) {
			case 'd':
				return D_SHARP;
			case 'e':
				return E_FLAT;
			case 'f':
				return F_DOUBLE_FLAT;
			}
		case 4:
			switch (note) {
			case 'd':
				return D_DOUBLE_SHARP;
			case 'e':
				return E;
			case 'f':
				return F_FLAT;
			}
		case 5:
			switch (note) {
			case 'e':
				return E_SHARP;
			case 'f':
				return F;
			case 'g':
				return G_DOUBLE_FLAT;
			}
		case 6:
			switch (note) {
			case 'e':
				return E_DOUBLE_SHARP;
			case 'f':
				return F_SHARP;
			case 'g':
				return G_FLAT;
			}
		case 7:
			switch (note) {
			case 'f':
				return F_DOUBLE_SHARP;
			case 'g':
				return G;
			case 'a':
				return A_DOUBLE_FLAT;
			}
		case 8:
			switch (note) {
			case 'g':
				return G_SHARP;
			case 'a':
				return A_FLAT;
			}
		case 9:
			switch (note) {
			case 'g':
				return G_DOUBLE_SHARP;
			case 'a':
				return A;
			case 'b':
				return B_DOUBLE_FLAT;
			}
		case 10:
			switch (note) {
			case 'a':
				return A_SHARP;
			case 'b':
				return B_FLAT;
			case 'c':
				return C_DOUBLE_FLAT;
			}
		case 11:
			switch (note) {
			case 'a':
				return A_DOUBLE_SHARP;
			case 'b':
				return B;
			case 'c':
				return C_FLAT;
			}
		}
		return null;
	}

	public static JNote getNoteScale(int Id, char key) // Returns the matching
														// accidental according
														// to the root of the
														// scale
	{
		switch (Id) {
		case 0:
			if (key == '#')
				return B_SHARP;
			else
				return C;
		case 1:
			if (key == '#')
				return C_SHARP;
			else
				return D_FLAT;
		case 2:
			return D;

		case 3:
			if (key == '#')
				return D_SHARP;
			else
				return E_FLAT;
		case 4:
			return E;
		case 5:
			if (key == '#')
				return E_SHARP;
			else
				return F;
		case 6:
			if (key == '#')
				return F_SHARP;
			else
				return G_FLAT;
		case 7:
			return G;
		case 8:
			if (key == '#')
				return G_SHARP;
			else
				return A_FLAT;
		case 9:
			return A;
		case 10:
			if (key == '#')
				return A_SHARP;
			else
				return B_FLAT;
		case 11:
			if (key == '#' || key == 'N')
				return B;
			else
				return C_FLAT;
		}
		return null;
	}



	public String toString() {
		return noteName;
	}

	public static JNote getNote(String Note) {
		switch (Note) {
		case "Cb":
			return C_FLAT;
		case "C":
			return C;
		case "C#":
			return C_SHARP;
		case "Db":
			return D_FLAT;
		case "D":
			return D;
		case "D#":
			return D_SHARP;
		case "Eb":
			return E_FLAT;
		case "E":
			return E;
		case "Fb":
			return F_FLAT;
		case "F":
			return F;
		case "F#":
			return F_SHARP;
		case "Gb":
			return G_FLAT;
		case "G":
			return G;
		case "G#":
			return G_SHARP;
		case "Ab":
			return A_FLAT;
		case "A":
			return A;
		case "A#":
			return A_SHARP;
		case "Bb":
			return B_FLAT;
		case "B":
			return B;
		}
		return null;
	}

	public JNote getMinorSecond() {
		int tempNote = ((id + 1) % 12);
		for (int i = 0; i < noteAlphabet.length; i++)
			if (key == noteAlphabet[i])
				return JNote.getNote(tempNote, noteAlphabet[((i + 1) % 7)]);
		return null;
	}

	public JNote getMajorSecond() {
		int tempNote = ((id + 2) % 12);
		for (int i = 0; i < noteAlphabet.length; i++)
			if (key == noteAlphabet[i])
				return JNote.getNote(tempNote, noteAlphabet[((i + 1) % 7)]);
		return null;
	}

	public JNote getMinorThird() // returns the third of a note. eg. A will
	// return C. C will return E
	{
		int tempNote = ((id + 3) % 12);
		for (int i = 0; i < noteAlphabet.length; i++)
			if (key == noteAlphabet[i])
				return JNote.getNote(tempNote, noteAlphabet[((i + 2) % 7)]);
		return null;
	}

	public JNote getMajorThird() // returns the third of a note. eg. A will
									// return C. C will return E
	{
		int tempNote = ((id + 4) % 12);
		for (int i = 0; i < noteAlphabet.length; i++)
			if (this.key == noteAlphabet[i])
				return JNote.getNote(tempNote, noteAlphabet[((i + 2) % 7)]);
		return null;
	}

	public JNote getPerfectFourth() {
		int tempNote = ((id + 5) % 12);
		for (int i = 0; i < noteAlphabet.length; i++)
			if (key == noteAlphabet[i])
				return JNote.getNote(tempNote, noteAlphabet[((i + 3) % 7)]);
		return null;
	}

	public JNote getPerfectFifth() {
		int tempNote = ((id + 7) % 12);
		for (int i = 0; i < noteAlphabet.length; i++)
			if (key == noteAlphabet[i])
				return JNote.getNote(tempNote, noteAlphabet[((i + 4) % 7)]);
		return null;
	}
	
	public JNote getAugmentedFifth() {
		int tempNote = ((id + 8) % 12);
		for (int i = 0; i < noteAlphabet.length; i++)
			if (this.key == noteAlphabet[i])
				return JNote.getNote(tempNote, noteAlphabet[((i + 4) % 7)]);
		return null;
	}

	public JNote getMinorSixth() {
		int tempNote = ((id + 8) % 12);
		for (int i = 0; i < noteAlphabet.length; i++)
			if (key == noteAlphabet[i])
				return JNote.getNote(tempNote, noteAlphabet[((i + 5) % 7)]);
		return null;
	}

	public JNote getMajorSixth() {
		int tempNote = ((id + 9) % 12);
		for (int i = 0; i < noteAlphabet.length; i++)
			if (key == noteAlphabet[i])
				return JNote.getNote(tempNote, noteAlphabet[((i + 5) % 7)]);
		return null;
	}

	public JNote getMinorSeventh() {
		int tempNote = ((id + 10) % 12);
		for (int i = 0; i < noteAlphabet.length; i++)
			if (key == noteAlphabet[i])
				return JNote.getNote(tempNote, noteAlphabet[((i + 6) % 7)]);
		return null;
	}

	public JNote getMajorSeventh() {
		int tempNote = ((id + 11) % 12);
		for (int i = 0; i < noteAlphabet.length; i++)
			if (key == noteAlphabet[i])
				return JNote.getNote(tempNote, noteAlphabet[((i + 6) % 7)]);
		return null;
	}

}
