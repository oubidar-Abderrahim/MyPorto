package com.controllers;

import javax.faces.bean.ManagedBean;

@ManagedBean(name= "hello", eager=true)
public class HelloBean {

   public String getMessage() {
      return "Hello World!";
   }
}
