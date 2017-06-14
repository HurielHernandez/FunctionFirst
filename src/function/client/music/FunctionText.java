package com.client.music;
public class FunctionText {
	public static void main(String[] args) {

		// Function.I.setChord(Note.F);
		Function.rviio.setChord(JNote.C);
		Function.ii.setChord(JNote.F);
		Function.VV.setChord(JNote.C);

		Chord one = new Chord(JNote.C_FLAT.getPerfectFourth(), 'M');
		System.out.println("\u00b0");

		System.out.println(Function.rviio);
	}
}
