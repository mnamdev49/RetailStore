#RetailStore

Request URL : <URL>/v1/store/bill

			 Method : Post
			 Header : Content-Type:application/json
					  Accept:application/json
			
			Request Payload sample : 
									
									{
										"customerName": "mahesh",
										"customerType": "storeAffilliate",
										"purchaseItmes": [
															"other_item01",
															"groceries_item01"
														  ]
									}
									
			Response Payload sample :
			
										{
											"customerName": "mahesh",
											"customerType": "storeAffilliate",
											"totalBillAmount": 200,
											"discount": 15,
											"payableAmount": 185,
											"purchaseItmes": [
																"other_item01",
																"groceries_item01"
															  ]
										}
										
							
Notes : - Here consider purchaseItmes values are groceries_item01,groceries_item02,groceries_item03,groceries_item04,other_item01,other_item02,other_item03,other_item04
          if we are using other items than this in list node of it so it will give httpstatus 404 not found and if give it null so it will give httpstatus 400 which is bad request.
		  
		  customerTypes are storeEmployee,storeAffilliate,longTermCustomer other than this or null it consider customerType is general customer.