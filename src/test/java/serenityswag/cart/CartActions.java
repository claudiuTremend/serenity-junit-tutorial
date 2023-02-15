package serenityswag.cart;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.cart.Cart;

public class CartActions extends UIInteractionSteps {

    @Step("Enter the cart page")
    public void openCart() {
        $(Cart.cartLink()).click();
    }
}
