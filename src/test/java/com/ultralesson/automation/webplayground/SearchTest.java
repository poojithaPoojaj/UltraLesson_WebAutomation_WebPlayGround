package com.ultralesson.automation.webplayground;

import com.ultralesson.automation.webplayground.drivers.DriverCreator;
import com.ultralesson.automation.webplayground.models.Item;
import com.ultralesson.automation.webplayground.pages.HomePage;
import com.ultralesson.automation.webplayground.pages.LauncherPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {
    @Test
    public void verifyIfSearchTermShowsRelevantResults() {
        //Arrange
        String searchItem = "Jeans";
        String searchKey = "Jean";
        String browser="firefox";
//        WebDriver webdriver=new DriverCreator().create(browser);
        WebDriver webDriver=new DriverCreator().createDriverContext(browser).create();
        LauncherPage launcherPage = new LauncherPage(webDriver); // Assume webdriver is created and                                                                      // handy
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        //Act
        HomePage homepage = new HomePage(webDriver);
        homepage.search(searchItem);
        List<Item> searchItems = homepage.getSearchItems();

        //Assert
//        Assert.assertEquals(4, searchItems.size());
//        Assert.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(searchKey)));
    }
    @Test
    public void searchUnAvailableProduct(){

    }
    public void verifyIfSearchWithBrandItemsShowingRelevantResults(){

    }
    public void verifySearchResultPageShowingEqualAmountOfItemsDisplayed(){

    }
}
