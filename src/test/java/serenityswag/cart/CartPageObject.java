package serenityswag.cart;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.ui.Button;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPageObject extends PageObject {

    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By CART_ITEMS = By.className("cart_item");
    public static final By ITEM_NAME = By.className("inventory_item_name");
    public static final By ITEM_DESCRIPTION = By.className("inventory_item_desc");
    public static final By ITEM_PRICE = By.className("inventory_item_price");

    @FindBy(id = "checkout")
    WebElementFacade checkoutButton;

    @FindBy(css = ".cart_item")
    List<WebElementFacade> cartItemElements;

    public void checkout() {
        checkoutButton.click();
    }

    public List<CartItem> items() {
//        List<CartItem> items = new ArrayList<>();
//        cartItemElements.forEach(item -> {
//            String name = item.findBy(".inventory_item_name").getText();
//            String description = item.findBy(".inventory_item_desc").getText();
//            Double price = getPrice(item.findBy(".inventory_item_price").getText());
//            items.add(new CartItem(name, description, price));
//        });
//        return items;

        return $$(CART_ITEMS).map(
                item -> new CartItem(
                    item.findBy(ITEM_NAME).getText(),
                    item.findBy(ITEM_DESCRIPTION).getText(),
                    getPrice(item.findBy(ITEM_PRICE).getText())
        ));
    }

    private Double getPrice(String priceString) {
        return Double.parseDouble(priceString.replace("$", ""));
    }
}
