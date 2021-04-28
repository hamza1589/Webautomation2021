package com.ebay.data;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "searchData")
    public Object[] getSearchData(){
        return new Object[]{"Core Java Book","Data Structure","Selenium"};

    }
}
