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
		iplLeagueAnalyser.loadDataToList(FILE_PATH);
	}

	@Test
	public void givenIplDataWhenCalculatedBattingAverageShouldReturnExactAnswer() {
		assertEquals(101,iplLeagueAnalyser.loadCSVData(FILE_PATH));
	}

	@Test
	public void givenIplDataCSVFileReturnsTop3BattingAverages() throws Exception {

		List<IplData> topBattingAverage = iplLeagueAnalyser.getTopBattingAverages(FILE_PATH);
		assertEquals(83.2, topBattingAverage .get(0).getAverage(), 0.0);
		assertEquals(69.2, topBattingAverage .get(1).getAverage(), 0.0);
		assertEquals(56.66, topBattingAverage .get(2).getAverage(), 0.0);
	}
	
	@Test
	public void givenIplDataCSVFileReturnsTop3StrikeRates() throws Exception {

		List<IplData> topStrikeRate = iplLeagueAnalyser.getTopStrikingRates(FILE_PATH);
		assertEquals(333.33, topStrikeRate.get(0).getSR(), 0.0);
		assertEquals(204.81, topStrikeRate.get(1).getSR(), 0.0);
		assertEquals(200.00, topStrikeRate.get(2).getSR(), 0.0);
	}
	
	@Test
	public void givenIplDataCSVFileReturnsCricketerWithMax6s() throws Exception {

		List<IplData> batmenWithMax6s = iplLeagueAnalyser.getTopBatmenWithMax6s(FILE_PATH);
		assertEquals("Andre Russell", batmenWithMax6s.get(0).getPlayer());
	}
	
	@Test
	public void givenIplDataCSVFileReturnsCricketerWithMax4s() throws Exception {

		List<IplData> batmenWithMax4s = iplLeagueAnalyser.getTopBatmenWithMax4s(FILE_PATH);
		assertEquals("Shikhar Dhawan", batmenWithMax4s.get(0).player);
	}
	
	@Test
	public void givenIplDataCSVFileReturnsBestStrikeRatesWith6sAnd4s() throws Exception {
		List<IplData> listOfTopStrikeRate = iplLeagueAnalyser.getCricketerWithBestStrikingRateWith6sAnd4s();
	    assertEquals("Andre Russell", listOfTopStrikeRate.get(0).getPlayer());
	}
}
