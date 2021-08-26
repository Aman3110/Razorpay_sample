package com.mt.services;
import java.util.*;

import java.awt.List;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
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
@RequestMapping("/capture")
public class Capture extends HttpServlet {
	@RequestMapping(value = "/postCaptureDetails", method = RequestMethod.GET)
	@ResponseBody
	String uploadImage(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
			throws RazorpayException,IOException {
		
		com.mt.services.payment obj=new com.mt.services.payment();
		com.mt.services.CreateOrder obj1=new com.mt.services.CreateOrder();
		//com.mt.services.Order obj1=new com.mt.services.Order();
		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_B6olL37xw4NXCq", "hzAwjHfvHSWlfCJNdn4CFdxy");
			
			
			try
			{
			return(razorpay.Payments.capture(obj.uploadImage(request, response, httpSession).toString(),obj1.uploadImage(request, response, httpSession)).toString());
			}
			catch(Exception e)
			{
				return(e.getMessage());
				//return("Payment Captured Sucessfully");
			}
			
			
			}
			
			
			//return("Payment Captured Successfully");
		
		catch(RazorpayException e1)
		{
			return(e1.getMessage());
		}
	
	
	}
}
