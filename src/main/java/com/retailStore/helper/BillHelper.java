package com.retailStore.helper;

import static com.retailStore.RetailStoreConstants.GROCERIES_ITEMS;
import static com.retailStore.RetailStoreConstants.GROCERIES_ITEMS_PRICE;
import static com.retailStore.RetailStoreConstants.OTHER_ITEMS;
import static com.retailStore.RetailStoreConstants.OTHER_ITEMS_PRICE;
import static com.retailStore.util.RetailStoreUtil.getDiscount;
import static com.retailStore.util.RetailStoreUtil.getItemsAndPriceMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.retailStore.model.Bill;

/**
 * Class handle bill calucation related operations
 * @author Mahesh Namdev
 * @since 10-09-2019
 */
@Component
public class BillHelper {
    
    public Bill getPrecentageBasedBill(Bill bill, Integer discount) {
        Double priceForGroceriesItems = getItemsBillAmount(getItemsAndPriceMap(GROCERIES_ITEMS, GROCERIES_ITEMS_PRICE), bill.getPurchaseItmes());
        Double priceForOtherItems = getItemsBillAmount(getItemsAndPriceMap(OTHER_ITEMS, OTHER_ITEMS_PRICE), bill.getPurchaseItmes());
        Double discountAmount = getDiscount(priceForOtherItems, discount);
        Double totalBillAmount = priceForOtherItems + priceForGroceriesItems;
        Double payableAmount = totalBillAmount - discountAmount;
        Integer extraDiscount = 0;
        if (payableAmount > 100) {
          extraDiscount = getDiscount(payableAmount);
        }
        payableAmount = payableAmount - extraDiscount;
        discountAmount = discountAmount + extraDiscount;
        bill.setTotalBillAmount(totalBillAmount);
        bill.setDiscount(discountAmount);
        bill.setPayableAmount(payableAmount);
        return bill;
    }
    
    public Bill getNonPrecentageBasedBill(Bill bill) {
        Double priceForGroceriesItems = getItemsBillAmount(getItemsAndPriceMap(GROCERIES_ITEMS, GROCERIES_ITEMS_PRICE), bill.getPurchaseItmes());
        Double priceForOtherItems = getItemsBillAmount(getItemsAndPriceMap(OTHER_ITEMS, OTHER_ITEMS_PRICE), bill.getPurchaseItmes());
        
        Double totalPayableAmount = priceForGroceriesItems + priceForOtherItems;
        
        Integer discount = 0;
        if (totalPayableAmount > 100) {
             discount = getDiscount(totalPayableAmount);
        }
        
        bill.setTotalBillAmount(totalPayableAmount);
        bill.setDiscount((double)discount);
        bill.setPayableAmount(totalPayableAmount - discount);
        return bill;
       }
    
    private Double getItemsBillAmount(Map<String, Double> itemPriceMap, List<String> items) {
        List<Double> purchasedItemsPrice = items.stream().map(i-> itemPriceMap.get(i)).collect(Collectors.toList());
        Double billAmount = 0.0;
        for(Double itemPrice : purchasedItemsPrice) {
              if (itemPrice != null)
                billAmount = billAmount + itemPrice;
        }
        return billAmount;
    }

}
