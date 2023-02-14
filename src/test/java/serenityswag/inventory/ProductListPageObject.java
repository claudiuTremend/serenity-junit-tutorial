package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

public class ProductListPageObject extends PageObject {

    public List<String> titles() {
        return $$(".inventory_item_name").textContents();
    }

    public void openProductDetailsFor(String itemName) {
        $(By.linkText(itemName)).click();
    }

    public String imageTextForProduct(String productName) {
        return $("//div[@class='inventory_item'][contains(.,'" + productName + "')]//img").getAttribute("alt");
    }
}