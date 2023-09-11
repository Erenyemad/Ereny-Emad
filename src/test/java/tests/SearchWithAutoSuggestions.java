package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchWithAutoSuggestions extends BaseTest {

    @Test
    public void testAutoSuggestions() throws InterruptedException {
        googlePage.enterSearchQuery(prop.getProperty("suggestQuery"));

        if (googlePage.areAutoSuggestionsDisplayed()) {
            googlePage.clickAutoSuggestion(0);
        } else {
            System.out.println("Auto-suggestions are not displayed.");
        }

        Assert.assertTrue(searchResultPage.areResultsDisplayed());



    }
}
