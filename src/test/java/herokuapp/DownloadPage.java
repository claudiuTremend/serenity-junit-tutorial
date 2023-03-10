package herokuapp;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://the-internet.herokuapp.com/download")
public class DownloadPage extends PageObject {
    public void downloadFile() {
        $(By.linkText("sample.png")).click();
    }
}
