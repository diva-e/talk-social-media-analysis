package de.netpioneer.socialmedia.sentimentanalysis.service;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.netpioneer.socialmedia.sentimentanalysis.db.SentimentAnalysisRepository;
import de.netpioneer.socialmedia.sentimentanalysis.model.SentimentAnalysisResult;

@Service
public class SentimentAnalysisService {
	
	@Autowired
	private SentimentAnalysisRepository sentimentAnalysisRepository;
	
	public SentimentAnalysisResult performSentimentAnalysis(String inputText) {	
		List<String> wordsFromText = getWordsFromText(inputText);
		return calculateAnalysisResults(wordsFromText);
	}
	
	private SentimentAnalysisResult calculateAnalysisResults(
			List<String> wordsFromText) {
		List<String> positiveWordsFromText = sentimentAnalysisRepository.getMatchingPositiveWords(wordsFromText);
		List<String> negativeWordsFromText = sentimentAnalysisRepository.getMatchingNegativeWords(wordsFromText);
		// TODO calculate score
		Double score = Double.valueOf(1.0);
		SentimentAnalysisResult result = new SentimentAnalysisResult(positiveWordsFromText, negativeWordsFromText, score); 
		return result;
	}

	private List<String> getWordsFromText(String text) {
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
