package WafiLifePages;

import Utilities.CustomMethods;
import org.openqa.selenium.By;

public class WafiLifeWritterListPage extends CustomMethods {
    public By NEXTPAGE_BUTTON = By.xpath("//a[@class='next page-numbers']");
    public By Dr_A_Hussain = By.xpath("//h3[contains(text(),'Dr. A. Hussain')]");
    public By Dr_AyubAli = By.xpath("//h3[contains(text(),'Dr. Ayub Ali')]");

}
