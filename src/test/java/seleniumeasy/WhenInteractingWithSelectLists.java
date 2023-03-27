package seleniumeasy;

import net.thucydides.core.annotations.Managed;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import seleniumeasy._page.SelectListPage;

import java.util.Arrays;

public class WhenInteractingWithSelectLists {

    @Managed
    WebDriver driver;

    SelectListPage selectListPage;

    @Test
    public void shouldDisplayAllTheSelectedOptions() {
        selectListPage.open();

        selectListPage.selectOptionWithValue(Arrays.asList("Florida"));

        selectListPage.getAllButton();

        Assertions.assertThat(selectListPage.optionsSelected()).contains("Florida", "Texas");
    }
}
