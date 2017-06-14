package com.client.music;
public class Chart {
	private int[] I = { 2, 3, 4, 5, 6, 7 };
	private int[] ii = { 5, 7 };
	private int[] iii = { 4, 6 };
	private int[] IV = { 1, 2, 5, 7 };
	private int[] V = { 1, 6, 7 };
	private int[] vi = { 2, 4 };
	private int[] vii = { 1, 5 };

	private int[] pI = { 4, 5, 7 };
	private int[] pii = { 1, 4, 6 };
	private int[] piii = { 1 };
	private int[] pIV = { 1, 3, 6 };
	private int[] pV = { 1, 2, 4, 7 };
	private int[] pvi = { 1, 3, 5 };
	private int[] pvii = { 1, 2, 4, 5 };

	private int degree;

	public Chart(int currentChord, char Direction) {
		if (Direction == 'n') {
			switch (currentChord) {
			case 1:
				nextChord(I);
				break;
			case 2:
				nextChord(ii);
				break;
			case 3:
				nextChord(iii);
				break;
			case 4:
				nextChord(IV);
				break;
			case 5:
				nextChord(V);
				break;
			case 6:
				nextChord(vi);
				break;
			case 7:
				nextChord(vii);
				break;
			}
		} else {
			switch (currentChord) {
			case 1:
				currentChord(pI);
				break;
			case 2:
				currentChord(pii);
				break;
			case 3:
				currentChord(piii);
				break;
			case 4:
				currentChord(pIV);
				break;
			case 5:
				currentChord(pV);
				break;
			case 6:
				currentChord(pvi);
				break;
			case 7:
				currentChord(pvii);
				break;
			}
		}
	}

	public void nextChord(int[] current) {
		int numberLimit = current.length;
		int next = (int) (Math.random() * numberLimit - 1);
		degree = current[next];
	}

	public int getNext() {
		return degree;
	}

	public void currentChord(int[] current) {
		int numberLimit = current.length;
		int previous = (int) (Math.random() * numberLimit);
		degree = current[previous];
	}
}
