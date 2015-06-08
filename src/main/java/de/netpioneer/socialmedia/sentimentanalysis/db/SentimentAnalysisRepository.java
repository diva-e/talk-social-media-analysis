package de.netpioneer.socialmedia.sentimentanalysis.db;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

@Component
public class SentimentAnalysisRepository {
	
	@Autowired
	private ResourceLoader resourceLoader;

	private List<String> positiveWords;
	
	private List<String> negativeWords;
	
	@PostConstruct
	public void init() throws IOException {
		Resource positiveWordsResource = resourceLoader.getResource("classpath:positive-words.txt");
		positiveWords = getWordsFromResource(positiveWordsResource);
		Resource negativeWordsResource = resourceLoader.getResource("classpath:negative-words.txt");
		negativeWords = getWordsFromResource(negativeWordsResource);
	}
	
	public List<String> getPositiveWords() {
		return positiveWords;
	}

	public List<String> getNegativeWords() {
		return negativeWords;
	}

	private List<String> getWordsFromResource(Resource resource) throws IOException {
		return Files.readLines(resource.getFile(), Charsets.UTF_8, new WordLineProcessor());
	}

}
