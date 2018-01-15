package com.armand.cms.core.validation;

public class CmsException extends RuntimeException {

  private static final long serialVersionUID = 8223728411442082470L;

  public CmsException(String message) {
    super(message);
  }

  public CmsException(String message, Throwable cause) {
    super(message, cause);
  }

  public CmsException(Throwable cause) {
    super(cause);
  }
	

}
