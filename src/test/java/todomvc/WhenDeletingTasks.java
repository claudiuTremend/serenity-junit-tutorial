package todomvc;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import todomvc._steps.ModifyTasksActionClass;

import static java.util.Arrays.asList;
import static net.serenitybdd.core.Serenity.getDriver;

public class WhenDeletingTasks {

    @Managed
    WebDriver driver;

    @Steps
    ModifyTasksActionClass modifyTasksActionClass;

    @BeforeEach
    void openTheApp() {
        modifyTasksActionClass.openPage();
    }

    @AfterEach
    void clearTheApp() {
        ((JavascriptExecutor)getDriver()).executeScript("localStorage.clear()");
    }

    @ParameterizedTest
    @CsvSource({
            "Walk the dog;Feed the cat, Feed the cat, Walk the dog",
            "Walk the dog;Feed the cat;Drink water, Feed the cat, Walk the dog;Drink water"
    })
    void shouldDeleteCorrectItems(
            String todoItems,
            String taskToDelete,
            String expectedTasks
    ) {
        modifyTasksActionClass.addTasks(modifyTasksActionClass.convertToList(todoItems));
        modifyTasksActionClass.deleteTaskWithLabel(taskToDelete);

        Serenity.reportThat("Deleted task should not be present", () ->
                Assertions.assertThat(modifyTasksActionClass.getTheListOfTasks())
                        .containsExactlyElementsOf(modifyTasksActionClass.convertToList(expectedTasks))
        );
    }

    @Test
    void shouldCompleteAndClearAllItems() {
        modifyTasksActionClass.addTasks(asList("Walk the dog", "Feed the cat", "Drink water"));

        modifyTasksActionClass.clearCompletedButtonState().shouldNotBeVisible();
        modifyTasksActionClass.completeAll();
        modifyTasksActionClass.clearCompleted();

        Assertions.assertThat(modifyTasksActionClass.getTheListOfTasks()).isEmpty();
    }
}
