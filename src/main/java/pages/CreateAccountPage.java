package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage{

    @FindBy(xpath = "//div[@class='a-section a-padding-medium auth-workflow']")
    private WebElement createAccountPage;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCreateAccountPageVisible() {
        return  createAccountPage.isDisplayed();
    }
}
