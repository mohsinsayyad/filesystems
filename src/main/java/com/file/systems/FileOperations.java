package com.file.systems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public interface FileOperations {

	Path write(Path path, byte[] content, StandardOpenOption... options) throws IOException;

	InputStream getResourceAsStream(String resource);

	BufferedReader createBufferedReader(InputStream in);

	String reverseFileContent(StringBuilder fileContent)
			throws IOException, URISyntaxException;
}
