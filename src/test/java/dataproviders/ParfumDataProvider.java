package dataproviders;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import static enums.TopMenuItems.*;

public class ParfumDataProvider {

    @DataProvider(name="ParfumFilter")
    public static Object[][] getParfumByFilter(Method m) {
        return new Object[][] {
                {PARFUM_SALE, "100BON", "Parfum", "", "Unisex"},
                {PARFUM_NEU, "", "Parfum", "", "Weiblich"},
                {PARFUM_LIMITIERT, "4711", "Duftset", "", "Unisex"}
        };
    }
}
