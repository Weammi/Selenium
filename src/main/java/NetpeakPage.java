import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NetpeakPage {

    private WebDriver driver;

    public NetpeakPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//ul[@class='menu-links']/li/a[text()='Карьера']")

    private WebElement careerLocator;

    public void openNetpeak() {
        driver.get("https://netpeak.ua/");
    }

    public void careerClick() {
        careerLocator.click();
    }

}
