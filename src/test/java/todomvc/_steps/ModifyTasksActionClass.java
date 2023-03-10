package todomvc._steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.ui.Label;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import todomvc._pages.ToDoPageObject;

import java.util.Arrays;
import java.util.List;

public class ModifyTasksActionClass extends UIInteractionSteps {


    ToDoPageObject toDoPageObject;
    public void openPage() {
        toDoPageObject.open();
    }

    @Step("Adding the task: {0}")
    public void addThisTask(String task) {
        $(ToDoPageObject.taskInput).typeAndEnter(task);
    }

    @Step("Complete task: {0}")
    public void completeTaskWithLabel(String label) {
        $("//li[contains(.,'" + label + "')]/div/input").click();
    }

    @Step("Filter by: {0}")
    public void filterBy(String filter) {
        $(By.linkText(filter)).click();
    }

    @Step("Delete task with label {0}")
    public void deleteTaskWithLabel(String taskLabel) {
        WebElementFacade deleteButton = $("//li[contains(.,'" + taskLabel + "')]/div/button");
        WebElementFacade label = $("//li[contains(.,'" + taskLabel + "')]/div/label");
        withAction().moveToElement(label).click().perform();
        withAction().moveToElement(deleteButton).click().perform();
    }

    public void addTasks(List<String> tasks) {
        tasks.forEach(task -> addThisTask(task));
    }

    public List<String> getTheListOfTasks() {
        return toDoPageObject.getTheTaskList();
    }

    public String getCountText() {
        return $(toDoPageObject.countSpan).getText();
    }

    public WebElementState clearCompletedButtonState() {
        return $(toDoPageObject.CLEAR_COMPLETED_BUTTON);
    }

    public List<String> convertToList(String items) {
        return Arrays.asList(items.split(";"));
    }

    public void completeAll() {
        $(toDoPageObject.COMPLETE_ALL).click();
    }

    public void clearCompleted() {
        $(toDoPageObject.CLEAR_COMPLETED_BUTTON).click();
    }
}
