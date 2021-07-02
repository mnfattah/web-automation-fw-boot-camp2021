package com.citibank.data;

import org.testng.annotations.DataProvider;

public class DataProvidersForTest {

    @DataProvider(name = "getDataForLogInTest")
    public Object [][] getDataForLogInTest() {
        return new Object[][]{
                {"testFakeID","testFakePassword1@"}
        };
    }
}
