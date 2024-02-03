package com.file.systems;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Logger;

public class Main {

	static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		
		FileContentReverser fileContentReverser = new FileContentReverser(new DefaultFileOperations());
		try {
			// Read file content
			StringBuilder fileContent = fileContentReverser.readFileContent("/input/ascii_input.txt");
			
			// Reverse file content
			String reverseFileContent = fileContentReverser.reverseFileContent(fileContent);
			 
			// Write file content to out.txt file
			fileContentReverser.writeFileContent(reverseFileContent, "./output.txt");
			
			logger.info("File content reversed & save to output file.");
			
		} catch (IOException | URISyntaxException e) {
			logger.severe("Error occurred while performing operation on file system" + e.getMessage());
		}
	}

}
