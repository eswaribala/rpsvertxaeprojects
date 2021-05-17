package com.ae.banking.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
	
	private long cardNo;
	private String customerName;
	private long transactionLimit;
	private LocalDate expiryDate;
	

}
