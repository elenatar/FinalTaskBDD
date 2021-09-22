package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@name='submit.add-to-registry.wishlist.unrecognized']")
    private WebElement addToListButton;

    @FindBy(xpath = "//div[@class='w-popover-header']")
    private WebElement addToListHeader;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void clickAddToListButton() {
        addToListButton.click();
    }

    public WebElement getAddToListButton() {
        return addToListButton;
    }

    public WebElement getAddToListHeader() { return addToListHeader; }
}
