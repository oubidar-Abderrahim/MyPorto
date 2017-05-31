package com.controllers;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="ajaxBean")
@SessionScoped
public class AjaxBean {
	
	private String testAjax;
	private String testAjaxAcommp;
	
	public String getTestAjax() {
		return testAjax;
	}
	public void setTestAjax(String testAjax) {
		this.testAjax = testAjax;
	}
	public String getTestAjaxAcommp() {
		return testAjaxAcommp;
	}
	public void setTestAjaxAcommp(String testAjaxAcommp) {
		this.testAjaxAcommp = testAjaxAcommp;
	}

}
