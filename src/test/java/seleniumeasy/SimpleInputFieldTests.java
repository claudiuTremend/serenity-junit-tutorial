package seleniumeasy;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import seleniumeasy._steps.Navigation;
import seleniumeasy._steps.SimpleInputFieldInteractions;
import seleniumeasy.utility.InputFormPages;

public class SimpleInputFieldTests {

    @Managed()
    WebDriver driver;

    @Steps
    Navigation navigation;

    @Steps
    SimpleInputFieldInteractions simpleInputFieldInteractions;

    @BeforeEach
    public void navigate() {
        navigation.openPage(InputFormPages.SimpleInputFieldForm);
    }

    @Test
    public void singleInputFieldTest() {
        simpleInputFieldInteractions.enterMessage("This is my message");

        simpleInputFieldInteractions.clickButtonWithLabel("Show Message");

        Serenity.reportThat("The message displayed should be the one from input",
                () -> Assertions.assertThat(simpleInputFieldInteractions.getDisplayedMessageForLabel("Your Message"))
                        .isEqualTo("This is my message"));
    }

    @Test
    public void twoInputFieldTest() {
        simpleInputFieldInteractions.enterAMessage("2", "5");

        simpleInputFieldInteractions.clickButtonWithLabel("Get Total");

        Serenity.reportThat("The total displayed should be 7",
                () -> Assertions.assertThat(simpleInputFieldInteractions.getDisplayedMessageForLabel("Total a + b = "))
                        .isEqualTo("7"));
    }
}
