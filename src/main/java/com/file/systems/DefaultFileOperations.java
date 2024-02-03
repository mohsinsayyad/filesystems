package com.file.systems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class DefaultFileOperations implements FileOperations {

    @Override
    public Path write(Path path, byte[] content, StandardOpenOption... options) throws IOException {
        return Files.write(path, content, options);
    }

	@Override
	public InputStream getResourceAsStream(String resource) {
		return getClass().getResourceAsStream(resource);
	}

	@Override
	public BufferedReader createBufferedReader(InputStream in) {
		return new BufferedReader(new InputStreamReader(in));
	}

	@Override
	public String reverseFileContent(StringBuilder fileContent) throws IOException, URISyntaxException {
		return fileContent.reverse().toString();
	}
}

