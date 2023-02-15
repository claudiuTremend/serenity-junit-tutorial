package serenityswag.cart;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

import java.util.List;

public class Cart extends PageObject {

    public static By cartLink() {
        return (By) By.cssSelector(".shopping_cart_link");
    }

    public int spanOfNumberDisplayed() {
        return Integer.parseInt($(".shopping_cart_badge").getText());
    }

    public List<String> listOfItemsInTheCart() {
        return $$("//div[@class='inventory_item_name']").textContents();
    }
}
