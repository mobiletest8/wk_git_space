package com.dorm.test.dormTest;

import java.net.URLEncoder;

import org.json.JSONObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import util.Assertion;
import util.HttpRequest;
import util.Property;
import util.SpliceParameter;;

@Listeners({util.AssertionListener.class})
public class AppTest
{
  
	@Test
	public void protocolURL(){
		
		Property p = new Property();
    	
		p.requestPath = "/creditcard/agreement/url";
		
		String token = SpliceParameter.sParameter("token", p.token);
		
		String response = HttpRequest.get(p.DORM_QA_URL, p.requestPath, token);
		
		JSONObject object = new JSONObject(response);
		
		Assertion.verifyEquals(object.get("status"), "0","状态是否相等");
	}
	
	@BeforeSuite
	public void login(){
		
		Property p = new Property();
		
		SpliceParameter sp = new SpliceParameter();
		
		p.requestPath = "/user/login";
		
		String user = sp.sParameter("username", p.user);
		
		String passwd = sp.sParameter("password", p.passwd);
		
		String token = sp.sParameter("token", p.deviceToken);
		
		String response = HttpRequest.post(p.DORM_QA_URL, p.requestPath, user + passwd + token);
				
		JSONObject object = new JSONObject(response);
		
		// 将普通字符串转换成application/x-www-from-urlencoded字符串
		p.token = URLEncoder.encode(object.getString("token"));
		
	}

}
