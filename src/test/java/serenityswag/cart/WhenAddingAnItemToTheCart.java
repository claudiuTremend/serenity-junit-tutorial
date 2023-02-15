package serenityswag.cart;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.inventory.ProductList;
import serenityswag.inventory.ProductListActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

@RunWith(SerenityRunner.class)
public class WhenAddingAnItemToTheCart {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    ProductListActions productListActions;

    @Steps
    CartActions cartActions;

    ProductList productList;
    Cart cart;

    @Before
    public void login() {
        login.as(STANDARD_USER);
    }

    @Test
    public void theCorrectItemCountShouldBeShown() {

        List<String> productTitles = productList.titles();
        productTitles.forEach(productName ->
                productListActions.addItemToCart(productName));

        int numberOfItemsAdded = cart.spanOfNumberDisplayed();

        Serenity.reportThat("The number of products in the cart should be 6",
                () -> assertThat(numberOfItemsAdded).isEqualTo(6));
    }

    @Test
    public void allTheItemsShouldAppearInTheCart() {

        List<String> productTitles = productList.titles();
        productListActions.addItemsToCart(productTitles);

        cartActions.openCart();

        List<String> productTitlesFromCart = cart.listOfItemsInTheCart();

        Serenity.reportThat("The list of added products should be the same as the list of products in the cart",
                () -> assertThat(productTitlesFromCart).containsAll(productTitles));
    }
}
