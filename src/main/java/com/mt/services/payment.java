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
@RequestMapping("/payment")

public class payment {
	@RequestMapping(value = "/getPaymentDetails", method = RequestMethod.GET)
	@ResponseBody
	String uploadImage(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
			throws RazorpayException {

		try
		{
		
			RazorpayClient razorpay = new RazorpayClient("rzp_test_owctpAlNb25JR9", "0kWjvm07v2VRRivcTDVNGOeF");
		JSONObject captureRequest = new JSONObject();
			
		
		  captureRequest.put("amount", "1000");
		  captureRequest.put("currency", "INR");

		  //com.razorpay.Payment payment = razorpay.Payments.capture("Pay_aman@2326", captureRequest);
		  com.razorpay.Payment payment = razorpay.Payments.fetch("pay_Ho9omsfF0ZwmfX");
		  return(payment.toString());
		}
		catch(RazorpayException e)
		{return(e.getMessage());
			}

}
}
