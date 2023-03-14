package org.example.deque2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class DequeTest extends BaseClass {

    WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(3));

    @Test (priority = 0)
    public void validateMainNav(){

        WebElement e = driver.findElement(By.xpath("//nav[@id='main-nav']"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//nav[@id='main-nav']")));
        Assert.assertEquals(e.isDisplayed(), true, "Main-nav not found.");
    }

    @Test (priority = 1)
    public void validateRadioButtons(){

        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='widget-controls']//form//input[@type='radio']"));
        Assert.assertEquals(elements.size(), 5, "Elements count does not match");
    }

    @Test (priority = 2)
    public void addTravellerAndValidate(){

        WebElement traveller_dropdown = driver.findElement(By.xpath("//div[@class='dynamic']//div[contains(@id, 'r-passenger')]"));
        Assert.assertEquals(traveller_dropdown.isDisplayed(), false);
        WebElement traveller_select = driver.findElement(By.xpath("//a[@class='add-traveler']"));
        wait.until(ExpectedConditions.elementToBeClickable(traveller_select));
        traveller_select.click();
        wait.until(ExpectedConditions.visibilityOf(traveller_dropdown));
        Assert.assertEquals(traveller_dropdown.isDisplayed(), true);

    }

    @Test (priority = 3)
    public void validateVideoText(){

        WebElement video_heading = driver.findElement(By.xpath("//h3[@id='video-text']"));
        Assert.assertEquals(video_heading.getText(), "Life was possible on Mars");
        WebElement next_arrow = driver.findElement(By.xpath("//div[@class='vid-arrows nextvid']"));
        next_arrow.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertEquals(video_heading.getText(), "Why Mars died");
    }
}
