package com.retailStore.exception;

import static com.retailStore.RetailStoreConstants.GROCERIES_ITEMS;
import static com.retailStore.RetailStoreConstants.OTHER_ITEMS;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.retailStore.model.Bill;
import com.retailStore.model.ExceptionResponse;

/**
 * Class use for set error message in response
 * @author Mahesh Namdev
 * @since 10-09-2019
 */
public class CustomErrorMessage {
    
   public ExceptionResponse requiredItemsExpception() {
       
       ExceptionResponse exceptionResponse = new ExceptionResponse();
       exceptionResponse.setStatus(BAD_REQUEST.value());
       exceptionResponse.setMessage("purchaseItmes Field can not be empty");
       return exceptionResponse;
   }
   
   public ExceptionResponse itemsNotFoundExpception(Bill billRequest) {
       ExceptionResponse exceptionResponse = null;
       List<String> totalItemsInStore = new ArrayList<String>();
       totalItemsInStore.addAll(GROCERIES_ITEMS);
       totalItemsInStore.addAll(OTHER_ITEMS);
       for (String item : billRequest.getPurchaseItmes()) {
         if (!totalItemsInStore.contains(item)) {
              exceptionResponse = new ExceptionResponse();
              exceptionResponse.setStatus(HttpStatus.NOT_FOUND.value());
              exceptionResponse.setMessage("purchaseItems values are not available");
              return exceptionResponse;
          }
       }
       return exceptionResponse;
   }
}
