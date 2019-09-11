/**
 * 
 */
package com.retailStore.model;

/**
 * Class use for error response
 * @author Mahesh Namdev
 * @since 10-09-2019
 */
public class ExceptionResponse {
  
  private Integer status;
  private String message;
  
  public Integer getStatus() {
    return status;
  }
  
  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }
  
  public void setMessage(String message) {
    this.message = message;
  }
  

}
