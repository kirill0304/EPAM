package pagesloremipsum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import static java.lang.Thread.sleep;
import static org.apache.commons.lang.StringUtils.countMatches;
import static org.openqa.selenium.By.xpath;

public class GeneratedPage extends BasePage{

    public GeneratedPage(WebDriver driver) {
        super(driver);
    }

    private static final String PARAGRAPH1_TEXT = "//div[@id = 'lipsum']/p[1]";
    private static final String TEXT_5_PARAGRAPHS = "//div[@id = 'lipsum']";
    static int num;
    private static final String TEXT_FOR_EACH_PARAGRAPH = "//div[@id = 'lipsum']/p["+ num + "]";
    private static final String GENERATED_DESCRIPTION = "//div[@id = 'generated']";
    private static final int TIME_TO_WAIT = 200;
    private static final String GENERATED_10_WORDS = "//div[@id='lipsum']";

    @FindBy(xpath  = "//div[@id = 'lipsum']/p[1]")
    private WebElement paragraph1text;
    @FindBy(xpath = "//div[@id = 'lipsum']")
    private WebElement text5Paragraphs;
    @FindBy(xpath = "//div[@id = 'generated']")
    private WebElement generatedDescription;
    @FindBy(xpath = "//div[@id='lipsum']")
    private WebElement generated10Words;
    private static final String WORDS_EXPECTED_STARTS_WITH = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
    private static final int EXPECTED_AMOUNT_OF_WORDS = 10;
    private static final String STRING_EXPECTED_TO_CONTAIN = "10 words";
    private static final String EXPECTED_WORDS_TO_START_WITH = "Lorem ipsum";
    private static final String EXPECTED_WORD_LOREM = "lorem";
    public static int countLorem=0;
    private static final int AMOUNT_OF_REPEATS_TEST_CHECK_RANDOMLY = 10;
    private static final int EXPECTED_AVERAGE_COUNT_LOREM = 2;

    public String getTextParagraph1() {
        waitForPageLoadComplete(TIME_TO_WAIT);
         return driver.findElement(xpath(PARAGRAPH1_TEXT)).getText();
    }

    public String getText5Paragraphs() {
        waitForPageLoadComplete(TIME_TO_WAIT);
        return driver.findElement(xpath(TEXT_5_PARAGRAPHS)).getText();
    }

    public String getGenerated10Words() {
        waitForPageLoadComplete(TIME_TO_WAIT);
        return driver.findElement(xpath(GENERATED_DESCRIPTION)).getText();
    }

    public int getGenerated10WordsLength() {
        String stringElement = driver.findElement(xpath(GENERATED_10_WORDS)).getText();
        return stringElement.split(" ").length;
    }

    public void verifyTextParagraphStartWithLorem() {
        waitForPageLoadComplete(TIME_TO_WAIT);
        String elementText = paragraph1text.getText();
        Assert.assertTrue(elementText.startsWith(WORDS_EXPECTED_STARTS_WITH));
    }



    public void getText5ParagraphsCuc() throws InterruptedException {
        waitForPageLoadComplete(TIME_TO_WAIT);
        sleep (TIME_TO_WAIT);
        waitVisibilityOfElement(TIME_TO_WAIT,text5Paragraphs);
        String elementText =  text5Paragraphs.getText();
        int count = countMatches(elementText, EXPECTED_WORD_LOREM);
        waitForPageLoadComplete(TIME_TO_WAIT);
        countLorem+=count;
    }

    public void getGenerated10WordsCuc() {
        waitForPageLoadComplete(TIME_TO_WAIT);
        String elementTextGenerated = generatedDescription.getText();
        Assert.assertTrue(elementTextGenerated.contains(STRING_EXPECTED_TO_CONTAIN));
    }

    public void getGenerated10WordsLengthCuc() {
        String stringElement = generated10Words.getText();
        int actualAmountOfWords = stringElement.split(" ").length;;
        Assert.assertEquals(actualAmountOfWords, EXPECTED_AMOUNT_OF_WORDS);
    }
    public void verifyTextParagraphNoLongerStartWithLorem() {
        waitForPageLoadComplete(TIME_TO_WAIT);
        String elementText = paragraph1text.getText();
        Assert.assertFalse(elementText.startsWith(EXPECTED_WORDS_TO_START_WITH));
    }
    public void checksAverageAmountOfLorem() {
        int countAverageLorem = countLorem / AMOUNT_OF_REPEATS_TEST_CHECK_RANDOMLY;
        Assert.assertTrue(countAverageLorem >= EXPECTED_AVERAGE_COUNT_LOREM);
    }




}
