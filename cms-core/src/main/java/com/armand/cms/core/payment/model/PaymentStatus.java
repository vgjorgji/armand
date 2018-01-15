package com.armand.cms.core.payment.model;

public enum PaymentStatus {
  WaitingPayment,
  CheckPayment,
  NotPaid,
  PartiallyPaid,
  Paid;
}
