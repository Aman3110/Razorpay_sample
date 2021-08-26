package com.mt.services;
import java.util.*;

import java.awt.List;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.razorpay.*;


@Controller
@RequestMapping(value="/ordercreate")

public class CreateOrder {
	@RequestMapping(value = "/postCreateOrderDetails", method = RequestMethod.POST)
	@ResponseBody
	/*String*/JSONObject uploadImage(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
			throws RazorpayException {

		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_B6olL37xw4NXCq", "hzAwjHfvHSWlfCJNdn4CFdxy");
			//JSONObject captureRequest = new JSONObject();
		

			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", 50000); 
			orderRequest.put("currency", "INR");
			
			//orderRequest.put("receipt", "order_rcptid_11");
			//String s=orderRequest.toJson();
			//com.razorpay.Order order = razorpay.Orders.create(orderRequest);
			return (orderRequest);
		}
		catch(RazorpayException e)
		{
			JSONObject obj1=new JSONObject();
			return obj1 ;
			//return(e.getMessage());
		}
	}
}
