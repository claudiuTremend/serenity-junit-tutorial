package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductDetailsPageObject extends PageObject {
    public String productName() {
        return $(".inventory_details_name").getText();
    }

    public WebElementState productImageWithAltValueOf(String firstItemName) {
        return find(By.cssSelector(".inventory_details_container img[alt='" + firstItemName + "']"));
    }
}
