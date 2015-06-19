package de.netpioneer.socialmedia.sentimentanalysis.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import de.netpioneer.socialmedia.core.util.FileUtilities;

@Repository
public class SentimentAnalysisRepository {

	@Value("classpath:positive-words.txt")
	private Resource positiveWordsResource;
	
	@Value("classpath:negative-words.txt")
	private Resource negativeWordsResource;	

	private List<String> positiveWords;
	
	private List<String> negativeWords;
	
	@PostConstruct
	public void init() throws IOException {
		positiveWords = getWordsFromResource(positiveWordsResource);
		negativeWords = getWordsFromResource(negativeWordsResource);
	}
	
	public List<String> getPositiveWords() {
		return positiveWords;
	}
	
	public List<String> getMatchingPositiveWords(List<String> wordsToCheck) {
		return getMatchingWords(wordsToCheck, this.positiveWords);
	}

	public List<String> getNegativeWords(List<String> wordsToCheck) {
		return negativeWords;
	}

	public List<String> getMatchingNegativeWords(List<String> wordsToCheck) {
		return getMatchingWords(wordsToCheck, this.negativeWords);
	}
	
	private List<String> getMatchingWords(List<String> wordsToCheck, List<String> words) {
		List<String> matchingWords = new ArrayList<>(wordsToCheck);
		matchingWords.retainAll(words);
		return matchingWords;
	}
	
	private List<String> getWordsFromResource(Resource resource) throws IOException {
		return FileUtilities.readLines(resource.getFile());
	}

}
