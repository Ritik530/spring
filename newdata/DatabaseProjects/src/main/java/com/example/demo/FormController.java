package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class FormController {
	@Autowired
	private CustomerRep rep;
	
	@RequestMapping("/home")
	public String details() {
		System.out.println("Welcome");
		return"index.html";
	}
	@PostMapping("/savedetails")
	public String details(@RequestBody Customer customer) {
		System.out.println("WELCOME");
		System.out.println(customer);
		rep.save(customer);
		return"viewdetails.html";
	}

	@RequestMapping("/getdetails")
	public String getdetails() {
		return "viewdetails.html";
	}
	
	
	@PostMapping("/getdetails")	
	public ModelAndView getdetails(@RequestParam int cid) {
		ModelAndView mv =new ModelAndView("Retrieve");
		Customer customer = rep.findById(cid).orElse(null);
		mv.addObject(customer);
		System.out.println(customer);
		System.out.println(mv);
		
		return mv;
		
	}
//	@RequestMapping("/customer/2")
//	@ResponseBody
//	public String GetCustomer2() {
//		return rep.findByCid(2).toString();
//	}
	@RequestMapping("/customer")
	@ResponseBody
	public String getCustomer() {
		return rep.findAll().toString();
	}
	
//	@RequestMapping("/customer")
//	@ResponseBody
//	public List<Customer> getCustomer() {
//		return rep.findAll();
//	}
	@RequestMapping("/customer/{cid}")
	@ResponseBody
	public Optional<Customer> GetCustomer2(@PathVariable("cid") int cid) {
		return rep.findByCid(cid);
	}
//	@RequestMapping("/customer/{cid}")
//	@ResponseBody
//	public String GetCustomer2(@PathVariable("cid") int cid) {
//		return rep.findByCid(cid).toString();
//	}


//	public @ResponseBody Map<String, Object> viewdetails(@RequestBody Map<String, Object> map1) 
//	
//	{
//		Map<String,Object> modelMap = new HashMap<>();
//		modelMap.put("cid", map1.get("cid"));
//		modelMap.put("cname", map1.get("cname"));
//		modelMap.put("cemail", map1.get("cemail"));
//		return modelMap;
//	}
	@DeleteMapping("/customers/{cid}")
	public Customer getCustomer4(@PathVariable("cid") int cid) {
		Customer cust = rep.getOne(cid);
		rep.delete(cust);
		return cust;
	}
	@PutMapping(path="/customers", consumes= {"application/json"})
	public Customer getCustomer5(@RequestBody Customer customer) {
		rep.save(customer);
		return customer;
	}
	

//	public String viewdetails(@RequestParam("cid") String cid,@RequestParam("cname") String cname, @RequestParam("cemail") String cemail,ModelMap modelMap) 
//	{
//		modelMap.put("cid", cid);
//		modelMap.put("cname", cname);
//		modelMap.put("cemail", cemail);
//		return"viewdetails.html";
//	}
//	@PostMapping("/customer")
//	public Customer getCustomer2(@RequestBody Customer customer) {
//		rep.save(customer);
//		System.out.println(customer);
//		return customer;
//	}

}
