package com.dorm.test;

import java.net.URLEncoder;

import org.json.JSONObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bean.Http;
import bean.User;
import util.Assertion;
import util.HttpRequest;
import util.SpliceParam;;

@Listeners({util.AssertionListener.class})
public class AppTest
{
  
	@Test
	public void protocolURL(){
		
		Http.setRequestPath("/creditcard/agreement/url");
		
		String response = HttpRequest.get(Http.getDormQa(), Http.getRequestPath(), SpliceParam.sParam("token", User.getToken()));
		
		JSONObject object = new JSONObject(response);
		
		Assertion.verifyEquals(object.get("status"), 0,"状态是否相等");
	}
	
	@BeforeSuite
	public void login(){
		
		User.setUsername("dorm7008");
		User.setPassword("e10adc3949ba59abbe56e057f20f883e");
		
		Http.setRequestPath("/user/login");
		Http.setParam(SpliceParam.sParam("username", User.getUsername())
				+ SpliceParam.sParam("password", User.getPassword()) + SpliceParam.sParam("token", User.getDeviceToken()));
		
		String response = HttpRequest.post(Http.getDormQa(), Http.getRequestPath(), Http.getParam());
				
		JSONObject object = new JSONObject(response);
		
		// 将普通字符串转换成application/x-www-from-urlencoded字符串
		User.setToken(URLEncoder.encode(object.getString("token")));
		
	}

}
