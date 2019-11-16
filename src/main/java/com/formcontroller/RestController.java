package com.formcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestController {
	
	@RequestMapping("/test")
	public String test()
	{
		return "Example";
	}

}
