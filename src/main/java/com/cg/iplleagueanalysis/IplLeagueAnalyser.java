package com.cg.iplleagueanalysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBeanBuilder;

public class IplLeagueAnalyser {

	public static List<IplData> IplDataList;
	public int loadCSVData(String csvFile) {
		int numOfEntries=0;
		try {

			Reader reader=Files.newBufferedReader(Paths.get(csvFile));
			Iterator<IplData> iterator=new OpenCSVBuilder().getCSVFileIterator(reader,IplData.class);
			Iterable<IplData> csvIterable = () -> iterator;
			System.out.println("load");
			numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(numOfEntries);
		return numOfEntries;
	}
	
	public void loadDataToList(String csvFile) throws IOException {
		Reader reader=Files.newBufferedReader(Paths.get(csvFile));
	    IplDataList = new CsvToBeanBuilder(reader).withType(IplData.class).build().parse();
	}
	
	public List<IplData> getTopBattingAverages(String csvFile) throws Exception {
		List<IplData> sortedAvgList = IplDataList.stream()
				.sorted((player1, player2) -> Double.compare(player1.getAverage(), player2.getAverage()))
				.collect(Collectors.toList());
		Collections.reverse(sortedAvgList);
		return sortedAvgList;
	}
	
	public List<IplData> getTopStrikingRates(String csvFile) throws Exception {
		List<IplData> sortedStrikingRateList = IplDataList.stream()
				.sorted((player1, player2) -> Double.compare(player1.getSR(), player2.getSR()))
				.collect(Collectors.toList());
		Collections.reverse(sortedStrikingRateList);
		return sortedStrikingRateList;
	}
	
	public List<IplData> getTopBatmenWithMax6s(String csvFile) throws IOException {
		List<IplData> batmenWithMax6s = IplDataList.stream()
				.sorted((player1, player2) -> Double.compare(player1.get6s(), player2.get6s()))
				.collect(Collectors.toList());
		Collections.reverse(batmenWithMax6s);
		return batmenWithMax6s ;
	}
	
	public List<IplData> getTopBatmenWithMax4s(String csvFile) throws IOException {
		List<IplData> batmenWithMax4s = IplDataList.stream()
				.sorted((player1, player2) -> Double.compare(player1.get4s(), player2.get4s()))
				.collect(Collectors.toList());
		Collections.reverse(batmenWithMax4s);
		return batmenWithMax4s ;
	}
}
