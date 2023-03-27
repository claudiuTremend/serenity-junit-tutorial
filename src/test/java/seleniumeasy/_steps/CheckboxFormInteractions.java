package seleniumeasy._steps;

import net.serenitybdd.core.steps.UIInteractionSteps;
import seleniumeasy._page.CheckboxForm;

public class CheckboxFormInteractions extends UIInteractionSteps {

    CheckboxForm checkboxForm;

    public boolean singleCheckboxIsClicked() {
        return checkboxForm.singleCheckboxFacade.isSelected();
    }

    public boolean successMessageState() {
        return checkboxForm.successMessageFacade.isVisible();
    }

    public void clickSingleCheckbox() {
        checkboxForm.singleCheckboxFacade.click();
    }
}
