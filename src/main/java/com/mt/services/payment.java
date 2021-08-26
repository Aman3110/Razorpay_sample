package com.mt.services;
import java.io.IOException;
import java.awt.*;
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
@RequestMapping("/payment")

public class payment {
	@RequestMapping(value = "/getPaymentDetails", method = RequestMethod.GET)
	@ResponseBody
	String uploadImage(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
			throws RazorpayException{

		try
		{
			com.mt.services.Order obj=new com.mt.services.Order();
		
			RazorpayClient razorpay = new RazorpayClient("rzp_test_B6olL37xw4NXCq", "hzAwjHfvHSWlfCJNdn4CFdxy");
		//JSONObject captureRequest = new JSONObject();
			//com.mt.services.Order obj=new Order();
		//java.util.List<Payment> payments = razorpay.Orders.fetchPayments(obj.getid());
		
			//java.util.List<com.razorpay.Payment> payments = razorpay.Payments.fetchAll();
			
		
			java.util.List<Payment> payments = razorpay.Orders.fetchPayments(obj.uploadImage(request, response, httpSession));
		
		  //captureRequest.put("amount", "1000");
		  //captureRequest.put("currency", "INR");

		  //com.razorpay.Payment payment = razorpay.Payments.capture("Pay_aman@2326", captureRequest);
		  //com.razorpay.Payment payment = razorpay.Payments.fetch("pay_Ho9omsfF0ZwmfX");
			//return(payments.toString());
			
			//return(payments.toString());
			try
			{
			return(payments.get(0).get("id").toString());
			}
			catch(Exception e)
			{
				return("No payment has been made for this particular order_id");
			}
			
			
			
			
		  
		}
		catch(RazorpayException e)
		{return(e.getMessage());
			}

}
}
