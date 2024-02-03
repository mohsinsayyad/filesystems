package com.file.systems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class FileContentReverser {
	
	private final FileOperations fileOperations;

    public FileContentReverser(FileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

	public String reverseFileContent(StringBuilder fileContent)
			throws IOException, URISyntaxException {
		// Reverse the content
		return fileContent.reverse().toString();

	}

	public StringBuilder readFileContent(String inputFilePath) throws IOException {
		// Read input file
		StringBuilder content = new StringBuilder("");
		try (InputStream in = fileOperations.getResourceAsStream(inputFilePath);
				BufferedReader reader = fileOperations.createBufferedReader(in)) {
			// Use resource
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line);
			}
		}
		return content;
	}
	
	public void writeFileContent(String reversedContent, String outputFilePath) throws IOException {
        fileOperations.write(Paths.get(outputFilePath), reversedContent.getBytes());
    }
}
