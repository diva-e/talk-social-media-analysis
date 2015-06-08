package de.netpioneer.socialmedia.sentimentanalysis.db;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.io.LineProcessor;

public class WordLineProcessor implements LineProcessor<List<String>> {

	private List<String> lines = new ArrayList<>();
	
	@Override
	public boolean processLine(String line) throws IOException {
		String trimmedLine = line.trim();
		if (trimmedLine.isEmpty() || trimmedLine.startsWith(";")) {
			return true;
		}
		lines.add(line);
		return true;
	}

	@Override
	public List<String> getResult() {
		return lines;
	}

}
