package de.netpioneer.socialmedia.sentimentanalysis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.netpioneer.socialmedia.core.domain.Sentence;
import de.netpioneer.socialmedia.sentimentanalysis.domain.Sentiment;
import de.netpioneer.socialmedia.sentimentanalysis.domain.SentimentAnalysisResult;
import de.netpioneer.socialmedia.sentimentanalysis.persistence.SentimentAnalysisRepository;

@Service
public class SentimentAnalysisService {
	
	@Autowired
	private SentimentAnalysisRepository sentimentAnalysisRepository;
	
	public Map<Sentiment, Integer> getSentimentFrequenciesForSentences(List<Sentence> sentences) {
		List<SentimentAnalysisResult> sentimentAnalysisResults = analyzeSentimentsForSentences(sentences);
		Map<Sentiment, Integer> sentimentFrequencies = new HashMap<>();
		for (SentimentAnalysisResult sentimentAnalysisResult : sentimentAnalysisResults) {
			updateSentimentFrequency(sentimentFrequencies, sentimentAnalysisResult.getSentiment());
		}
		return sentimentFrequencies;
	}
	
	private void updateSentimentFrequency(Map<Sentiment, Integer> sentimentFrequencies, Sentiment sentiment) {
		if (!sentimentFrequencies.containsKey(sentiment)) {
			sentimentFrequencies.put(sentiment, 1);
		} else {
			Integer currentFrequency = sentimentFrequencies.get(sentiment);
			sentimentFrequencies.put(sentiment, currentFrequency + 1);
		}
	}
	
	private List<SentimentAnalysisResult> analyzeSentimentsForSentences(List<Sentence> sentences) {
		List<SentimentAnalysisResult> sentimentAnalysisResults = new ArrayList<>();
		for (Sentence sentence : sentences) {
			SentimentAnalysisResult sentimentAnalysisResult = analyzeSentimentsForWords(sentence.getWords());
			sentimentAnalysisResults.add(sentimentAnalysisResult);
		}
		return sentimentAnalysisResults;
	}
	
	private SentimentAnalysisResult analyzeSentimentsForWords(List<String> words) {	
		return calculateAnalysisResults(words);
	}
	
	private SentimentAnalysisResult calculateAnalysisResults(
			List<String> wordsFromText) {
		List<String> positiveWordsFromText = sentimentAnalysisRepository.getMatchingPositiveWords(wordsFromText);
		List<String> negativeWordsFromText = sentimentAnalysisRepository.getMatchingNegativeWords(wordsFromText);
		SentimentAnalysisResult result = new SentimentAnalysisResult(positiveWordsFromText, negativeWordsFromText); 
		return result;
	}

}
