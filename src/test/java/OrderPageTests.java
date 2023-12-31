import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.After;



@RunWith(Parameterized.class)
public class OrderPageTests {
    String name;
    String surname;
    String address;
    String phoneNumber;
    String comment;
    String date;

    public OrderPageTests(String name, String surname, String address, String phoneNumber, String comment, String date) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getPersonInformation() {
        return new Object[][]{
                {"Степан", "Бобров", "Изюминск", "79999999999", "10.10.2023", "Комментарий к заказу"},
                {"Анфиса", "Яилимаф", "Пригород", "79119992211", "01.01.2030", "К началу года"},

        };
    }

    WebDriver driver = new FirefoxDriver();


    @Test
    public void checkOrderPageFlowUsingTopOrderButton() {
        driver.get(MainPage.mainPageURL);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickTopOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillPersonalInformation(name, surname, address, phoneNumber);
        objOrderPage.clickNextButton();
        objOrderPage.fillRentInformation(date, comment);
        assertThat(objOrderPage.resultMessage(), containsString("Номер заказа"));
    }

    @Test
    public void checkOrderPageFlowUsingMiddleOrderButton() {
        driver.get(MainPage.mainPageURL);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.scrollToMiddleOrderButton();
        objMainPage.clickMiddleOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillPersonalInformation(name, surname, address, phoneNumber);
        objOrderPage.clickNextButton();
        objOrderPage.fillRentInformation(date, comment);
        assertThat(objOrderPage.resultMessage(), containsString("Номер заказа"));
    }
    @After
    public void teardown() {
        driver.quit();
    }
}

