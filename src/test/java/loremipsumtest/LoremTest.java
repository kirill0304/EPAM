package loremipsumtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.apache.commons.lang.StringUtils.countMatches;


public class LoremTest extends BaseTest {
    private static final String WORD_EXPECTED_FISH = "рыба";
    private static final String WORDS_EXPECTED_STARTS_WITH = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
    private static final String NUMBER_FIELD_INPUT_10 = "10";
    private static final String NUMBER_FIELD_INPUT_5 = "5";
    private static final int EXPECTED_AMOUNT_OF_WORDS = 10;
    private static final String STRING_EXPECTED_TO_CONTAIN = "10 words";
    private static final String EXPECTED_WORDS_TO_START_WITH = "Lorem ipsum";
    private static final String EXPECTED_WORD_LOREM = "lorem";
    private static final int AMOUNT_OF_REPEATS_TEST_CHECK_RANDOMLY = 10;
    private static final int EXPECTED_AVERAGE_COUNT_LOREM = 2;


    @Test(description = "Task1/Part1-Test#1")
    public void verifyTheWordFishCorrectlyAppearsInThe1Paragraph() {
        getHomePage().changeLanguageRu();
        String elementText = getHomePage().findFirstParagraph();
        Assert.assertTrue(elementText.contains(WORD_EXPECTED_FISH));
    }

    @Test(description = "Task1/Part1-Test#2")
    public void verifyDefaultSettingResultStartingWithTextLoremIpsum() {
        getHomePage().clickOnGenerateButton();
        String elementText = getGeneratedPage().getTextParagraph1();
        Assert.assertTrue(elementText.startsWith(WORDS_EXPECTED_STARTS_WITH));
    }

    @Test(description = "Task2/Part2-Test#1")
    public void verifyLoremIpsumIsGeneratedWithCorrectSize() {
        getHomePage().clickOnWords();
        getHomePage().enterAmount(NUMBER_FIELD_INPUT_10);
        getHomePage().clickOnGenerateButton();
        String elementTextGenerated = getGeneratedPage().getGenerated10Words();
        Assert.assertTrue(elementTextGenerated.contains(STRING_EXPECTED_TO_CONTAIN));
        int actualAmountOfWords = getGeneratedPage().getGenerated10WordsLength();
        Assert.assertEquals(actualAmountOfWords, EXPECTED_AMOUNT_OF_WORDS);
    }

    @Test(description = "Task2/Part2-Test#2")
    public void verifyTheCheckbox() {
        getHomePage().uncheckCheckbox();
        getHomePage().clickOnGenerateButton();
        String elementText = getGeneratedPage().getTextParagraph1();
        Assert.assertFalse(elementText.startsWith(EXPECTED_WORDS_TO_START_WITH));
    }

    @Test(description = "Task2/Part2-Test#3", invocationCount = 10, groups = "RandomlyGeneratedTextContainLorem")
    public void checkIfRandomlyGeneratedTextContainLorem() throws InterruptedException {

        getHomePage().enterAmount(NUMBER_FIELD_INPUT_5);
        getHomePage().clickOnGenerateButton();
        String elementText = getGeneratedPage().getText5Paragraphs();
        int count = countMatches(elementText, EXPECTED_WORD_LOREM);
        getGeneratedPage().countLorem+=count;
        System.out.println("Test"+getGeneratedPage().countLorem);
    }


    @Test(dependsOnMethods = {"checkIfRandomlyGeneratedTextContainLorem"}, groups = "RandomlyGeneratedTextContainLorem")
    public void after10repeats() {
        int countAverageLorem = getGeneratedPage().countLorem / AMOUNT_OF_REPEATS_TEST_CHECK_RANDOMLY;
        Assert.assertTrue(countAverageLorem>= EXPECTED_AVERAGE_COUNT_LOREM);
    }
}
