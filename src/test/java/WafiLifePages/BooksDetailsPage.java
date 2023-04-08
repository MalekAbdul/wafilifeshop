package WafiLifePages;

import Utilities.CustomMethods;
import org.openqa.selenium.By;
public class BooksDetailsPage extends CustomMethods {
    public By BUTTON_ADDTOCART = By.xpath("//button[@type='submit'][contains(text(),'অর্ডার করুন')][2]");
    public By BUTTON_COMPLETE_ORDER = By.xpath("//span[contains(text(),'অর্ডার সম্পন্ন করুন')]");
}
