package todomvc;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import todomvc._pages.ToDoPageObject;
import todomvc._steps.ModifyTasksActionClass;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;

@RunWith(SerenityParameterizedRunner.class)
public class WhenFilteringTasks {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    ModifyTasksActionClass modifyTasksActionClass;
    ToDoPageObject toDoPageObject;

    private String filterBy;
    private List<String> todoItems;
    private String completedItem;
    private List<String> expectedItems;

    public WhenFilteringTasks(String filterBy, List<String> todoItems, String completedItem, List<String> expectedItems) {
        this.filterBy = filterBy;
        this.todoItems = todoItems;
        this.completedItem = completedItem;
        this.expectedItems = expectedItems;
    }

    @TestData(columnNames = "Filter by, Task List, Completed Item, Expected List")
    public static Collection<Object[]> testData() {
        return asList(
                new Object[][]{
                        {"Active", asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Walk the dog")},
                        {"Completed", asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Feed the cat")},
                        {"All", asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Feed the cat", "Walk the dog")}
                }
        );
    }

    @Test
    public void shouldDisplayCorrectFilteredItems() {
        modifyTasksActionClass.openPage();

        modifyTasksActionClass.addTasks(todoItems);
        modifyTasksActionClass.completeTaskWithLabel(completedItem);
        modifyTasksActionClass.filterBy(filterBy);

        Serenity.reportThat("Should display " + expectedItems, () ->
                        Assertions.assertThat(toDoPageObject.getTheTaskList()).containsExactlyElementsOf(expectedItems)
                );
    }
}
