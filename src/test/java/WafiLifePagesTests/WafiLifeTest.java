package WafiLifePagesTests;

import Utilities.BaseDriverSetup;
import WafiLifePages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        String wafilifeTitle = "Buy Islamic Books - Online Book Shop in Bangladesh | Wafilife";
        Assert.assertEquals(getDriver().getTitle(), wafilifeTitle);
        wafiLifeHomePage.takeScreenShot("Wafilife Home Page");
    }

    @Test
    public void clickOnWriterMenu(){

        getDriver().get(wafiLifeHomePage.WAFILIFE_URL);
        String text = wafiLifeHomePage.getElement(wafiLifeHomePage.LEKHOK).getText();
        Assert.assertEquals(text, "লেখক");
        wafiLifeHomePage.clickOnElement(wafiLifeHomePage.LEKHOK);
        wafiLifeHomePage.takeScreenShot("Click to Writer Menu Button");
    }

    @Test
    public void goNextPageTest()
    {
        getDriver().get(wafiLifeHomePage.WAFILIFE_URL);
        wafiLifeHomePage.clickOnElement(wafiLifeHomePage.LEKHOK);
        wafiLifeWritterListPage.scrollToElemnt(wafiLifeWritterListPage.NEXTPAGE_BUTTON);
        wafiLifeHomePage.clickOnElement(wafiLifeWritterListPage.NEXTPAGE_BUTTON);
    }
    public void wafiLifeTestCases() throws InterruptedException {

        //go back to previous page
        getDriver().navigate().back();
        Thread.sleep(5000);

        //Move to an Author location
        wafiLifeWritterListPage.moveOnElement(wafiLifeWritterListPage.Dr_AyubAli);
        Thread.sleep(5000);

        //Select an Author
        wafiLifeWritterListPage.clickOnElement(wafiLifeWritterListPage.Dr_AyubAli);
        Thread.sleep(5000);

        //View Book Details
        drAyubAliBookspage.clickOnElement(drAyubAliBookspage.BOOK_DISCRETEMATH);
        Thread.sleep(5000);

        //Click অর্ডার করুন
        booksDetailsPage.clickOnElement(booksDetailsPage.BUTTON_ADDTOCART);
        booksDetailsPage.takeScreenShot("Book Details");
        Thread.sleep(5000);

        //Click অর্ডার সম্পন্ন করুন
        booksDetailsPage.clickOnElement(booksDetailsPage.BUTTON_COMPLETE_ORDER);
        Thread.sleep(5000);
        booksDetailsPage.takeScreenShot("Oder Page");

        //Provide all Information of  আপনার বিলিং এবং শিপিং তথ্য
        checkOutPageInput();

    }
    public void checkOutPageInput() throws InterruptedException {

        //নতুন অ্যাকাউন্ট তৈরি করতে টিক দিন
        wafiLifeCheckoutPage.clickOnElement(wafiLifeCheckoutPage.CHECKBOX_CREATE_ACCOUNT);
        Thread.sleep(2000);

        //পাসওয়ার্ড দিন *
        wafiLifeCheckoutPage.writeText(wafiLifeCheckoutPage.INPUT_PASSWORD_FIELD, "hijibiji");
        Thread.sleep(2000);

        //নাম
        wafiLifeCheckoutPage.writeText(wafiLifeCheckoutPage.INPUT_NAME_FIELD, "Abdul Malek");
        Thread.sleep(2000);

        //ফোন নাম্বার *
        wafiLifeCheckoutPage.writeText(wafiLifeCheckoutPage.INPUT_PHONE_FIELD, "01777777777");
        Thread.sleep(2000);

        //জরুরী ফোন (যদি থাকে)
        wafiLifeCheckoutPage.writeText(wafiLifeCheckoutPage.INPUT_EMERGENCY_PHONE_FIELD, "01666666666");
        Thread.sleep(2000);

        //ইমেইল *
        wafiLifeCheckoutPage.writeText(wafiLifeCheckoutPage.INPUT_EMAIL_FIELD, "a1@gmail.com");
        Thread.sleep(2000);

        //জেলা *
        wafiLifeCheckoutPage.clickOnElement(wafiLifeCheckoutPage.ZILLA_DROPDOWN_ICON);
        wafiLifeCheckoutPage.searchByValue(wafiLifeCheckoutPage.INPUT_ZILLA_SEARCH_FIELD, "Tangail");
        Thread.sleep(2000);

        //এরিয়া/উপজেলা *
        wafiLifeCheckoutPage.dropDownWithValue(wafiLifeCheckoutPage.INPUT_AREA_FIELD, "গোপালপুর");
        Thread.sleep(2000);

        //ঠিকানা *
        wafiLifeCheckoutPage.writeText(wafiLifeCheckoutPage.INPUT_ADDRESS_FIELD, "Hemnagar");
        Thread.sleep(2000);

        //অন্যান্য তথ্য (অর্ডার বা পণ্য ডেলিভারি সংক্রান্ত আরো কোনো তথ্য থাকলে দিন)
        wafiLifeCheckoutPage.writeText(wafiLifeCheckoutPage.INPUT_INFORMATION_FIELD, "Nai Nai");
        wafiLifeCheckoutPage.takeScreenShot("Input info");
        Thread.sleep(2000);

        //অর্ডার সম্পন্ন করুন

    }

}
