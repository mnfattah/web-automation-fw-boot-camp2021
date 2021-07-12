package com.amazon.data;

import org.testng.annotations.DataProvider;

public class DataProvidersForTest {

    @DataProvider(name = "getDataForSearchTest")
    public Object[][] getDataForSearchInTest() {

        return new Object[][] {
                {"pen"}
        };
    }


    @DataProvider(name = "getDataForAutoSuggestionTest")
    public Object[][] getDataForAutoSuggestionTest() {

        return new Object[][] {
                {"pencil"}
        };
    }

    @DataProvider(name = "getDataForSignIN")
    public Object[][] getDataForSignIN() {

        return new Object[][] {
                {"mnfattah_j@yahoo.com","abcd1234"}
        };
    }

}
