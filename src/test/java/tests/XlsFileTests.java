package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.pdftest.PDF.containsText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.getFile;

public class XlsFileTests {
    @Test
    void xlsTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/11.xls";
        String expectedData = "Ahoy";

        XLS xls = new XLS(new File(xlsFilePath));
        String actualData = xls.excel.getSheetAt(0).getRow(3).getCell(1).toString();
        assertThat(actualData, containsString(expectedData));

    }
}
