package seleniumeasy._steps;

import net.serenitybdd.core.steps.UIInteractionSteps;
import seleniumeasy._page.SimpleInputFieldForm;

public class SimpleInputFieldInteractions extends UIInteractionSteps {

    SimpleInputFieldForm simpleInputFieldForm;

    public String getDisplayedMessageForLabel(String label) {
        return $(simpleInputFieldForm.RESULT_SPAN_WITH_LABEL, label).getText();
    }

    public void enterMessage(String message) {
        simpleInputFieldForm.singleInputFieldFacade.sendKeys(message);
    }

    public void clickButtonWithLabel(String buttonLabel) {
        $(simpleInputFieldForm.BUTTON_WITH_TEXT, buttonLabel).click();
    }

    public void enterAMessage(String a, String b) {
        simpleInputFieldForm.fieldAFacade.sendKeys(a);
        simpleInputFieldForm.fieldBFacade.sendKeys(b);
    }
}
