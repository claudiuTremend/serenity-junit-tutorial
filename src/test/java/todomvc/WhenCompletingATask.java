package todomvc;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import todomvc._pages.ToDoPageObject;
import todomvc._steps.ModifyTasksActionClass;

@RunWith(SerenityRunner.class)
public class WhenCompletingATask {

    @Managed
    WebDriver webDriver;

    @Steps
    ModifyTasksActionClass modifyTasksActionClass;

    ToDoPageObject toDoPageObject;

    @Before
    public void doBefore() {
        modifyTasksActionClass.openPage();

        // Add "Feed the cat" and "Walk the dog" to the list
        modifyTasksActionClass.addThisTask("Feed The Cat");
        modifyTasksActionClass.addThisTask("Walk The Dog");

        // Complete "Feed the cat"
        modifyTasksActionClass.completeTaskWithLabel("Feed The Cat");

    }

    // TODO: Exercise 3
    @Test
    public void activeTasksShouldNotShowCompletedTasks() {
        // Filter by "Active"
        modifyTasksActionClass.filterBy("Active");

        // Check that only "Walk the dog" appears
        Serenity.reportThat("Check that the completed task is not visible", () ->
                Assertions.assertThat(toDoPageObject.getTheTaskList()).doesNotContain("Feed The Cat"));
    }

    // TODO: Exercise 4
    @Test
    public void completedTasksShouldNotShowActiveTasks() {
        // Filter by "Completed"
        modifyTasksActionClass.filterBy("Completed");

        // Check that only "Feed the cat" appears
        Serenity.reportThat("Check that the incomplete task is not visible", () ->
                Assertions.assertThat(toDoPageObject.getTheTaskList()).doesNotContain("Walk The Dog"));
    }
}
