import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;


public class Netpeak extends WebDriverSetting {

    @Test
    public void first() {

        NetpeakPage netpeakPage = PageFactory.initElements(driver, NetpeakPage.class);
        NetpeakCareer netpeakCareer = PageFactory.initElements(driver, NetpeakCareer.class);
        NetpeakQuestionnaire netpeakQuestionnaire = PageFactory.initElements(driver, NetpeakQuestionnaire.class);
        NetpeakEducationCenter netpeakEducationCenter = PageFactory.initElements(driver, NetpeakEducationCenter.class);

        netpeakPage.openNetpeak();
        netpeakPage.careerClick();

        netpeakCareer.switchTab();
        scrollAndClick(netpeakCareer.iWantToWorkNetPeak());

        netpeakQuestionnaire.loadingInTheWrongFormat();
        netpeakQuestionnaire.textFormatError();
        netpeakQuestionnaire.inputName(generateNameAndSurname());
        netpeakQuestionnaire.inputSurname(generateNameAndSurname());
        netpeakQuestionnaire.inputEmail(generateEmail());
        netpeakQuestionnaire.inputYear(generateYear());
        netpeakQuestionnaire.inputMonth(generateMonth());
        netpeakQuestionnaire.inputDay(generateDay());
        netpeakQuestionnaire.inputPhone(generatePhone());
        scrollAndClick(netpeakQuestionnaire.sendQuestionnaire());
        netpeakQuestionnaire.redText();
        scrollAndClick(netpeakQuestionnaire.courses());

        netpeakEducationCenter.netpeakEducationCenter();

    }


    public String generatePhone() {
        int set2, set3;
        Random generator = new Random();
        set2 = generator.nextInt(643) + 100;
        set3 = generator.nextInt(8999) + 1000;
        return "+7918" + set2 + set3;
    }

    public void scrollAndClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
        element.click();
    }

    public int generateYear() {
        Random ran = new Random();
        return ran.nextInt(51) + 2;
    }

    public int generateMonth() {
        Random ran = new Random();
        return ran.nextInt(11) + 2;
    }

    public int generateDay() {
        Random ran = new Random();
        return ran.nextInt(30) + 2;
    }

    public String generateNameAndSurname() {
        return RandomStringUtils.randomAlphabetic(100);
    }

    public String generateEmail() {
        return RandomStringUtils.randomAlphabetic(90);
    }
}