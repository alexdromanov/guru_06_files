package tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.zip.ZipException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import static utils.Files.getFile;
import static utils.Files.readTextFromPath;
import static utils.Zip.unzip;

public class ZipFileTests {
    @Test
    void zipWithPasswordTest() throws IOException, ZipException, net.lingala.zip4j.exception.ZipException {
        String zipFilePath = "./src/test/resources/files/11.zip";
        String unzipFolderPath = "./src/test/resources/files/unzip";
        String zipPassword = "";
        String unzipTxtFilePath = "./src/test/resources/files/unzip/1.txt";
        String expectedData = "Ahoy";


        unzip(zipFilePath, unzipFolderPath, zipPassword);

        String actualData = readTextFromPath(unzipTxtFilePath);

        assertThat(actualData, containsString(expectedData));
    }
}