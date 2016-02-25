package de.netpioneer.socialmedia.twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.SearchParameters.ResultType;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

@Service
public class TwitterService {
	
	@Autowired
	private Twitter twitter;

	public List<Tweet> findTweetsByKeyword(String keyword, String language) {
		SearchParameters searchParameters = new SearchParameters(keyword)
				.resultType(ResultType.RECENT)
				.lang(language)
				.count(100);
		SearchResults searchResults = twitter.searchOperations().search(searchParameters);
		List<Tweet> tweets = searchResults.getTweets();
		return tweets;
	}
	
}
