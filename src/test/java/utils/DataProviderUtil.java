package utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

    @DataProvider(name = "loginCredentials")
    public static Object[][] getLoginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce"}
        };
    }
}
