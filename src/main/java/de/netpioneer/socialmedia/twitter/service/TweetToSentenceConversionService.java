package de.netpioneer.socialmedia.twitter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;

import de.netpioneer.socialmedia.core.domain.Sentence;
import de.netpioneer.socialmedia.wordprocessing.service.WordSplittingService;

@Component
public class TweetToSentenceConversionService {

	@Autowired
	private WordSplittingService wordSplittingService;
	
	public Sentence convertTweetToSentence(Tweet tweet) {
		List<String> words = wordSplittingService.getWordsFromText(tweet.getText());
		Sentence sentence = new Sentence(words);
		return sentence;
	}
	
	public List<Sentence> convertTweetsToSentences(List<Tweet> tweets) {
		List<Sentence> sentences = new ArrayList<>();
		for (Tweet tweet : tweets) {
			sentences.add(convertTweetToSentence(tweet));
		}
		return sentences;
	}
	
}
