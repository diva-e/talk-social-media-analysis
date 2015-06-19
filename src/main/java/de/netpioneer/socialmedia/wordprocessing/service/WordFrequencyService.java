package de.netpioneer.socialmedia.wordprocessing.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import de.netpioneer.socialmedia.core.domain.Sentence;

@Service
public class WordFrequencyService {

	public Map<String, Integer> calculateWordFrequencies(List<Sentence> sentences) {
		Map<String, Integer> wordFrequencies = new HashMap<>();
		for (Sentence sentence : sentences) {
			updateWordFrequencies(wordFrequencies, sentence);
		}
		return wordFrequencies;
	}

	private void updateWordFrequencies(Map<String, Integer> wordFrequencies,
			Sentence sentence) {
		for (String word : sentence.getWords()) {
			updateWordFrequency(wordFrequencies, word);
		}
	}

	private void updateWordFrequency(Map<String, Integer> wordFrequencies, String word) {
		if (!wordFrequencies.containsKey(word)) {
			wordFrequencies.put(word, 1);
		} else {
			Integer currentFrequency = wordFrequencies.get(word);
			wordFrequencies.put(word, currentFrequency + 1);
		}
	}
	
}
