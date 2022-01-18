package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import pagesloremipsum.HomePage;
import pagesloremipsum.GeneratedPage;
import pagesloremipsum.RadioButton;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionsSteps {
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    RadioButton radioButton;
    GeneratedPage generatedPage;
    private static final int TIME_TO_WAIT = 60;
    private static final String NUMBER_FIELD_INPUT_10 = "10";

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }
    @BeforeMethod
    public void testsSetup(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        driver.close();
    }

    @Given("User opens homepage page")
    public void openPage() {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage();
        homePage.waitForPageLoadComplete(TIME_TO_WAIT);
    }

    @When("User changes language to Russian")
    public void userChangesLanguageToRussian() {
        homePage.changeLanguageRuCuc();
    }

    @Then("Use finds word in the first paragraph and verifies")
    public void useFindsWordInTheThParagraphAndVerifies() {
         homePage.findFirstParagraphAndAssertCuc();
    }

    @When("User clicks on button Generate")
    public void userClicksOnButtonGenerate() {
        homePage.clickOnGenerateButtonCuc();
    }


    @Then("Use checks first paragraph starts with expected sentence")
    public void useChecksFirstParagraphStartsWithExpectedSentence() {
        generatedPage = pageFactoryManager.getGeneratedPage();
        generatedPage.verifyTextParagraphStartWithLorem();

    }

    @And("User chooses radiobutton Words")
    public void userChoosesRadiobuttonWords() {
        radioButton = pageFactoryManager.getRadioButton();
        radioButton.clickOnWordsCuc();
    }

    @And("User enters amount of the word they need")
    public void userEntersAmountOfTheWordTheyNeed() {
        homePage = pageFactoryManager.getHomePage();
        homePage.enterAmountCuc(NUMBER_FIELD_INPUT_10);
    }

    @And("User checks the message has expected amount of words")
    public void userChecksTheMessageHasExpectedAmountOfWords() {
        generatedPage = pageFactoryManager.getGeneratedPage();
        generatedPage.getGenerated10WordsCuc();
    }

    @Then("Use checks generated words amount")
    public void useChecksGeneratedWordsAmount() {
        generatedPage.getGenerated10WordsLengthCuc();
    }

    @And("User unchecks checkbox")
    public void userUnchecksCheckbox() {
        homePage.uncheckCheckboxCuc();
    }

    @Then("Use checks that generated first paragraph no longer starts with Lorem ipsum")
    public void useChecksThatGeneratedFirstParagraphNoLongerStartsWithLoremIpsum() {
        generatedPage = pageFactoryManager.getGeneratedPage();
        generatedPage.verifyTextParagraphNoLongerStartWithLorem();
    }

    @When("User checks random generated text contains Lorem")
    public void userFindsTextFromEachParagraphAndDeterminesTheNumberOfParagraphsContainingTheWordLoremTriesTimes() throws InterruptedException {
        generatedPage = pageFactoryManager.getGeneratedPage();
        generatedPage.getText5ParagraphsCuc();
    }

    @Then("User checks average amount of Lorem is less than two")
    public void userChecksAverageAmountOfLoremIsLessThan() {
        generatedPage.checksAverageAmountOfLorem();
    }


    @When("User opens, clicks, checks nine more times")
    public void userOpenClickCheckNineMoreTimes() throws InterruptedException {
        for (int i = 0; i < 9; i++) {
        openPage();
        userClicksOnButtonGenerate();
        userFindsTextFromEachParagraphAndDeterminesTheNumberOfParagraphsContainingTheWordLoremTriesTimes();
    }

    }
}
