package de.netpioneer.socialmedia.core.model;

import java.util.List;

public class Sentence {

	private List<String> words;

	public Sentence(List<String> words) {
		this.words = words;
	}

	public List<String> getWords() {
		return words;
	}

	@Override
	public String toString() {
		return "Sentence [words=" + words + "]";
	}
	
}
