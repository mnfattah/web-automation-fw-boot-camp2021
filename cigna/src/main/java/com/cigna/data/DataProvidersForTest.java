package com.cigna.data;

import org.testng.annotations.DataProvider;

public class DataProvidersForTest {

    @DataProvider(name = "getDataForLogInTest")
    public Object[][] getDataForLogInTest() {

        return new Object[][] {
            {"testfakeID", "testfakePassword12@"}

        };
    }
}