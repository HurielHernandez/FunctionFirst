package function.client.music;
public class Function {
	private char quality;
	private Chord chord;
	private String name;
	private int id;
	private JNote root = null;

	// Majors
	public static Function I = new Function("I", 'M', 0);
	public static Function ii = new Function("ii", 'm', 2);
	public static Function II = new Function("II", 'M', 2);
	public static Function iii = new Function("iii", 'm', 4);
	public static Function IV = new Function("IV", 'M', 5);
	public static Function V = new Function("V", 'M', 7);
	public static Function VV = new Function("V/V", 'M', 2); // V of V attempt
	public static Function vi = new Function("vi", 'm', 9);
	public static Function viio = new Function("vii\u00b0", 'd', 11);

	// Minors
	public static Function i = new Function("i", 'm', 0);
	public static Function iio = new Function("ii\u00b0", 'd', 2);
	public static Function miii = new Function("iii", 'm', 3);
	public static Function bIII = new Function("bIII", 'M', 3);
	public static Function iv = new Function("iv", 'm', 5);
	public static Function rV = new Function("V", 'M', 7);  //// Changed rV to V
	public static Function bVI = new Function("bVI", 'M', 8);
	public static Function bVII = new Function("bVII", 'M', 10);
	public static Function rviio = new Function("vii\u00b0", 'd', 11);

	public Function(String name, char quality, int id) {
		this.name = name;
		this.id = id;
		this.quality = quality;

	}

	public String getName() {
		return name;
	}



	public void setChord(JNote key) {

		if (isMajor() == true) {
			char minorKey = key.getKeyScale();
			int note = (id + key.getId()) % 12;
			chord = new Chord(JNote.getNoteScale(note, minorKey), quality);
		} else {
			char minorKey = key.getMinorThird().getKeyScale();
			int note = (id + key.getId()) % 12;
			chord = new Chord(JNote.getNoteScale(note, minorKey), quality);
		}
	}

	public boolean isMajor() {
		if (name == "I" || name == "ii" || name == "iii" || name == "IV"
				|| name == "V" || name == "vi" || name == "viio"
				|| name == "vii\u00b0" || name == "V/V")
			return true;
		return false;
	}

	public String toString() {
		return (name + " " + chord);
	}

	public Chord getChord() {
		return chord;
	}

	public char getQuality() {
		return quality;
	}
	
	public boolean isEqual(Function function)
	{
		return (this.name.equals(function.getName()));
	}

}
