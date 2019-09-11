/**
 * 
 */
package com.retailStore.service;

import static com.retailStore.RetailStoreConstants.LONG_TERM_CUSTOMER;
import static com.retailStore.RetailStoreConstants.LONG_TERM_CUSTOMER_DISCOUNT;
import static com.retailStore.RetailStoreConstants.STORE_AFFILLIATE;
import static com.retailStore.RetailStoreConstants.STORE_AFFILLIATE_DISCOUNT;
import static com.retailStore.RetailStoreConstants.STORE_EMPLOYEE;
import static com.retailStore.RetailStoreConstants.STORE_EMPLOYEE_DISCOUNT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailStore.helper.BillHelper;
import com.retailStore.model.Bill;

/**
 * Service class to handle Invoice for Retail Store
 * @author Mahesh Namdev
 * @since 10-09-2019
 */
@Service
public class BillService {
    
    @Autowired
    private BillHelper billHelper;

    public Bill createInvoice(Bill billRequest) {
        
        if (billRequest.getCustomerType() != null && billRequest.getCustomerType().equalsIgnoreCase(STORE_EMPLOYEE)) {
            return billHelper.getPrecentageBasedBill(billRequest, STORE_EMPLOYEE_DISCOUNT);
        } else if (billRequest.getCustomerType() != null
               && billRequest.getCustomerType().equalsIgnoreCase(STORE_AFFILLIATE)) {
            return billHelper.getPrecentageBasedBill(billRequest, STORE_AFFILLIATE_DISCOUNT);
        } else if (billRequest.getCustomerType() != null
               && billRequest.getCustomerType().equalsIgnoreCase(LONG_TERM_CUSTOMER)) {
            return billHelper.getPrecentageBasedBill(billRequest, LONG_TERM_CUSTOMER_DISCOUNT);
        } else {
            return billHelper.getNonPrecentageBasedBill(billRequest);
        }
    }
    
}
