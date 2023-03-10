package seleniumeasy;

import net.thucydides.core.annotations.Managed;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;

public class CalculationTestJUnit5 {

    @Managed
    WebDriver driver;

    TwoInputFieldForm twoInputFieldForm;

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "2, 3, 5",
            "5, 10, 15"
    })
    public void shouldCalculateTheCorrectTotal(String a, String b, String expectedResult) {
        twoInputFieldForm.open();

        twoInputFieldForm.enterA(a);
        twoInputFieldForm.enterB(b);

        twoInputFieldForm.getTotal();

        Assertions.assertThat(twoInputFieldForm.displayedTotal()).isEqualTo(expectedResult);
    }
}
