package music;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _ChordTest
{
	@Test
	public void should_get_Major_Chord()
	{
		Chord sut = new Chord(JNote.C, 'M');
		
		assertEquals("Root", JNote.C, sut.getChord()[0]);
		assertEquals("Third", JNote.E, sut.getChord()[1]);
		assertEquals("Fifth", JNote.G, sut.getChord()[2]);
	} 
	
	@Test
	public void should_get_Minor_Chord()
	{
		Chord sut = new Chord(JNote.F, 'm');
		
		assertEquals("Root", JNote.F, sut.getChord()[0]);
		assertEquals("Third", JNote.A_FLAT, sut.getChord()[1]);
		assertEquals("Fifth", JNote.C, sut.getChord()[2]);
	} 
	
	@Test
	public void should_get_e_diminished()
	{
		Chord sut = new Chord(JNote.E, 'd');
		
		assertEquals("Root", JNote.E, sut.getChord()[0]);
		assertEquals("Third", JNote.G, sut.getChord()[1]);
		assertEquals("Fifth", JNote.B_FLAT, sut.getChord()[2]);
	}
	
	@Test
	public void should_get_Diminished_Chord()
	{
		Chord sut = new Chord(JNote.A, 'd');
		
		assertEquals("Root", JNote.A, sut.getChord()[0]);
		assertEquals("Third", JNote.C, sut.getChord()[1]);
		assertEquals("Fifth", JNote.E_FLAT, sut.getChord()[2]);
	} 
	
	@Test
	public void should_get_Augmented_Chord()
	{
		Chord sut = new Chord(JNote.E, 'a');
		
		assertEquals("Root", JNote.E, sut.getChord()[0]);
		assertEquals("Third", JNote.G_SHARP, sut.getChord()[1]);
		assertEquals("Fifth", JNote.B_SHARP, sut.getChord()[2]);
	}
	
	@Test
	public void should_get_Augmented_Chord_F_SHARP()
	{
		Chord sut = new Chord(JNote.F_SHARP, 'a');
		
		assertEquals("Root", JNote.F_SHARP, sut.getChord()[0]);
		assertEquals("Third", JNote.A_SHARP, sut.getChord()[1]);
		assertEquals("Fifth" + sut.getChord()[2].getId() , JNote.C_DOUBLE_SHARP, sut.getChord()[2]);
	}
	
	@Test
	public void should_get_Augmented_Chord_A_SHARP()
	{
		Chord sut = new Chord(JNote.A_SHARP, 'a');
				
		assertEquals("Root", JNote.A_SHARP, sut.getChord()[0]);
		assertEquals("Third"  + sut.getChord()[1].getId(), JNote.C_DOUBLE_SHARP, sut.getChord()[1]);
		assertEquals("Fifth", JNote.E_DOUBLE_SHARP, sut.getChord()[2]);
	}
	 
	@Test
	public void should_get_major_Chord_A_SHARP()
	{
		Chord sut = new Chord(JNote.A_SHARP, 'M');
		
		assertEquals("Root", JNote.A_SHARP, sut.getChord()[0]);
		assertEquals("Third", JNote.C_DOUBLE_SHARP, sut.getChord()[1]);
		assertEquals("Fifth", JNote.E_SHARP, sut.getChord()[2]);
	}
	
	@Test
	public void should_get_major_Chord_F_SHARP()
	{
		Chord sut = new Chord(JNote.F_SHARP, 'M');
		
		assertEquals("Root", JNote.F_SHARP, sut.getChord()[0]);
		assertEquals("Third", JNote.A_SHARP, sut.getChord()[1]);
		assertEquals("Fifth", JNote.C_SHARP, sut.getChord()[2]);
	}
	
}
