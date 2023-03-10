package seleniumeasy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.ui.Button;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://demo.seleniumeasy.com/basic-first-form-demo.html")
public class TwoInputFieldForm extends PageObject {
    public void enterA(String value) {
        $("#sum1").sendKeys(value);
    }

    public void enterB(String value) {
        $("#sum2").sendKeys(value);
    }

    public void getTotal() {
        $(Button.withText("Get Total")).click();
    }

    public String displayedTotal() {
        return $("#displayvalue").getText();
    }
}
