package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class SearchWithValidData extends BaseTest {
    @Test
    public void verifySearchResultWithValidData() throws InterruptedException {
        googlePage.enterSearchQuery(prop.getProperty("validData"));
        actions.sendKeys(Keys.ENTER).build().perform();
        String substringToCheck = "results";
        boolean isTextContained = searchResultPage.doesElementTextContain(substringToCheck);

        if (isTextContained) {
            System.out.println("Text contains: " + substringToCheck);

        } else {
            System.out.println("Text does not contain: " + substringToCheck);
        }
    }

}
