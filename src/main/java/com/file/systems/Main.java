package com.file.systems;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.logging.Logger;

public class Main {

	static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		
		FileContentReverser fileContentReverser = new FileContentReverser(new FileOperationsImpl());
		
		try {
			// Read file content
			StringBuilder fileContent = fileContentReverser.readFileContent("/input/ascii_input.txt");
			
			// Reverse file content
			String reverseFileContent = fileContentReverser.reverseFileContent(fileContent);
			 
			// Write file content to out.txt file
			Path path = fileContentReverser.writeFileContent(reverseFileContent, "output.txt");
			
			logger.info("File content reversed & saved to output file path :: " + path.toUri());
			
		} catch (IOException | URISyntaxException e) {
			logger.severe("Error occurred while performing operation on file system" + e.getMessage());
		}
	}

}
