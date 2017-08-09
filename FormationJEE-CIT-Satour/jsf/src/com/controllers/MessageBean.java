package com.controllers;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "message", eager = true)
public class MessageBean {
   private String message = "Hello World!";
	
   public String getMessage() {
      return message;
   }
   public void setMessage(String message) {
      this.message = message;
   }
}