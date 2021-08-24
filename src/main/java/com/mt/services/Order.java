package com.mt.services;

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
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Controller
@RequestMapping("/order")
public class Order {

	
	@RequestMapping(value = "/getOrderDetails", method = RequestMethod.GET)
	@ResponseBody
	String uploadImage(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
			throws RazorpayException {

		try
		{
		/*Create an order---*/RazorpayClient razorpay = new RazorpayClient("rzp_test_owctpAlNb25JR9", "0kWjvm07v2VRRivcTDVNGOeF");
		JSONObject orderRequest = new JSONObject();
		//orderRequest.put("id","pay_G3P9vcIhRs3NV4");
		orderRequest.put("amount", 50000); // amount in the smallest currency unit
		orderRequest.put("currency", "INR");
		orderRequest.put("receipt", "order_rcptid_11");
		com.razorpay.Order order = razorpay.Orders.create(orderRequest);
		return(order.toString());
		}
		catch(RazorpayException e)
		{return(e.getMessage());
			}
}
}
