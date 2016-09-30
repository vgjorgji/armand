package com.vcms.payment.model;

import java.util.Date;

import com.vcms.persist.model.HistoryModel;
import com.vcms.website.model.Website;

public class Payment extends HistoryModel {
	
	private Website website;
	private PaymentFor paymentFor;
	private String paymentForDetails;
	private Date validityPeriodStart;
	private Date validityPeriodEnd;
	
	private long cost;
	private PaymentStatus status;
	
	private Date paymentDate1;
	private long amountPaid1;
	private Date paymentDate2;
	private long amountPaid2;
	private Date paymentDate3;
	private long amountPaid3;
	
	public Website getWebsite() {
		return website;
	}
	
	public void setWebsite(Website website) {
		this.website = website;
	}
	
	public PaymentFor getPaymentFor() {
		return paymentFor;
	}
	
	public void setPaymentFor(PaymentFor paymentFor) {
		this.paymentFor = paymentFor;
	}
	
	public String getPaymentForDetails() {
		return paymentForDetails;
	}
	
	public void setPaymentForDetails(String paymentForDetails) {
		this.paymentForDetails = paymentForDetails;
	}
	
	public Date getValidityPeriodStart() {
		return validityPeriodStart;
	}
	
	public void setValidityPeriodStart(Date validityPeriodStart) {
		this.validityPeriodStart = validityPeriodStart;
	}
	
	public Date getValidityPeriodEnd() {
		return validityPeriodEnd;
	}
	
	public void setValidityPeriodEnd(Date validityPeriodEnd) {
		this.validityPeriodEnd = validityPeriodEnd;
	}
	
	public long getCost() {
		return cost;
	}
	
	public void setCost(long cost) {
		this.cost = cost;
	}
	
	public PaymentStatus getStatus() {
		return status;
	}
	
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	
	public Date getPaymentDate1() {
		return paymentDate1;
	}
	
	public void setPaymentDate1(Date paymentDate1) {
		this.paymentDate1 = paymentDate1;
	}
	
	public long getAmountPaid1() {
		return amountPaid1;
	}
	
	public void setAmountPaid1(long amountPaid1) {
		this.amountPaid1 = amountPaid1;
	}
	
	public Date getPaymentDate2() {
		return paymentDate2;
	}
	
	public void setPaymentDate2(Date paymentDate2) {
		this.paymentDate2 = paymentDate2;
	}
	
	public long getAmountPaid2() {
		return amountPaid2;
	}
	
	public void setAmountPaid2(long amountPaid2) {
		this.amountPaid2 = amountPaid2;
	}
	
	public Date getPaymentDate3() {
		return paymentDate3;
	}
	
	public void setPaymentDate3(Date paymentDate3) {
		this.paymentDate3 = paymentDate3;
	}
	
	public long getAmountPaid3() {
		return amountPaid3;
	}
	
	public void setAmountPaid3(long amountPaid3) {
		this.amountPaid3 = amountPaid3;
	}
	
	public long getTotalAmountPaid() {
		return amountPaid1 + amountPaid2 + amountPaid3;
	}

}
