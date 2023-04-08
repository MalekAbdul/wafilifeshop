package WafiLifePages;

import Utilities.CustomMethods;
import org.openqa.selenium.By;

public class WafiLifeCheckoutPage extends CustomMethods {
    public String CHECKOUT_URL = "https://www.wafilife.com/checkout/";
    public By CHECKBOX_CREATE_ACCOUNT = By.xpath("//input[@id='createaccount']");
    public By INPUT_PASSWORD_FIELD = By.xpath("//input[@id='account_password']");
    public By INPUT_NAME_FIELD = By.xpath("(//input[@id='billing_first_name'])[1]");
    public By INPUT_PHONE_FIELD = By.xpath("(//input[@id='billing_phone'])[1]");
    public By INPUT_EMERGENCY_PHONE_FIELD = By.xpath("//input[@id='billing_alternative_phone']");
    public By INPUT_EMAIL_FIELD = By.xpath("(//input[@id='billing_email'])[1]");
    public By ZILLA_DROPDOWN_ICON = By.xpath("(//span[@role='presentation'])[1]");
    public By INPUT_ZILLA_SEARCH_FIELD = By.xpath("(//input[@role='combobox'])[1]");
    public By INPUT_AREA_FIELD = By.xpath("(//select[@id='billing_area'])[1]");
    public By INPUT_ADDRESS_FIELD = By.xpath("(//textarea[@id='billing_address_1'])[1]");
    public By INPUT_INFORMATION_FIELD = By.xpath("(//textarea[@id='order_comments'])[1]");
    public By BUTTON_PLACE_ORDER = By.xpath("//button[@id='place_order']");
}
