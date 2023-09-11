package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

   private WebDriver driver;



    private By results =By.id("extabar");
    private By searchResults=By.id("result-stats");


    public SearchResultPage(WebDriver driver)
   {
       this.driver=driver;
   }

    public String getElementText() {
        WebElement element = driver.findElement(results);
        return element.getText();
    }

    public boolean doesElementTextContain(String substring) {
        String elementText = getElementText();
        return elementText.contains(substring);
    }

    public boolean areResultsDisplayed() {
        return driver.findElement(searchResults).isDisplayed();
    }
}


