import java.io.PrintWriter;

public class OutputWriter {
    private PrintWriter printWriter;

    public OutputWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public void print(String output) {
        printWriter.print(output);
        printWriter.flush();
    }

    public void println(String output) {
        printWriter.println(output);
        printWriter.flush();
    }

    public void println(double output) {
        printWriter.println(output);
        printWriter.flush();
    }
}