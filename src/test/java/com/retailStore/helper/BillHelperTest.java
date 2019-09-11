package com.retailStore.helper;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.retailStore.model.Bill;

/**
 * Junit Test cases for test Bill Helper class Methods
 * @author Mahesh Namdev
 * @since 11-09-2019
 */
@RunWith(MockitoJUnitRunner.class)
public class BillHelperTest {
    
    @InjectMocks
    private BillHelper billHelper;
    
    private static Bill bill;
    
    @Before
    public void setUp() {
        bill = new Bill();
        bill.setCustomerName("test");
        bill.setPurchaseItmes(Arrays.asList("other_item01"));
     }
    
    @Test
    public void getPrecentageBasedBillTest() {
        
        Bill billResult = billHelper.getPrecentageBasedBill(bill, 5);
        assertEquals("5.0", billResult.getDiscount().toString());
        assertEquals("95.0", billResult.getPayableAmount().toString());
        assertEquals("100.0", billResult.getTotalBillAmount().toString());
    }
    
    @Test
    public void getNonPrecentageBasedBillTest() {
        
        Bill billResult = billHelper.getNonPrecentageBasedBill(bill);
        assertEquals("0.0", billResult.getDiscount().toString());
        assertEquals("100.0", billResult.getPayableAmount().toString());
        assertEquals("100.0", billResult.getTotalBillAmount().toString());
    }
  
}
