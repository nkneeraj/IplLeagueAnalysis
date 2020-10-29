package com.cg.iplleagueanalysis;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class IplLeagueAnalysisTester {
	public String FILE_PATH="D:\\neeraj_workspace\\iplleagueanalysis\\FactsheetMostRuns.csv";
	public IplLeagueAnalyser iplLeagueAnalyser;

	@Before
	public void setUp() throws IOException {
		iplLeagueAnalyser=new IplLeagueAnalyser();
	}

	@Test
	public void givenIplDataWhenCalculatedBattingAverageShouldReturnExactAnswer() {
		assertEquals(101,iplLeagueAnalyser.loadCSVData(FILE_PATH));
	}
}
