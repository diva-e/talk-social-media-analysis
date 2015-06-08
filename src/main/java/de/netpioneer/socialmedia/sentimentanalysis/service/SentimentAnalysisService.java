package de.netpioneer.socialmedia.sentimentanalysis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.netpioneer.socialmedia.sentimentanalysis.db.SentimentAnalysisRepository;
import de.netpioneer.socialmedia.sentimentanalysis.model.SentimentAnalysisResult;

@Service
public class SentimentAnalysisService {
	
	@Autowired
	private SentimentAnalysisRepository sentimentAnalysisRepository;
	
	public SentimentAnalysisResult performSentimentAnalysis(String inputText) {
		return null;
	}

}
