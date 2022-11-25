package pages.web;

import Locators.web.Locator;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage{
    private String UserName = Locator.LoginPage.EmailCSS;
    private String Password = Locator.LoginPage.PasswordCSS;
    private String LoginButton = Locator.LoginPage.LoginButtonCSS;

    public void setUsername(String Username) throws InterruptedException {
        SelenideElement element = $(UserName);
        sendKeys(element, Username);
    }

    public void setPassword(String password) throws InterruptedException {
        SelenideElement element = $(Password);
        sendKeys(element, password);
    }

    public void clickLoginButton() throws InterruptedException {
        SelenideElement loginButton = $(LoginButton);
        click(loginButton);
    }
}
