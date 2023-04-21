package WafiLifePages;

import Utilities.CustomMethods;
import org.openqa.selenium.By;

public class DrAyubAliBookspage extends CustomMethods {
    public String DRAYUBALIBOOKSPAGE_URL = "https://www.wafilife.com/cat/books/author/dr-ayub-ali/";
    public By BOOK_LATTICE_THEORY = By.xpath("//a[contains(text(),'Lattice Theory and Boolean Algebra (Masters) (News')]");
    public By BOOK_DISCRETEMATH = By.xpath("//a[contains(text(),'Discrete Mathematics (Snatok 4th Year)')]");

}
