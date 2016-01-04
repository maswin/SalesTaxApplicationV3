import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;

public class OutputWriterTest {

    @Test
    public void shouldWriteOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter printWriter = new PrintWriter(out);
        OutputWriter outputWriter = new OutputWriter(printWriter);
        outputWriter.print("output");
        assertEquals("output", out.toString());
    }

    @Test
    public void shouldWriteOutputAndNewLine() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter printWriter = new PrintWriter(out);
        OutputWriter outputWriter = new OutputWriter(printWriter);
        outputWriter.println("output");
        assertEquals("output\n", out.toString());
    }
}