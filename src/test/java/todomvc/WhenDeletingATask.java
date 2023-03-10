package todomvc;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import todomvc._pages.ToDoPageObject;
import todomvc._steps.ModifyTasksActionClass;

@DisplayName("When Deleting A Task Story")
public class WhenDeletingATask {

    @Managed
    WebDriver webDriver;

    @Steps
    ModifyTasksActionClass modifyTasksActionClass;
    ToDoPageObject toDoPageObject;

    // TODO: Exercise 5
    @Test
    public void deletedItemsShouldDissapearFromTheList() {

        modifyTasksActionClass.openPage();

        // Add "Feed the cat" and "Walk the dog" to the list
        modifyTasksActionClass.addThisTask("Feed The Cat");
        modifyTasksActionClass.addThisTask("Walk The Dog");

        // Delete "Feed the cat"
        modifyTasksActionClass.deleteTaskWithLabel("Feed The Cat");

        // Check that only "Walk the dog" appears
        Serenity.reportThat("The list of taks should display only one task", () ->
                Assertions.assertThat(toDoPageObject.getTheTaskList()).containsExactly("Walk The Dog"));
    }
}