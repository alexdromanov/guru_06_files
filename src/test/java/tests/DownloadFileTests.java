package tests;

import com.codeborne.selenide.Configuration;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import utils.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DownloadFileTests {
    @Test
    void selenideDownloadReadmeTest() throws IOException {
        Configuration.downloadsFolder = "downloads";

        open("https://github.com/selenide/selenide/blob/master/README.md");
        File downloadFile = $("#raw-url").download();
        String fileContent = Files.readTextFromFile(downloadFile);
        assertThat(fileContent, containsString("Selenide = 1UI Testing Framework powered by Selenium WebDriver"));
    }

//    @Test
//    void selenideDownloadReadme1Test() {
//         open("https://github.com/selenide/selenide/blob/master/README.md");
//        try {
//            $("#row-url").download();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

