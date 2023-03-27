package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy._page.TwoInputFieldForm;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent
@UseTestDataFrom("test-data/calculations.csv")
public class CalculationsTest {

    private String a;
    private String b;
    private String total;

    @Managed(driver = "firefox")
    WebDriver driver;

//    @TestData(columnNames = "A, B, Total")
//    public static Collection<Object[]> testData() {
//        return Arrays.asList(
//             new Object[][] {
//                     {"1", "2", "3"},
//                     {"10", "2", "12"},
//                     {"11", "22", "33"},
//                     {"0", "10", "10"},
//                     {"1", "20", "21"},
//             }
//        );
//    }

    TwoInputFieldForm twoInputFieldForm;

    @Qualifier
    public String qualifier() {return a + " + " + b + " = " + total;}

    @Test
    public void shouldCalculateTheCorrectTotal() {
        twoInputFieldForm.open();

        twoInputFieldForm.enterA(a);
        twoInputFieldForm.enterB(b);
        twoInputFieldForm.getTotal();

        Assertions.assertThat(twoInputFieldForm.displayedTotal()).isEqualTo(total);
    }
}
