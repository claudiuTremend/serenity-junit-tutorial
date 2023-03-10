package herokuapp;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://the-internet.herokuapp.com/hovers")
public class HoverPage extends PageObject {

    public static final String VISIBLE_FIGURE = "(//*[@class='figure'])[{0}]";

    public void hoverOverFigure(int number) {
        WebElementFacade figure = $(VISIBLE_FIGURE, number);

        withAction().moveToElement(figure).perform();
    }

    public WebElementState captionForFigure(int number) {
        return $("(//*[@class='figcaption'])[{0}]", number);
    }
}
