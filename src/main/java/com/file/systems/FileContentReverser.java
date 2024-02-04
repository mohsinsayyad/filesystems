package com.file.systems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileContentReverser {
	
	private final IFileOperations fileOperations;

    public FileContentReverser(IFileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

	/**
	 * Method to reverse file content.
	 * 
	 * @param fileContent
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public String reverseFileContent(StringBuilder fileContent)
			throws IOException, URISyntaxException {
		// Reverse the content
		return fileContent.reverse().toString();

	}

	/**
	 * This method takes input as file path to read content from text file.
	 * input/ascii_input.txt is present under src/main/resource folder.
	 * 
	 * @param inputFilePath
	 * @return
	 * @throws IOException
	 */
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
	
	/**
	 * This method writes reversed content to output.txt file & returns file path.
	 * 
	 * @param reversedContent
	 * @param outputFilePath
	 * @return Path
	 * @throws IOException
	 */
	public Path writeFileContent(String reversedContent, String outputFilePath) throws IOException {
        return fileOperations.write(Paths.get(outputFilePath), reversedContent.getBytes());
    }
}
