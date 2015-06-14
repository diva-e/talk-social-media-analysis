package de.netpioneer.socialmedia.wordprocessing.service;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WordSplittingService {

	public List<String> getWordsFromText(String text) {
		List<String> words = new ArrayList<>();
		BreakIterator breakIterator = BreakIterator.getWordInstance();
		breakIterator.setText(text);
		int start = breakIterator.first();
		for (int end = breakIterator.next(); end != BreakIterator.DONE; start = end, end = breakIterator
				.next()) {
			String word = text.substring(start, end).toLowerCase();
			if (Character.isAlphabetic(word.codePointAt(0))) {
				words.add(word);
			}
		}
		return words;
	}
	
}
