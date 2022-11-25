package pages.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static com.codeborne.selenide.files.DownloadActions.click;

public class BasePage {

    public BasePage(){
    }

    public static void click(SelenideElement element) throws InterruptedException {
        highlightElement(element).click();
    }

    public static void sendKeys(SelenideElement element, String text) throws InterruptedException {
        highlightElement(element).sendKeys(text);
    }

    public static String getText(SelenideElement element) throws InterruptedException {
        return highlightElement(element).getText();
    }

    public static SelenideElement highlightElement(SelenideElement element) {
        JavascriptExecutor js = (JavascriptExecutor) webdriver().driver().getWebDriver();
        js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');",element);
        return element;
    }
}
