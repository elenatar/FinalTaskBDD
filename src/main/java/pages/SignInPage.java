package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{
    //h4[@class='a-alert-heading']
    @FindBy(xpath = "//div[@class='a-section a-padding-medium auth-workflow']")
    private WebElement signInPageContainer;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//span[@class='a-list-item']")
    private WebElement warningField;

    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    private WebElement createYourAmazonAccountButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignInPageVisible() {
        return signInPageContainer.isDisplayed();
    }

    public void enterSymbolsToEmailField(final String keyword) {
        emailField.clear();
        emailField.sendKeys(keyword);
    }

    public void clickContinueButton() {
       continueButton.click();
    }

    public boolean isWarningFieldVisible() {
        return warningField.isDisplayed();
    }

    public String  getWarningFieldText() {
        return warningField.getText();
    }

    public WebElement getWarningField() {
        return warningField;
    }

    public void clickCreateYourAmazonAccountButton() {
        createYourAmazonAccountButton.click();
    }
}
