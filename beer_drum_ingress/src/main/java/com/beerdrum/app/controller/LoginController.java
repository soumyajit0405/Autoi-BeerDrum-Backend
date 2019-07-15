package com.beerdrum.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.beerdrum.app.model.AllUser;
import com.beerdrum.app.services.LoginService;






@CrossOrigin
@RestController
public class LoginController extends AbstractBaseController{

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = REST+"loginUser", method = RequestMethod.POST,headers="Accept=application/json")
	public Hashtable<String,Object> loginUser(@RequestBody HashMap<String,String> loginDetails){
	//	System.out.println(loginDetails.get("userName"));
		return loginService.loginUser(loginDetails);
		
	}
	
	@RequestMapping(value = REST+"userDetails", method = RequestMethod.POST,headers="Accept=application/json")
	public Hashtable<String,Object> getUserDetails(@RequestBody HashMap<String,String> inputDetails){
	//	System.out.println(loginDetails.get("userName"));
		return loginService.getUserDetails(inputDetails);
		
	}
	
	@RequestMapping(value = REST+"registerUser", method = RequestMethod.POST,headers="Accept=application/json")
	public Hashtable<String,Object> registerUser(@RequestBody AllUser alluser){
	//	System.out.println(loginDetails.get("userName"));
		return loginService.registerUser(alluser);
		
	}
	
		
}
