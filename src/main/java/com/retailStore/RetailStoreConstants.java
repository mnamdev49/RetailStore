package com.retailStore;

import java.util.Arrays;
import java.util.List;

/**
 * Class hold all constants related to Retail Store
 * @author Mahesh Namdev
 * @since 10-09-2019
 */
public interface RetailStoreConstants {
    
    public static final String STORE_EMPLOYEE = "storeEmployee";
    
    public static final String STORE_AFFILLIATE = "storeAffilliate";
    
    //Customer who has more than 2 years terms with retail store
    public static final String LONG_TERM_CUSTOMER = "longTermCustomer";
    
    public static final List<String> GROCERIES_ITEMS = Arrays.asList("groceries_item01", "groceries_item02",
            "groceries_item03", "groceries_item04");
    
    //treated as index position wise price of GROCERIES_ITEMS
    public static final List<Double> GROCERIES_ITEMS_PRICE = Arrays.asList(100.0, 30.0, 50.0, 20.0);
    
    public static final List<String> OTHER_ITEMS = Arrays.asList("other_item01", "other_item02",
            "other _item03", "other_item04");
    
    //treated as index position wise price of OTHER_ITEMS
    public static final List<Double> OTHER_ITEMS_PRICE = Arrays.asList(100.0, 30.0, 800.0, 500.0);
    
    public static final Integer STORE_EMPLOYEE_DISCOUNT = 30;
    
    public static final Integer STORE_AFFILLIATE_DISCOUNT = 10;
    
    public static final Integer LONG_TERM_CUSTOMER_DISCOUNT = 5;
    
}
