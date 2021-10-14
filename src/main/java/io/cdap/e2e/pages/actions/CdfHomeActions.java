package io.cdap.e2e.pages.actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.cdap.e2e.utils.SeleniumDriver;

public class CdfHomeActions {
    public static io.cdap.e2e.pages.locators.CdfHomeLocators CdfHomeLocators = null;

    static {

        CdfHomeLocators = PageFactory.initElements(SeleniumDriver.getDriver(), io.cdap.e2e.pages.locators.CdfHomeLocators.class);

    }

    public static void clickStudio()
    {

        JavascriptExecutor js = (JavascriptExecutor)SeleniumDriver.getDriver();
        WebElement element= io.cdap.e2e.pages.locators.CdfHomeLocators.studio;
           js.executeScript("arguments[0].click();",element);
        System.out.println("FIrst case passed");

    }



}