import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NetpeakEducationCenter {
    private WebDriver driver;
    private WebDriverWait wait;

    public NetpeakEducationCenter(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//div[@class='hero-content']//h1")
    private WebElement textEducationCenter;

    private By waitTextEducationCenter = By.xpath("//div[@class='hero-content']//h1");

    public void netpeakEducationCenter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitTextEducationCenter));
        Assert.assertEquals(textEducationCenter.getText(), "Образовательный Центр Netpeak");
    }
}
