package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement amountOfProductsInCart;

    @FindBy(xpath = "//a[@id='nav-cart']")
    private WebElement cartButton;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    private WebElement signInButton;

    public HomePage(WebDriver driver) { super(driver); }

    public void openHomePage(String url) { driver.get(url); }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void enterKeywordToSearchField(final String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public String getTextOfAmountProductsInCart() {
        return amountOfProductsInCart.getText();
    }

    public void clickSignInButton() { signInButton.click(); }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public void clickCartButton() { cartButton.click(); }

    public boolean isCartButtonVisible() {
        return cartButton.isDisplayed();
    }

}
