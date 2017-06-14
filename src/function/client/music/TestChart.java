package function.client.music;
public class TestChart {
	// Major
	private static final Function[] I = { Function.ii, Function.iii,Function.IV, Function.V, Function.vi, Function.viio };
	private static final Function[] ii = { Function.V, Function.viio };
	private static final Function[] iii = { Function.IV, Function.vi };
	private static final Function[] IV = { Function.I, Function.ii, Function.V,	Function.viio };
	private static final Function[] V = { Function.I, Function.vi,	Function.viio };
	private static final Function[] VV = { Function.V };
	private static final Function[] vi = { Function.ii, Function.IV };
	private static final Function[] viio = { Function.I, Function.V };
	// Major Previous Chords
	private static final Function[] pI = { Function.IV, Function.V,	Function.viio };
	private static final Function[] pii = { Function.I, Function.IV, Function.vi };
	private static final Function[] piii = { Function.I };
	private static final Function[] pIV = { Function.I, Function.iii, Function.vi };
	private static final Function[] pV = { Function.I, Function.ii,	Function.IV, Function.viio, Function.VV };
	private static final Function[] pVV = { Function.I, Function.ii, Function.IV, Function.viio, };
	private static final Function[] pvi = { Function.I, Function.iii,Function.V };
	private static final Function[] pviio = { Function.I, Function.ii,Function.IV, Function.V };
	// minor chords
	private static final Function[] i = { Function.iio, Function.bIII,Function.iv, Function.rV, Function.bVI, Function.rviio,Function.bVII };
	private static final Function[] iio = { Function.rV, Function.rviio, };
	private static final Function[] miii = { Function.iv, Function.bVI};
	private static final Function[] bIII = { Function.bVI, Function.iv };
	private static final Function[] iv = { Function.i, Function.iio };
	private static final Function[] rV = { Function.i, Function.bVI,Function.rviio };
	private static final Function[] bVI = { Function.iv, Function.iio, };
	private static final Function[] bVII = { Function.bIII, Function.iv };
	private static final Function[] rviio = { Function.i, Function.rV };
	// minor previous
	private static final Function[] pi = { Function.iv, Function.rV,Function.rviio };
	private static final Function[] piio = { Function.i, Function.iv,Function.bVI };
	private static final Function[] pmiii = {Function.i};
	private static final Function[] pbIII = { Function.i, Function.bVII };
	private static final Function[] piv = { Function.i, Function.bIII,Function.bVI, Function.bVII };
	private static final Function[] prV = { Function.i, Function.iio,	Function.rviio };
	private static final Function[] pbVI = { Function.i, Function.bIII,	Function.rV };
	private static final Function[] pbVII = { Function.i };
	private static final Function[] prviio = { Function.i, Function.iio,Function.rV };

	private Function next;

	public TestChart(Function currentFunction, char Direction) {

		if (Direction == 'n') {
			switch (currentFunction.getName()) {
			case "I":
				nextChord(I);
				break;
			case "ii":
				nextChord(ii);
				break;
			case "iii":
				nextChord(iii);
				break;
			case "IV":
				nextChord(IV);
				break;
			case "V":
				nextChord(V);
				break;
			case "V/V":
				nextChord(VV);
				break;
			case "vi":
				nextChord(vi);
				break;
			case "viio":
				nextChord(viio);
				break;
			case "i":
				nextChord(i);
				break;
			case "iio":
				nextChord(iio);
				break;
			case "bIII":
				nextChord(bIII);
				break;
			case "iv":
				nextChord(iv);
				break;
			case "rV":
				nextChord(rV);
				break;
			case "bVI":
				nextChord(bVI);
				break;
			case "bVII":
				nextChord(bVII);
				break;
			case "rviio":
				nextChord(rviio);
			}
		} else {
			//*Begin Test
			switch (currentFunction.getName()) {
			case "I":
				currentChord(pI);
				break;
			case "ii":
				currentChord(pii);
				break;
			case "iii":
				if(currentFunction.equals(Function.miii))
					currentChord(pmiii);
				else
					currentChord(piii);
				break;
			case "IV":
				currentChord(pIV);
				break;
			case "V":
				if(currentFunction.equals(Function.rV))
					currentChord(prV);
					else
					currentChord(pV);
				break;	
			case "V/V": // V/V test
				currentChord(pVV);
				break;
			case "vi":
				currentChord(pvi);
				break;
			case "vii\u00b0":
				if(currentFunction.equals(Function.rviio))
					currentChord(prviio);
					else
					currentChord(pviio);
				break;
			case "i":
				currentChord(pi);
				break;
			case "ii\u00b0":
				currentChord(piio);
				break;
			case "bIII":
				currentChord(pbIII);
				break;
			case "iv":
				currentChord(piv);
				break;
			case "bVI":
				currentChord(pbVI);
				break;
			case "bVII":
				currentChord(pbVII);
				break;

			}
		}
	}

	public void nextChord(Function[] current) {
		int numberLimit = current.length;
		int number = (int) (Math.random() * numberLimit - 1);
		next = current[number];
	}

	public Function getNext() {
		return next;
	}

	public void currentChord(Function[] current) {
		int numberLimit = current.length;
		int number = (int) (Math.random() * numberLimit);
		next = current[number];
	}
}
