package com.cg.iplleagueanalysis;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

public class IplLeagueAnalyser {

	public static int loadCSVData(String csvFile) {
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

}
