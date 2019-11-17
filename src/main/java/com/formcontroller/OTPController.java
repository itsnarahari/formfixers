package com.formcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.form.service.OtpService;

@Controller
public class OTPController {
	
	@Autowired
	MyEmailService myEmailService;

	@Autowired
	OtpService otpService;
	
	@RequestMapping("/test")
	public String test()
	{
		return "<h3>Hai</hai>";
	}
	
	@GetMapping("/generateOtp")
	public String generateOtp(){
	Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
	String username = auth.getName();
	int otp = otpService.generateOTP(username);
	
	//logger.info("OTP : "+otp);
	//Generate The Template to send OTP 
	EmailTemplate template = new EmailTemplate("SendOtp.html");
	
	Map<String,String> replacements = new HashMap();
	replacements.put("user", username);
	replacements.put("otpnum", String.valueOf(otp));
	String message = template.getTemplate(replacements);
	myEmailService.sendOtpMessage("naraharinaik7@gmail.com", "OTP -SpringBoot", message);
	return "otppage";
	}
}