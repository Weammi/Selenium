import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class NetpeakQuestionnaire {

    private WebDriver driver;
    private WebDriverWait wait;

    public NetpeakQuestionnaire(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//input[@name='up_file']")
    private WebElement loading;

    @FindBy(xpath = "//label[text()='Ошибка: неверный формат файла (разрешённые форматы: doc, docx, pdf, txt, odt, rtf).']")
    private WebElement textFormatError;

    @FindBy(xpath = "//input[@data-error-name='Firstname']")
    private WebElement name;

    @FindBy(xpath = "//input[@data-error-name='Lastname']")
    private WebElement surname;

    @FindBy(xpath = "//input[@data-error-name='Email']")
    private WebElement email;

    @FindBy(xpath = "//input[@data-error-name='Mobile phone number']")
    private WebElement phone;

    @FindBy(xpath = "//button[@name='difficult']")
    private WebElement send;

    @FindBy(xpath = "//p[@class='warning-fields help-block']")
    private WebElement textColor;

    @FindBy(xpath = "//li[@class='blog']/*")
    private WebElement coursesLocator;

    private By waitTextFormatError = By.xpath("//label[text()='Ошибка: неверный формат файла (разрешённые форматы: doc, docx, pdf, txt, odt, rtf).']");

    public void loadingInTheWrongFormat() {
        File file = new File("1.bmp");
        loading.sendKeys(file.getAbsolutePath());
    }

    public void textFormatError() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitTextFormatError));
        Assert.assertEquals(textFormatError.getText(), "Ошибка: неверный формат файла (разрешённые форматы: doc, docx, pdf, txt, odt, rtf).");
    }

    public void inputName(String nameRandom) {
        name.sendKeys(nameRandom);
    }

    public void inputSurname(String surnameRandom) {
        surname.sendKeys(surnameRandom);
    }

    public void inputEmail(String emailRandom) {
        email.sendKeys(emailRandom + "@gmail.com");
    }

    public void inputPhone(String phoneRandom) {
        phone.sendKeys(phoneRandom);
    }

    public void inputYear(int yearRandom) {
        WebElement year = driver.findElement(By.xpath("//select[@name='by']/*[" + yearRandom + "]"));
        year.click();
    }

    public void inputMonth(int monthRandom) {
        WebElement month = driver.findElement(By.xpath("//select[@name='bm']/*[" + monthRandom + "]"));
        month.click();
    }

    public void inputDay(int dayRandom) {
        WebElement month = driver.findElement(By.xpath("//select[@name='bd']/*[" + dayRandom + "]"));
        month.click();
    }

    public WebElement sendQuestionnaire() {
        return send;
    }

    public void redText() {
        Assert.assertEquals(Color.fromString(textColor.getCssValue("color")).asHex(), "#ff0000");
    }

    public WebElement courses() {
        return coursesLocator;
    }
}
