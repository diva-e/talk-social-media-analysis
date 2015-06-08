package de.netpioneer.socialmedia.sentimentanalysis.model;

import java.util.List;

public class SentimentAnalysisResult {

	private List<String> positiveWords;
	
	private List<String> negativeWords;
	
	private Double score;

	public SentimentAnalysisResult(List<String> positiveWords,
			List<String> negativeWords, Double score) {
		super();
		this.positiveWords = positiveWords;
		this.negativeWords = negativeWords;
		this.score = score;
	}

	public List<String> getPositiveWords() {
		return positiveWords;
	}

	public List<String> getNegativeWords() {
		return negativeWords;
	}

	public Double getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "SentimentAnalysisResult [positiveWords=" + positiveWords
				+ ", negativeWords=" + negativeWords + ", score=" + score + "]";
	}
	
}
