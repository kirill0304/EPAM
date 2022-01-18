package pagesloremipsum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    private static final String RU_LANGUAGE = "//a[@href='http://ru.lipsum.com/']";
    private static final String FIRST_PARAGRAPH = "//*[contains(text(), 'рыба')]";
    private static final String GENERATE_BUTTON = "//input [@name='generate']";
    private static final String WORDS_RADIOBUTTON = "//input[@value='words']";
    private static final String AMOUNT_INPUT = "//input[@name='amount']";
    private static final String CHECKBOX_STARTS_WITH_LOREM = "//input[@name='start']";

    private static final String LOREM_IPSUM_URL ="https://lipsum.com/";
    @FindBy(xpath = "//a[@href='http://ru.lipsum.com/']")
    private WebElement ruLanguage;
    @FindBy(xpath  = "//*[contains(text(), 'рыба')]")
    private WebElement firstParagraph;
    @FindBy(xpath  = "//input [@name='generate']")
    private WebElement generatedButton;
    @FindBy(xpath  = "//input[@value='words']")
    private WebElement wordsRadiobutton;
    @FindBy(xpath  = "//input[@name='amount']")
    private WebElement amountInput;
    @FindBy(xpath  = "//input[@name='start']")
    private WebElement checkboxStartsWithLorem;
    private static final  String WORD_EXPECTED_FISH = "рыба";
    private static final int TIME_TO_WAIT = 60;

    public void changeLanguageRu() { driver.findElement(xpath(RU_LANGUAGE)).click(); }
    public String findFirstParagraph() {
     return driver.findElement(xpath(FIRST_PARAGRAPH)).getText();
    }
    public void clickOnGenerateButton(){
    driver.findElement(xpath(GENERATE_BUTTON)).click();
    }
    public void clickOnWords() {
        driver.findElement(xpath(WORDS_RADIOBUTTON)).click();
    }
    public void enterAmount(String number) {
        driver.findElement(xpath(AMOUNT_INPUT)).clear();
        driver.findElement(xpath(AMOUNT_INPUT)).sendKeys(number);
    }
    public void uncheckCheckbox() {
        driver.findElement(xpath(CHECKBOX_STARTS_WITH_LOREM)).click();
    }


    public void openHomePage() {
        driver.get(LOREM_IPSUM_URL);}
    public void changeLanguageRuCuc() {
        ruLanguage.click(); }
    public void findFirstParagraphAndAssertCuc() {
        String elementText = firstParagraph.getText();
        Assert.assertTrue(elementText.contains(WORD_EXPECTED_FISH));
    }
    public void clickOnGenerateButtonCuc(){
        generatedButton.click();
    }
    public void clickOnWordsCuc() {
        wordsRadiobutton.click();
    }
    public void enterAmountCuc(String number) {
        amountInput.clear();
        amountInput.sendKeys(number);
    }
    public void uncheckCheckboxCuc() {
        checkboxStartsWithLorem.click();
    }



}
