package com.soumya.conf.request;

import static org.junit.Assert.*;

import org.junit.Test;

import com.soumya.conf.Proposal;

public class RequestValidatorTest {

	@Test
	public void testValidateAndGetWhenTitleIsMoreThanMaxLimit() {
		try {
			RequestValidator.validateAndGet("Writing Fast Tests Against Enterprise Rails 181min");
			fail();
		} catch (ValidationException e) {
			assertEquals("Invalid Input: max duration should be 180min", e.getMessage());
		}
	}
	
	@Test
	public void testValidateAndGetWhenDurationIsLessThanMinLimit() {
		try {
			RequestValidator.validateAndGet("Writing Fast Tests Against Enterprise Rails 4min");
			fail();
		} catch (ValidationException e) {
			assertEquals("Invalid Input: min duration should be 5min", e.getMessage());
		}
	}
	
	@Test
	public void testValidateAndGetWhenDurationIsMissing() {
		try {
			RequestValidator.validateAndGet("Writing Fast Tests Against Enterprise Rails");
			fail();
		} catch (ValidationException e) {
			assertEquals("Invalid Input: duration is missing", e.getMessage());
		}
	}
	
	@Test
	public void testValidateAndGetWhenDurationIsLightning() {
		try {
			Proposal proposal = RequestValidator.validateAndGet("Writing Fast Tests Against Enterprise Rails lightning");
			assertEquals(5, proposal.getDurationInMinutes());
		} catch (ValidationException e) {
			fail();
		}
	}	
	
	@Test
	public void testValidateAndGetWhenTitleIsEmpty() {
		try {
			RequestValidator.validateAndGet("60min");
			fail();
		} catch (ValidationException e) {
			assertEquals("Invalid Input: title cann't be empty", e.getMessage());
		}
	}
	
	@Test
	public void testValidateAndGetWhenTitleIsSpace() {
		try {
			RequestValidator.validateAndGet(" 60min");
			fail();
		} catch (ValidationException e) {
			assertEquals("Invalid Input: title cann't be empty", e.getMessage());
		}
	}
	
	@Test
	public void testValidateAndGetWithEmptyInput() {
		try {
			RequestValidator.validateAndGet("");
			fail();
		} catch (ValidationException e) {
			assertEquals("Invalid Input: input cann't be empty", e.getMessage());
		}
	}
}
