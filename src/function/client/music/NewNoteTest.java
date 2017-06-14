package music;
public class NewNoteTest {
	public static void main(String[] args) {
		System.out.println(JNote.C.getId());
		System.out.println(JNote.A_SHARP.getName());
		System.out.println(JNote.getNote(6, 'c'));
		System.out.println(JNote.C.getMajorSecond());
		System.out.println(JNote.C.getMinorThird());
	}
}
