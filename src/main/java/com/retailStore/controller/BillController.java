/**
 * 
 */
package com.retailStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retailStore.exception.CustomErrorMessage;
import com.retailStore.model.Bill;
import com.retailStore.service.BillService;

/**
 * Bill Controller for perform Invoice operations for Retail Store
 * @author Mahesh Namdev
 * @since 10-09-2019
 */
@RestController
@RequestMapping(path = "/v1/store/bill", produces = MediaType.APPLICATION_JSON_VALUE)
public class BillController {
    
    @Autowired
    private BillService billService;
    
    //Method use for create invoice
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createInvoice(@RequestBody Bill billRequest) {
       if (billRequest.getPurchaseItmes() == null || billRequest.getPurchaseItmes().size() == 0) {
          CustomErrorMessage errorMessageUtil  = new CustomErrorMessage();
          return new ResponseEntity<Object>(errorMessageUtil.requiredItemsExpception(), HttpStatus.BAD_REQUEST);
       } else if (billRequest.getPurchaseItmes() != null || billRequest.getPurchaseItmes().size() > 0) {
           CustomErrorMessage errorMessageUtil  = new CustomErrorMessage();
           
           if(errorMessageUtil.itemsNotFoundExpception(billRequest)!=null) {
             return new ResponseEntity<Object>(errorMessageUtil.itemsNotFoundExpception(billRequest), HttpStatus.NOT_FOUND);
           }
       }
       
       Bill billResponse = billService.createInvoice(billRequest);
       
       return new ResponseEntity<Object>(billResponse, HttpStatus.OK);
    }
    


}
