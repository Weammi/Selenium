import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class NetpeakCareer {
    private WebDriver driver;
    private WebDriverWait wait;

    public NetpeakCareer(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//a[@class='btn green-btn']")
    private WebElement iWantToWorkNetpeakLocator;

    private By waitIWantToWork = By.xpath("//a[@class='btn green-btn']");

    public void switchTab() {
        ArrayList<String> tabList = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
    }


    public WebElement iWantToWorkNetPeak() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitIWantToWork));
        return iWantToWorkNetpeakLocator;
    }
}
