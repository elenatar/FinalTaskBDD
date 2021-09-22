package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    SearchPage searchPage;
    ProductPage productPage;
    SignInPage signInPage;
    CartPage cartPage;
    CreateAccountPage createAccountPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
        initPages();
    }

    private void initPages() {
        homePage = pageFactoryManager.getHomePage();
        searchPage = pageFactoryManager.getSearchPage();
        productPage = pageFactoryManager.getProductPage();
        signInPage = pageFactoryManager.getSignInPage();
        cartPage = pageFactoryManager.getCartPage();
        createAccountPage = pageFactoryManager.getCreateAccountPage();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void checkSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @When("User makes search by keyword {string}")
    public void searchByKeyword(final String keyword) {
        homePage.enterKeywordToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("User checks that url contains search {string}")
    public void checkThatUrlContainsSearchedKeyword(final String keyword) {
        assertTrue(driver.getCurrentUrl().contains(keyword));
    }

    @And("User clicks on first product")
    public void clickOnFirstProduct() {
        searchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchPage.clickOnFirstProductWithPrice();
    }

    @And("User clicks Add to Cart button on product page")
    public void clickAddToCartButton() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartButton());
        productPage.clickAddToCartButton();
    }

    @Then("User checks that add to cart header is {string}")
    public void checkAddToCartAmountOfProducts(final String keyword) {
        assertEquals(homePage.getTextOfAmountProductsInCart(), keyword);
    }

    @Then("User checks that resulted products title contains search {string}")
    public void checkThatResultedProductsTitleContainsSearchKeyword(final String keyword) {
        for (WebElement webElement : searchPage.getSearchedResultsList()) {
            if(webElement.getText().contains("sponsored")){
                continue;
            }
            assertTrue(webElement.getText().contains(keyword));
        }
    }

    @And("User clicks Add to List button")
    public void clickAddToListButton() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToListButton());
        productPage.clickAddToListButton();
    }

    @Then("User checks that add to cart popup header is {string}")
    public void checkAddToCartPopupHeader(final String expectedText) {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToListHeader());
        assertEquals(productPage.getAddToListHeader().getText(), expectedText);
    }

    @Then("User checks that sign in page appears")
    public void checkThatSignInPageAppears() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(signInPage.isSignInPageVisible());
    }

    @And("User checks Sign in button visibility")
    public void userChecksSignInButtonVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSignInButtonVisible();
    }

    @And("User clicks Sign in button")
    public void clickSignInButton() {
        homePage.clickSignInButton();
    }

    @And("User checks Cart button visibility")
    public void checkCartButtonVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isCartButtonVisible();
    }

    @And("User clicks Cart button")
    public void clickCartButton() {
        homePage.clickCartButton();
    }

    @And("User clicks Sign in to your account button")
    public void clickSignInToYourAccountButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage.clickSignInToYourAccountButton();
    }

    @And("User clicks Sign up now")
    public void clickSignUpNow() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage.clickSignUpNowButton();
    }

    @And("User clicks Continue button")
    public void clickContinueButton() {
        signInPage.clickContinueButton();
    }

    @And("User enters {string} on Email field")
    public void inputSymbolsOnEmailField(final String symbols) {
        signInPage.enterSymbolsToEmailField(symbols);
    }

    @And("User checks that warning field appears")
    public void checkWarningFieldVisibility() {
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getWarningField());
        signInPage.isWarningFieldVisible();
    }

    @And("User checks the warning {string}")
    public void checkWarningMessage(final String message) {
        assertEquals(signInPage.getWarningFieldText(), message);
    }

    @And("Users clicks Create your Amazon account")
    public void clickCreateYourAmazonAccount() {
        signInPage.clickCreateYourAmazonAccountButton();
    }

    @Then("User checks that Create account page appears")
    public void checkCreateAccountPageVisibility() {
        createAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(createAccountPage.isCreateAccountPageVisible());
    }
}
