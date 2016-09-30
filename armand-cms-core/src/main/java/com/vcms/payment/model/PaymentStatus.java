package com.vcms.payment.model;

public enum PaymentStatus {
	WaitingPayment, 
	CheckPayment, 
	NotPaid, 
	PartiallyPaid,
	Paid;
}
