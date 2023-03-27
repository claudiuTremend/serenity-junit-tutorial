package seleniumeasy._page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.ui.Button;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html")
public class SelectListPage extends PageObject {

    @FindBy(id = "multi-select")
    private WebElementFacade multiList;
    @FindBy(className = "panel-heading")
    private WebElementFacade multiListt;

    public void selectOptionWithValue(List<String> values) {
        values.forEach(value ->
                withAction()
                        .keyDown(Keys.LEFT_CONTROL)
                        .click(multiList.selectByValue(value))
                        .keyUp(Keys.LEFT_CONTROL)
                        .perform()
        );
    }

    public void getAllButton() {
        $(Button.withText("Get All Selected")).click();
    }

    public String optionsSelected() {
        return $(".getall-selected").getText();
    }
}
