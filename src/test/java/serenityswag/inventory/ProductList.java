package serenityswag.inventory;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

import java.util.List;

public class ProductList extends UIInteractionSteps {

    public List<String> titles() {

        return $$(".inventory_item_name").textContents();
    }
    public static By productDetailsLinkFor(String itemName) {
        return By.linkText(itemName);
    }

    public String imageTextForProduct(String productName) {
        return $("//div[@class='inventory_item'][contains(.,'" + productName + "')]//img").getAttribute("alt");
    }
}
