package com.client.music;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class _NoteTest
{
	@Test
	public void should_produce_Note_C_ID_0()
	{
		JNote sut = JNote.C;
		
		assertEquals(0, sut.getId());
		assertEquals("C", sut.getName());
		assertEquals(JNote.D_FLAT, sut.getMinorSecond());
		assertEquals(JNote.D, sut.getMajorSecond());
		assertEquals(JNote.E_FLAT, sut.getMinorThird());
		assertEquals(JNote.E, sut.getMajorThird());
		assertEquals(JNote.F, sut.getPerfectFourth());
		assertEquals(JNote.G, sut.getPerfectFifth());
		assertEquals(JNote.A_FLAT, sut.getMinorSixth());
		assertEquals(JNote.A, sut.getMajorSixth());
		assertEquals(JNote.B_FLAT, sut.getMinorSeventh());
		assertEquals(JNote.B, sut.getMajorSeventh());

	}
	@Test
	public void should_produce_Note_C_Sharp_ID_1()
	{
		JNote sut = JNote.C_SHARP;
		
		assertEquals(1, sut.getId());
		assertEquals("C#", sut.getName());
		assertEquals(JNote.D, sut.getMinorSecond());
		assertEquals(JNote.D_SHARP, sut.getMajorSecond());
		assertEquals(JNote.E, sut.getMinorThird());
		assertEquals(JNote.E_SHARP, sut.getMajorThird());
		assertEquals(JNote.F_SHARP, sut.getPerfectFourth());
		assertEquals(JNote.G_SHARP, sut.getPerfectFifth());
		assertEquals(JNote.A, sut.getMinorSixth());
		assertEquals(JNote.A_SHARP, sut.getMajorSixth());
		assertEquals(JNote.B, sut.getMinorSeventh());
		assertEquals(JNote.B_SHARP, sut.getMajorSeventh());
	}
	
	@Test
	public void should_produce_Note_D_ID_2()
	{
		JNote sut = JNote.D;
		
		assertEquals(2, sut.getId());
		assertEquals("D", sut.getName());
		assertEquals(JNote.E_FLAT, sut.getMinorSecond());
		assertEquals(JNote.E, sut.getMajorSecond());
		assertEquals(JNote.F, sut.getMinorThird());
		assertEquals(JNote.F_SHARP, sut.getMajorThird());
		assertEquals(JNote.G, sut.getPerfectFourth());
		assertEquals(JNote.A, sut.getPerfectFifth());
		assertEquals(JNote.B_FLAT, sut.getMinorSixth());
		assertEquals(JNote.B, sut.getMajorSixth());
		assertEquals(JNote.C, sut.getMinorSeventh());
		assertEquals(JNote.C_SHARP, sut.getMajorSeventh());
	}
	
	@Test
	public void should_produce_Note_F_ID_5()
	{
		JNote sut = JNote.F;
		
		assertEquals(5, sut.getId());
		assertEquals("F", sut.getName());
		assertEquals(JNote.G_FLAT, sut.getMinorSecond());
		assertEquals(JNote.G, sut.getMajorSecond());
		assertEquals(JNote.A_FLAT, sut.getMinorThird());
		assertEquals(JNote.A, sut.getMajorThird());
		assertEquals(JNote.B_FLAT, sut.getPerfectFourth());
		assertEquals(JNote.C, sut.getPerfectFifth());
		assertEquals(JNote.D_FLAT, sut.getMinorSixth());
		assertEquals(JNote.D, sut.getMajorSixth());
		assertEquals(JNote.E_FLAT, sut.getMinorSeventh());
		assertEquals(JNote.E, sut.getMajorSeventh());
	}

	@Test
	public void should_produce_Note_F_SHARP_ID_6()
	{
		JNote sut = JNote.F_SHARP;
		
		assertEquals(6, sut.getId());
		assertEquals("F#", sut.getName());
		assertEquals(JNote.G, sut.getMinorSecond());
		assertEquals(JNote.G_SHARP, sut.getMajorSecond());
		assertEquals(JNote.A, sut.getMinorThird());
		assertEquals(JNote.A_SHARP, sut.getMajorThird());
		assertEquals(JNote.B, sut.getPerfectFourth());
		assertEquals(JNote.C_SHARP, sut.getPerfectFifth());
		assertEquals(JNote.D, sut.getMinorSixth());
		assertEquals(JNote.D_SHARP, sut.getMajorSixth());
		assertEquals(JNote.E, sut.getMinorSeventh());
		assertEquals(JNote.E_SHARP, sut.getMajorSeventh());
	}
	
	@Test
	public void should_produce_Note_A_SHARP_ID_10()
	{
		JNote sut = JNote.A_SHARP;
		
		assertEquals(10, sut.getId());
		assertEquals("A#", sut.getName());
		assertEquals(JNote.C_DOUBLE_SHARP, sut.getMajorThird());
		assertEquals(JNote.E_DOUBLE_SHARP, sut.getAugmentedFifth());
		
	
	}
	
	


}
