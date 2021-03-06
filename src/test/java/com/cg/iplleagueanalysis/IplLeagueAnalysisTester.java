package com.cg.iplleagueanalysis;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;


public class IplLeagueAnalysisTester {
	public String FILE_PATH="D:\\neeraj_workspace\\iplleagueanalysis\\FactsheetMostRuns.csv";
	public IplLeagueAnalyser iplLeagueAnalyser;
	public String FILE_PATH_BOWLING_DATA="D:\\neeraj_workspace\\iplleagueanalysis\\FactsheetMostWkts.csv";
	
	@Before
	public void setUp() throws IplAnalyserException {
		iplLeagueAnalyser=new IplLeagueAnalyser();
		iplLeagueAnalyser.loadDataToList(FILE_PATH);
		iplLeagueAnalyser.loadBowlingDataToLIst(FILE_PATH_BOWLING_DATA);
	}

	@Test
	public void givenIplData_loadData_ShouldReturnExactAnswer() {
		assertEquals(101,iplLeagueAnalyser.loadCSVData(FILE_PATH));
	}
	
	@Test
	public void givenIplDataCSVFileReturnsTop3BattingAverages(){
	
		List<IplData> topBattingAverage = iplLeagueAnalyser.getTopBattingAverages();
		assertEquals(83.2, topBattingAverage .get(0).getAverage(), 0.0);
		assertEquals(69.2, topBattingAverage .get(1).getAverage(), 0.0);
		assertEquals(56.66, topBattingAverage .get(2).getAverage(), 0.0);
	}
	
	@Test
	public void givenIplDataCSVFileReturnsTop3StrikeRates(){

		List<IplData> topStrikeRate = iplLeagueAnalyser.getTopStrikingRates();
		assertEquals(333.33, topStrikeRate.get(0).getSR(), 0.0);
		assertEquals(204.81, topStrikeRate.get(1).getSR(), 0.0);
		assertEquals(200.00, topStrikeRate.get(2).getSR(), 0.0);
	}
	
	@Test
	public void givenIplDataCSVFileReturnsCricketerWithMax6s(){
		
		List<IplData> batmenWithMax6s = iplLeagueAnalyser.getTopBatmenWithMax6s();
		assertEquals("Andre Russell", batmenWithMax6s.get(0).getPlayer());
	}
	
	@Test
	public void givenIplDataCSVFileReturnsCricketerWithMax4s(){
		
		List<IplData> batmenWithMax4s = iplLeagueAnalyser.getTopBatmenWithMax4s();
		assertEquals("Shikhar Dhawan", batmenWithMax4s.get(0).getPlayer());
	}
	
	@Test
	public void givenIplDataCSVFileReturnsBestStrikeRatesWith6sAnd4s(){
		List<IplData> listOfTopStrikeRate = iplLeagueAnalyser.getCricketerWithBestStrikingRateWith6sAnd4s();
	    assertEquals("Andre Russell", listOfTopStrikeRate.get(0).getPlayer());
	}
	
	@Test
	public void givenIplDataCSVFileReturnsCricketersWithGreatAverageAndBestStrikeRates(){
		List<IplData> listOfTopAverageWithBestStrikERate = iplLeagueAnalyser.getGreatestAverageWithBestStrikingRate();
		assertEquals("MS Dhoni", listOfTopAverageWithBestStrikERate.get(0).getPlayer());
	}
	
	@Test
	public void givenIplDataCSVFileReturnsCricketersWithMaximumRunAndBestAverages(){
		List<IplData> listOfMaxRunAndGreatestAverage = iplLeagueAnalyser.getMaximumRunWithGreatestAverage();
		assertEquals("David Warner", listOfMaxRunAndGreatestAverage.get(0).getPlayer());
	}
	
	@Test
	public void givenIplBowlingData_SortBowlingDataAccordingToAverage_ReturnSameList() {
		List<BowlingData> listOfTopBowlingAverage = iplLeagueAnalyser. getTopBowlingAverages();
		assertEquals("Anukul Roy",listOfTopBowlingAverage.get(0).player);
		assertEquals("Jagadeesha Suchith",listOfTopBowlingAverage.get(1).player);
		assertEquals("Alzarri Joseph",listOfTopBowlingAverage.get(2).player);
	}
	
	@Test
	public void givenIplBowlingData_SortBowlingDataAccordingToStrikeRate_ReturnSameList() {
		List<BowlingData> listOfTopBowlingStrikeRate = iplLeagueAnalyser.getTopBowlingStrikeRates();
		assertEquals("Alzarri Joseph",listOfTopBowlingStrikeRate.get(0).player);
     	assertEquals("Ish Sodhi",listOfTopBowlingStrikeRate.get(1).player);
		assertEquals("Khaleel Ahmed",listOfTopBowlingStrikeRate.get(2).player);
	}
	
	@Test
	public void givenIplBowlingData_SortBowlingDataAccordingToEconomy_ReturnSameList() {
		List<BowlingData> listOfTopBowlersWithBestEconomy = iplLeagueAnalyser.getTopBowlerWithBestEconomy();
		assertEquals("Shivam Dube",listOfTopBowlersWithBestEconomy.get(0).player);
	}
	
	@Test
	public void givenIplBowlingData_SortBowlingDataAccordingToBestEconomyWithMax4wAnd5w_ReturnSameList() {
		List<BowlingData> listOfTopBowlersWithBestStrikeRateANdMax4w5w = iplLeagueAnalyser.getBowlersWithBestStrikeRateWithMax4wAnd5w();
		assertEquals("Kagiso Rabada",listOfTopBowlersWithBestStrikeRateANdMax4w5w.get(0).player);
	}
	
	@Test
	public void givenIplBowlingData_SortBowlingDataAccordingToBestStrikeRateAndAverage_ReturnSameList() {
		List<BowlingData> listOfTopBowlersWithBestStrikeRateAndAverage = iplLeagueAnalyser.getBowlersWithStrikeRateAndBestAverage();
    	assertEquals("Anukul Roy",listOfTopBowlersWithBestStrikeRateAndAverage.get(0).player);
	}
	
	@Test
	public void givenIplBowlingData_SortWithMaxWicketsAndGreatAverage_ReturnSameList() {
		List<BowlingData> listOfBowlersWithMaximumWicketsAndGreatAverage=iplLeagueAnalyser.getBowlersWithMaxWicketsAndBestAverage();
		assertEquals("Imran Tahir",listOfBowlersWithMaximumWicketsAndGreatAverage.get(0).player);
	}
	
	@Test
	public void givenBattingAndBowlingData_whenSortedOnBestBattingAndBowlingAverage_ShouldReturnCorrectList() {
		List<String> playersWithBestBattingAndBowlingAverage=iplLeagueAnalyser.getBestBattingAndBowlingAverage();
		assertEquals("Andre Russell", playersWithBestBattingAndBowlingAverage.get(0));
	    assertEquals("Marcus Stoinis", playersWithBestBattingAndBowlingAverage.get(1));

	}
	
	@Test
	public void givenBattingAndBowlingData_whenSortedOnMostRunsAndMostWicket_ShouldReturnCorrectList() {
		List<String> playerWithMostRunAndMostWicket=iplLeagueAnalyser.getPlayerWithMostRunAndMostWicket();
		assertEquals("Andre Russell", playerWithMostRunAndMostWicket.get(0));
		assertEquals("Hardik Pandya", playerWithMostRunAndMostWicket.get(1));
	}
	
	@Test
	public void givenBattingData_whenSortedWithWithMaxCenturiesAndBattingAverage_ShouldReturnCorrectList() {
		List<IplData> playerWithMaxCenturyAndBestBattingAverage=iplLeagueAnalyser.getPlayerWithMax100AndBestBattingAverage();
		assertEquals("David Warner",playerWithMaxCenturyAndBestBattingAverage.get(0).player);
	}
	
	@Test
	public void givenBattingData_WhenSortedWithBestAverageAndZeroCentury_ShouldReturnCorrectList() {
		List<IplData> playerWithZeroCenturyButBestBattingAverage=iplLeagueAnalyser.getPlayerWithZeroCenturyOrHalfCenturyAndBestBattingAverage();
		assertEquals("Marcus Stoinis",playerWithZeroCenturyButBestBattingAverage.get(0).player);
	}
}
