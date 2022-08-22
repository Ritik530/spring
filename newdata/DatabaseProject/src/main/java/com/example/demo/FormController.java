package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FormController {
	@GetMapping("/home")
	public String home() {
		System.out.println("Welcome");
		return"index.html";
	}
	@PostMapping("/details")

//	public String viewdetails(@RequestParam("cid") String cid,@RequestParam("cname") String cname, @RequestParam("cemail") String cemail,ModelMap modelMap) 
//	public String viewdetails(@RequestParam("cid") String cid,@RequestParam("cname") String cname, @RequestParam("cemail") String cemail, ModelMap modelMap) 
//	{
//		Client customer = new Client();
//		customer.setCid(cid);
//		customer.setCname(cname);
//		customer.setCemail(cemail);
//		System.out.println(customer);
//		
//		modelMap.addAttribute("cid", cid);
//		modelMap.addAttribute("cname", cname);
//		modelMap.addAttribute("cemail", cemail);
//		modelMap.addAttribute("customer",customer);
//		return"viewdetails.html";
//	}
	public @ResponseBody Map<String, Object> viewdetails(@RequestBody Map<String, Object> map1) 
	
	{
		Map<String,Object> modelMap = new HashMap<>();
		modelMap.put("cid", map1.get("cid"));
		modelMap.put("cname", map1.get("cname"));
		modelMap.put("cemail", map1.get("cemail"));
		return modelMap;
	}



}
