package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchWithEmptyData  extends BaseTest {
    @Test
    public void verifySearchResultWithEmptyData(){
        googlePage.enterSearchQuery(prop.getProperty("EmptyData"));
        actions.sendKeys(Keys.ENTER).build().perform();
        String ExpectedResult=googlePage.getCurrentUrl();
        String ActualResult="https://www.google.com/";
        Assert.assertEquals(ExpectedResult,ActualResult);








    }

}
