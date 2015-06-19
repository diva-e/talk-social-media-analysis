package de.netpioneer.socialmedia.sentimentanalysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.netpioneer.socialmedia.sentimentanalysis.domain.SentimentAnalysisResult;
import de.netpioneer.socialmedia.sentimentanalysis.persistence.SentimentAnalysisRepository;
import de.netpioneer.socialmedia.wordprocessing.service.WordSplittingService;

@Service
public class SentimentAnalysisService {
	
	@Autowired
	private WordSplittingService wordSplittingService;
	
	@Autowired
	private SentimentAnalysisRepository sentimentAnalysisRepository;
	
	public SentimentAnalysisResult performSentimentAnalysis(String inputText) {	
		List<String> wordsFromText = wordSplittingService.getWordsFromText(inputText);
		return calculateAnalysisResults(wordsFromText);
	}
	
	private SentimentAnalysisResult calculateAnalysisResults(
			List<String> wordsFromText) {
		List<String> positiveWordsFromText = sentimentAnalysisRepository.getMatchingPositiveWords(wordsFromText);
		List<String> negativeWordsFromText = sentimentAnalysisRepository.getMatchingNegativeWords(wordsFromText);
		// TODO calculate score
		double score = 1.0d;
		SentimentAnalysisResult result = new SentimentAnalysisResult(positiveWordsFromText, negativeWordsFromText, score); 
		return result;
	}

}
