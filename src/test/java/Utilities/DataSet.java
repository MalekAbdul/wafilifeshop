package Utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
    @DataProvider(name = "credentials")
    public static Object dataset()
    {
        Object[][] objects = {

                {"Abdul Malek", "01777777777", "malek@gmail.com", "password"}
        };

        return objects;
    }

    @DataProvider(name = "Address")
    public static Object addressDataset()
    {
        Object[][] objects = {

                {"Tangail", "গোপালপুর", "Shimlapara, Hemnagar (1992)"}
        };

        return objects;
    }

}
