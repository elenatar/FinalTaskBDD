package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class SearchPage extends BasePage {

    private static final String PRICE_FIELD= "//span[@class='a-price-whole']";

    @FindBy(xpath = "//div[@class='a-section aok-relative s-image-fixed-height']")
    private List<WebElement> productsList;

    @FindBy(xpath = "//div[contains(@class,'list-col-right')]")
    private List<WebElement> searchResultsList;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstProductWithPrice() {
        WebElement targetElement = productsList.stream()
                .filter(e -> {
                    WebElement priceElement = e.findElement(By.xpath(PRICE_FIELD));
                    return Objects.nonNull(priceElement) && !priceElement.getText().isBlank();
                })
                .findAny()
                .orElseThrow(() -> new RuntimeException("Don't find any element with price"));
        targetElement.click();
    }

    public List<WebElement> getSearchedResultsList() {
        return searchResultsList;
    }

}
