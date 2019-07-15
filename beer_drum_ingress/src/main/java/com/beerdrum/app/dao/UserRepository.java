package com.beerdrum.app.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beerdrum.app.model.AllUser;


@Repository
public interface UserRepository extends JpaRepository<AllUser, Long> {
	
	@Query("Select count(*) from AllUser alluser where alluser.phoneNum=?1")
	 	long checkUserExistence(String phoneNum);

		@Query("Select alluser from AllUser alluser where alluser.mailId=?1")
		AllUser getUserDetailsByMail(String mailId);


		@Query("Select alluser from AllUser alluser where alluser.phoneNum=?1")
		AllUser getUserDetails(String phoneNum);

		@Query("Select count(*) from AllUser alluser where alluser.mailId=?1")
	 	long checkUserExistenceByMail(String mail);
		
		@Query("Select count(*) from AllUser alluser where alluser.bdId=?1")
	 	long checkUserExistenceById(String bdId);
		
		@Query("Select alluser from AllUser alluser where alluser.bdId=?1")
		AllUser getUserDetailsById(String bdId);
}
