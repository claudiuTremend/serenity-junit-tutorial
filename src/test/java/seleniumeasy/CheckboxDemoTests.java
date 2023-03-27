package seleniumeasy;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import seleniumeasy._steps.CheckboxFormInteractions;
import seleniumeasy._steps.Navigation;
import seleniumeasy.utility.InputFormPages;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxDemoTests {

    @Managed
    WebDriver driver;

    @Steps
    Navigation navigation;

    @Steps
    CheckboxFormInteractions checkboxFormInteractions;

    @Test
    public void singleCheckBoxDemo() {
        navigation.openPage(InputFormPages.CheckBoxForm);

        assertThat(checkboxFormInteractions.singleCheckboxIsClicked()).isFalse();
        assertThat(checkboxFormInteractions.successMessageState()).isFalse();

        checkboxFormInteractions.clickSingleCheckbox();

        assertThat(checkboxFormInteractions.singleCheckboxIsClicked()).isTrue();
        assertThat(checkboxFormInteractions.successMessageState()).isTrue();
    }
}
