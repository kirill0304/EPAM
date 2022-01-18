package manager;

import org.openqa.selenium.WebDriver;
import pagesloremipsum.GeneratedPage;

import pagesloremipsum.HomePage;
import pagesloremipsum.RadioButton;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() { return new HomePage(driver);
    }
    public GeneratedPage getGeneratedPage(){return new GeneratedPage(driver);}
    public RadioButton getRadioButton(){return new RadioButton(driver);}
    }
