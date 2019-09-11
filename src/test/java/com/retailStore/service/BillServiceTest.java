package com.retailStore.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.retailStore.helper.BillHelper;
import com.retailStore.model.Bill;

/**
 * Junit Test cases for test Bill Service class Methods
 * @author Mahesh Namdev
 * @since 11-09-2019
 */
@RunWith(MockitoJUnitRunner.class)
public class BillServiceTest {
    
    @InjectMocks
    private BillService billService;
    
    @Mock
    private BillHelper billHelper;
    
    private static Bill bill;
    
    @Before
    public void setUp() {
       bill = new Bill();
       bill.setCustomerName("test");
       bill.setPurchaseItmes(Arrays.asList("other_item01"));
    }
    
    @Test
    public void createInvoiceTestForStoreEmployee() {
        
        bill.setCustomerType("storeEmployee");
        
        when(billHelper.getPrecentageBasedBill(bill, 30)).thenReturn(bill);
        
        Bill billResult = billService.createInvoice(bill);
        
        assertEquals("storeEmployee", billResult.getCustomerType());
        assertEquals("test", billResult.getCustomerName());
    }
    
    @Test
    public void createInvoiceTestForStoreAffilliate() {
        
        bill.setCustomerType("storeAffilliate");
        
        when(billHelper.getPrecentageBasedBill(bill, 10)).thenReturn(bill);
        
        Bill billResult = billService.createInvoice(bill);
        
        assertEquals("storeAffilliate", billResult.getCustomerType());
        assertEquals("test", billResult.getCustomerName());
    }
    
    @Test
    public void createInvoiceTestForLongTermCustomer() {
        
        bill.setCustomerType("longTermCustomer");
        
        when(billHelper.getPrecentageBasedBill(bill, 5)).thenReturn(bill);
        
        Bill billResult = billService.createInvoice(bill);
        
        assertEquals("longTermCustomer", billResult.getCustomerType());
        assertEquals("test", billResult.getCustomerName());
    }
    
    @Test
    public void createInvoiceTestForOtherCustomer() {
        
        bill.setCustomerType("other");
        
        when(billHelper.getNonPrecentageBasedBill(bill)).thenReturn(bill);
        
        Bill billResult = billService.createInvoice(bill);
        
        assertEquals("other", billResult.getCustomerType());
        assertEquals("test", billResult.getCustomerName());
    }

}
