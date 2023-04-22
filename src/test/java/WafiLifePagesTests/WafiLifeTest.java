package WafiLifePagesTests;

import Utilities.BaseDriverSetup;
import Utilities.DataSet;
import WafiLifePages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class WafiLifeTest extends BaseDriverSetup{

    WafiLifeHomePage wafiLifeHomePage = new WafiLifeHomePage();
    WafiLifeWritterListPage wafiLifeWritterListPage = new WafiLifeWritterListPage();
    DrAyubAliBookspage drAyubAliBookspage = new DrAyubAliBookspage();
    BooksDetailsPage booksDetailsPage = new BooksDetailsPage();
    WafiLifeCheckoutPage wafiLifeCheckoutPage = new WafiLifeCheckoutPage();

    @Test
    public void goWafilifeHomepageTest()
    {
        getDriver().get(wafiLifeHomePage.WAFILIFE_URL);
        Assert.assertEquals(getDriver().getCurrentUrl(), wafiLifeHomePage.WAFILIFE_URL);
        System.out.println("Page Link: "+getDriver().getCurrentUrl());
        String aspectedTitle = "Buy Islamic Books - Online Book Shop in Bangladesh | Wafilife";
        Assert.assertEquals(getDriver().getTitle(), aspectedTitle);
        System.out.println("Page Title: "+getDriver().getTitle());
        wafiLifeHomePage.takeScreenShot("Wafilife Home Page");

    }

    @Test
    public void clickOnWriterMenu(){

        getDriver().get(wafiLifeHomePage.WAFILIFE_URL);
        Assert.assertEquals(getDriver().getCurrentUrl(), wafiLifeHomePage.WAFILIFE_URL);
        System.out.println("Page Link: "+getDriver().getCurrentUrl());
        System.out.println("Page Title: "+getDriver().getTitle());
        String text = wafiLifeHomePage.getElement(wafiLifeHomePage.LEKHOK).getText();
        Assert.assertEquals(text, "লেখক");
        wafiLifeHomePage.clickOnElement(wafiLifeHomePage.LEKHOK);
        Assert.assertEquals(getDriver().getCurrentUrl(), wafiLifeWritterListPage.AUTHORLISTPAGE_URL);
        wafiLifeHomePage.takeScreenShot("Click to Writer Menu Button");

    }

    @Test
    public void goNextPageTest()
    {
        getDriver().get(wafiLifeWritterListPage.AUTHORLISTPAGE_URL);
        Assert.assertEquals(getDriver().getCurrentUrl(), wafiLifeWritterListPage.AUTHORLISTPAGE_URL);
        System.out.println("Page Link: "+getDriver().getCurrentUrl());
        wafiLifeHomePage.clickOnElement(wafiLifeHomePage.LEKHOK);
        wafiLifeWritterListPage.scrollToElemnt(wafiLifeWritterListPage.NEXTPAGE_BUTTON);
        Assert.assertEquals(wafiLifeWritterListPage.getElement(wafiLifeWritterListPage.NEXTPAGE_BUTTON).getText(), "→");
        System.out.println(wafiLifeWritterListPage.getElement(wafiLifeWritterListPage.NEXTPAGE_BUTTON).getText());
        wafiLifeHomePage.clickOnElement(wafiLifeWritterListPage.NEXTPAGE_BUTTON);
        wafiLifeWritterListPage.takeScreenShot("Next Page");
        
    }

    @Test
    public void selectAuthor()
    {
        getDriver().get(wafiLifeWritterListPage.AUTHORLISTPAGE_URL);
        System.out.println("Page Title: "+getDriver().getTitle());
        Assert.assertEquals(wafiLifeWritterListPage.getElement(wafiLifeWritterListPage.Dr_AyubAli).getText(), "Dr. Ayub Ali");
        wafiLifeWritterListPage.clickOnElement(wafiLifeWritterListPage.Dr_AyubAli);
        Assert.assertEquals(getDriver().getCurrentUrl(), drAyubAliBookspage.DRAYUBALIBOOKSPAGE_URL);
        drAyubAliBookspage.takeScreenShot("Dr. Ayub Ali Book Page");

    }

    @Test
    public void selectABook()
    {
        getDriver().get(drAyubAliBookspage.DRAYUBALIBOOKSPAGE_URL);
        System.out.println("Page Link: "+getDriver().getCurrentUrl());
        System.out.println("Page Title: "+getDriver().getTitle());
        Assert.assertEquals(drAyubAliBookspage.getElement(drAyubAliBookspage.BOOK_DISCRETEMATH).getText(), "Discrete Mathematics (Snatok 4th Year)");
        drAyubAliBookspage.clickOnElement(drAyubAliBookspage.BOOK_DISCRETEMATH);
        drAyubAliBookspage.takeScreenShot("Discrete Mathematics (Snatok 4th Year)");

    }

    @Test
    public void orderBook()
    {
        getDriver().get(booksDetailsPage.BOOKDEETAILSPAGE_URL);
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.wafilife.com/shop/books/discrete-mathematics-snatok-4th-year");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getDriver().getTitle(), " ");
        System.out.println("Page Title: "+getDriver().getTitle());
        booksDetailsPage.clickOnElement(booksDetailsPage.BUTTON_ADDTOCART);
        booksDetailsPage.takeScreenShot("Book Add To Cart");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(booksDetailsPage.BUTTON_COMPLETE_ORDER));
        booksDetailsPage.clickOnElement(booksDetailsPage.BUTTON_COMPLETE_ORDER);
        System.out.println("Page Title:"+getDriver().getTitle());

    }

    @Test(dataProvider = "credentials", dataProviderClass = DataSet.class)
    public void checkOutPageInput(String name, String phone, String email, String password) throws InterruptedException {

        getDriver().get(booksDetailsPage.BOOKDEETAILSPAGE_URL);
        booksDetailsPage.clickOnElement(booksDetailsPage.BUTTON_ADDTOCART);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(booksDetailsPage.BUTTON_COMPLETE_ORDER));
        booksDetailsPage.clickOnElement(booksDetailsPage.BUTTON_COMPLETE_ORDER);

        //নতুন অ্যাকাউন্ট তৈরি করতে টিক দিন
        wafiLifeCheckoutPage.clickOnElement(wafiLifeCheckoutPage.CHECKBOX_CREATE_ACCOUNT);
        //পাসওয়ার্ড দিন *
        wafiLifeCheckoutPage.writeText(wafiLifeCheckoutPage.INPUT_PASSWORD_FIELD, password);
        //নাম
        wafiLifeCheckoutPage.writeText(wafiLifeCheckoutPage.INPUT_NAME_FIELD, name);
        //ফোন নাম্বার *
        wafiLifeCheckoutPage.writeText(wafiLifeCheckoutPage.INPUT_PHONE_FIELD, phone);
        //জরুরী ফোন (যদি থাকে)
        wafiLifeCheckoutPage.writeText(wafiLifeCheckoutPage.INPUT_EMERGENCY_PHONE_FIELD, "01666666666");
        //ইমেইল *
        wafiLifeCheckoutPage.writeText(wafiLifeCheckoutPage.INPUT_EMAIL_FIELD, email);
        wafiLifeCheckoutPage.takeScreenShot("Input Credentials");

    }

    @Test(dataProvider = "Address", dataProviderClass = DataSet.class)
    public void checkOutPageInputAddress(String district, String area, String address) throws InterruptedException {

        getDriver().get(booksDetailsPage.BOOKDEETAILSPAGE_URL);
        booksDetailsPage.clickOnElement(booksDetailsPage.BUTTON_ADDTOCART);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(booksDetailsPage.BUTTON_COMPLETE_ORDER));
        booksDetailsPage.clickOnElement(booksDetailsPage.BUTTON_COMPLETE_ORDER);

        //জেলা *
        wafiLifeCheckoutPage.clickOnElement(wafiLifeCheckoutPage.ZILLA_DROPDOWN_ICON);
        wafiLifeCheckoutPage.writeText(wafiLifeCheckoutPage.INPUT_ZILLA_SEARCH_FIELD, district);
        wafiLifeCheckoutPage.getElement(wafiLifeCheckoutPage.INPUT_ZILLA_SEARCH_FIELD).sendKeys(Keys.ARROW_DOWN);
        wafiLifeCheckoutPage.getElement(wafiLifeCheckoutPage.INPUT_ZILLA_SEARCH_FIELD).sendKeys(Keys.ENTER);
        Assert.assertEquals(wafiLifeCheckoutPage.getElement(wafiLifeCheckoutPage.ZILLA_INPUT_FIELD).getText(), "Tangail");

        //এরিয়া/উপজেলা *
        wait.until(ExpectedConditions.elementToBeClickable(wafiLifeCheckoutPage.INPUT_AREA_FIELD));
        wafiLifeCheckoutPage.dropDownWithValue(wafiLifeCheckoutPage.INPUT_AREA_FIELD, area);

        //ঠিকানা *
        wafiLifeCheckoutPage.writeText(wafiLifeCheckoutPage.INPUT_ADDRESS_FIELD, address);

        //অন্যান্য তথ্য (অর্ডার বা পণ্য ডেলিভারি সংক্রান্ত আরো কোনো তথ্য থাকলে দিন)
        wafiLifeCheckoutPage.writeText(wafiLifeCheckoutPage.INPUT_INFORMATION_FIELD, "Handle with Care!!!");
        wafiLifeCheckoutPage.takeScreenShot("Input Address");

    }


}
