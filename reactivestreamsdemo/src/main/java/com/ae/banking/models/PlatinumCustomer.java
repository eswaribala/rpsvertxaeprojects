package com.ae.banking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatinumCustomer extends Customer{

	private String offer;

	public PlatinumCustomer(long customerId, String name, long phoneNo, String offer) {
		super(customerId, name, phoneNo);
		this.offer = offer;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+offer;
	}
	
	
	
	
	
}
