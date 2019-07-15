package com.beerdrum.app.services;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.beerdrum.app.dao.LoginDao;
import com.beerdrum.app.dao.UserRepository;
import com.beerdrum.app.model.AllUser;






@Service("loginService")
public class LoginService extends AbstractBaseService{

	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private UserRepository userrepository;
	
	
	public Hashtable<String,Object> loginUser(HashMap<String,String> loginDetails){
		
		return loginDao.loginUser(loginDetails);
	}
	
public Hashtable<String,Object> getUserDetails(HashMap<String,String> inputDetails){
		
		return loginDao.getUserDetails(inputDetails);
	}

public Hashtable<String,Object> registerUser(AllUser alluser){
	
	return loginDao.registerUser(alluser);
}
	

}
