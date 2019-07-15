package com.beerdrum.app.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.postgresql.geometric.PGpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.beerdrum.app.model.AllUser;

@Transactional
@Repository
public class LoginDao extends AbstractBaseDao {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	UserRepository userrepository;

	public Hashtable<String, Object> loginUser(HashMap<String, String> loginDetails) {

		Hashtable<String, Object> response = new Hashtable<>();
		Long regId = (long) 0;
		long count = 0;
		AllUser alluser = new AllUser();
		long checkExistence = 0;
		try {
			// long checkExistence =
			// checkExistence(Long.parseLong(loginDetails.get("chefId")));
			if(loginDetails.get("provider").equalsIgnoreCase("P"))
			{
			checkExistence = userrepository.checkUserExistence(loginDetails.get("phone"));
			if (checkExistence == 0) {
				response.put("responseStatus", "301");
				response.put("responseMessage", "User Not Registered");
				
				return response;
			}
			else {
				/*
				 * Query query =
				 * manager.createQuery("select count(*) from ChefLoginDetail a where a.chefId="
				 * + Long.parseLong(loginDetails.get("chefId")) + " and a.chefPassword='" +
				 * loginDetails.get("password") + "'");
				 */
									AllUser userData = userrepository.getUserDetails(loginDetails.get("phone"));
					response.put("userDetail", userData);
					response.put("responseStatus", "200");
					response.put("responseMessage", "Login Successfull");
				
			 }
			}
			else if(loginDetails.get("provider").equalsIgnoreCase("G") || loginDetails.get("provider").equalsIgnoreCase("F"))
			{
				checkExistence = userrepository.checkUserExistenceByMail(loginDetails.get("mailId"));
				if (checkExistence == 0) {
					response.put("responseStatus", "301");
					response.put("responseMessage", "User Not Registered");
					
					return response;
				}
				else {
						AllUser userData = userrepository.getUserDetailsByMail(loginDetails.get("mailId"));
						response.put("userDetail", userData);
						response.put("responseStatus", "200");
						response.put("responseMessage", "Login Successfull");
					
				 }
			}
			 
			}

			
		

		catch (

		Exception e) {
			System.out.println("Error in checkExistence" + e.getMessage());
			e.printStackTrace();
			response.put("responseStatus", "500");
			response.put("responseMessage", "Internal Server Error");
			
			return response;
		}
		// return response;
		return response;
	}

	
	public Hashtable<String, Object> registerUser(AllUser alluser) {

		Hashtable<String, Object> response = new Hashtable<>();
		Long regId = (long) 0;
		long count = 0;
		//AllUser alluser = new AllUser();
		long checkExistence = 0;
		try {
			// long checkExistence =
			// checkExistence(Long.parseLong(loginDetails.get("chefId")));
			checkExistence = userrepository.checkUserExistence(alluser.getPhoneNum());
			if (checkExistence != 0) {
				response.put("responseStatus", "301");
				response.put("responseMessage", "User Already Registered. Please try with other phone number.");
				
				return response;
			} else {
				/*
				 * Query query =
				 * manager.createQuery("select count(*) from ChefLoginDetail a where a.chefId="
				 * + Long.parseLong(loginDetails.get("chefId")) + " and a.chefPassword='" +
				 * loginDetails.get("password") + "'");
				 */
				alluser.setBdId("BD_"+checkExistence+1);
				userrepository.save(alluser);
					//response.put("userDetail", userData);
					response.put("responseStatus", "200");
					response.put("responseMessage", "Registration Successfull");
				}
			}

	

		catch (

		Exception e) {
			System.out.println("Error in checkExistence" + e.getMessage());
			e.printStackTrace();
			response.put("responseStatus", "500");
			response.put("responseMessage", "Internal Server Error");
			
			return response;
		}
		// return response;
		return response;
	}	 

	public Hashtable<String, Object> getUserDetails(HashMap<String, String> userDetails) {

		Hashtable<String, Object> response = new Hashtable<>();
		Long regId = (long) 0;
		long count = 0;
		AllUser alluser = new AllUser();
		long checkExistence = 0;
		try {
			// long checkExistence =
			// checkExistence(Long.parseLong(loginDetails.get("chefId")));
			checkExistence = userrepository.checkUserExistenceById(userDetails.get("bdId"));
			if (checkExistence == 0) {
				response.put("responseStatus", "301");
				response.put("responseMessage", "User Not Registered");
				return response;
			} else {
				AllUser userData = userrepository.getUserDetailsById(userDetails.get("bdId"));
				response.put("userDetail", userData);
				response.put("responseStatus", "200");
				response.put("responseMessage", "Data Extracted");

			}

		}

		catch (

		Exception e) {
			System.out.println("Error in checkExistence" + e.getMessage());
			e.printStackTrace();
			response.put("responseStatus", "500");
			response.put("responseMessage", "Internal Server Error");
			return response;
		}
		// return response;
		return response;
	}
}
