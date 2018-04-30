package com.soumya.conf.request;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.soumya.conf.Proposal;
import com.soumya.conf.organize.Organizer;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RequestProcessor.class })
public class RequestProcessorTest {

	@Mock
	private Organizer organizer;
	
	private RequestProcessor requestProcessor;
	
	@Before
	public void setUp() throws Exception{
		requestProcessor = PowerMockito.spy(new RequestProcessor(organizer));
	}
		

	@Test
	public void testProcessWithValidInputs() throws Exception {
		List<String> inputs = new ArrayList<>();
		inputs.add("Writing Fast Tests Against Enterprise Rails 60min");
		inputs.add("Overdoing it in Python 45min");	
		PowerMockito.doReturn(inputs).when(requestProcessor, "readInputs", anyString());
		requestProcessor.process();
		verify(organizer, times(1)).organize(anyListOf(Proposal.class));
	}
	
	@Test
	public void testProcessWithInValidInputs() throws Exception {
		List<String> inputs = new ArrayList<>();
		inputs.add("Writing Fast Tests Against Enterprise Rails");
		inputs.add("45min");
		PowerMockito.doReturn(inputs).when(requestProcessor, "readInputs", anyString());
		requestProcessor.process();
		verify(organizer, never()).organize(anyListOf(Proposal.class));
	}
	
	@Test
	public void testProcessWithEmptyInputs() throws Exception {
		List<String> inputs = new ArrayList<>();
		inputs.add("");
		PowerMockito.doReturn(inputs).when(requestProcessor, "readInputs", anyString());
		requestProcessor.process();
		verify(organizer, never()).organize(anyListOf(Proposal.class));
	}

}
