package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import constants.web.ApplicationConstants;
import constants.web.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.DashBoardPage;
import pages.web.LoginPage;

import java.util.List;

public class LoginPageStepdef {
    LoginPage loginPage;
    DashBoardPage dashBoardPage;

    @Given("Enter valid Username & Password")
    public void enter_valid_username_password() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.setUsername(ApplicationConstants.Login.StandardUserName);
        loginPage.setPassword(ApplicationConstants.Login.Password);
    }

    @When("Click on Login button")
    public void click_on_login_button() throws InterruptedException {
        loginPage.clickLoginButton();
    }

    @Then("Verify user should navigate to {string} page")
    public void verify_user_should_navigate_to_dashboard_screen(String menuText) {
    dashBoardPage = new DashBoardPage();
    dashBoardPage.getDashBoardTitleText().shouldBe(Condition.exactText(menuText));
    }
}
