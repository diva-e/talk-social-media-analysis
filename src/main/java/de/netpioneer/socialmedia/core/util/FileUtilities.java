package de.netpioneer.socialmedia.core.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public final class FileUtilities {

	private FileUtilities() {}

	public static List<String> readLines(File file) throws IOException {
		return Files.readLines(file, Charsets.UTF_8, new WordLineProcessor());
	}
	
}
