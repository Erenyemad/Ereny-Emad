package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GooglePage {

    private WebDriver driver;

    private By searchBox = By.name("q");
    private By googleSearchButton=By.name("btnK");



    private By autoSuggestionDropdown=By.xpath("//ul[@role='listbox']");
    private By autoSuggestions = By.xpath("//ul[@role='listbox']//li[@role='presentation']");

    public GooglePage(WebDriver driver) {
        this.driver=driver;
    }

    public By getGoogleSearchButton() {
        return googleSearchButton;
    }

    public By getSearchBox() {
        return searchBox;
    }
    public By getAutoSuggestionDropdown() {
        return autoSuggestionDropdown;
    }

    public void enterSearchQuery(String text){
        driver.findElement(searchBox).sendKeys(text);

    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public boolean areAutoSuggestionsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAutoSuggestionDropdown()));

        WebElement Dropdown = driver.findElement(autoSuggestionDropdown);
        return Dropdown.isDisplayed();


    }

    public void clickAutoSuggestion(int index) {
        List<WebElement> suggestions = driver.findElements(autoSuggestions);
        if (index >= 0 && index < suggestions.size()) {
            suggestions.get(index).click();
        } else {
            throw new IllegalArgumentException("Invalid index for auto-suggestion: " + index);
        }
    }




}
