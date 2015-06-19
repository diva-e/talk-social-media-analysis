package de.netpioneer.socialmedia.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.netpioneer.socialmedia.core.domain.Sentence;
import de.netpioneer.socialmedia.sentimentanalysis.model.Sentiment;
import de.netpioneer.socialmedia.sentimentanalysis.service.SentimentAnalysisService;
import de.netpioneer.socialmedia.twitter.service.TweetToSentenceConversionService;
import de.netpioneer.socialmedia.twitter.service.TwitterService;
import de.netpioneer.socialmedia.wordprocessing.service.WordFrequencyService;

@RequestMapping(value = "/social-media-analysis/v1.0/", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class SocialMediaAnalysisController {

	@Autowired
	private SentimentAnalysisService sentimentAnalysisService;
	
	@Autowired
	private WordFrequencyService wordFrequencyService;
	
	@Autowired
	private TwitterService twitterService;
	
	@Autowired
	private TweetToSentenceConversionService tweetToSentenceConversionService;
	
	@RequestMapping(value = "sentiments", method = RequestMethod.GET)
	public Map<Sentiment, Double> getSentimentsForTweetsByKeyword(@RequestParam String keyword) {
		// TODO make call to sentimentAnalysisService
		Map<Sentiment, Double> sentiments = new HashMap<>();
		sentiments.put(Sentiment.POSITIVE, Double.valueOf(0.21d));
		sentiments.put(Sentiment.NEGATIVE, Double.valueOf(0.56d));
		sentiments.put(Sentiment.NEUTRAL, Double.valueOf(0.23d));
		return sentiments;
	}
	
	@RequestMapping(value = "wordfrequencies", method = RequestMethod.GET)
	public Map<String, Integer> getWordFrequenciesForTweetsByKeyword(@RequestParam String keyword) {
		List<Tweet> tweets = twitterService.findTweetsByKeyword(keyword);
		List<Sentence> sentences = tweetToSentenceConversionService.convertTweetsToSentences(tweets);		
		return wordFrequencyService.calculateWordFrequencies(sentences);
	}
	
}
