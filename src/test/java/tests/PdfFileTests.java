package tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.pdftest.PDF.containsText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.getFile;
import static utils.Files.readTextFromPath;

public class PdfFileTests {
    @Test
    void pdfTest() throws IOException {
        String pdfFilePath = "./src/test/resources/files/11.pdf";
        String expectedData = "alexdromanov";

        PDF pdf = new PDF(getFile(pdfFilePath));
        assertThat(pdf, PDF.containsText(expectedData));

    }
}
