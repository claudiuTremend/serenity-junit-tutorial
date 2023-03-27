package seleniumeasy._page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CheckboxForm extends PageObject {

    @FindBy(id = "isAgeSelected")
    public WebElementFacade singleCheckboxFacade;

    @FindBy(id = "txtAge")
    public WebElementFacade successMessageFacade;
}
