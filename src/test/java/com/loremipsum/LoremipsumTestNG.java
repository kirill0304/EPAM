package com.loremipsum;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.apache.commons.lang.StringUtils.countMatches;
import static org.openqa.selenium.By.xpath;



public class LoremipsumTestNG {
    private WebDriver driver;

    int  countLorem = 0;


    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    @BeforeTest
    public void profileSetUp(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://lipsum.com/");
    }
    @Test(description = "Task1/Part1-Test#1")
    public void verifyTheWordFishCorrectlyAppearsInThe1Paragraph() {
        driver.findElement(xpath("//a[@href='http://ru.lipsum.com/']")).click();
        String elementTextFish = driver.findElement(xpath("//*[contains(text(), 'рыба')]")).getText();
        Assert.assertTrue(elementTextFish.contains("рыба"));
    }
    @Test(description = "Task1/Part1-Test#2")
    public void verifyDefaultSettingResultStartingWithTextLoremIpsum(){
        driver.findElement(xpath("//input [@name='generate']")).click();
        String elementText = driver.findElement(xpath("//div[@id = 'lipsum']/p[1]")).getText();
        Assert.assertTrue(elementText.startsWith("Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
    }
    @Test(description = "Task2/Part2-Test#1")
    public void verifyLoremIpsumIsGeneratedWithCorrectSize()  {
        driver.findElement(xpath("//input[@value='words']")).click();
        driver.findElement(xpath("//input[@name='amount']")).clear();
        driver.findElement(xpath("//input[@name='amount']")).sendKeys("10");
        driver.findElement(xpath("//input [@name='generate']")).click();
        waitForPageLoadComplete(100);
        String elementTextGenerated = driver.findElement(xpath("//div[@id = 'generated']")).getText();
        Assert.assertTrue(elementTextGenerated.contains("10 words"));
        String stringElement = driver.findElement(xpath("//div[@id='lipsum']")).getText();
        int actualAmountOfWords = stringElement.split(" ").length;
        Assert.assertEquals(actualAmountOfWords, 10);
    }
    @Test(description = "Task2/Part2-Test#2")
    public void verifyTheCheckbox(){
        driver.findElement(xpath("//input[@name='start']")).click();
        driver.findElement(xpath("//input [@name='generate']")).click();
        waitForPageLoadComplete(100);
        String elementText = driver.findElement(xpath("//div[@id = 'lipsum']/p[1]")).getText();
        Assert.assertFalse(elementText.startsWith("Lorem ipsum"));
    }
    @Test(description = "Task2/Part2-Test#3",priority = 1, invocationCount = 10, groups = "RandomlyGeneratedTextContainLorem")
    public void checkIfRandomlyGeneratedTextContainLorem()  {
        driver.findElement(xpath("//input[@name='amount']")).clear();
        driver.findElement(xpath("//input[@name='amount']")).sendKeys("5");
        driver.findElement(xpath("//input [@name='generate']")).click();
        waitForPageLoadComplete(200);
        for (int i=1; i<6; i++) {
            String elementText = driver.findElement(xpath("//div[@id = 'lipsum']/p[" + i + "]")).getText();
            String findLorem = "lorem";
            int count = countMatches(elementText.toLowerCase(), findLorem);
            if (count>=1){
                countLorem ++;}
        }
        }
@Test (description = "Task2/Part2-Test#3p2", dependsOnMethods={"checkIfRandomlyGeneratedTextContainLorem"}, groups = "RandomlyGeneratedTextContainLorem", alwaysRun = true)
        public void after10repeats(){
     int countAverageLorem = countLorem/10;
        Assert.assertTrue(countAverageLorem>= 2);

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}

