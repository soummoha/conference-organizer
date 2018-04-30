package com.soumya.conf.util;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

public class FormatterTest {

	@Test
	public void testFormatLocalTime() {
		assertEquals( "01:45AM", Formatter.format(LocalTime.of(1, 45)));
		assertEquals( "03:30PM", Formatter.format(LocalTime.of(15, 30)));
		assertEquals( "02:00PM", Formatter.format(LocalTime.of(14, 0)));
		assertEquals( "10:15AM", Formatter.format(LocalTime.of(10, 15)));
	}

	@Test
	public void testFormatInt() {
		assertEquals( "60min", Formatter.format(60));
		assertEquals( "lightning", Formatter.format(5));
		assertTrue( Formatter.format(0).isEmpty());
	}

}
