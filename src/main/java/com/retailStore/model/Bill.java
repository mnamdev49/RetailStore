/**
 * 
 */
package com.retailStore.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * JSON Request and Response Model class for prepare Invoice of Retail Store
 * @author Mahesh Namdev
 * @since 10-09-2019
 */
@JsonInclude(Include.NON_NULL)
public class Bill {
    
    private String customerName;
    private String customerType;
    private List<String> purchaseItems;
    private Double totalBillAmount;
    private Double discount;
    private Double payableAmount;
    
    public String getCustomerName() {
       return customerName;
    }
    public void setCustomerName(String customerName) {
       this.customerName = customerName;
    }
    
    public String getCustomerType() {
       return customerType;
    }
    
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    public List<String> getPurchaseItmes() {
        return purchaseItems;
    }
    public void setPurchaseItmes(List<String> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }
    
    public Double getTotalBillAmount() {
       return totalBillAmount;
    }
    public void setTotalBillAmount(Double totalBillAmount) {
       this.totalBillAmount = totalBillAmount;
    }
    
    public Double getDiscount() {
       return discount;
    }
    public void setDiscount(Double discount) {
       this.discount = discount;
    }
    
    public Double getPayableAmount() {
       return payableAmount;
    }
    public void setPayableAmount(Double payableAmount) {
       this.payableAmount = payableAmount;
    }
}
