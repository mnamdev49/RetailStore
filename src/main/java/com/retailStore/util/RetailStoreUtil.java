/**
 * 
 */
package com.retailStore.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class hand discunt related operation on Bill
 * @author Mahesh Namdev
 * @since 10-09-2019
 */
public class RetailStoreUtil {

    public static int getDiscount(Double billAmount) {
       
       double discountUnitOnCent = billAmount/100;
       int discountUnitOnCentInteger = (int)discountUnitOnCent;
       
       return discountUnitOnCentInteger * 5;
    }
    
    public static double getDiscount(Double billAmount, Integer discountPercent) {
        double discountAmount = (billAmount/100) * discountPercent;
        return discountAmount;
     }
    
    public static Map<String, Double> getItemsAndPriceMap(List<String> itemsList, List<Double> priceList) {
        Map<String, Double> itemsPriceMap = new HashMap<String, Double>();
        
        for(int i = 0 ; i<itemsList.size(); i++) {
            itemsPriceMap.put(itemsList.get(i), priceList.get(i));
        }
        return itemsPriceMap;
    }

}
