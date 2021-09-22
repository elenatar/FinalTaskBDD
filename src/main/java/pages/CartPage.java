package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//a[@id='a-autoid-0-announce']")
    private WebElement signInToYourAccountButton;

    @FindBy(xpath = "//a[@id='a-autoid-1-announce']")
    private WebElement signUpNowButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignInToYourAccountButton() {
        signInToYourAccountButton.click();
    }

    public void clickSignUpNowButton() { signUpNowButton.click(); }
}
