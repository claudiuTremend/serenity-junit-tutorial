package seleniumeasy._steps;

import net.serenitybdd.core.steps.UIInteractionSteps;
import seleniumeasy.utility.InputFormPages;

public class Navigation extends UIInteractionSteps {
    public void openPage(InputFormPages pageName) {
        openPageNamed(pageName.name());
    }
}
