package de.netpioneer.socialmedia.sentimentanalysis.domain;

import java.util.List;

public class SentimentAnalysisResult {

	private List<String> positiveWords;
	
	private List<String> negativeWords;

	public SentimentAnalysisResult(List<String> positiveWords,
			List<String> negativeWords) {
		this.positiveWords = positiveWords;
		this.negativeWords = negativeWords;
	}

	public List<String> getPositiveWords() {
		return positiveWords;
	}

	public List<String> getNegativeWords() {
		return negativeWords;
	}

	public Sentiment getSentiment() {
		if (negativeWords.size() > positiveWords.size()) {
			return Sentiment.NEGATIVE;
		}
		if (negativeWords.size() == positiveWords.size()) {
			return Sentiment.NEUTRAL;
		}
		return Sentiment.POSITIVE;
	}

	@Override
	public String toString() {
		return "SentimentAnalysisResult [positiveWords=" + positiveWords
				+ ", negativeWords=" + negativeWords + "]";
	}

}
