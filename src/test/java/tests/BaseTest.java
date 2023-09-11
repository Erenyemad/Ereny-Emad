package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import pages.GooglePage;
import pages.SearchResultPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    private EdgeDriver driver;
    GooglePage googlePage;
   SearchResultPage searchResultPage;
    Actions actions;
    Properties prop;

    @BeforeClass
    public void setUp() throws IOException {
        prop = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//config//data.properties");
        prop.load(file);
        driver=new EdgeDriver();
        WebDriverManager.edgedriver().setup();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        googlePage=new GooglePage(driver);
        searchResultPage =new SearchResultPage(driver);
         actions=new Actions(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();

    }


}
