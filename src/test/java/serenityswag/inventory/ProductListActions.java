package serenityswag.inventory;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class ProductListActions extends UIInteractionSteps {

    @Step("Add {0} to cart")
    public void addItemToCart(String productName) {
        $(ProductList.addToCartButton(productName)).click();
    }

    @Step("Add {0} to cart")
    public void addItemsToCart(List<String> products) {
        products.forEach(productName -> $(ProductList.addToCartButton(productName)).click());
    }
}
