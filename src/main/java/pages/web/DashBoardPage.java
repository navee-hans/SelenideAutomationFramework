package pages.web;

import Locators.web.Locator;
import com.codeborne.selenide.SelenideElement;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class DashBoardPage extends BasePage{

    private String DashBoardLeftMenuBar = Locator.DashBoardPage.DashBoardHeaderTitleCSS;

    public SelenideElement getDashBoardTitleText(){
        SelenideElement element = $(DashBoardLeftMenuBar);
        return element;
    }


}
