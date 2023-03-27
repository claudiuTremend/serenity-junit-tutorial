package seleniumeasy._page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SimpleInputFieldForm extends PageObject {

    public static final String BUTTON_WITH_TEXT = "//button[contains(.,'{0}')]";
    public static final String RESULT_SPAN_WITH_LABEL = "//div[contains(.,'{0}')]/span";

    @FindBy(xpath = "//div[contains(.,'Enter message')]/input")
    public WebElementFacade singleInputFieldFacade;

    @FindBy(css = "#sum1")
    public WebElementFacade fieldAFacade;

    @FindBy(css = "#sum2")
    public WebElementFacade fieldBFacade;
}
