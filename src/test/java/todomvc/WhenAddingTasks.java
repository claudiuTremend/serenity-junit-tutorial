package todomvc;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import todomvc._pages.ToDoPageObject;
import todomvc._steps.ModifyTasksActionClass;

import java.util.Arrays;

import static net.serenitybdd.core.Serenity.getDriver;

public class WhenAddingTasks {

    // TODO: Exercise 1
    ToDoPageObject toDoPageObject;
    @Steps
    ModifyTasksActionClass modifyTasksActionClass;

    @Managed()
    WebDriver driver;

    @BeforeEach
    void openTheApp() {
        toDoPageObject.open();
    }

    @AfterEach
    void clearTheApp() {
        ((JavascriptExecutor)getDriver()).executeScript("localStorage.clear()");
    }

    @Nested
    @DisplayName("Adding single or multiple tasks")
    class FirstNestedClass {

        @Test
        public void addingASingleTask() {
            // Add "Feed The Cat" to the list
            // Check that "Feed The Cat" appears in the list

            // open the todo app

            // add the task
            modifyTasksActionClass.addThisTask("Feed The Cat");

            // check that the task appears
            Serenity.reportThat("Check that the task Feed The Cat exists!", () ->
                    Assertions.assertThat(toDoPageObject.getTheTaskList()).contains("Feed The Cat"));
        }

        // TODO: Exercise 2
        @Test
        public void addingMultipleTasks() {
            // Add "Feed The Cat" and "Walk the dog" to the list
            // Check that they all appear in the list

            // open the todo app

            // add the tasks
            modifyTasksActionClass.addThisTask("Feed The Cat");
            modifyTasksActionClass.addThisTask("Walk The Dog");

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(toDoPageObject.getTheTaskList());

            Serenity.reportThat("The list of tasks contains the added tasks", () ->
                    Assertions.assertThat(toDoPageObject.getTheTaskList())
                            .containsExactly("Feed The Cat", "Walk The Dog"));
        }
    }

    @Nested
    @DisplayName("When testing the number of added tasks")
    class SecondNestedClass {

        @Test
        void shouldBeTheCorrectNumberOfItems() {
            modifyTasksActionClass.addTasks(Arrays.asList("Feed The Cat", "Walk The Dog", "Milk the cow"));

            Assertions.assertThat(modifyTasksActionClass.getTheListOfTasks()).hasSize(3);
        }

        @Test
        void shouldDisplayTheCorrectNumberOfItems() {
            modifyTasksActionClass.addTasks(Arrays.asList("Feed The Cat", "Walk The Dog", "Milk the cow"));

            Assertions.assertThat(modifyTasksActionClass.getCountText()).contains("3 items left");
        }

        @Test
        void shouldTestClearCompletedButton() {
            modifyTasksActionClass.clearCompletedButtonState().shouldNotBeVisible();
        }
    }
}
