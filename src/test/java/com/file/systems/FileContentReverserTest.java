package com.file.systems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ FileContentReverser.class, Files.class })
public class FileContentReverserTest {
 
	@Test
    public void testReadFileContent() throws IOException {
		// Arrange
        String inputFilePath = "/input/ascii_input.txt";
        String fileContent = "ABC";

        // Mocking
        FileOperations fileOperationsMock = Mockito.mock(FileOperations.class);
        FileContentReverser fileContentReverser = new FileContentReverser(fileOperationsMock);

        InputStream inputStreamMock = mock(InputStream.class);
        BufferedReader bufferedReaderMock = mock(BufferedReader.class);

        when(fileOperationsMock.getResourceAsStream(inputFilePath)).thenReturn(inputStreamMock);
        when(fileOperationsMock.createBufferedReader(inputStreamMock)).thenReturn(bufferedReaderMock);

        when(bufferedReaderMock.readLine()).thenReturn("A", "B", "C", null);

        // Act
        StringBuilder result = fileContentReverser.readFileContent(inputFilePath);

        // Assert
        assertEquals(fileContent, result.toString());

	}

	@Test
	public void testReverseFileContent() throws IOException, URISyntaxException {
		// Test input
		String inputContent = "ABC";
		StringBuilder fileContent = new StringBuilder(inputContent);

		FileOperations fileOperationsMock = mock(FileOperations.class);
		FileContentReverser fileContentReverser = new FileContentReverser(fileOperationsMock);
		
		// Call the method
		String reversedContent = fileContentReverser.reverseFileContent(fileContent);

		// Assertions
		assertNotNull(reversedContent);
		assertEquals("CBA", reversedContent);
	}

	@Test
    public void testWriteFileContent() throws IOException {
        // Arrange
        String reversedContent = "CBA";
        String outputFilePath = "output.txt";

        FileOperations fileOperationsMock = mock(FileOperations.class);
        Path mockedPath = mock(Path.class);

        when(fileOperationsMock.write(any(Path.class), any(byte[].class))).thenReturn(mockedPath);

        FileContentReverser yourClass = new FileContentReverser(fileOperationsMock);

        // Act
        yourClass.writeFileContent(reversedContent, outputFilePath);

        // Assert
        verify(fileOperationsMock).write(any(Path.class), any(byte[].class));
    }
}
