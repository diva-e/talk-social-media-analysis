package de.netpioneer.socialmedia.sentimentanalysis.domain;

import java.util.List;

public class SentimentAnalysisResult {

	private List<String> positiveWords;
	
	private List<String> negativeWords;
	
	private double score;

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

	public double getScore() {
		return score;
	}
	
	public Sentiment getSentiment() {
		if (score < 0.5) {
			return Sentiment.NEGATIVE;
		}
		if (score == 0.5) {
			return Sentiment.NEUTRAL;
		}
		return Sentiment.POSITIVE;
	}

	@Override
	public String toString() {
		return "SentimentAnalysisResult [positiveWords=" + positiveWords
				+ ", negativeWords=" + negativeWords + ", score=" + score + "]";
	}
	
}
