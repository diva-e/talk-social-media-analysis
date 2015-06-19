package de.netpioneer.socialmedia.twitter.persistence;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import de.netpioneer.socialmedia.core.util.FileUtilities;

@Repository
public class TwitterStopwordRepository {
	
	private List<String> stopwords;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@PostConstruct
	public void init() throws IOException {
		Resource stopwordsResource = resourceLoader.getResource("classpath:twitter-stopwords.txt");
		stopwords = FileUtilities.readLines(stopwordsResource.getFile());
	}
	
	public List<String> getStopwords() {
		return stopwords;
	}

}
