package todomvc._pages;

import com.vladsch.flexmark.util.html.HtmlFormattingAppendable;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.ui.Label;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://todomvc.com/examples/angularjs/#/")
public class ToDoPageObject extends PageObject {

    public static final By taskInput = By.cssSelector(".new-todo");
    public static final By countSpan = By.cssSelector(".todo-count");
    public static final SearchableTarget COMPLETE_ALL = Label.forField("toggle-all");

    public static final By CLEAR_COMPLETED_BUTTON = By.cssSelector(".clear-completed");

    public String getTaskWithLabel(String taskLabel) {
        return $(".view").getText();
    }

    public List<String> getTheTaskList() {
        return $$("//div[@class='view']/label").textContents();
    }
}
