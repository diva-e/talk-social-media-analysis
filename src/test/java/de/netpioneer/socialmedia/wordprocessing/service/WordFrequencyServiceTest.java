package de.netpioneer.socialmedia.wordprocessing.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.Map;

import org.junit.Test;

import de.netpioneer.socialmedia.core.model.Sentence;

public class WordFrequencyServiceTest {
	
	private WordFrequencyService wordFrequencyService = new WordFrequencyService();

	@Test
	public void calculateWordFrequencies() {
		Sentence sentence1 = createSentence("before", "good", "cloud");
		Sentence sentence2 = createSentence("earth", "good", "before");
		Sentence sentence3 = createSentence("cloud", "bad", "before");
		
		Map<String, Integer> wordFrequencies = wordFrequencyService.calculateWordFrequencies(Arrays.asList(sentence1, sentence2, sentence3));
		
		assertThat(wordFrequencies.size(), is(5));
		assertThat(wordFrequencies, hasEntry("before", 3));
		assertThat(wordFrequencies, hasEntry("good", 2));
		assertThat(wordFrequencies, hasEntry("cloud", 2));
		assertThat(wordFrequencies, hasEntry("earth", 1));
		assertThat(wordFrequencies, hasEntry("bad", 1));
	}

	private Sentence createSentence(String... words) {
		return new Sentence(Arrays.asList(words));
	}

}
