package com.mt.services;
import java.util.*;

import java.awt.List;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.razorpay.*;


@Controller
@RequestMapping(value="/order")
public class Order {
	@RequestMapping(value = "/getOrderDetails", method = RequestMethod.GET)
	@ResponseBody
	String uploadImage(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
			throws RazorpayException {

		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_B6olL37xw4NXCq", "hzAwjHfvHSWlfCJNdn4CFdxy");
			//JSONObject captureRequest = new JSONObject();
		
			CreateOrder obj=new CreateOrder();
			//JSONObject orderRequest = new JSONObject();
//			orderRequest.put("amount", 50000); 
//			orderRequest.put("currency", "INR");
//			orderRequest.put("receipt", "order_rcptid_11");
			
			
			
			com.razorpay.Order order = razorpay.Orders.create(obj.uploadImage(request, response, httpSession));
			
			//com.razorpay.Order order1 = razorpay.Orders.fetch(order.get("id").toString());
			
			
			//return("order_Ho9noMpUp25Y7P");
			return(order.get("id").toString());
			
			  
			} 
		catch (RazorpayException e) {
			  // Handle Exception
			
			  return(e.getMessage());
			}
	}
}
//public String fun()
//{
//		com.mt.services.Order obj=new com.mt.services.Order();
//		try
//		{
//		String a=obj.uploadImage(null, null, null);
//		return
//		}
//		catch(RazorpayException e)
//		{
//			return(e.getMessage());
//		}
//		
//		
//
//		try
//		{
//		
//			RazorpayClient razorpay = new RazorpayClient("rzp_test_B6olL37xw4NXCq", "hzAwjHfvHSWlfCJNdn4CFdxy");
//		//JSONObject captureRequest = new JSONObject();
//	
//
//		JSONObject orderRequest = new JSONObject();
//		orderRequest.put("amount", 50000); // amount in the smallest currency unit
//		orderRequest.put("currency", "INR");
//		orderRequest.put("receipt", "order_rcptid_11");
//
//		com.razorpay.Order order = razorpay.Orders.create(orderRequest);
//		
//		com.razorpay.Order order1 = razorpay.Orders.fetch(order.get("id").toString());
//		
//		return(order1.get("id").toString());
//		//java.util.List<Payment> payments = razorpay.Orders.fetchPayments(order1.get("id").toString());
//		//System.out.println(payments.toString());
//		}
//		catch(RazorpayException e)
//		{
//			return(e.getMessage());
//		}
//}
//
//	
//	
////	@RequestMapping(value = "/postOrderDetails", method = RequestMethod.POST)
////	@ResponseBody
////	String uploadImage_1(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
////			throws RazorpayException {
////
////		try
////		{
////		/*Create an order---*/
////		RazorpayClient razorpay = new RazorpayClient("rzp_test_B6olL37xw4NXCq", "hzAwjHfvHSWlfCJNdn4CFdxy");
////		JSONObject orderRequest = new JSONObject();
////		orderRequest.put("amount", 50000); 
////		orderRequest.put("currency", "INR");
////		orderRequest.put("receipt", "order_rcptid_11");
////		com.razorpay.Order order = razorpay.Orders.create(orderRequest);
////		//order.order_id
////		return(order.toString());
////		}
////		catch(RazorpayException e)
////		{
////			return(e.getMessage());
////			
////		}
//		
////}
////	public String getid()
////	{
////		return a;
////	}
//	
//}
