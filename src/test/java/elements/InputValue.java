package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputValue extends BaseElement {
//    Конструктор
    public InputValue(WebDriver driver, By by) {
        super(driver, by);
    }

    //
    public void inputValue(String value) {
        WaitFor.visibilityOfElementLocated(by);
        WaitFor.clickabilityOfElement(webElement);
        webElement.click();
        webElement.sendKeys(value);
    }
}
