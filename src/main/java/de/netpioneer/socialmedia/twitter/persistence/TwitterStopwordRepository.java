package de.netpioneer.socialmedia.twitter.persistence;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import de.netpioneer.socialmedia.core.util.FileUtilities;

@Repository
public class TwitterStopwordRepository {
	
	@Value("classpath:twitter-stopwords.txt")
	private Resource stopwordsResource;
	
	private List<String> stopwords;
	
	@PostConstruct
	public void init() throws IOException {
		stopwords = FileUtilities.readLines(stopwordsResource.getFile());
	}
	
	public List<String> getStopwords() {
		return stopwords;
	}

}
