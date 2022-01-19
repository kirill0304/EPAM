package pagesloremipsum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButton extends HomePage {
    @FindBy(xpath  = "//input[@value='paragraphs']")
    private WebElement paragraphsRadiobutton;
    @FindBy(xpath  = "//input[@value='words']")
    private WebElement wordsRadiobutton;
    @FindBy(xpath  = "//input[@value='bytes']")
    private WebElement bytesRadiobutton;
    @FindBy(xpath  = "//input[@value='lists']")
    private WebElement listsRadiobutton;

    public RadioButton(WebDriver driver) {
        super(driver);
    }


}
