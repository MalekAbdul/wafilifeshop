package Utilities;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.io.ByteArrayInputStream;
import static Utilities.BaseDriverSetup.getDriver;
public class CustomMethods {
    public WebElement getElement(By locator) {
        return getDriver().findElement(locator);
    }
    public void writeText(By locator, String text) {
        getElement(locator).sendKeys(text);
    }
    public void clickOnElement(By locator) {
        getElement(locator).click();
    }
    public void moveOnElement(By locator)
    {
        Actions action = new Actions(getDriver());
        action.moveToElement(getElement(locator)).perform();
    }
    public void scrollToElemnt(By loactor) {
        WebElement el = getElement(loactor);
        JavascriptExecutor js =(JavascriptExecutor)getDriver();
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        js.executeScript("arguments[0].scrollIntoView();", el);
    }
    public void dropDownWithValue(By locator, String value){

        Select s = new Select(getDriver().findElement(locator));
        s.selectByVisibleText(value);
    }
    public void searchByValue(By locator, String text){
        writeText(locator, text);
        getElement(locator).sendKeys(Keys.ARROW_DOWN);
        getElement(locator).sendKeys(Keys.ENTER);
    }

    public void takeScreenShot(String name) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
