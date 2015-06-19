package de.netpioneer.socialmedia.core.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.io.LineProcessor;

public class WordLineProcessor implements LineProcessor<List<String>> {

	private List<String> lines = new ArrayList<>();
	
	@Override
	public boolean processLine(String line) throws IOException {
		String trimmedLine = line.trim();
		if (!isValidLine(trimmedLine)) {
			return true;
		}
		lines.add(line);
		return true;
	}

	private boolean isValidLine(String trimmedLine) {
		return !trimmedLine.isEmpty() && !trimmedLine.startsWith(";");
	}

	@Override
	public List<String> getResult() {
		return lines;
	}

}
