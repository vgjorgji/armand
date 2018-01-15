package com.armand.cms.core.payment.model;

import java.util.Date;

import com.armand.cms.core.persist.model.HistoryModel;
import com.armand.cms.core.website.model.Website;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

  public long getTotalAmountPaid() {
    return amountPaid1 + amountPaid2 + amountPaid3;
  }

}
