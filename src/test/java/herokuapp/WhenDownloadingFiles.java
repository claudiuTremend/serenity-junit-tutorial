package herokuapp;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.configuration.SessionLocalTempDirectory;
import org.awaitility.Awaitility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenDownloadingFiles {

    @Managed
    WebDriver driver;

    DownloadPage downloadPage;

    @Test
    public void shouldDownloadTheCorrectFile() throws InterruptedException {
        downloadPage.open();

        downloadPage.downloadFile();

        File downloadedFile = SessionLocalTempDirectory.forTheCurrentSession().resolve("sample.png").toFile();
        System.out.println(downloadedFile.exists() + " " + downloadedFile);

//        Awaitility.await().atMost(15, TimeUnit.SECONDS)
//                .until(() -> downloadedFile.exists());

        Thread.sleep(3000);
        assertThat(downloadedFile).exists();
    }
}
