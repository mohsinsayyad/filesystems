package com.file.systems;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Main.class })
public class MainTest {

    @Test
    public void testMainMethod() throws IOException, URISyntaxException {
        // Arrange
        FileContentReverser fileContentReverserMock = mock(FileContentReverser.class);
        Logger loggerMock = mock(Logger.class);

        when(fileContentReverserMock.readFileContent("/input/ascii_input.txt")).thenReturn(new StringBuilder("ABC"));
        when(fileContentReverserMock.reverseFileContent(any())).thenReturn("CBA");
        when(fileContentReverserMock.writeFileContent(any(), any())).thenReturn(Paths.get("output.txt"));
        // Replace the static logger with a mock
        Whitebox.setInternalState(Main.class, "logger", loggerMock);

        // Act
        Main.main(null);

        // Assert or verify
        verify(loggerMock).info("File content reversed & saved to output file path :: " + Paths.get("output.txt").toUri());
        verifyNoMoreInteractions(loggerMock);
    }
}
