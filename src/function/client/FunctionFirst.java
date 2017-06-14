package function.client;


import function.client.music.Chord;
import function.client.music.Function;
import function.client.music.JNote;
import function.client.music.TestProgression;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;



public class FunctionFirst implements EntryPoint 
{
	// other

	private static final String[] KEY =	{ "C", "D", "E", "F", "G", "A", "B" };
	private static final String[] ACCIDENTALS =	{ "", "#", "b" };
	JsArrayInteger jsArrayInteger = JavaScriptObject.createArray().cast();
	private TestProgression progression = new TestProgression(JNote.A, 'M', 5);
	private char mode = ' ';
	private Button Start = new Button("Start");
	private RadioButton Major = new RadioButton("radioGroup", "Major");
	private RadioButton Minor = new RadioButton("radioGroup", "Minor");
	private ListBox NumberOfChords = new ListBox();
	private Label ErrorMsg = new Label();

	JNote note = JNote.A;
	Chord chord = new Chord(JNote.A, 'M');
	//private Part p = new Part();


	//

	private FlowPanel settings = new FlowPanel();
	private FlowPanel navigation = new FlowPanel();
	private FlowPanel commandPanel = new FlowPanel();
	private Label wordLabel = new Label("Message");
	private Label answerLabel = new Label("");
	private Image image = new Image();
	private Grid majorGrid = new Grid(4, 3);
	private Grid minorGrid = new Grid(4, 4);
	private PopupPanel settingsPop = new PopupPanel();
	private FlowPanel answerPop = new FlowPanel();

	private int location = 0;
	private String[] function =	{ "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	private String[] answers;
	private String displayAnswer = "";

	private Button Play = new Button("Play");
	private Button New = new Button("New");
	private Button Display = new Button("Display");
	private Button Submit = new Button("Submit");
	private Button a1 = new Button("1");
	private Button a2 = new Button("2");
	private Button a3 = new Button("3");
	private Button a4 = new Button("4");
	private Button a5 = new Button("5");
	private Button a6 = new Button("6");
	private Button a7 = new Button("7");
	private Button a8 = new Button("8");
	private Button a9 = new Button("9");
	private Button a10 = new Button("10");
	private Button a11 = new Button("11");
	private Button a12 = new Button("12");

	private Button I = new Button("I");
	private Button ii = new Button("ii");
	private Button iii = new Button("iii");
	private Button IV = new Button("IV");
	private Button V = new Button("V");
	private Button vi = new Button("vi");
	private Button viio = new Button("vii\u00b0");
	private Button mi = new Button("i");
	private Button miio = new Button("ii\u00b0");
	private Button miii = new Button("iii");
	private Button mbIII = new Button("bIII");
	private Button miv = new Button("iv");
	private Button mV = new Button("V");
	private Button mbVI = new Button("bVI");
	private Button mbVII = new Button("bVII");
	private Button mviio = new Button("vii\u00b0");
	private Button mVoV = new Button("V/V");
	private Button mVoii = new Button("V/ii");


	public void onModuleLoad()
	{
		
		//playProgression();
		RootPanel functionFirst = RootPanel.get("functionFirst");

		functionFirst.add(image);
		//functionFirst.add(wordLabel);
		functionFirst.add(minorGrid);
		functionFirst.add(majorGrid);
		functionFirst.add(navigation);
		functionFirst.add(answerPop);
		functionFirst.add(commandPanel);
		functionFirst.add(settingsPop);

		minorGrid.setVisible(false);

		// other
		settings.add(ErrorMsg);
		settings.add(Major);
		settings.add(Minor);
		settings.add(NumberOfChords);
		settings.add(Start);

		settings.setStyleName("commandPanel");

		settingsPop.add(settings);
		settingsPop.setGlassEnabled(true);
		settingsPop.show();
		settingsPop.center();

		answerPop.add(answerLabel);
		answerPop.setStyleName("commandPanel");
		answerPop.setVisible(false);
		answerLabel.setStyleName("answer-label");

		NumberOfChords.addItem("1");
		NumberOfChords.addItem("2");
		NumberOfChords.addItem("3");
		NumberOfChords.addItem("4");
		NumberOfChords.addItem("5");
		NumberOfChords.addItem("6");
		NumberOfChords.addItem("7");
		NumberOfChords.addItem("8");
		NumberOfChords.addItem("9");
		NumberOfChords.addItem("10");
		NumberOfChords.addItem("11");
		NumberOfChords.addItem("12");

		// wordLabel.setText(progression.toString());
		ErrorMsg.setText("Select mode and number of chords:");

		Start.setStyleName("command-buttons");

		Start.addClickHandler(new ClickHandler()
		{

			@Override
			public void onClick(ClickEvent event)
			{

				String key = KEY[(int) (Math.random() * 7 - 1)];
				String accidental = ACCIDENTALS[((int) (Math.random() * 3))];

				// reset
				a1.setVisible(true);
				a2.setVisible(true);
				a3.setVisible(true);
				a4.setVisible(true);
				a5.setVisible(true);
				a6.setVisible(true);
				a7.setVisible(true);
				a8.setVisible(true);
				a9.setVisible(true);
				a10.setVisible(true);
				a11.setVisible(true);
				a12.setVisible(true);

				displayAnswer = "";
				answerLabel.setText("");
				answerPop.setVisible(false);

				a1.removeStyleName("rightAnswer");
				a1.removeStyleName("wrongAnswer");
				a2.removeStyleName("rightAnswer");
				a2.removeStyleName("wrongAnswer");
				a3.removeStyleName("rightAnswer");
				a3.removeStyleName("wrongAnswer");
				a4.removeStyleName("rightAnswer");
				a4.removeStyleName("wrongAnswer");
				a5.removeStyleName("rightAnswer");
				a5.removeStyleName("wrongAnswer");
				a6.removeStyleName("rightAnswer");
				a6.removeStyleName("wrongAnswer");
				a7.removeStyleName("rightAnswer");
				a7.removeStyleName("wrongAnswer");
				a8.removeStyleName("rightAnswer");
				a8.removeStyleName("wrongAnswer");
				a9.removeStyleName("rightAnswer");
				a9.removeStyleName("wrongAnswer");
				a10.removeStyleName("rightAnswer");
				a10.removeStyleName("wrongAnswer");
				a11.removeStyleName("rightAnswer");
				a11.removeStyleName("wrongAnswer");
				a12.removeStyleName("rightAnswer");
				a12.removeStyleName("wrongAnswer");

				for (int i = 0; i < function.length; i++)
					function[i] = (i + 1 + "");
				setButton();
				
				jsArrayInteger.setLength(0);

				mode = ' ';
				if (Major.getValue())
					mode = 'M';
				else if (Minor.getValue())
					mode = 'm';

				if (mode == ' ')
					ErrorMsg.setText("Select a mode");
				else
				{
					JNote selected = JNote.getNote(key + accidental);
					if (selected == JNote.D_SHARP) // Temporary Patch to solve
													// D#
						// problem
						// returning CDoubleFlat
						selected = JNote.E_FLAT;

					int numberChords = NumberOfChords.getSelectedIndex() + 1;

					if (numberChords >= 1 && numberChords <= 12)
					{
						progression = new TestProgression(selected, mode, numberChords);

						answers = new String[numberChords];

						// Set Answers
						for (int i = 0; i < numberChords; i++)
						{
							answers[i] = progression.getProgression()[i].getName();
						}
						
						
					
						//Begin Test to Javascript
					//-------------------------------------------------------------------------------------
						// audio test
					
			
						//set Octaves
						int octave = 0;
						System.out.println(octave);

						for (int i = 0; i < numberChords; i++)
						{
							Chord chord = progression.getProgression()[i].getChord();
							int[] chords = new int[4];

							for(int k = 0; k < chords.length; k++)
								chords[k] = 10;
						

							//remove viio from the root
							if (progression.getProgression()[i].isEqual(Function.viio))
								chords[0] = (chord.getChord()[1].getNote());
							else
								chords[0] = (chord.getChord()[0].getNote()) - (0);

							int numbers[] = { 
									chord.getChord()[0].getNote(),
									chord.getChord()[1].getNote(),	
									chord.getChord()[2].getNote() };
							
							java.util.Arrays.sort(numbers);

							chords[1] = (numbers[0] + (12 + 0));
							chords[2] = (numbers[1] + (0 + 12));
							chords[3] = (numbers[2] + (0 + 12));

							
							jsArrayInteger.push(chords[0]);
							jsArrayInteger.push(chords[1]);
							jsArrayInteger.push(chords[2]);
							jsArrayInteger.push(chords[3]);
						}
						
						//-------------------------------------------------------------------------------------

						// Set input that won't be used to unclickable

						switch (numberChords)
						{
						case 0:
							a1.setVisible(false);
						case 1:
							a2.setVisible(false);
						case 2:
							a3.setVisible(false);
						case 3:
							a4.setVisible(false);
						case 4:
							a5.setVisible(false);
						case 5:
							a6.setVisible(false);
						case 6:
							a7.setVisible(false);
						case 7:
							a8.setVisible(false);
						case 8:
							a9.setVisible(false);
						case 9:
							a10.setVisible(false);
						case 10:
							a11.setVisible(false);
						case 11:
							a12.setVisible(false);
						}

						// Display Correct Grid
						if (mode == 'M')
						{
							minorGrid.setVisible(false);
							majorGrid.setVisible(true);
						} else if (mode == 'm')
						{
							majorGrid.setVisible(false);
							minorGrid.setVisible(true);
						}

						// creates Display String
						for (int i = 0; i < answers.length; i++)
							displayAnswer += answers[i] + " ";

						wordLabel.setText(displayAnswer);
						settingsPop.hide();
						setNavigation();

					}

				}
			}

		});

		//

		// add navigation buttons
		navigation.add(a1);
		navigation.add(a2);
		navigation.add(a3);
		navigation.add(a4);
		navigation.add(a5);
		navigation.add(a6);
		navigation.add(a7);
		navigation.add(a8);
		navigation.add(a9);
		navigation.add(a10);
		navigation.add(a11);
		navigation.add(a12);

		navigation.setStyleName("navigation");

		// set Button IDs
		a1.setStyleDependentName("a1", true);
		a2.setStyleDependentName("a2", true);
		a3.setStyleDependentName("a3", true);
		a4.setStyleDependentName("a4", true);
		a5.setStyleDependentName("a5", true);
		a6.setStyleDependentName("a6", true);
		a7.setStyleDependentName("a7", true);
		a8.setStyleDependentName("a8", true);
		a9.setStyleDependentName("a9", true);
		a10.setStyleDependentName("a10", true);
		a11.setStyleDependentName("a11", true);
		a12.setStyleDependentName("a12", true);

		commandPanel.add(Play);
		commandPanel.add(Display);
		commandPanel.add(Submit);
		commandPanel.add(New);

		Play.setStyleName("command-buttons");
		Display.setStyleName("command-buttons");
		New.setStyleName("command-buttons");
		Submit.setStyleName("command-buttons");

		Play.setStyleDependentName("play", true);
		Display.setStyleDependentName("display", true);
		New.setStyleDependentName("new", true);
		Submit.setStyleDependentName("submit", true);

		commandPanel.setStyleName("commandPanel");

		// set Major Grid Panel
		majorGrid.setWidget(0, 0, new Label("D"));
		majorGrid.getWidget(0, 0).setStyleName("widget-text");
		majorGrid.setWidget(0, 1, new Label("T"));
		majorGrid.getWidget(0, 1).setStyleName("widget-text");
		majorGrid.setWidget(0, 2, new Label("R"));
		majorGrid.getWidget(0, 2).setStyleName("widget-text");
		majorGrid.setWidget(1, 0, I);
		majorGrid.setWidget(1, 1, iii);
		majorGrid.setWidget(1, 2, ii);
		majorGrid.setWidget(2, 0, IV);
		majorGrid.setWidget(2, 1, V);
		majorGrid.setWidget(3, 0, vi);
		majorGrid.setWidget(3, 1, viio);

		majorGrid.setStyleName("dtr-grid");

		// set Minor Grid Panel
		minorGrid.setWidget(0, 0, new Label("D"));
		minorGrid.getWidget(0, 0).setStyleName("widget-text");
		minorGrid.setWidget(0, 1, new Label("T"));
		minorGrid.getWidget(0, 1).setStyleName("widget-text");
		minorGrid.setWidget(0, 2, new Label("R"));
		minorGrid.getWidget(0, 2).setStyleName("widget-text");
		minorGrid.setWidget(0, 3, new Label("Te"));
		minorGrid.getWidget(0, 3).setStyleName("widget-text");
		minorGrid.setWidget(1, 0, mi);
		minorGrid.setWidget(1, 1, miii);
		minorGrid.setWidget(1, 2, miio);
		minorGrid.setWidget(1, 3, mbVII);
		minorGrid.setWidget(2, 0, miv);
		minorGrid.setWidget(2, 1, mV);
		minorGrid.setWidget(2, 2, mVoV);
		minorGrid.setWidget(2, 3, mbIII);
		minorGrid.setWidget(3, 0, mbVI);
		minorGrid.setWidget(3, 1, mviio);

		minorGrid.setStyleName("dtr-grid");

		// Set DTR IDs
		I.setStyleDependentName("I", true);
		ii.setStyleDependentName("ii", true);
		iii.setStyleDependentName("iii", true);
		IV.setStyleDependentName("IV", true);
		V.setStyleDependentName("V", true);
		vi.setStyleDependentName("vi", true);
		viio.setStyleDependentName("vii\u00b0", true);

		mi.setStyleDependentName("i", true);
		miio.setStyleDependentName("ii\u00b0", true);
		miii.setStyleDependentName("iii", true);
		mbIII.setStyleDependentName("bIII", true);
		miv.setStyleDependentName("iv", true);
		mV.setStyleDependentName("V", true);
		mVoV.setStyleDependentName("V/V", true);
		mVoii.setStyleDependentName("V/ii", true);
		mbVI.setStyleDependentName("bVI", true);
		mviio.setStyleDependentName("vii\u00b0", true);
		mbVII.setStyleDependentName("bVII", true);

		ClickHandler actionHandler = new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{

				String source = event.getSource().toString().split("buttons-")[1].split("\"")[0];
				wordLabel.setText(source);
				switch (source)
				{
				case "play":
					
					playProgression(jsArrayInteger);
					wordLabel.setText(source);
					break;
				case "display":
					answerLabel.setText(displayAnswer);
					answerPop.setVisible(true);
				case "submit":
					// wordLabel.setText(source);
					double correct = 0;
					double total = 0;
					for (int i = 0; i < function.length; i++)
					{
						if (answers[i].equals(function[i]))
						{
							switch (i)
							{
							case 0:
								a1.addStyleName("rightAnswer");
								break;
							case 1:
								a2.addStyleName("rightAnswer");
								break;
							case 2:
								a3.addStyleName("rightAnswer");
								break;
							case 3:
								a4.addStyleName("rightAnswer");
								break;
							case 4:
								a5.addStyleName("rightAnswer");
								break;
							case 5:
								a6.addStyleName("rightAnswer");
								break;
							case 6:
								a7.addStyleName("rightAnswer");
								break;
							case 7:
								a8.addStyleName("rightAnswer");
								break;
							case 8:
								a9.addStyleName("rightAnswer");
								break;
							case 9:
								a10.addStyleName("rightAnswer");
								break;
							case 10:
								a11.addStyleName("rightAnswer");
								break;
							case 11:
								a12.addStyleName("rightAnswer");
								break;
							}
							System.out.println(i + 1 + " Correct");
							correct++;
							total++;
						} else
						{
							switch (i)
							{
							case 0:
								a1.addStyleName("wrongAnswer");
								break;
							case 1:
								a2.addStyleName("wrongAnswer");
								break;
							case 2:
								a3.addStyleName("wrongAnswer");
								break;
							case 3:
								a4.addStyleName("wrongAnswer");
								break;
							case 4:
								a5.addStyleName("wrongAnswer");
								break;
							case 5:
								a6.addStyleName("wrongAnswer");
								break;
							case 6:
								a7.addStyleName("wrongAnswer");
								break;
							case 7:
								a8.addStyleName("wrongAnswer");
								break;
							case 8:
								a9.addStyleName("wrongAnswer");
								break;
							case 9:
								a10.addStyleName("wrongAnswer");
								break;
							case 10:
								a11.addStyleName("wrongAnswer");
								break;
							case 11:
								a12.addStyleName("wrongAnswer");
								break;
							}
							System.out.println(i + 1 + " Wrong");
							total++;
						}
						String score = ((correct / total)) + "";
						score = score.substring(0, 3);
						wordLabel.setText("Score: " + score);

					}
					break;
				case "new":
					wordLabel.setText(source);
					settingsPop.show();
					settingsPop.center();
					break;
				}

			}

		};

		Play.addClickHandler(actionHandler);
		Display.addClickHandler(actionHandler);
		New.addClickHandler(actionHandler);
		Submit.addClickHandler(actionHandler);

		ClickHandler handler = new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				unSelectButtons();

				// Get Source ID
				String source = event.getSource().toString().split("Button-")[1].split("\"")[0];

				if (source.contains("a"))
					location = Integer.parseInt(source.split("a")[1]) - 1;
				else
					function[location] = source;
				setButton();
				setNavigation();

				wordLabel.setText((location + 1) + " : " + function[location]);

			}

		};
		addButtonHandlers(handler);
	}


	private void unSelectButtons()
	{
		a1.setStyleName("gwt-Button-selected", false);
		a2.setStyleName("gwt-Button-selected", false);
		a3.setStyleName("gwt-Button-selected", false);
		a4.setStyleName("gwt-Button-selected", false);
		a5.setStyleName("gwt-Button-selected", false);
		a6.setStyleName("gwt-Button-selected", false);
		a7.setStyleName("gwt-Button-selected", false);
		a8.setStyleName("gwt-Button-selected", false);
		a9.setStyleName("gwt-Button-selected", false);
		a10.setStyleName("gwt-Button-selected", false);
		a11.setStyleName("gwt-Button-selected", false);
		a12.setStyleName("gwt-Button-selected", false);

		I.setStyleName("gwt-Button-selected", false);
		ii.setStyleName("gwt-Button-selected", false);
		iii.setStyleName("gwt-Button-selected", false);
		IV.setStyleName("gwt-Button-selected", false);
		V.setStyleName("gwt-Button-selected", false);
		vi.setStyleName("gwt-Button-selected", false);
		viio.setStyleName("gwt-Button-selected", false);

		mi.setStyleName("gwt-Button-selected", false);
		miio.setStyleName("gwt-Button-selected", false);
		miii.setStyleName("gwt-Button-selected", false);
		mbIII.setStyleName("gwt-Button-selected", false);
		miv.setStyleName("gwt-Button-selected", false);
		mV.setStyleName("gwt-Button-selected", false);
		mVoV.setStyleName("gwt-Button-selected", false);
		mVoii.setStyleName("gwt-Button-selected", false);
		mbVI.setStyleName("gwt-Button-selected", false);
		mviio.setStyleName("gwt-Button-selected", false);
		mbVII.setStyleName("gwt-Button-selected", false);
	}

	private void setNavigation()
	{
		switch (function.length - 1)
		{
		case 11:
			a12.setText(function[11]);
		case 10:
			a11.setText(function[10]);
		case 9:
			a10.setText(function[9]);
		case 8:
			a9.setText(function[8]);
		case 7:
			a8.setText(function[7]);
		case 6:
			a7.setText(function[6]);
		case 5:
			a6.setText(function[5]);
		case 4:
			a5.setText(function[4]);
		case 3:
			a4.setText(function[3]);
		case 2:
			a3.setText(function[2]);
		case 1:
			a2.setText(function[1]);
		case 0:
			a1.setText(function[0]);
		}
	}

	private void setButton()
	{
		if (function[location] != null)
		{
			wordLabel.setText((location + 1) + " : " + function[location]);
			switch (function[location])
			{
			case "I":
				I.setStyleName("gwt-Button-selected", true);
				break;
			case "ii":
				ii.setStyleName("gwt-Button-selected", true);
				break;
			case "iii":
				if (mode == 'M')
					iii.setStyleName("gwt-Button-selected", true);
				else
					miii.setStyleName("gwt-Button-selected", true);
				break;
			case "IV":
				IV.setStyleName("gwt-Button-selected", true);
				break;
			case "V":
				if (mode == 'M')
					V.setStyleName("gwt-Button-selected", true);
				else
					mV.setStyleName("gwt-Button-selected", true);
				break;
			case "vi":
				vi.setStyleName("gwt-Button-selected", true);
				break;
			case "vii\u00b0":
				if (mode == 'M')
					viio.setStyleName("gwt-Button-selected", true);
				else
					mviio.setStyleName("gwt-Button-selected", true);
				break;
			case "i":
				mi.setStyleName("gwt-Button-selected", true);
				break;
			case "ii\u00b0":
				miio.setStyleName("gwt-Button-selected", true);
				break;
			case "bIII":
				mbIII.setStyleName("gwt-Button-selected", true);
				break;
			case "iv":
				miv.setStyleName("gwt-Button-selected", true);
				break;
			case "bVI":
				mbVI.setStyleName("gwt-Button-selected", true);
				break;
			case "bVII":
				mbVII.setStyleName("gwt-Button-selected", true);
				break;
			case "V/V":
				mVoV.setStyleName("gwt-Button-selected", true);
				break;
		
			}
		} else if (location < function.length)
			wordLabel.setText((location + 1) + " : ");
		switch (location)
		{
		case 0:
			a1.setStyleName("gwt-Button-selected", true);
			break;
		case 1:
			a2.setStyleName("gwt-Button-selected", true);
			break;
		case 2:
			a3.setStyleName("gwt-Button-selected", true);
			break;
		case 3:
			a4.setStyleName("gwt-Button-selected", true);
			break;
		case 4:
			a5.setStyleName("gwt-Button-selected", true);
			break;
		case 5:
			a6.setStyleName("gwt-Button-selected", true);
			break;
		case 6:
			a7.setStyleName("gwt-Button-selected", true);
			break;
		case 7:
			a8.setStyleName("gwt-Button-selected", true);
			break;
		case 8:
			a9.setStyleName("gwt-Button-selected", true);
			break;
		case 9:
			a10.setStyleName("gwt-Button-selected", true);
			break;
		case 10:
			a11.setStyleName("gwt-Button-selected", true);
			break;
		case 11:
			a12.setStyleName("gwt-Button-selected", true);
			break;
		}
	}

	private void addButtonHandlers(ClickHandler handler)
	{
		a1.addClickHandler(handler);
		a2.addClickHandler(handler);
		a3.addClickHandler(handler);
		a4.addClickHandler(handler);
		a5.addClickHandler(handler);
		a6.addClickHandler(handler);
		a7.addClickHandler(handler);
		a8.addClickHandler(handler);
		a9.addClickHandler(handler);
		a10.addClickHandler(handler);
		a11.addClickHandler(handler);
		a12.addClickHandler(handler);

		I.addClickHandler(handler);
		ii.addClickHandler(handler);
		iii.addClickHandler(handler);
		IV.addClickHandler(handler);
		V.addClickHandler(handler);
		vi.addClickHandler(handler);
		viio.addClickHandler(handler);

		mi.addClickHandler(handler);
		miio.addClickHandler(handler);
		miii.addClickHandler(handler);
		mbIII.addClickHandler(handler);
		miv.addClickHandler(handler);
		mV.addClickHandler(handler);
		mVoV.addClickHandler(handler);
		mVoii.addClickHandler(handler);
		mbVI.addClickHandler(handler);
		mviio.addClickHandler(handler);
		mbVII.addClickHandler(handler);

	}
	
	public static JsArrayInteger toJsArray(Integer[] progression) {
	    JsArrayInteger jsArrayInteger = JsArrayInteger.createArray().cast();
	    for (Integer s : progression) {
	        jsArrayInteger.push(s);
	    }
	    return jsArrayInteger; 
	}
	
	private native void playProgression(JsArrayInteger jsArrayInteger)
    /*-{

		$wnd.alert("Playing"); //Test to see that function gets executed.

		var note = jsArrayInteger;
		
		$wnd.MIDI.loadPlugin({
			instrument : "acoustic_grand_piano",// or the instrument code 1 (aka the default)
			onsuccess : function() {

				for (var i = 0; i < note.length; i = i + 4) {

					//(channel, note, velocity, delay)
					$wnd.MIDI.noteOn(0, note[i], 127, i - (i * .25));
					$wnd.MIDI.noteOn(0, note[i + 1], 127, i - (i * .25));
					$wnd.MIDI.noteOn(0, note[i + 2], 127, i - (i * .25));
					$wnd.MIDI.noteOn(0, note[i + 3], 127, i - (i * .25));

					$wnd.MIDI.noteOff(0, note[i], i / 2 + .25);
					$wnd.MIDI.noteOff(0, note[i + 1], i / 2 + .25);
					$wnd.MIDI.noteOff(0, note[i + 2], i / 2 + .25);
					$wnd.MIDI.noteOff(0, note[i + 3], i / 2 + .25);

				}
			}
		});

	}-*/;
	
}