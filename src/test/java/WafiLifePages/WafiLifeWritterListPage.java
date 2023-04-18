package WafiLifePages;

import Utilities.CustomMethods;
import org.openqa.selenium.By;

public class WafiLifeWritterListPage extends CustomMethods {

    public String AUTHORLISTPAGE_URL = "https://www.wafilife.com/cat/books/author/";
    public By NEXTPAGE_BUTTON = By.xpath("//a[@class='next page-numbers']");
    public By Dr_A_Hussain = By.xpath("//h3[contains(text(),'Dr. A. Hussain')]");
    public By Dr_AyubAli = By.xpath("//h3[contains(text(),'Dr. Ayub Ali')]");
    public By Dr_Md_Shariful_Islam = By.xpath("//h3[contains(text(),'Dr. Md. Shariful_Islam')]");

}
