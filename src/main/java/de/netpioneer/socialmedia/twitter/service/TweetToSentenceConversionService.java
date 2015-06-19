package de.netpioneer.socialmedia.twitter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;

import de.netpioneer.socialmedia.core.domain.Sentence;
import de.netpioneer.socialmedia.twitter.persistence.TwitterStopwordRepository;
import de.netpioneer.socialmedia.wordprocessing.service.WordSplittingService;

@Component
public class TweetToSentenceConversionService {
	
	@Autowired
	private TwitterStopwordRepository twitterStopwordRepository;
	
	@Autowired
	private WordSplittingService wordSplittingService;
	
	public Sentence convertTweetToSentence(Tweet tweet) {
		List<String> words = wordSplittingService.getWordsFromText(tweet.getText());
		removeStopwords(words);
		Sentence sentence = new Sentence(words);
		return sentence;
	}
	
	private void removeStopwords(List<String> words) {
		words.removeAll(twitterStopwordRepository.getStopwords());
	}

	public List<Sentence> convertTweetsToSentences(List<Tweet> tweets) {
		List<Sentence> sentences = new ArrayList<>();
		for (Tweet tweet : tweets) {
			sentences.add(convertTweetToSentence(tweet));
		}
		return sentences;
	}
	
}
